package com.petproject.repository;

import com.petproject.model.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityRepositoryStub implements ActivityRepository {

    @Override
    public List<Activity> findAllActivities() {
        List<Activity> activities = new ArrayList<Activity>();

        Activity activity1= new Activity();
        activity1.setDescription("dancing");
        activity1.setDuration(45);

        Activity activity2 = new Activity();
        activity2.setDescription("cycling");
        activity2.setDuration(60);

        activities.add(activity1);
        activities.add(activity2);

        return activities;
    }
}
