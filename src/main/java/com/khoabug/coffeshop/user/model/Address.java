package com.khoabug.coffeshop.user.model;

import com.khoabug.coffeshop.common.model.AbstractModel;

import java.io.Serializable;

/**
 * @author : khoabug
 * @created : 7/24/23, Monday
 **/
public class Address extends AbstractModel<User> implements Serializable {
    private Integer streetNumber;
    private String addressLine;
    private String city;
    private Long postalCode;

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
    }
}
