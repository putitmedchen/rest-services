package com.petproject.view;

import com.petproject.model.Activity;
import com.petproject.repository.ActivityRepository;
import com.petproject.repository.ActivityRepositoryStub;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("activities")
public class ActivityResource {

    private ActivityRepository activityRepository = new ActivityRepositoryStub();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Activity> getAllActivities() {
        return activityRepository.findAllActivities();
    }


}
