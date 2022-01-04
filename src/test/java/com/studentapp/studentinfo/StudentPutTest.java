package com.studentapp.studentinfo;

import com.studentapp.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class StudentPutTest extends TestBase {
      //Homework
    @Test
    public void createStudent() {
        List<String> courseList = new ArrayList<>();
        courseList.add("Java");
        courseList.add("Selenium");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("krishna123");
        studentPojo.setLastName("Patel12");
        studentPojo.setEmail("abc1234@gmail.com");
        studentPojo.setProgramme("Automation");
        studentPojo.setCourses(courseList);

        Response response = given()
                .header("Content-Type","application/json")
                .pathParam("id", 102)
                .body(studentPojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();


    }


}
