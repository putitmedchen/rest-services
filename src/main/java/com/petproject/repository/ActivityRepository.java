package com.petproject.repository;

import com.petproject.model.Activity;

import java.util.List;

public interface ActivityRepository {

    List<Activity> findAllActivities();

}
