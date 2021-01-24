package ru.taxicrm.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.taxicrm.domain.Call;

import java.util.List;

@Service
public interface CallService {

    void save(Call call);

    Call findById(Long id);

    void delete(Call call);

    List<Call> findAll(Pageable page);
}