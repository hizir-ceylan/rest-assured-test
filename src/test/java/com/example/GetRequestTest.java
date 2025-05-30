package com.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class GetRequestTest {

    @Test
    public void testGetExample() {
        Response response = RestAssured
                .given()
                .when()
                .get("https://jsonplaceholder.typicode.com/todos/1");

        long duration = response.time();

        System.out.println("Cevap süresi: " + duration + " ms");

        assertEquals(200, response.getStatusCode());

        response.then().body("id", equalTo(1));

        assertTrue("Cevap 1 saniyeden uzun sürdü", duration < 1000);
    }
}
