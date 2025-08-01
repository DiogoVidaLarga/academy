package com.ctw.workstation.rack.entity;

import java.util.UUID;

public class RackDTO {

    public UUID id;
    public String serialNumber;
    public Status status;
    public UUID teamId;

    public RackDTO(UUID id, String serialNumber, Status status, UUID teamId) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.status = status;
        this.teamId = teamId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public void setTeamId(UUID teamId) {
        this.teamId = teamId;
    }
}
