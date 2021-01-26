package ru.taxicrm.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import ru.taxicrm.domain.Call;

import java.time.LocalDateTime;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CallServiceTest {

    @Mock
    private CallService callService;

    private Call call;

    @Before
    public void init() {
        call = new Call();
        call.setCallid(1L);
        call.setClientid(1L);
        call.setUserid(1L);
        call.setName("test2");
        call.setPhone("0000000000");
        call.setRecordtime(LocalDateTime.now());
    }

    @Test
    public void saveTest() {
        callService.save(call);
        verify(callService, times(1)).save(call);
    }

    @Test
    public void findByIdTest() {
        callService.findById(1L);
        verify(callService, times(1)).findById(1L);
    }
}