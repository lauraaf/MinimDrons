package edu.upc.dsa.services;



import edu.upc.dsa.DronManager;
import edu.upc.dsa.DronsManagerImpl;
import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.FlightPlan;
import edu.upc.dsa.models.Pilot;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/Drons", description = "Endpoint to Drons Service")
@Path("/DronsManager")
public class DronService {

    private DronManager dm;

    public DronService() {
        this.dm = DronsManagerImpl.getInstance();
        if (dm.size()==0) {
            this.dm.addDron("1", "Air98","Vueling","X405");

        }


    }
    @POST
    @ApiOperation(value = "Add new dron", notes = "Add new dron")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Dron.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/Add Dron")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDron(Dron dron){

        if (dron.getIdDron()==null || dron.getName()==null || dron.getFabricant()==null)  return Response.status(500).entity(dron).build();
        this.dm.addDron(dron.getIdDron(), dron.getModel(), dron.getFabricant(), dron.getFabricant());
        return Response.status(201).entity(dron).build();
    }


    @GET
    @ApiOperation(value = "get Flight plans from a pilot", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Pilot.class, responseContainer="List"),
    })
    @Path("/get Flight Plans")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPilotFlightPlans(Pilot pilot) {

        List<FlightPlan> fp = this.dm.pilotFlightPlans(pilot);

        GenericEntity<List<FlightPlan>> entity = new GenericEntity<List<FlightPlan>>(fp) {};
        return Response.status(201).entity(entity).build()  ;

    }

    /*@GET
    @ApiOperation(value = "get Flight plans from a dron", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Dron.class, responseContainer="List"),
    })
    @Path("/get Flight Plans")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFlightPlansD(Dron dron) {

        List<FlightPlan> fp = this.dm.dronFlightPlans(dron);

        GenericEntity<List<FlightPlan>> entity = new GenericEntity<List<FlightPlan>>(fp) {};
        return Response.status(201).entity(entity).build()  ;

    }



    /*@POST
    @ApiOperation(value = "Add new product", notes = "Add new product")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Product.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProduct(Product product){

        if (product.getIdProduct()==null || product.getName()==null || product.getPrice()== 0)  return Response.status(500).entity(product).build();
        this.pm.addProduct(product.getIdProduct(), product.getName(), product.getPrice());
        return Response.status(201).entity(product).build();
    }
   /* @GET
    @ApiOperation(value = "get all Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTracks() {

        List<User> tracks = this.tm.findAll();

        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(tracks) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @GET
    @ApiOperation(value = "get a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrack(@PathParam("id") String id) {
        User t = this.tm.getTrack(id);
        if (t == null) return Response.status(404).build();
        else  return Response.status(201).entity(t).build();
    }

    @DELETE
    @ApiOperation(value = "delete a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    public Response deleteTrack(@PathParam("id") String id) {
        User t = this.tm.getTrack(id);
        if (t == null) return Response.status(404).build();
        else this.tm.deleteTrack(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    public Response updateTrack(User track) {

        User t = this.tm.updateTrack(track);

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= User.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newTrack(User track) {

        if (track.getSinger()==null || track.getTitle()==null)  return Response.status(500).entity(track).build();
        this.tm.addTrack(track);
        return Response.status(201).entity(track).build();
    }*/

}