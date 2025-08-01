package com.ctw.workstation.team.boundary;

import com.ctw.workstation.team.control.TeamService;
import com.ctw.workstation.team.entity.TeamDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


import java.util.List;
import java.util.UUID;

@Path("/workstation/teams")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource {

    @Inject
    TeamService teamService;

    @GET
    public Response getAll() {
        List<TeamDTO> teams = teamService.getAllTeams();
        return Response.ok(teams).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") UUID id) {
        TeamDTO team = teamService.getTeamById(id);
        if (team != null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(team).build();
    }

    @POST
    public Response create(TeamDTO dto) {
        TeamDTO created = teamService.createTeam(dto);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") UUID id, TeamDTO dto) {
        TeamDTO updated = teamService.updateTeam(id, dto);
        if (updated != null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") UUID id) {
        boolean deleted = teamService.deleteTeam(id);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}