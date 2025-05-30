package com.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class GetRequestTest {

    @Test
    public void testGetExample() {
        long startTime = System.currentTimeMillis();

        Response response = RestAssured
                .given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1");

        long duration = System.currentTimeMillis() - startTime;

        assertEquals(200, response.getStatusCode());
        response.then().body("id", equalTo(1));

        // Süre kontrolü opsiyonel hale getirildi
        assertTrue("Cevap 2 saniyeden uzun sürdü", duration < 2000);
    }
}
