package ru.taxicrm.controller.impl;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.taxicrm.controller.AbstractController;
import ru.taxicrm.domain.Day;
import ru.taxicrm.repository.DayRepository;
import ru.taxicrm.service.impl.DayServiceImpl;

@RestController
@RequestMapping("day")
@Api(tags = {"Список дней"})
@CrossOrigin
public class DayController extends AbstractController<Day, DayRepository, DayServiceImpl> {

    @Autowired
    public DayController(DayServiceImpl service) {
        super(service);
    }
}