package ru.taxicrm.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.taxicrm.domain.Client;

import java.util.List;

@Service
public interface ClientService {

    void save(Client client);

    Client findById(Long id);

    void delete(Client client);

    List<Client> findAll(Pageable page);
}