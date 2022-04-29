package edu.upc.eetac.dsa.services;

import edu.upc.eetac.dsa.models.*;
import edu.upc.eetac.dsa.JuegoManager;
import edu.upc.eetac.dsa.JuegoManagerImpl;

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

@Api(value = "/JuegoManager", description = "Endpoint to User Service")
@Path("/JuegoManager")

public class ManagerService {

    static final Logger logger = Logger.getLogger(ManagerService.class);

    private JuegoManager manager;

    public ManagerService() {

        PropertyConfigurator.configure("src/main/resources/log4j.properties");

        this.manager = JuegoManagerImpl.getInstance();

            Usuario usuario1 = new Usuario("Adrián", "Quirós", "15-09-2000",
                    "adrian.quiros@estudiantat.upc.edu", "12345");

            Usuario usuario2 = new Usuario("Rodolfo", "Rangel", "05-10-1960",
                "rodolfo.rangel@gmail.com", "12345");

            this.manager.RegistrarUsuario(usuario1);
            this.manager.RegistrarUsuario(usuario2);
        }
    }

    @GET
    @ApiOperation(value = "Get all usuarios", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class, responseContainer = "List"),
    })
    @Path("/Usuarios")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarios() {

        List<Usuario> usuario = this.manager.getListaDeUsuarios();
        GenericEntity<List<Usuario>> entity = new GenericEntity<List<Usuario>>(usuario) {
        };
        return Response.status(201).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "Get all objetos", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objeto.class, responseContainer = "List"),
    })

    @Path("/Objetos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjetos() {
        List<Objeto> TiendaDeObjetos = this.manager.getListaDeObjetos();
        GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(TiendaDeObjetos); {
        };
        return Response.status(201).entity(entity).build();
    }
}