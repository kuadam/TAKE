/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

/**
 *
 * @author kuadam
 */
public class Main {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();

        String all = client.target("http://localhost:8080/Complaints/resources/complaints/")
                .request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        System.out.println("All: " + all);

        JSONArray list = new JSONArray(all);
        int id = 0;
        for (int i = 0; i < list.length(); i++) {
            JSONObject item = list.getJSONObject(i);
            String status = item.getString("status");
            if ("open".equals(status)) {
                id = item.getInt("id");
                break;
            }
        }

        if (id != 0) {
            String open = client.target("http://localhost:8080/Complaints/resources/complaints/" + String.valueOf(id))
                    .request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
            System.out.println("Open: " + open);

            JSONObject item = new JSONObject(open);
            Complaint complaint = new Complaint();
            complaint.setId(item.getInt("id"));
            complaint.setAuthor(item.getString("author"));
            complaint.setComplaintDate(item.getString("complaintDate"));
            complaint.setComplaintText(item.getString("complaintText"));
            complaint.setStatus("closed");
            
            client.target("http://localhost:8080/Complaints/resources/complaints/" + String.valueOf(id))
                    .request(MediaType.APPLICATION_JSON_TYPE).put(Entity.entity(complaint, MediaType.APPLICATION_JSON_TYPE));
        }

        String allOpen = client.target("http://localhost:8080/Complaints/resources/complaints?status=open")
                .request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        System.out.println("All (Open): " + allOpen);
        client.close();
    }
}
