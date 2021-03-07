package ru.taxicrm.service;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<E, R extends JpaRepository<E, Long>> {

    private R repo;

    public AbstractService(R repo) {
        this.repo = repo;
    }

    public E save(E entity) {
        return repo.save(entity);
    }

    public List<E> saveAll(List<E> entity) {
        return repo.saveAll(entity);
    }

    public Optional<E> findById(Long id) {
        Optional<E> obj = repo.findById(id);
        if (!obj.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Объект с id = %s не найден", id)
            );
        }
        return obj;
    }

    public List<E> findAll() {
        return repo.findAll();
    }

    public Page<E> findAllPage(Integer page) {
        Pageable pageable;
        if (page == null || page == 0) {
            pageable = PageRequest.of(0, Constant.MAX_COUNT_ELEMENT_PAGE);
        } else
            pageable = PageRequest.of(page - 1, Constant.MAX_COUNT_ELEMENT_PAGE);
        return repo.findAll(pageable);
    }

    public E update(Long id, E entity) {
        Optional<E> obj = findById(id);

        // Обновляем поля объекта исключая поля с пустыми значениями
        List<String> emptyFields = new ArrayList<>();
        for (Field field : entity.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (field.get(entity) == null) {
                    emptyFields.add(field.getName());
                }
                if (field.get(entity) != null && "".equals(field.get(entity).toString().trim())) {
                    field.set(entity, null);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        BeanUtils.copyProperties(entity, obj.get(), emptyFields.toArray(new String[0]));

        return repo.save(obj.get());
    }

    public Long delete(Long id) {
        Optional<E> byId = findById(id);
        repo.delete(byId.get());
        return id;
    }

    public R getRepo() {
        return repo;
    }
}