package ru.taxicrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.taxicrm.domain.Call;
import ru.taxicrm.service.CallService;

@RestController
@RequestMapping("call")
public class CallController {

    private CallService callService;

    @Autowired
    public void setCallService(CallService callService) {
        this.callService = callService;
    }

    @PostMapping(value = "save")
    public void save(@RequestBody Call call) {
        callService.save(call);
    }
}
