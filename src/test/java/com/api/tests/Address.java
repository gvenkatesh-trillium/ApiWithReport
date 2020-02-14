package com.api.tests;

import com.api.utils.BaseClass;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Random;

public class Address extends BaseClass {


    @Test()
    public void CreateContactActivatedAndValidated(Method method) {
        testCase = method.getName();
        extentTest = extent.createTest( "Create contact, Activate and Validate");
        request.header("Content-Type", "application/json");
        rNum = String.valueOf(new Random().nextInt(100000 - 10 + 1) + 1);
        jsonBody = "{\n" +
                "  \n" +
                "  \"firstName\": \"API Automation FirstName\",\n" +
                "  \"lastName\": \"API Automation LasttName\",\n" +
                "\n" +
                "  \"personalemail\": \"personalemail." + rNum + "GV@Automation.com\",\n" +
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
        extentTest.log(Status.INFO, " POST request Body : <br />" + jsonBody);
        response = request.post(BASE_URL + testCase);

        try {
            Assert.assertEquals(response.getStatusCode(), 200);
            extentTest.log(Status.PASS, " Check POST response Code : <br />" + response.getStatusCode());
        } catch (AssertionError StatusCodeError) {
            extentTest.log(Status.FAIL, "Expected Response Code \"200\" but returned : <br />" + response.getStatusCode());
            throw StatusCodeError;
        }
        try {
            Assert.assertTrue(response.asString().contains("\"success\":" + "true"));
            extentTest.log(Status.PASS, " Check POST response Body  has Success is \"true\" and messageError is \"null\" : <br />" + response.asString());
        } catch (AssertionError SuccessError) {
            extentTest.log(Status.FAIL, "Expected Response Success is \"true\" and messageError is \"null\" but returned : <br />" + response.asString());
            throw SuccessError;
        }

        contactId = response.asString().split("\"")[9];
        eMail = response.asString().split("\"")[17];
        if (!eMail.contains("@")) {
            extentTest.log(Status.FAIL, " no email found in response : <br/>" + response.asString());
        }
        Assert.assertTrue(response.asString().contains(contactId));

    }

    @Test(priority=2, dependsOnMethods = {"CreateAddress"})
    public void RetrieveAddresses(Method method) {

        testCase = method.getName();
        extentTest = extent.createTest(" Test case: Retrieve Addresses and verify the response");
        request.header("Content-Type", "application/json");
        jsonBody = "{\n" +
                "  \"contactId\": \"7c21ea88-213f-e811-a956-002248072cc3\",\n" +
                " \n" +
                "}";
        extentTest.log(Status.INFO, " POST request Body : <br />" + jsonBody);
        request.body(jsonBody);
        response = request.post(BASE_URL + testCase);

        try {
            Assert.assertEquals(response.getStatusCode(), 200);
            extentTest.log(Status.PASS, " Check POST response Code : <br />" + response.getStatusCode());
        } catch (AssertionError StatusCodeError) {
            extentTest.log(Status.FAIL, "Expected Response Code \"200\" but returned : <br />" + response.getStatusCode());
            throw StatusCodeError;
        }
        try {
            Assert.assertTrue(response.asString().contains("\"success\":" + "true"));
            extentTest.log(Status.PASS, " Check POST response Body  has Success is \"true\" and messageError is \"null\" : <br />" + response.asString());
        } catch (AssertionError SuccessError) {
            extentTest.log(Status.FAIL, "Expected Response Success is \"true\" and messageError is \"null\" but returned : <br />" + response.asString());
            throw SuccessError;
        }

    }

