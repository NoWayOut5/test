package ru.taxicrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.taxicrm.domain.UserRole;
import ru.taxicrm.repository.UserRoleRepository;
import ru.taxicrm.service.AbstractService;

@Service
@Transactional
public class UserRoleServiceImpl extends AbstractService<UserRole, UserRoleRepository> {

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository repo) {
        super(repo);
    }
}