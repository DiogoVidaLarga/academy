package com.ctw.workstation.teammember.entity;

import java.util.UUID;

public class TeamMemberDTO {

    public UUID id;
    public UUID teamId;
    public String ctwId;
    public String name;

    public TeamMemberDTO(UUID id, UUID teamId,String ctwId, String name) {
        this.id = id;
        this.teamId = teamId;
        this.ctwId = ctwId;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCtwId() {
        return ctwId;
    }

    public void setCtwId(String ctwId) {
        this.ctwId = ctwId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public void setTeamId(UUID teamId) {
        this.teamId = teamId;
    }
}
