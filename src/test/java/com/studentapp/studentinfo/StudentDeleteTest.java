package com.studentapp.studentinfo;

import com.studentapp.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class StudentDeleteTest extends TestBase {
    //Homework
    @Test
    public void updateStudentWithPatch(){
        StudentPojo studentPojo = new StudentPojo();


        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", 103)
                .body(studentPojo)
                .when()
                .delete("/{id}");
        response.then().statusCode(204);
        response.prettyPrint();



    }
}







