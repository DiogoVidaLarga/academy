package com.ctw.workstation.rack.entity;

import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.rackasset.entity.RackAsset;
import com.ctw.workstation.team.entity.Team;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "T_RACK")

public class Rack extends PanacheEntityBase {
    public static final String GET_ALL = "Rack.getAll";

    @Id
    @GeneratedValue
    @Column(name = "id",updatable = false, nullable = false)
    public UUID id;

    @Column(name = "SERIAL_NUMBER", length = 20, nullable = false)
    public String serialNumber;

    @Transient
    public Integer age;

    @Column(name = "ASSEMBLED_AT")
    public Date assembledAt;

    @Column(name = "STATUS")
    public Status status;

    @Column(name = "TEAM_ID", nullable = false)
    public UUID teamId;

    @Column(name = "DEFAULT_LOCATION")
    public String defaultLocation;

    @Column(name = "CREATED_AT")
    public LocalDateTime createdAt;

    @Column(name = "MODIFIED_AT")
    public LocalDateTime modifiedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID", updatable = false, insertable = false, nullable = false)
    public Team team;

    @OneToMany(mappedBy = "rack", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "rack", fetch = FetchType.LAZY)
    private List<RackAsset> rackAssets;


    public String getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAssembledAt(Date assembledAt) {
        this.assembledAt = assembledAt;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTeamId(UUID teamId) {
        this.teamId = teamId;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public UUID getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Integer getAge() {
        return age;
    }

    public Date getAssembledAt() {
        return assembledAt;
    }

    public Status getStatus() {
        return status;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public Team getTeam() {
        return team;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<RackAsset> getRackAssets() {
        return rackAssets;
    }

    public void setRackAssets(List<RackAsset> rackAssets) {
        this.rackAssets = rackAssets;
    }


}
