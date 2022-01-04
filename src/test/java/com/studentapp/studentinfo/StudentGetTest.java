package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class StudentGetTest extends TestBase {
    @Test
    public void getsingleStudentInfo(){
        Response response = given()
                .pathParams("id",5)
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void getAllStudentsInfo(){
        Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void searchStudentWithParameter(){
        HashMap<String,Object> qPrams = new HashMap<>();
        qPrams.put("programme","Finanacial Analysis");
        qPrams.put("limit","2");
        Response response = given()
                .queryParams(qPrams)
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
