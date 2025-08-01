package com.ctw.workstation.team.entity;

public class TeamMapper {

    //Entity -> DTO
    public static TeamDTO toDTO(Team team) {
        if (team == null) {
            return null;
        }
        return new TeamDTO(
                team.getId(),
                team.getName(),
                team.getProduct()
        );
    }

    //DTO -> Entity
    public static Team toEntity(TeamDTO teamDTO) {
        if (teamDTO == null) {
            return null;
        }
        Team team = new Team();
        team.setId(teamDTO.id);
        team.setName(teamDTO.name);
        team.setProduct(teamDTO.product);
        return team;
    }
}
