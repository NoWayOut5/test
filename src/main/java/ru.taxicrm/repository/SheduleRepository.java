package ru.taxicrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.taxicrm.domain.Shedule;

import java.util.List;
import java.util.Optional;

@Repository
public interface SheduleRepository extends JpaRepository<Shedule, Long> {

    @Query("FROM Shedule WHERE contractorid = ?1")
    List<Optional<Shedule>> getScheduleContractor(Long contractorId);
}