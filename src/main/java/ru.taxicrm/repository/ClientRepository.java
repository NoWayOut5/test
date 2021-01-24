package ru.taxicrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.taxicrm.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}