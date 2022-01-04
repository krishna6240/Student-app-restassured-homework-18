package com.studentapp.assertionexample;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class AssertionExampleDemo {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
    }


    // 1) Verify that the products of limit is equal to 10
    @Test
    public void test001() {
        response.body("limit", equalTo(10));
    }

    // 2) Verify that the products of total is = 51957
    @Test//homework
    public void test002() {
        response.body("total", equalTo(51969));
    }

    // 3) Check the Name 'Duracell - AA Batteries (8-Pack)' is available in List of product's name
    @Test
    public void test003() {
        response.body("data.name", hasItem("Duracell - AA Batteries (8-Pack)"));

    }

    // 4) Check Multiple Names (Energizer - MAX Batteries AA (4-Pack), Duracell - 9V Batteries (2-Pack)) are available in list of product's name
    @Test
    public void test004() {
//homework
        response.body("data.name", hasItems("Energizer - MAX Batteries AA (4-Pack)", "Duracell - 9V Batteries (2-Pack)"));
    }

    // 5) Verify the 'name' field inside first categories map for the first data (Checking Values inside Map using hasKey(entityType))
    @Test
    public void test005() {//heskey--fieldname--name=value
        response.body("data[0].categories[0]", hasKey("name"));

    }

    // 6) Check entry 'manufacturer = Energizer' is inside map of product name is 'Energizer - N Cell E90 Batteries (2-Pack)'
    @Test
    public void test006() {
        response.body("data.findAll{it.name='Duracell - AAA Batteries (4-Pack)'}", hasItems(hasEntry("manufacturer", "Energizer")));
    }

    // 7) Checking multiple values in the same statement
    @Test
    public void test007() {
        response.body("limit", equalTo(10))
                .body("data.findAll{it.name=='Energizer - N Cell E90 Batteries (2-Pack)'}", hasItem(hasEntry("manufacturer", "Energizer")))
                .body("data[0].categories[0]", hasKey("name"));

    }

    // 8) Logical Assertions
    @Test
    public void test008() {
        response.body("limit", equalTo(10))
                .body("limit", lessThan(12))
                .body("limit", greaterThan(9))
                .body("limit", greaterThanOrEqualTo(10));


    }
}
