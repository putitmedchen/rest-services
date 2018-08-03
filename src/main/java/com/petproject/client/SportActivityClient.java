package com.petproject.client;

import com.petproject.model.SportActivity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class SportActivityClient {

    private Client client;

    public SportActivityClient() {
        client = ClientBuilder.newClient();
    }


    public SportActivity get(String id) {
        WebTarget target = client.target("http://localhost:8080/webapi/");

//            SportActivity response = target.path("activities/" + id).request().get(SportActivity.class);
        Response response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON_TYPE).get(Response.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException(response.getStatus() + " : there was an error on server");

        }

        return response.readEntity(SportActivity.class);
    }

    public List<SportActivity> get() {
        WebTarget target = client.target("http://localhost:8080/webapi/");

        List<SportActivity> response = target.path("activities/").request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<List<SportActivity>>() {
        });

        return response;

    }

    public SportActivity createActivity(SportActivity sportActivity) {
        WebTarget target = client.target("http://localhost:8080/webapi/");

//            SportActivity response = target.path("activities/" + id).request().get(SportActivity.class);
        Response response = target.path("activities/activity").request(MediaType.APPLICATION_JSON).post(Entity.entity(sportActivity, MediaType.APPLICATION_JSON));

        if (response.getStatus() != 200) {
            throw new RuntimeException(response.getStatus() + " : there was an error on server");
        }

        return response.readEntity(SportActivity.class);
    }

    public SportActivity updateActivity(SportActivity sportActivity) {
        WebTarget target = client.target("http://localhost:8080/webapi/");

        Response response = target.path("activities/" + sportActivity.getId()).request(MediaType.APPLICATION_JSON).put(Entity.entity(sportActivity, MediaType.APPLICATION_JSON));

        if (response.getStatus() != 200){
            throw new RuntimeException(response.getStatus() + " : there was an error on server");
        }

        return response.readEntity(SportActivity.class);
    }
}

