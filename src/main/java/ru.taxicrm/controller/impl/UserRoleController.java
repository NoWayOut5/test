package ru.taxicrm.controller.impl;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.taxicrm.controller.AbstractController;
import ru.taxicrm.domain.UserRole;
import ru.taxicrm.repository.UserRoleRepository;
import ru.taxicrm.service.impl.UserRoleServiceImpl;

@RestController
@RequestMapping("userrole")
@Api(tags = {"Роли пользователей"})
@CrossOrigin
public class UserRoleController extends AbstractController<UserRole, UserRoleRepository, UserRoleServiceImpl> {

    @Autowired
    public UserRoleController(UserRoleServiceImpl service) {
        super(service);
    }
}