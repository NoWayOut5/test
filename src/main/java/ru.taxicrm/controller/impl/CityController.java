package ru.taxicrm.controller.impl;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.taxicrm.controller.AbstractController;
import ru.taxicrm.domain.City;
import ru.taxicrm.repository.CityRepository;
import ru.taxicrm.service.impl.CityServiceImpl;

@RestController
@RequestMapping("city")
@Api(tags = {"Города"})
@CrossOrigin
public class CityController extends AbstractController<City, CityRepository, CityServiceImpl> {

    @Autowired
    public CityController(CityServiceImpl service) {
        super(service);
    }
}