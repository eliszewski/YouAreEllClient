package controllers;

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
}