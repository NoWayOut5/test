package ru.taxicrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.taxicrm.domain.User;
import ru.taxicrm.repository.UserRepository;
import ru.taxicrm.service.AbstractService;

@Service
@Transactional
public class UserServiceImpl extends AbstractService<User, UserRepository> {

    @Autowired
    public UserServiceImpl(UserRepository repo) {
        super(repo);
    }
}