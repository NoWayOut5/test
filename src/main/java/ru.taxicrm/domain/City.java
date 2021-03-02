package ru.taxicrm.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ApiModel(description = "Города")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long cityid;

    private String name;

    @OneToMany(mappedBy = "city")
    @JsonIgnore
    @ToString.Exclude
    @ApiModelProperty(hidden = true)
    private List<Shedule> shedules;
}