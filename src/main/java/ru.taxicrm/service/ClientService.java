package ru.taxicrm.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.taxicrm.domain.Client;

import java.util.Optional;

@Service
public interface ClientService {

    void save(Client client);

    Optional<Client> findById(Long id);

    Page<Client> findAll(Integer page);

    Client update(Long id, Client client);

    void delete(Long id);
}