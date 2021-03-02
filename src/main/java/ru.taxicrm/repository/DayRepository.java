package ru.taxicrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.taxicrm.domain.Day;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {
}