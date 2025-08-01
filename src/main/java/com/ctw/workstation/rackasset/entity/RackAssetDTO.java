package com.ctw.workstation.rackasset.entity;

import java.util.UUID;

public class RackAssetDTO {

    public UUID id;
    public String assettag;
    public UUID rackId;

    public RackAssetDTO(UUID id, String assettag, UUID rackId) {
        this.id = id;
        this.assettag = assettag;
        this.rackId = rackId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAssettag() {
        return assettag;
    }

    public void setAssettag(String assettag) {
        this.assettag = assettag;
    }

    public UUID getRackId() {
        return rackId;
    }

    public void setRackId(UUID rackId) {
        this.rackId = rackId;
    }
}
