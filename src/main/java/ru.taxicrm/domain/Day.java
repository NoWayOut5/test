package ru.taxicrm.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalTime;

@Entity(name = "days")
@Data
@ApiModel(description = "Список дней")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long dayid;

    @ApiModelProperty(value = "пн/вт/ср/чт/пт/сб/вс")
    private String name;

    @ApiModelProperty(value = "in/out")
    private String direction;

    @ApiModelProperty(example = "00:00", dataType = "String")
    private LocalTime time;

    @ApiModelProperty(value = "Расписание")
    private Long sheduleid;

    @ManyToOne
    @JoinColumn(name = "sheduleid", insertable = false, updatable = false)
    @JsonIgnore
    @ToString.Exclude
    @ApiModelProperty(hidden = true)
    private Shedule shedule;
}