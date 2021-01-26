package ru.taxicrm.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.taxicrm.domain.Call;

import java.util.Optional;

@Service
public interface CallService {

    void save(Call call);

    Optional<Call> findById(Long id);

    Page<Call> findAll(Integer page);

    Call update(Long id, Call call);

    void delete(Long id);
}