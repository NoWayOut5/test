package ru.taxicrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import ru.taxicrm.domain.City;
import ru.taxicrm.domain.Contractor;
import ru.taxicrm.domain.Day;
import ru.taxicrm.domain.Shedule;
import ru.taxicrm.dto.ImportShedule;
import ru.taxicrm.repository.SheduleRepository;
import ru.taxicrm.service.AbstractService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SheduleServiceImpl extends AbstractService<Shedule, SheduleRepository> {

    @Autowired
    public SheduleServiceImpl(SheduleRepository repo) {
        super(repo);
    }

    private CityServiceImpl cityService;
    private ContractorServiceImpl contractorService;
    private DayServiceImpl dayService;

    @Autowired
    public void setCityService(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @Autowired
    public void setContractorService(ContractorServiceImpl contractorService) {
        this.contractorService = contractorService;
    }

    @Autowired
    public void setDayService(DayServiceImpl dayService) {
        this.dayService = dayService;
    }

    public Optional<Shedule> getScheduleContractor(Long id) {
        List<Optional<Shedule>> obj = getRepo().getScheduleContractor(id);
        if (obj.size() == 0) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Объект с id = %s не найден", id)
            );
        }
        return obj.get(0);
    }

    public Shedule importText(ImportShedule importShedule) {
        // Если города нет в справочнике, то создаем
        String nameCity = importShedule.getCity();
        List<City> cities = cityService.findByNameIgnoreCase(nameCity);
        City city = null;
        if (cities.size() == 0) {
            City cityNotExist = new City();
            cityNotExist.setName(nameCity);
            city = cityService.save(cityNotExist);
        } else {
            city = cities.get(0);
        }

        // Если контрагента нет в справочнике, то создаем
        String nameContractor = importShedule.getContractor();
        List<Contractor> contractors = contractorService.findByNameIgnoreCase(nameContractor);
        Contractor contractor = null;
        if (contractors.size() == 0) {
            Contractor contractorNotExist = new Contractor();
            contractorNotExist.setName(nameContractor);
            contractor = contractorService.save(contractorNotExist);
        } else {
            contractor = contractors.get(0);
        }

        Shedule shedule = new Shedule();
        shedule.setCityid(city.getCityid());
        shedule.setClname(importShedule.getClname());
        shedule.setPhone(importShedule.getPhone());
        shedule.setStartingpoint(importShedule.getStartingpoint());
        shedule.setTransportway(importShedule.getTransportway());
        shedule.setDestination(importShedule.getDestination());
        shedule.setDestname(importShedule.getDestname());
        shedule.setCustomer(importShedule.getCustomer());
        shedule.setContractorid(contractor.getContractorid());
        shedule.setNote(importShedule.getNote());
        Shedule sheduleNew = getRepo().save(shedule);

        // Дни недели
        // пн
        Day dayMon_in = new Day();
        dayMon_in.setTime(importShedule.getMon_in());
        dayMon_in.setDirection("in");
        dayMon_in.setName("mon");
        dayMon_in.setSheduleid(sheduleNew.getSheduleid());
        dayService.save(dayMon_in);

        Day dayMon_out = new Day();
        dayMon_out.setTime(importShedule.getMon_out());
        dayMon_out.setDirection("out");
        dayMon_out.setName("mon");
        dayMon_out.setSheduleid(sheduleNew.getSheduleid());
        dayService.save(dayMon_out);

        // вт
        Day dayTue_in = new Day();
        dayTue_in.setTime(importShedule.getTue_in());
        dayTue_in.setDirection("in");
        dayTue_in.setName("tue");
        dayTue_in.setSheduleid(sheduleNew.getSheduleid());
        dayService.save(dayTue_in);

        Day dayTue_out = new Day();
        dayTue_out.setTime(importShedule.getTue_out());
        dayTue_out.setDirection("out");
        dayTue_out.setName("tue");
        dayTue_out.setSheduleid(sheduleNew.getSheduleid());
        dayService.save(dayTue_out);

        // ср
        Day dayWed_in = new Day();
        dayWed_in.setTime(importShedule.getWed_in());
        dayWed_in.setDirection("in");
        dayWed_in.setName("wed");
        dayWed_in.setSheduleid(sheduleNew.getSheduleid());
        dayService.save(dayWed_in);

        Day dayWed_out = new Day();
        dayWed_out.setTime(importShedule.getWed_out());
        dayWed_out.setDirection("out");
        dayWed_out.setName("wed");
        dayWed_out.setSheduleid(sheduleNew.getSheduleid());
        dayService.save(dayWed_out);

        // чт
        Day dayThu_in = new Day();
        dayThu_in.setTime(importShedule.getThu_in());
        dayThu_in.setDirection("in");
        dayThu_in.setName("thu");
        dayThu_in.setSheduleid(sheduleNew.getSheduleid());
        dayService.save(dayThu_in);

        Day dayThu_out = new Day();
        dayThu_out.setTime(importShedule.getThu_out());
        dayThu_out.setDirection("out");
        dayThu_out.setName("thu");
        dayThu_out.setSheduleid(sheduleNew.getSheduleid());
        dayService.save(dayThu_out);

        // пт
        Day dayFri_in = new Day();
        dayFri_in.setTime(importShedule.getFri_in());
        dayFri_in.setDirection("in");
        dayFri_in.setName("fri");
        dayFri_in.setSheduleid(sheduleNew.getSheduleid());
        dayService.save(dayFri_in);

        Day dayFri_out = new Day();
        dayFri_out.setTime(importShedule.getFri_out());
        dayFri_out.setDirection("out");
        dayFri_out.setName("fri");
        dayFri_out.setSheduleid(sheduleNew.getSheduleid());
        dayService.save(dayFri_out);

        // сб
        Day daySat_in = new Day();
        daySat_in.setTime(importShedule.getSat_in());
        daySat_in.setDirection("in");
        daySat_in.setName("sat");
        daySat_in.setSheduleid(sheduleNew.getSheduleid());
        dayService.save(daySat_in);

        Day daySat_out = new Day();
        daySat_out.setTime(importShedule.getSat_out());
        daySat_out.setDirection("out");
        daySat_out.setName("sat");
        daySat_out.setSheduleid(sheduleNew.getSheduleid());
        dayService.save(daySat_out);

        // вс
        Day daySun_in = new Day();
        daySun_in.setTime(importShedule.getSun_in());
        daySun_in.setDirection("in");
        daySun_in.setName("sun");
        daySun_in.setSheduleid(sheduleNew.getSheduleid());
        dayService.save(daySun_in);

        Day daySun_out = new Day();
        daySun_out.setTime(importShedule.getSun_out());
        daySun_out.setDirection("out");
        daySun_out.setName("sun");
        daySun_out.setSheduleid(sheduleNew.getSheduleid());
        dayService.save(daySun_out);

        return shedule;
    }
}