package com.ctw.workstation.rack.entity;

public class RackMapper {

    //convert Entity -> DTO
    public static RackDTO toDTO(Rack rack) {
        if (rack == null) {
            return null;
        }
        return new RackDTO(
            rack.getId(),
            rack.getSerialNumber(),
            rack.getStatus(),
            rack.getTeamId()
        );
    }

    //Convert DTO -> Entity
    public static Rack toEntity(RackDTO dto) {
        if (dto == null) {
            return null;
        }
        Rack rack = new Rack();
        rack.setId(dto.getId());
        rack.setSerialNumber(dto.getSerialNumber());
        rack.setStatus(dto.getStatus());
        rack.setTeamId(dto.getTeamId());
        return rack;
    }
}
