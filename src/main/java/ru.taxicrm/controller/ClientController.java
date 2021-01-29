package ru.taxicrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.taxicrm.domain.Client;
import ru.taxicrm.service.ClientService;

@RestController
@RequestMapping("client")
@CrossOrigin
public class ClientController {

    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "save")
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }
}