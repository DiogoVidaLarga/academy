package com.ctw.workstation.teammember.boundary;

import com.ctw.workstation.teammember.control.TeamMemberService;
import com.ctw.workstation.teammember.entity.TeamMemberDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Path("/workstation/teamMembers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeamMemberResource {

    @Inject
    TeamMemberService teamMemberService;

    @GET
    public Response getAll() {
        List<TeamMemberDTO> members = teamMemberService.getAllTeamMembers();
        return Response.ok(members).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") UUID id) {
        TeamMemberDTO member = teamMemberService.getTeamMemberById(id);
        if (member != null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(member).build();
    }

    @POST
    public Response create(TeamMemberDTO dto) {
        TeamMemberDTO created = teamMemberService.createTeamMember(dto);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") UUID id, TeamMemberDTO dto) {
        TeamMemberDTO updated = teamMemberService.updateTeamMember(id, dto);
        if (updated != null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") UUID id) {
        boolean deleted = teamMemberService.deleteTeamMember(id);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
