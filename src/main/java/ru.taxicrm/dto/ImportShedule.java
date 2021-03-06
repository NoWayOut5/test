package ru.taxicrm.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalTime;

@Data
public class ImportShedule {

    private String city;

    private String clname;

    private String phone;

    private String startingpoint;

    private String transportway;

    @ApiModelProperty(example = "00:00", dataType = "String")
    private LocalTime mon_in;

    @ApiModelProperty(example = "00:00", dataType = "String")
    private LocalTime mon_out;

    @ApiModelProperty(example = "00:00", dataType = "String")
    private LocalTime tue_in;

    @ApiModelProperty(example = "00:00", dataType = "String")
    private LocalTime tue_out;

    @ApiModelProperty(example = "00:00", dataType = "String")
    private LocalTime wed_in;

    @ApiModelProperty(example = "00:00", dataType = "String")
    private LocalTime wed_out;

    @ApiModelProperty(example = "00:00", dataType = "String")
    private LocalTime thu_in;

    @ApiModelProperty(example = "00:00", dataType = "String")
    private LocalTime thu_out;

    @ApiModelProperty(example = "00:00", dataType = "String")
    private LocalTime fri_in;

    @ApiModelProperty(example = "00:00", dataType = "String")
    private LocalTime fri_out;

    @ApiModelProperty(example = "00:00", dataType = "String")
    private LocalTime sat_in;

    @ApiModelProperty(example = "00:00", dataType = "String")
    private LocalTime sat_out;

    @ApiModelProperty(example = "00:00", dataType = "String")
    private LocalTime sun_in;

    @ApiModelProperty(example = "00:00", dataType = "String")
    private LocalTime sun_out;

    private String destination;

    private String destname;

    private String customer;

    private String contractor;

    private String note;
}