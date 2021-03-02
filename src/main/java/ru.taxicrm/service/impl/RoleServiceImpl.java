package ru.taxicrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.taxicrm.domain.Role;
import ru.taxicrm.repository.RoleRepository;
import ru.taxicrm.service.AbstractService;

@Service
@Transactional
public class RoleServiceImpl extends AbstractService<Role, RoleRepository> {

    @Autowired
    public RoleServiceImpl(RoleRepository repo) {
        super(repo);
    }
}