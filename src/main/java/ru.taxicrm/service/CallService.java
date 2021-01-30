package ru.taxicrm.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.taxicrm.domain.Call;

import java.util.List;
import java.util.Optional;

@Service
public interface CallService {

    Call save(Call call);

    Optional<Call> findById(Long id);

    List<Call> findAll();

    Page<Call> findAllPage(Integer page);

    Call update(Long id, Call call);

    void delete(Long id);
}