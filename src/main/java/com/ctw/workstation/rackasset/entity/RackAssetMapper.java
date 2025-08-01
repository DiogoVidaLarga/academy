package com.ctw.workstation.rackasset.entity;

public class RackAssetMapper {

    //convert Entity -> DTO
    public static RackAssetDTO toDTO(RackAsset rackAsset) {
        if (rackAsset == null) {
            return null;
        }
        return new RackAssetDTO(
                rackAsset.getId(),
                rackAsset.getAssetTag(),
                rackAsset.getRackId()
        );
    }


    //Convert DTO -> Entity
    public static RackAsset toEntity(RackAssetDTO dto) {
        if (dto == null) {
            return null;
        }
        RackAsset asset = new RackAsset();
        asset.setId(dto.getId());
        asset.setAssetTag(dto.getAssettag());
        asset.setRackId(dto.getRackId());
        return asset;
    }

}
