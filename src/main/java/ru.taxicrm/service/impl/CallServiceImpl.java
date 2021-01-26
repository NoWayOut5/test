package ru.taxicrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.taxicrm.domain.Call;
import ru.taxicrm.repository.CallRepository;
import ru.taxicrm.service.CallService;

import java.util.Optional;

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
    public Optional<Call> findById(Long id) {
        return callRepository.findById(id);
    }

    @Override
    public Page<Call> findAll(Integer page) {
        return null;
    }

    @Override
    public Call update(Long id, Call call) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}