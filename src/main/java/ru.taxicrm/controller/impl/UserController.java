package ru.taxicrm.controller.impl;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.taxicrm.controller.AbstractController;
import ru.taxicrm.domain.User;
import ru.taxicrm.repository.UserRepository;
import ru.taxicrm.service.impl.UserServiceImpl;

@RestController
@RequestMapping("user")
@Api(tags = {"Пользователи"})
public class UserController extends AbstractController<User, UserRepository, UserServiceImpl> {

    @Autowired
    public UserController(UserServiceImpl service) {
        super(service);
    }
}