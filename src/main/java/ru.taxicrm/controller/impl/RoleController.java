package ru.taxicrm.controller.impl;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.taxicrm.controller.AbstractController;
import ru.taxicrm.domain.Role;
import ru.taxicrm.repository.RoleRepository;
import ru.taxicrm.service.impl.RoleServiceImpl;

@RestController
@RequestMapping("role")
@Api(tags = {"Роли"})
@CrossOrigin
public class RoleController extends AbstractController<Role, RoleRepository, RoleServiceImpl> {

    @Autowired
    public RoleController(RoleServiceImpl service) {
        super(service);
    }
}