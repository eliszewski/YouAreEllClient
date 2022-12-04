package controllers;

import java.util.ArrayList;
import java.util.HashMap;

import models.Id;

public class IdController {
    private HashMap<String, Id> allIds;

    Id myId;

    public ArrayList<Id> getIds() {
        return null;
    }

    public Id postId(Id id) throws Exception {
        // create json from id
        // call server, get json result Or error
        // result json to Id obj
        return null;
        //return ServerController.shared().idPost(id);
    }

    public Id putId(Id id) {
        return null;
    }
 
}