package edu.upc.eetac.dsa.services;

import edu.upc.eetac.dsa.Manager;
import edu.upc.eetac.dsa.models.*;
import edu.upc.eetac.dsa.ManagerImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/Manager", description = "Endpoint to User Service")
@Path("/Manager")

public class ManagerService {

    static final Logger logger = Logger.getLogger(ManagerService.class);

    private Manager manager;

    public ManagerService() {

        PropertyConfigurator.configure("src/main/resources/log4j.properties");

        this.manager = ManagerImpl.getInstance();

        if (this.manager.getMapUsuarios().size() == 0) {

            //Usuario ElChupaCabras = new Persona("1", "ad-qu", "A");

            //this.manager.addUsuario(ElChupaCabras);
        }
    }

    @GET
    @ApiOperation(value = "Get all usuarios", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class, responseContainer = "List"),
    })
    @Path("/Usuarios")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {

        List<Usuario> personas = this.manager.getUsuario();
        GenericEntity<List<Usuario>> entity = new GenericEntity<List<Usuario>>(usuarios) {
        };
        return Response.status(201).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "Get all partidas", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Partida.class, responseContainer = "List"),
    })

    @Path("/Partidas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLabs() {
        List<Partida> labs = this.manager.getPartidas();
        GenericEntity<List<Partida>> entity = new GenericEntity<List<Partida>>(partidas) {
        };
        return Response.status(201).entity(entity).build();
    }
}