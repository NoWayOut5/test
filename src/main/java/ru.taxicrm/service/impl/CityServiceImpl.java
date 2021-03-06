package ru.taxicrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.taxicrm.domain.City;
import ru.taxicrm.repository.CityRepository;
import ru.taxicrm.service.AbstractService;

import java.util.List;

@Service
@Transactional
public class CityServiceImpl extends AbstractService<City, CityRepository> {

    @Autowired
    public CityServiceImpl(CityRepository repo) {
        super(repo);
    }

    public List<City> findByNameIgnoreCase(String name) {
        return getRepo().findByNameIgnoreCase(name);
    }
}