package com.ctw.workstation.teammember.entity;

public class TeamMemberMapper {

    //convert Entity -> DTO
    public static TeamMemberDTO toDTO(TeamMember member) {
        if (member == null) {
            return null;
        }
        return new TeamMemberDTO(
                member.getId(),
                member.getTeamId(),
                member.getCtwId(),
                member.getName()
        );
    }

    //Convert DTO -> Entity
    public static TeamMember toEntity(TeamMemberDTO dto) {
        if (dto == null) {
            return null;
        }
        TeamMember member = new TeamMember();
        member.setId(dto.getId());
        member.setTeamId(dto.getTeamId());
        member.setCtwId(dto.getCtwId());
        member.setName(dto.getName());
        return member;
    }

}
