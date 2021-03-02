package ru.taxicrm.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@ApiModel(description = "Расписание")
public class Shedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long sheduleid;

    @ApiModelProperty(value = "Контрагенты")
    private Long contractorid;

    @ApiModelProperty(value = "Города")
    private Long cityid;

    @ApiModelProperty(value = "ФИО")
    private String clname;

    @ApiModelProperty(value = "Телефон")
    private String phone;

    @ApiModelProperty(value = "Адрес проживания")
    private String startingpoint;

    @ApiModelProperty(value = "Способ перевозки")
    private String transportway;

    @ApiModelProperty(value = "Пункт назначения")
    private String destination;

    @ApiModelProperty(value = "Примечание")
    private String note;

    @ApiModelProperty(value = "Активно с", example = "2000-01-01 00:00:00")
    private LocalDateTime datefrom;

    @ApiModelProperty(value = "Активно по", example = "2000-01-01 00:00:00")
    private LocalDateTime dateto;

    @OneToMany(mappedBy = "shedule")
    @ApiModelProperty(hidden = true)
    private List<Day> days;

    @ManyToOne
    @JoinColumn(name = "cityid", insertable = false, updatable = false)
    @ApiModelProperty(hidden = true)
    private City city;
}