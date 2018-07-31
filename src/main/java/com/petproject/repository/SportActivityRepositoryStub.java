package com.petproject.repository;

import com.petproject.model.SportActivity;
import com.petproject.model.User;

import java.util.ArrayList;
import java.util.List;

public class SportActivityRepositoryStub implements SportActivityRepository {

    @Override
    public List<SportActivity> findAllActivities() {
        List<SportActivity> activities = new ArrayList<SportActivity>();

        SportActivity sportActivity1 = new SportActivity();
        sportActivity1.setDescription("dancing");
        sportActivity1.setDuration("45");

        SportActivity sportActivity2 = new SportActivity();
        sportActivity2.setDescription("cycling");
        sportActivity2.setDuration("60");

        activities.add(sportActivity1);
        activities.add(sportActivity2);

        return activities;
    }

    @Override
    public SportActivity findActivity(String activityId) {

        SportActivity sportActivity1 = new SportActivity();

        sportActivity1.setId("1234");
        sportActivity1.setDescription("dancing");
        sportActivity1.setDuration("45");

        User user = new User();
        user.setId("567");
        user.setName("Andrew");

        sportActivity1.setUser(user);

        return sportActivity1;
    }

    @Override
    public void createSportActivity(SportActivity sportActivity) {
        SportActivity sportActivity1 = sportActivity;
    }
}
