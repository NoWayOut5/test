package ru.taxicrm.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "users")
@Data
@ApiModel(description = "Пользователи")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long userid;

    private String login;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String name;

    @ApiModelProperty(example = "1")
    private Integer enabled;

    @CreationTimestamp
    @ApiModelProperty(hidden = true)
    private LocalDateTime createdate;

    private Long contractorid;
}