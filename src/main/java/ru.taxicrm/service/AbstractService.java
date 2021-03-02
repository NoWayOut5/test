package ru.taxicrm.service;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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
        String tbl = entity.getClass().getSimpleName().toLowerCase();
        BeanUtils.copyProperties(entity, obj.get(), tbl + "id", tbl + "sid");
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