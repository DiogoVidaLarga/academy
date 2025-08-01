package com.ctw.workstation.rackasset.entity;

import com.ctw.workstation.rack.entity.Rack;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "RACK_ASSET")

public class RackAsset extends PanacheEntityBase {

    @Id
    @GeneratedValue
    @Column(name = "id",updatable = false, nullable = false)
    private UUID id;

    @Column(name = "ASSET_TAG", length = 20, nullable = false)
    public String assetTag;

    @Column(name = "RACK_ID")
    public UUID rackId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RACK_ID",updatable = false, insertable = false,nullable = false)
    private Rack rack;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public UUID getRackId() {
        return rackId;
    }

    public void setRackId(UUID rackId) {
        this.rackId = rackId;
    }
}
