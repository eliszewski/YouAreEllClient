package controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ServerController {
    private String rootURL = "http://zipcode.rocks:8085";
    private String idURL = "http://zipcode.rocks:8085/ids";
    //private ServerController svr = new ServerController();
    private List<Id> ids;

    ServerController() {}

//    public static shared() {
//        return svr;
//    }

    // ﷽﷽﷽

    public  String idGet() throws IOException {
        String jSonString = "";
        URL url = new URL(idURL);
        ObjectMapper mapper = new ObjectMapper();
        ids = mapper.readValue(url, new TypeReference<>(){});

        jSonString = mapper.writeValueAsString(ids);

        return jSonString;
        // url -> /ids/
        // send the server a get with url
        // return json from server
    }
//    public JsonString idPost(Id) {
//        // url -> /ids/
//        // create json from Id
//        // request
//        // reply
//        // return json
//    }
//    public JsonString idPut(Id) {
//        // url -> /ids/
//    }


}

// ServerController.shared.doGet()