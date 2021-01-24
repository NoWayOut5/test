package ru.taxicrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.taxicrm.domain.Call;

@Repository
public interface CallRepository extends JpaRepository<Call, Long> {
}