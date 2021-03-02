package ru.taxicrm.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import ru.taxicrm.domain.Contractor;
import ru.taxicrm.service.impl.ContractorServiceImpl;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ContractorServiceImplTest {

    @Mock
    private ContractorServiceImpl contractorService;

    private Contractor contractor;

    @Before
    public void init() {
        contractor = new Contractor();
        contractor.setContractorid(1L);
        contractor.setName("test1");
    }

    @Test
    public void saveTest() {
        contractorService.save(contractor);
        verify(contractorService, times(1)).save(contractor);
    }

    @Test
    public void findByIdTest() {
        contractorService.findById(1L);
        verify(contractorService, times(1)).findById(1L);
    }
}