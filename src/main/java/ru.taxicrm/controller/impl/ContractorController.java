package ru.taxicrm.controller.impl;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.taxicrm.controller.AbstractController;
import ru.taxicrm.domain.Contractor;
import ru.taxicrm.repository.ContractorRepository;
import ru.taxicrm.service.impl.ContractorServiceImpl;

import java.util.List;

@RestController
@RequestMapping("contractor")
@Api(tags = {"Контрагенты"})
@CrossOrigin
public class ContractorController extends AbstractController<Contractor, ContractorRepository, ContractorServiceImpl> {

    @Autowired
    public ContractorController(ContractorServiceImpl service) {
        super(service);
    }

    @GetMapping(value = "name/{name}")
    public List<Contractor> findByFirstNameIgnoreCase(@PathVariable String name) {
        return getService().findByNameIgnoreCase(name);
    }
}