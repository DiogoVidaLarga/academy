package com.ctw.workstation.teammember.control;

import com.ctw.workstation.teammember.entity.TeamMember;
import com.ctw.workstation.teammember.entity.TeamMemberDTO;
import com.ctw.workstation.teammember.entity.TeamMemberMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class TeamMemberService {

    @Inject
    TeamMemberRepository teamMemberRepository;

    public List<TeamMemberDTO> getAllTeamMembers() {
        return teamMemberRepository
                .listAll()
                .stream()
                .map(TeamMemberMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TeamMemberDTO getTeamMemberById(UUID id) {
        TeamMember member = teamMemberRepository.findById(id);
        return TeamMemberMapper.toDTO(member);
    }

    @Transactional
    public TeamMemberDTO createTeamMember(TeamMemberDTO dto) {
        TeamMember teamMember = TeamMemberMapper.toEntity(dto);
        teamMember.setCreatedAt(java.time.LocalDateTime.now());
        teamMember.setModifiedAt(java.time.LocalDateTime.now());
        teamMemberRepository.persist(teamMember);
        return TeamMemberMapper.toDTO(teamMember);
    }

    @Transactional
    public TeamMemberDTO updateTeamMember(UUID id, TeamMemberDTO dto) {
        TeamMember member = teamMemberRepository.findById(id);
        if (member == null) {
            return null;
        }
        member.setTeamId(dto.getTeamId());
        member.setCtwId(dto.getCtwId());
        member.setName(dto.getName());
        member.setModifiedAt(java.time.LocalDateTime.now());
        return TeamMemberMapper.toDTO(member);
    }

    @Transactional
    public boolean deleteTeamMember(UUID id) {
        TeamMember member = teamMemberRepository.findById(id);
        if (member == null) {
            return false;
        }

        teamMemberRepository.delete(member);
        return true;
    }
}
