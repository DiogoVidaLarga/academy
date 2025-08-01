package com.ctw.workstation.team.control;

import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamMapper;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class TeamRepository implements PanacheRepositoryBase<Team, UUID> {


}
