package ru.taxicrm.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long clientid;

    private String name;

    public Long getClientid() {
        return clientid;
    }

    public void setClientid(Long clientid) {
        this.clientid = clientid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(clientid, client.clientid) &&
                Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientid, name);
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientid=" + clientid +
                ", name='" + name + '\'' +
                '}';
    }
}