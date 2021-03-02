package ru.taxicrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.taxicrm.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}