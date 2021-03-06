package ru.taxicrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.taxicrm.domain.Contractor;
import ru.taxicrm.repository.ContractorRepository;
import ru.taxicrm.service.AbstractService;

import java.util.List;

@Service
@Transactional
public class ContractorServiceImpl extends AbstractService<Contractor, ContractorRepository> {

    @Autowired
    public ContractorServiceImpl(ContractorRepository repo) {
        super(repo);
    }

    public List<Contractor> findByNameIgnoreCase(String name) {
        return getRepo().findByNameIgnoreCase(name);
    }
}