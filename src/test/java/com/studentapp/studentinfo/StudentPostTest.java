package com.studentapp.studentinfo;

import com.studentapp.StudentPojo;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.TestUtils;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StudentPostTest extends TestBase {
    @Test
    public void createStudent() {
        List<String> courseList = new ArrayList<>();
        courseList.add("Java");
        courseList.add("Selenium");
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("veera123");
        studentPojo.setLastName("patel");
        studentPojo.setEmail("admin123@gmail.com");
        studentPojo.setProgramme("Tester");
        studentPojo.setCourses(courseList);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(studentPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

    }
