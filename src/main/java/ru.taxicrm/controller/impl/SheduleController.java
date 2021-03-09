package ru.taxicrm.controller.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.taxicrm.controller.AbstractController;
import ru.taxicrm.domain.Shedule;
import ru.taxicrm.dto.ImportShedule;
import ru.taxicrm.repository.SheduleRepository;
import ru.taxicrm.service.impl.SheduleServiceImpl;

import java.util.Optional;

@RestController
@RequestMapping("shedule")
@Api(tags = {"Расписание"})
public class SheduleController extends AbstractController<Shedule, SheduleRepository, SheduleServiceImpl> {

    @Autowired
    public SheduleController(SheduleServiceImpl service) {
        super(service);
    }

    @GetMapping(value = "getschedulecontractor/{id}")
    @ApiOperation(value = "Получить расписание по контрагенту")
    public Optional<Shedule> getScheduleContractor(@PathVariable Long id) {
        return getService().getScheduleContractor(id);
    }

    @PostMapping(value = "import", produces = "application/json")
    @ApiOperation(value = "Импорт записей по текстовым значениям")
    public Shedule importText(@RequestBody ImportShedule imp) {
        return getService().importText(imp);
    }
}