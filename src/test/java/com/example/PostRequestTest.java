package com.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class PostRequestTest {

    @Test
    public void testPostExample() {
        String requestBody = "{ \"title\": \"yazilim\", \"body\": \"test projesi\", \"userId\": 10 }";

        long startTime = System.currentTimeMillis();

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("https://jsonplaceholder.typicode.com/posts");

        long duration = System.currentTimeMillis() - startTime;

        assertEquals(201, response.getStatusCode());
        response.then().body("title", equalTo("yazilim"));
        response.then().body("body", equalTo("test projesi"));
        response.then().body("userId", equalTo(10));
        assertTrue("Cevap 1 saniyeden uzun sürdü", duration < 1000);
    }
}
