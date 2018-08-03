package com.petproject;

import com.petproject.client.SportActivityClient;
import com.petproject.model.SportActivity;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ActivitySportClientTest {

    @Test
    public void testGet(){
//        fail("not yet implemented");

        SportActivityClient client = new SportActivityClient();

        SportActivity activity = client.get("123");

        System.out.println(activity);

        assertNotNull(activity);
    }

    @Test
    public void testGetAll(){
        SportActivityClient client = new SportActivityClient();

        List<SportActivity> activityList = client.get();

        for (SportActivity activity: activityList){
            System.out.println(activity);
        }

        assertNotNull(activityList);
    }

    @Test(expected = RuntimeException.class)
    public void testBadRequest()
    {
        SportActivityClient client = new SportActivityClient();

        SportActivity activity = client.get("123");

    }

    @Test//(expected = RuntimeException.class)
    public void testNotFound()
    {
        SportActivityClient client = new SportActivityClient();

        SportActivity activity = client.get("7777");

    }

    @Test
    public void createActivity(){
        SportActivityClient client = new SportActivityClient();
        SportActivity sportActivity = new SportActivity();
        sportActivity.setDescription("coctail dance");
        sportActivity.setDuration("60");

         sportActivity = client.createActivity(sportActivity);

        assertNotNull(sportActivity);
    }

    @Test
    public void putActivity(){
        SportActivityClient client = new SportActivityClient();

        SportActivity sportActivity = new SportActivity();
        sportActivity.setDescription("playing violin");
        sportActivity.setDuration("75");

        sportActivity = client.updateActivity(sportActivity);

        assertNotNull(sportActivity);
    }

}
