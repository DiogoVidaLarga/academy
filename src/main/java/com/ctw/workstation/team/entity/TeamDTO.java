package com.ctw.workstation.team.entity;

import java.util.UUID;

public class TeamDTO {

    public UUID id;
    public String name;
    public String product;

    public TeamDTO(UUID id, String name, String product) {
        this.id = id;
        this.name = name;
        this.product = product;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
