package com.example.demo.salescontrol.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer personSeller;
    private Integer productId;
    private long quantity;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setPersonSeller(Integer personSeller) {
        this.personSeller = personSeller;
    }

    public Integer getPersonSeller() {
        return personSeller;
    }

    public void setProductId(Integer productId) {

        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }
}

