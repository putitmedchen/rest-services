package com.petproject.view;

import com.petproject.model.SportActivity;
import com.petproject.model.User;
import com.petproject.repository.SportActivityRepository;
import com.petproject.repository.SportActivityRepositoryStub;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
    public SportActivity getActivity(@PathParam("activityId") String activityId) {
        return sportActivityRepository.findActivity(activityId);
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
    public SportActivity createActivityParam(SportActivity activity) {
        SportActivity sportActivity = activity;
        sportActivityRepository.createSportActivity(sportActivity);
        return sportActivity;
    }


}
