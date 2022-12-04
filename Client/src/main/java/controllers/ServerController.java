package controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class ServerController {
    private String rootURL = "http://zipcode.rocks:8085";
    private String idURL = "http://zipcode.rocks:8085/ids";
    private static  ServerController svr = new ServerController();
    private List<Id> ids;
    private List<Message> messages;

    public ServerController() {}

    public static ServerController shared() {
        return svr;
    }

    // ﷽﷽﷽

    public  String idGet() throws IOException {
        String jSonString = "";
        URL url = new URL(rootURL + "/ids");
        ObjectMapper mapper = new ObjectMapper();
        ids = mapper.readValue(url, new TypeReference<>(){});

        jSonString = mapper.writeValueAsString(ids);

        return jSonString;
        // url -> /ids/
        // send the server a get with url
        // return json from server
    }

    public  String messageGet() throws IOException {
        String jSonString = "";
        URL url = new URL(rootURL + "/messages");
        ObjectMapper mapper = new ObjectMapper();
        messages = mapper.readValue(url, new TypeReference<>(){});

        jSonString = mapper.writeValueAsString(messages);

        return jSonString;
        // url -> /ids/
        // send the server a get with url
        // return json from server
    }
    Id myId = new Id("Eryk", "eliszewski");
    public String idPost(Id id) throws Exception {
        // url -> /ids/
        // create json from Id
        // request
        // reply
        // return json

        URL url = new URL(rootURL + "/ids");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            System.out.println(id);
            byte[] input = id.toString().getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }
        StringBuilder response;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
        }

        return response.toString();
    }
//    public JsonString idPut(Id) {
//        // url -> /ids/
//    }


}

//ServerController.shared.doGet()