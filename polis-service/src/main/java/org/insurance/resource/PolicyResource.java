package org.insurance.resource;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.insurance.dto.PolicyRequest;
import org.insurance.entity.Policy;
import org.insurance.service.PolicyService;

import java.util.List;

@Path("/polis")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PolicyResource {

    @Inject
    PolicyService policyService;

    @GET
    public List<Policy> listAll(){
        return policyService.listAll();
    }

    @GET
    @Path("/{id}")
    public Policy getById(@PathParam("id")Long id){
        return policyService.getById(id);
    }

    @POST
    @Path("/create")
    public Policy create(PolicyRequest request){
        return policyService.create(request);
    }
}
