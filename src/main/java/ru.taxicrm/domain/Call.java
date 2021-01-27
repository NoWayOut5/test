package ru.taxicrm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Call {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long callid;

    private String phone;

    private String name;

    private Long clientid;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(example = "2020-31-01 23:59:59")
    private LocalDateTime recordtime;

    private Long userid;

    public Long getCallid() {
        return callid;
    }

    public void setCallid(Long callid) {
        this.callid = callid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getClientid() {
        return clientid;
    }

    public void setClientid(Long clientid) {
        this.clientid = clientid;
    }

    public LocalDateTime getRecordtime() {
        return recordtime;
    }

    public void setRecordtime(LocalDateTime recordtime) {
        this.recordtime = recordtime;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Call call = (Call) o;
        return Objects.equals(callid, call.callid) &&
                Objects.equals(phone, call.phone) &&
                Objects.equals(name, call.name) &&
                Objects.equals(clientid, call.clientid) &&
                Objects.equals(recordtime, call.recordtime) &&
                Objects.equals(userid, call.userid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(callid, phone, name, clientid, recordtime, userid);
    }

    @Override
    public String toString() {
        return "Call{" +
                "callid=" + callid +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", clientid=" + clientid +
                ", recordtime=" + recordtime +
                ", userid=" + userid +
                '}';
    }
}