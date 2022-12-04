package controllers;

import models.Id;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ServerControllerTest {

    @Test
    public void TestIdGet() throws IOException {
        ServerController serverController = new ServerController();
        System.out.println(serverController.idGet());
        Assert.assertTrue(true);
    }

    @Test
    public void TestMessagesGet() throws IOException {
        ServerController serverController = new ServerController();
        System.out.println(serverController.messageGet());
        Assert.assertTrue(true);

    }

    @Test
    public  void TestPost() throws Exception {
        Id myId = new Id("", "very simple");
        System.out.println(myId);
        ServerController sc = new ServerController();
        sc.idPost(myId);
    }


}