package com.petproject.repository;

import com.petproject.model.SportActivity;

import java.util.List;

public interface SportActivityRepository {

    List<SportActivity> findAllActivities();

    SportActivity findActivity(String activityId);

    void createSportActivity(SportActivity sportActivity);
}
