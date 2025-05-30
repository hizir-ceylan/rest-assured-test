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

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("https://jsonplaceholder.typicode.com/posts");

        assertEquals(201, response.getStatusCode());

        response.then().body("title", equalTo("yazilim"));
        response.then().body("body", equalTo("test projesi"));
        response.then().body("userId", equalTo(10));

        assertTrue("Cevap 2 saniyeden uzun sürdü", response.time() < 2000);
    }
}
