package com.ctw.workstation.team.control;

import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamDTO;
import com.ctw.workstation.team.entity.TeamMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class TeamService {

    @Inject
    TeamRepository teamRepository;

    public List<TeamDTO> getAllTeams() {
        return teamRepository
                .listAll()
                .stream()
                .map(TeamMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TeamDTO getTeamById(UUID id) {
        Team team = teamRepository.findById(id);
        return TeamMapper.toDTO(team);
    }

    @Transactional
    public TeamDTO createTeam(TeamDTO dto) {
        Team team = TeamMapper.toEntity(dto);
        team.setCreatedAt(java.time.LocalDateTime.now());
        team.setModifiedAt(java.time.LocalDateTime.now());
        team.setDefaultLocation("Portugal");
        teamRepository.persist(team);
        return TeamMapper.toDTO(team);
    }

    @Transactional
    public TeamDTO updateTeam(UUID id,TeamDTO dto) {
        Team team = teamRepository.findById(id);
        if (team == null) {
            return null;
        }
        team.setName(dto.name);
        team.setProduct(dto.product);
        team.setModifiedAt(java.time.LocalDateTime.now());
        return TeamMapper.toDTO(team);
    }

    @Transactional
    public boolean deleteTeam(UUID id) {
        Team team = teamRepository.findById(id);
        if (team == null) {
            return false;
        }
        teamRepository.delete(team);
        return true;
    }

}
