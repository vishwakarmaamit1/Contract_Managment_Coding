package com.aconex.cost.contract.controllers;

import com.aconex.cost.contract.repositories.ContractRepository;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/contracts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.WILDCARD)
public class ContractsController {

    private final ContractRepository contractRepository;

    public ContractsController(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @GET
    @UnitOfWork
    public Response index() {
        return Response.ok(contractRepository.findAll()).build();
    }
}
