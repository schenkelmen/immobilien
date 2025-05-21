package de.hsos.immo.boundary;

import de.hsos.immo.boundary.dto.AdresseDTO;
import de.hsos.immo.boundary.dto.ImmoDTO;
import de.hsos.immo.boundary.dto.NeuImmoDTO;
import de.hsos.immo.control.ImmoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Collection;

@Path("immobilien")
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class ImmoResource {

    @Inject
    ImmoService immoService;

    @GET
    public Response getAllImmo() {
        Collection<ImmoDTO> immos = immoService.getAllImmobilie()
                .stream()
                .map(ImmoDTO::toDTO)
                .toList();
        return Response.ok(immos).build();
    }

    @GET
    @Path("/{id}")
    public Response getImmoById(@PathParam("id") long id) {
        ImmoDTO immoDTO = immoService.getImmobilieById(id)
                .map(ImmoDTO::toDTO)
                .orElseThrow(() -> new NotFoundException("Immo not found"));
        if(immoDTO == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(immoDTO).build();
    }

    @POST
    public Response createImmo(NeuImmoDTO neuImmoDTO) {
        long id = immoService.neueImmobilieAnlegen(neuImmoDTO.name(), neuImmoDTO.description(), neuImmoDTO.adresse());
        return Response.status(Response.Status.CREATED).entity(id).build();
    }

}
