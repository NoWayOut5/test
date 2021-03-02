package ru.taxicrm.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;
import ru.taxicrm.service.AbstractService;

import java.util.List;
import java.util.Optional;

public abstract class AbstractController<E, R extends JpaRepository<E, Long>, S extends AbstractService<E, R>> {

    private S service;

    public AbstractController(S service) {
        this.service = service;
    }

    @PostMapping(value = "save")
    public E save(@RequestBody E entity) {
        return service.save(entity);
    }

    @GetMapping(value = "{id}")
    public Optional<E> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "findall")
    public List<E> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "findall/{page}")
    public Page<E> findAll(@PathVariable Integer page) {
        return service.findAllPage(page);
    }

    @PutMapping("{id}")
    public E update(@PathVariable Long id, @RequestBody E entity) {
        return service.update(id, entity);
    }

    @DeleteMapping(value = "{id}")
    public Long delete(@PathVariable Long id) {
        return service.delete(id);
    }

    public S getService() {
        return service;
    }
}