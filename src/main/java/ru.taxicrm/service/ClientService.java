package ru.taxicrm.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.taxicrm.domain.Client;

import java.util.List;
import java.util.Optional;

@Service
public interface ClientService {

    Client save(Client client);

    Optional<Client> findById(Long id);

    List<Client> findAll();

    Page<Client> findAllPage(Integer page);

    Client update(Long id, Client client);

    void delete(Long id);
}