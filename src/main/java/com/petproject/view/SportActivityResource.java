package com.petproject.view;

import com.petproject.model.SportActivity;
import com.petproject.model.User;
import com.petproject.repository.SportActivityRepository;
import com.petproject.repository.SportActivityRepositoryStub;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("activities") //http://localhost:8080/webapi/activities
public class SportActivityResource {

    private SportActivityRepository sportActivityRepository = new SportActivityRepositoryStub();

    //http://localhost:8080/webapi/activities
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.WILDCARD})
    public Response getAllActivities() {
        List<SportActivity> activitiesList = sportActivityRepository.findAllActivities();

        return  Response.ok().entity(new GenericEntity<List<SportActivity>>(activitiesList){}).build();
    }

    //http://localhost:8080/webapi/activities/{activityId}
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.WILDCARD})
    @Path("{activityId}")
    public Response getActivity(@PathParam("activityId") String activityId) {
        if (activityId == null | activityId.length() < 4) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        SportActivity sportActivity = sportActivityRepository.findActivity(activityId);

        if (sportActivity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok().entity(sportActivity).build();
    }


    //http://localhost:8080/webapi/activities/{activityId}/user
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.WILDCARD})
    @Path("{activityId}/user")
    public Response getUserByActivity(@PathParam("activityId") String activityId) {

        User user =  sportActivityRepository.findActivity(activityId).getUser();
        System.out.println("Get user " + user + " by activityId" + activityId);

        return Response.ok().entity(user).build();
    }

    //http://localhost:8080/webapi/activities/activity
    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response createActivityParam(SportActivity sportActivity) {

        SportActivity activity = sportActivityRepository.createSportActivity(sportActivity);
        System.out.println("POST " + activity);

        return Response.ok().entity(activity).build();
    }

    //http://localhost:8080/webapi/activities/activity/{activityId}
    @PUT
    @Path("{activityId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateActivity(SportActivity sportActivity) {
        SportActivity activity = sportActivityRepository.updateSportActivity(sportActivity);
        System.out.println("PUT " + activity);
        return Response.ok().entity(activity).build();
    }

    //http://localhost:8080/webapi/activities/activity/{activityId}
    @DELETE
    @Path("{activityId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response deleteActivity(@PathParam("activityId") String activityId){
        System.out.println("DELETE sport activity with id = " + activityId);
        sportActivityRepository.deleteSportActivity(activityId);

        return Response.ok().build();
    }

}
