package ru.taxicrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import ru.taxicrm.domain.Shedule;
import ru.taxicrm.repository.SheduleRepository;
import ru.taxicrm.service.AbstractService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SheduleServiceImpl extends AbstractService<Shedule, SheduleRepository> {

    @Autowired
    public SheduleServiceImpl(SheduleRepository repo) {
        super(repo);
    }

    public Optional<Shedule> getScheduleContractor(Long id) {
        List<Optional<Shedule>> obj = getRepo().getScheduleContractor(id);
        if (obj.size() == 0) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Объект с id = %s не найден", id)
            );
        }
        return obj.get(0);
    }
}