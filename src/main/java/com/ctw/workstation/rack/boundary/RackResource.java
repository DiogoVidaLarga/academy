package com.ctw.workstation.rack.boundary;

import com.ctw.workstation.rack.control.RackService;
import com.ctw.workstation.rack.entity.RackDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Path("/workstation/racks")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RackResource {

    @Inject
    RackService rackService;

    @GET
    public Response getAll() {
        List<RackDTO> racks = rackService.getAllRacks();
        return Response.ok(racks).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") UUID id) {
        RackDTO rack = rackService.getRackById(id);
        if (rack != null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(rack).build();
    }

    @POST
    public Response create(RackDTO dto) {
        RackDTO created = rackService.createRack(dto);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") UUID id, RackDTO dto) {
        RackDTO updated = rackService.updateRack(id, dto);
        if (updated != null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") UUID id) {
        boolean deleted = rackService.deleteRack(id);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}