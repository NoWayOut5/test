package ru.taxicrm.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import ru.taxicrm.domain.Client;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ClientServiceTest {

    @Mock
    private ClientService clientService;

    private Client client;

    @Before
    public void init() {
        client = new Client();
        client.setClientid(1L);
        client.setName("test1");
    }

    @Test
    public void saveTest() {
        clientService.save(client);
        verify(clientService, times(1)).save(client);
    }

    @Test
    public void findByIdTest() {
        clientService.findById(1L);
        verify(clientService, times(1)).findById(1L);
    }
}