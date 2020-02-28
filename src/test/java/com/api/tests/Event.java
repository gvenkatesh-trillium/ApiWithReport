package com.api.tests;

import com.api.utils.BaseClass;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Event extends BaseClass {

    @Test()
    public void CreateBookings(Method method) {
        testCase = method.getName();
        extentTest = extent.createTest("Create Bookings and Validate");
        request.header("Content-Type", "application/json");
        jsonBody = "Aysegul to add API request details here test ";

        extentTest.log(Status.INFO," POST request Body : <br /> "+ jsonBody);
        request.body(jsonBody);
        response = request.post(BASE_URL + testCase);

        verifyResponse.validateAssertion();

    }
}
