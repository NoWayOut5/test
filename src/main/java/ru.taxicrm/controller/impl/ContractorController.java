package ru.taxicrm.controller.impl;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.taxicrm.controller.AbstractController;
import ru.taxicrm.domain.Contractor;
import ru.taxicrm.repository.ContractorRepository;
import ru.taxicrm.service.impl.ContractorServiceImpl;

@RestController
@RequestMapping("contractor")
@Api(tags = {"Контрагенты"})
@CrossOrigin
public class ContractorController extends AbstractController<Contractor, ContractorRepository, ContractorServiceImpl> {

    @Autowired
    public ContractorController(ContractorServiceImpl service) {
        super(service);
    }
}