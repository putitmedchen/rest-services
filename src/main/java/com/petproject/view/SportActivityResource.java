package com.petproject.view;

import com.petproject.model.SportActivity;
import com.petproject.model.User;
import com.petproject.repository.SportActivityRepository;
import com.petproject.repository.SportActivityRepositoryStub;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("activities") //http://localhost:8080/webapi/activities
public class SportActivityResource {

    private SportActivityRepository sportActivityRepository = new SportActivityRepositoryStub();

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.WILDCARD})
    public List<SportActivity> getAllActivities() {
        return sportActivityRepository.findAllActivities();
    }

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

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.WILDCARD})
    @Path("{activityId}/user")
    public User getUserByActivity(@PathParam("activityId") String activityId) {
        return sportActivityRepository.findActivity(activityId).getUser();
    }

    @POST
    @Path("activity")//http://localhost:8080/webapi/activities/activity
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public SportActivity createActivityParam(SportActivity sportActivity) {
        SportActivity activity = sportActivityRepository.createSportActivity(sportActivity);
        System.out.println("POST " + activity);
        return activity;
    }

    @PUT
    @Path("{activityId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public SportActivity updateActivity(SportActivity sportActivity) {
        SportActivity activity = sportActivityRepository.updateSportActivity(sportActivity);
        System.out.println("PUT " + activity);
        return activity;
    }

}
