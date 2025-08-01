package com.ctw.workstation.rackasset.boundary;

import com.ctw.workstation.rackasset.control.RackAssetService;
import com.ctw.workstation.rackasset.entity.RackAssetDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Path("/workstation/rackAssets")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RackAssetResource {

    @Inject
    RackAssetService rackAssetService;

    @GET
    public Response getAll() {
        List<RackAssetDTO> asset = rackAssetService.getAllRackAssets();
        return Response.ok(asset).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") UUID id) {
        RackAssetDTO asset = rackAssetService.getRackAssetById(id);
        if (asset != null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(asset).build();
    }

    @POST
    public Response create(RackAssetDTO dto) {
        RackAssetDTO created = rackAssetService.createRackAsset(dto);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") UUID id, RackAssetDTO dto) {
        RackAssetDTO updated = rackAssetService.updateRackAsset(id, dto);
        if (updated != null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") UUID id) {
        boolean deleted = rackAssetService.deleteRackAsset(id);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}