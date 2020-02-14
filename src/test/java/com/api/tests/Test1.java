package com.api.tests;

import com.api.utils.BaseClass;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Random;

public class Test1 extends BaseClass {

    @Test
    public void CreateContactActivatedAndValidated(Method method) {
        testCase = method.getName();
        extentTest = extent.createTest(" Create contact, Activate and Validate");
        request.header("Content-Type", "application/json");
        String rNum = String.valueOf(new Random().nextInt(100000 - 10 + 1) + 1);
        jsonBody = "{\n" +
                "  \n" +
                "  \"firstName\": \"API Automation FirstName\",\n" +
                "  \"lastName\": \"API Automation LasttName\",\n" +
                "\n" +
                "  \"personalemail\": \"personalemail."+rNum+"GV@Automation.com\",\n" +
                "  \"workemail\": \"string\",\n" +
                "  \"preferredEmailAddress\": {\n" +
                "    \"value\": 167410000,\n" +
                "    \"description\": \"work\"\n" +
                "  },\n" +
                "\n" +
                "  \"title\": {\n" +
                "    \"value\": 167410032,\n" +
                "    \"description\": \"string\"\n" +
                "},\n" +
                " \n" +
                "\n" +
                "  \"jobRoleOther\": \"API jobRoleOther\",\n" +
                "  \"jobTitle\": \"API jobTitle\",\n" +
                "  \"organisationText\": \"OrganisationText\"\n" +
                "}";
        request.body(jsonBody);
        extentTest.log(Status.INFO," POST request Body : <br />"+ jsonBody);
        response = request.post(BASE_URL + testCase);

        try {
            Assert.assertEquals(response.getStatusCode(), 200);
            extentTest.log(Status.PASS," Check POST response Code : <br />"+ response.getStatusCode());
        } catch (AssertionError StatusCodeError) {
            extentTest.log(Status.FAIL,"Expected Response Code \"200\" but returned : <br />"+ response.getStatusCode());
            throw StatusCodeError;
        }
        try {
            Assert.assertTrue(response.asString().contains("\"success\":" + "true"));
            extentTest.log(Status.PASS," Check POST response Body  has Success is \"true\" and messageError is \"null\" : <br />"+ response.asString());
        } catch (AssertionError SuccessError) {
            extentTest.log(Status.FAIL,"Expected Response Success is \"true\" and messageError is \"null\" but returned : <br />"+ response.asString());
            throw SuccessError;
        }

        contactId =  response.asString().split("\"")[9];
        eMail = response.asString().split("\"")[17];
        if(!eMail.contains("@")){
            extentTest.log(Status.FAIL," no email found in response "+ response.asString());
        }
        Assert.assertTrue(response.asString().contains(contactId));

    }
}
