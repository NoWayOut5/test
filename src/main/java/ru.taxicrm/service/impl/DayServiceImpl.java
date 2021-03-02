package ru.taxicrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.taxicrm.domain.Day;
import ru.taxicrm.repository.DayRepository;
import ru.taxicrm.service.AbstractService;

@Service
@Transactional
public class DayServiceImpl extends AbstractService<Day, DayRepository> {

    @Autowired
    public DayServiceImpl(DayRepository repo) {
        super(repo);
    }
}