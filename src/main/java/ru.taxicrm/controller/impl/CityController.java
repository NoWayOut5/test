package ru.taxicrm.controller.impl;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.taxicrm.controller.AbstractController;
import ru.taxicrm.domain.City;
import ru.taxicrm.repository.CityRepository;
import ru.taxicrm.service.impl.CityServiceImpl;

import java.util.List;

@RestController
@RequestMapping("city")
@Api(tags = {"Города"})
@CrossOrigin
public class CityController extends AbstractController<City, CityRepository, CityServiceImpl> {

    @Autowired
    public CityController(CityServiceImpl service) {
        super(service);
    }

    @GetMapping(value = "name/{name}")
    public List<City> findByFirstNameIgnoreCase(@PathVariable String name) {
        return getService().findByNameIgnoreCase(name);
    }
}