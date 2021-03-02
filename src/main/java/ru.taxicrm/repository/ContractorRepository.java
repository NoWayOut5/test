package ru.taxicrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.taxicrm.domain.Contractor;

@Repository
public interface ContractorRepository extends JpaRepository<Contractor, Long> {
}