package ru.taxicrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.taxicrm.domain.Call;
import ru.taxicrm.repository.CallRepository;
import ru.taxicrm.service.CallService;

import java.util.List;

@Service
@Transactional
public class CallServiceImpl implements CallService {

    private CallRepository callRepository;

    @Autowired
    public void setCallRepository(CallRepository callRepository) {
        this.callRepository = callRepository;
    }

    @Override
    public void save(Call call) {
        callRepository.save(call);
    }

    @Override
    public Call findById(Long id) {
        return null;
    }

    @Override
    public void delete(Call call) {
        callRepository.delete(call);
    }

    @Override
    public List<Call> findAll(Pageable page) {
        callRepository.findAll(page);
        return null;
    }
}