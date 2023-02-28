package br.com.udemy.data.vo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@JsonPropertyOrder({"id", "address", "first_name", "last_name", "gender"})
//JsonPropertyOrder: essa anotation server para mudar a order das propriedades
public class PersonVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    @JsonProperty("first_name")
    //@JsonProperty: essa anotation server para definir como você quer fique seu JSON
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String address;
    @JsonIgnore
    //@JsonIgnore: essa anotation serve para ocultar essa propriedade do JSON
    private String gender;
    private Date birthDay;

    public PersonVO() {}

    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }

    public String getFirstName() {

        return firstName;
    }
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }
    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getAddress() {

        return address;
    }
    public void setAddress(String address) {

        this.address = address;
    }

    public String getGender() {

        return gender;
    }
    public void setGender(String gender) {

        this.gender = gender;
    }

    public Date getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonVO that)) return false;
        return Objects.equals(getId(),
                that.getId()) && Objects.equals(getFirstName(),
                that.getFirstName()) && Objects.equals(getLastName(),
                that.getLastName()) && Objects.equals(getAddress(),
                that.getAddress()) && Objects.equals(getGender(),
                that.getGender()) && Objects.equals(getBirthDay(), that.getBirthDay());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getFirstName(),
                getLastName(),
                getAddress(),
                getGender(),
                getBirthDay());
    }
}