    @Test(priority=1, dependsOnMethods = {"CreateContactActivatedAndValidated"})
    public void CreateAddress(Method method) {

        testCase = method.getName();
        extentTest = extent.createTest("Test case : Create Address for a Contact and verify the response");
        request.header("Content-Type", "application/json");
        jsonBody = "{\n" +
                " \"contactId\": \"" + contactId + "\",\n" +
                "\n" +
                "  \"addressTypeCodeValue\": 1,\n" +
                "  \"countryId\": \"42579c4a-ebd4-e711-a94b-00224801b4c8\",\n" +
                "  \"countyId\": \"eb81b897-ebd4-e711-a94b-00224801b4c8\",\n" +
                "  \"companyName\": \"Trillium automation\",\n" +
                "  \"street1\": \"London street 1\",\n" +
                "  \"street2\": \"Street 2\",\n" +
                "  \"street3\": \"Street 3\",\n" +
                "  \"city\": \"London\",\n" +
                "  \"countyText\": \"string\",\n" +
                "  \"postalCode\": \"S1WE34GV\",\n" +
                "  \"isCorrespondence\": true,\n" +
                "  \"isInvoice\": true,\n" +
                "  \"stopMail\": true\n" +
                "}";
        extentTest.log(Status.INFO, " POST request Body : <br />" + jsonBody);
        request.body(jsonBody);
        response = request.post(BASE_URL + testCase);
        addressId = response.asString().split("\"")[9];
        System.out.println("address di is = "+addressId);
        try {
            Assert.assertEquals(response.getStatusCode(), 200);
            extentTest.log(Status.PASS, " Check POST response Code : <br />" + response.getStatusCode());
        } catch (AssertionError StatusCodeError) {
            extentTest.log(Status.FAIL, "Expected Response Code \"200\" but returned : <br />" + response.getStatusCode());
            throw StatusCodeError;
        }
        try {
            Assert.assertTrue(response.asString().contains("\"success\":" + "true"));
            extentTest.log(Status.PASS, " Check POST response Body  has Success is \"true\" and messageError is \"null\" : <br />" + response.asString());
        } catch (AssertionError SuccessError) {
            extentTest.log(Status.FAIL, "Expected Response Success is \"true\" and messageError is \"null\" but returned : <br />" + response.asString());
            throw SuccessError;
        }

    }
    @Test(priority=3, dependsOnMethods = {"CreateAddress"})
    public void UpdateAddress(Method method) {

        testCase = method.getName();
        extentTest = extent.createTest( " Test case :Update Address for a Contact and verify the response");
        request.header("Content-Type", "application/json");
//        System.out.println("address id is = "+addressId);
        jsonBody = "{\n" +
                " \"id\": \"" + addressId + "\",\n" +
                "  \"companyName\": \"UpdateAddressCompanyName1\",\n" +
                "  \"street1\": \"UpdateAddressStree1\",\n" +
                "  \"street2\": \"UpdateAddressStree2\",\n" +
                "  \"street3\": \"UpdateAddressStree3\",\n" +
                "  \"city\": \"UpdateAddressCity\",\n" +
                "  \"postalCode\": \"NEW 90 STCD\",\n" +
                "  \"isCorrespondence\": true,\n" +
                "  \"isInvoice\": true,\n" +
                "  \"stopMail\": true\n" +
                "}";
        extentTest.log(Status.INFO, " POST request Body : <br />" + jsonBody);
        request.body(jsonBody);
        response = request.post(BASE_URL + testCase);

        try {
            Assert.assertEquals(response.getStatusCode(), 200);
            extentTest.log(Status.PASS, " Check POST response Code : <br />" + response.getStatusCode());
        } catch (AssertionError StatusCodeError) {
            extentTest.log(Status.FAIL, "Expected Response Code \"200\" but returned : <br />" + response.getStatusCode());
            throw StatusCodeError;
        }
        try {
            Assert.assertTrue(response.asString().contains("\"success\":" + "true"));
            extentTest.log(Status.PASS, " Check POST response Body  has Success is \"true\" and messageError is \"null\" : <br />" + response.asString());
        } catch (AssertionError SuccessError) {
            extentTest.log(Status.FAIL, "Expected Response Success is \"true\" and messageError is \"null\" but returned : <br />" + response.asString());
            throw SuccessError;
        }

    }
    @Test(priority = 4, dependsOnMethods = {"UpdateAddress"})
    public void DeactivateAddress(Method method) {

        testCase = method.getName();
        extentTest = extent.createTest( "Deactivate Address for a Contact and verify the response");
        request.header("Content-Type", "application/json");
        System.out.println("address id is = "+addressId);
        jsonBody = "{\n" +
                " \"id\": \"" + addressId + "\",\n" +
                "}";
        extentTest.log(Status.INFO, " POST request Body : <br />" + jsonBody);
        request.body(jsonBody);
        response = request.post(BASE_URL + testCase);

        try {
            Assert.assertEquals(response.getStatusCode(), 200);
            extentTest.log(Status.PASS, " Check POST response Code : <br />" + response.getStatusCode());
        } catch (AssertionError StatusCodeError) {
            extentTest.log(Status.FAIL, "Expected Response Code \"200\" but returned : <br />" + response.getStatusCode());
            throw StatusCodeError;
        }
        try {
            Assert.assertTrue(response.asString().contains("\"success\":" + "true"));
            extentTest.log(Status.PASS, " Check POST response Body  has Success is \"true\" and messageError is \"null\" : <br />" + response.asString());
        } catch (AssertionError SuccessError) {
            extentTest.log(Status.FAIL, "Expected Response Success is \"true\" and messageError is \"null\" but returned : <br />" + response.asString());
            throw SuccessError;
        }

    }
}