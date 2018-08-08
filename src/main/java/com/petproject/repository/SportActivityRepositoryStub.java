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
        if (activityId.equals("7777")) {
            return null;
        }

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
    public SportActivity createSportActivity(SportActivity sportActivity) {
        //should have insert statement to DB
        return sportActivity;
    }

    @Override
    public SportActivity updateSportActivity(SportActivity sportActivity) {
        //search the DB to see weather such activity is present
        //select * from Activities where id=*id*?
        //in case yes - update it
        //in case no - create it
        return sportActivity;
    }

    @Override
    public void deleteSportActivity(String activityId){
        //search the DB to see weather such activity is present
        //in case yes - delete it
        //delete * from Activities where activityId = activityId;
    }


}
