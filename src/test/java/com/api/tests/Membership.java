package com.api.tests;

import com.api.utils.BaseClass;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Membership extends BaseClass {

    @Test(groups = "Membership.CreateContactActivatedAndValidated")
    public void CreateContactActivatedAndValidated(Method method) {
        testCase = method.getName();
        extentTest = extent.createTest( "Test case : Create contact, Activate and Validate");
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
            contactId = response.asString().split("\"")[9];
            eMail = response.asString().split("\"")[17];
        } catch (Exception e) {
            extentTest.log(Status.FAIL, "Failed to extract to Contact ID and eMail from response : <br />" + response.asString());
            e.printStackTrace();
        }
        if (!eMail.contains("@")) {
            extentTest.log(Status.FAIL, " no email found in response : <br/>" + response.asString());
        }
        Assert.assertTrue(response.asString().contains(contactId));

        verifyResponse.validateAssertion();

    }


    @Test
    public void RetrieveAllMembershipsByContactId(Method method) {

        testCase = method.getName();
        extentTest = extent.createTest("Retrieve All Memberships By ContactId and Validate the response");
        request.header("Content-Type", "application/json");

        jsonBody = "{\n" +
                "  \"id\": \"cda4ae1d-3042-e811-a958-002248072825\",\n" +
                "}";
        request.body(jsonBody);
        extentTest.log(Status.INFO," POST request Body : <br />"+ jsonBody);
        response = request.post(BASE_URL + testCase);
        verifyResponse.validateAssertion();

    }

    @Test
    public void RetrieveActiveMembershipsByContactId(Method method) {

        testCase = method.getName();
        extentTest = extent.createTest("Retrieve Active Memberships By ContactId and Validate the response");
        request.header("Content-Type", "application/json");

        jsonBody = "{\n" +
                "  \"id\": \"cda4ae1d-3042-e811-a958-002248072825\",\n" +
                "}";
        request.body(jsonBody);
        extentTest.log(Status.INFO," POST request Body : <br />"+ jsonBody);
        response = request.post(BASE_URL + testCase);
        verifyResponse.validateAssertion();


    }


    @Test
    public void RetrieveAllMembershipTypes(Method method) {

        testCase = method.getName();
        extentTest = extent.createTest("Retrieve All Membership Types and Validate the response");
        request.header("Content-Type", "application/json");

        jsonBody = "{\n" +
                "  \"attributesName\": [\n" +
                "    \"string\"\n" +
                "  ]\n" +
                "}";
        request.body(jsonBody);
        extentTest.log(Status.INFO," POST request Body : <br />"+ jsonBody);
        response = request.post(BASE_URL + testCase);
        verifyResponse.validateAssertion();


    }

    @Test
    public void RetrieveMembershipGradesByTypeId(Method method) {

        testCase = method.getName();
        extentTest = extent.createTest("Retrieve Membership Grades By TypeId and Validate the response");
        request.header("Content-Type", "application/json");

        jsonBody = "{\n" +
                "  \"id\": \"cda4ae1d-3042-e811-a958-002248072825\",\n" +
                "  \"attributesName\": [\n" +
                "    \"string\"\n" +
                "  ]\n" +
                "}";
        request.body(jsonBody);
        extentTest.log(Status.INFO," POST request Body : <br />"+ jsonBody);
        response = request.post(BASE_URL + testCase);
        verifyResponse.validateAssertion();


    }

    @Test
    public void RetrieveMembershipBands(Method method) {
// response code is 200 but response body has no values except "success" and "messageError"
        testCase = method.getName();
        extentTest = extent.createTest("Retrieve Membership Bands and Validate the response");
        request.header("Content-Type", "application/json");

        jsonBody = "{\n" +
                "  \"gradeId\": \"00000000-0000-0000-0000-000000000000\",\n" +
                "  \"attributesName\": [\n" +
                "    \"string\"\n" +
                "  ]\n" +
                "}";
        request.body(jsonBody);
        extentTest.log(Status.INFO," POST request Body : <br />"+ jsonBody);
        response = request.post(BASE_URL + testCase);
        verifyResponse.validateAssertion();

    }

    @Test
    public void RetrieveValidMembershipDiscountCodeForWeb(Method method) {
// response code is 200 but response body has an error ""Object reference not set to an instance of an object.","
        testCase = method.getName();
        extentTest = extent.createTest("Retrieve Valid Membership Discount Code For Web and Validate the response");
        request.header("Content-Type", "application/json");

        jsonBody = "{\n" +
                "  \"code\": \"string\",\n" +
                "  \"membershipId\": \"04db2799-3432-ea11-a810-000d3a7ed588\",\n" +
                "  \"attributesName\": [\n" +
                "    \"string\"\n" +
                "  ]\n" +
                "}";
        request.body(jsonBody);
        extentTest.log(Status.INFO," POST request Body : <br />"+ jsonBody);
        response = request.post(BASE_URL + testCase);
        verifyResponse.validateAssertion();


    }


    @Test
    public void ApplyMembershipDiscountCodeForWeb(Method method) {
// response code is 200 but response body has an error ""Object reference not set to an instance of an object."
        testCase = method.getName();
        extentTest = extent.createTest("Apply Membership Discount Code For Web and Validate the response");
        request.header("Content-Type", "application/json");

        jsonBody = "{\n" +
                "  \"code\": \"string\",\n" +
                "  \"membershipId\": \"04db2799-3432-ea11-a810-000d3a7ed588\",\n" +
                "  \"tri_discountcodeid\": [\n" +
                "    \"CodeODcASA4YLuw\"\n" +
                "  ]\n" +
                "}";
        request.body(jsonBody);
        extentTest.log(Status.INFO," POST request Body : <br />"+ jsonBody);
        response = request.post(BASE_URL + testCase);
        verifyResponse.validateAssertion();


    }

        @Test(dependsOnMethods = {"CreateContactActivatedAndValidated"})
        public void CreateMembership(Method method) {

        testCase = method.getName();
        extentTest = extent.createTest("Create Membership for Contact and Validate the response");
        request.header("Content-Type", "application/json");

            jsonBody = "{\n" +
                    " \"contactId\": \" " + contactId + "\",\n" +
                    "\"typeId\": \" " + data.membershipType() + "\",\n" +
                    "\"gradeId\": \" " + membershipGrade + "\",\n" +
                    "\"bandId\": \" " + membershipBand + "\",\n" +

                    " \"methodOfPaymentId\": \"77c3741e-2b1c-e511-80c7-005056bf2f1c\",\n" +
                    "  \"paymentFrequency\": 167410000,\n" +
                    "  \"reasonCodeId\": \"00000000-0000-0000-0000-000000000000\",\n" +
                    "  \"membershipReasonForJoiningId\": \" " + data.reasonForJoining() + "\",\n" +
                    "  \"startDate\": \"2020-01-23T16:00:01.254Z\",\n" +
                    "  \"membershipStatus\": 167410000\n" +
                    "}";
        request.body(jsonBody);
        extentTest.log(Status.INFO, " POST request Body : <br />" + jsonBody);
        response = request.post(BASE_URL + testCase);


        Pattern pattern = Pattern.compile("[a-zA-Z0-9-]{36}");
        Matcher m = pattern.matcher(response.asString());
        while (m.find()){
//            System.out.println(m.group());
            membershipId = m.group();
        }

            verifyResponse.validateAssertion();

    }

    @Test(dependsOnMethods = {"CreateContactActivatedAndValidated"})
    // response code is 200 but response body has an error "Subsetting 'Fundraising_PaymentFrequency' must be an integer"
    public void CreateFundraisingMembership(Method method) {
        testCase = method.getName();
        extentTest = extent.createTest("Create Fundraising Membership and Validate the response");
        request.header("Content-Type", "application/json");

        jsonBody = "{\n" +
                "  \"isGift\": true,\n" +
                "  \"member\": {\n" +
                "    \"contactId\": \"00000000-0000-0000-0000-000000000000\",\n" +
                "    \"emailAddress\": \"string\",\n" +
                "    \"title\": {\n" +
                "      \"value\": 0,\n" +
                "      \"description\": \"string\"\n" +
                "    },\n" +
                "    \"fistName\": \"API test\",\n" +
                "    \"lastName\": \"API Last Name\",\n" +
                "    \"telephone\": \"45546435132\",\n" +
                "    \"addressPostCode\": \"S1W36GH\",\n" +
                "    \"addressLine\": \"London \",\n" +
                "    \"addressCountryId\": \"42579c4a-ebd4-e711-a94b-00224801b4c8\"\n" +
                "  },\n" +
                "  \"billingContact\": {\n" +
                "    \"contactId\": \" "+ contactId + "\",\n" +
                "    \"title\": {\n" +
                "      \"value\": 167410032,\n" +
                "      \"description\": \"Mr\"\n" +
                "    },\n" +
                "    \"fistName\": \"API test\",\n" +
                "    \"lastName\": \"API Last Name\",\n" +
                "    \"telephone\": \"45546435132\",\n" +
                "    \"addressPostCode\": \"S1W36GH\",\n" +
                "    \"addressLine\": \"London \",\n" +
                "    \"addressCountryId\": \"42579c4a-ebd4-e711-a94b-00224801b4c8\"\n" +
                "  },\n" +
                " \n" +
                "  \"giftAidDeclaration\": {\n" +
                "    \"optIn\": true,\n" +
                "    \"date\": \"2020-01-23T16:00:01.289Z\"\n" +
                "  },\n" +
                "  \"paymentDetails\": {\n" +
                "    \"onlinePayment\": true,\n" +
                "    \"amount\": 122\n" +
                "  },\n" +
                "  \"directDebit\": {\n" +
                "    \"accountName\": \"API Testing\",\n" +
                "    \"accountNumber\": \"12341234\",\n" +
                "    \"sortCode\": \"121212\"\n" +
                "  }\n" +
                "}";
        request.body(jsonBody);
        extentTest.log(Status.INFO," POST request Body : <br />"+ jsonBody);
        response = request.post(BASE_URL + testCase);

        verifyResponse.validateAssertion();
    }
    @Test(dependsOnMethods = {"CreateContactActivatedAndValidated","CreateMembership"})
    public void CreateMembershipTransactionAndProcessPayment(Method method) {
        testCase = method.getName();
        extentTest = extent.createTest("Create Membership Transaction And Process Payment and Validate the response");
        request.header("Content-Type", "application/json");

        jsonBody = "{\n" +
                "  \"isDirectDebit\": true,\n" +
                "  \"directDebitCallbackURL\": \"string\",\n" +
                "  \"isOnlinePayment\": true,\n" +
                "  \"contactId\": \" "+ contactId + "\",\n" +
                "  \"membershipID\": \""+ membershipId + "\",\n" +
                "  \"frequencyOfPayment\": {\n" +
                "    \"value\": 167410000,\n" +
                "    \"description\": \"Annually\"\n" +
                "  },\n" +
                "  \"methodOfPaymentId\": \"77c3741e-2b1c-e511-80c7-005056bf2f1c\",\n" +
                " \"onlinePaymentSuccessURL\":\"https://www.onlinePaymentSuccessURL.co.uk\",\n" +
                "  \"onlinePaymentFailureURL\": \"https://www.onlinePaymentFailureURL.co.uk\"\n" +
                "}";
        request.body(jsonBody);
        extentTest.log(Status.INFO," POST request Body : <br />"+ jsonBody);
        response = request.post(BASE_URL + testCase);

        verifyResponse.validateAssertion();
    }

    @Test(dependsOnMethods = {"CreateContactActivatedAndValidated","CreateMembership"})
    public void CreateMembershipTransactionAndDirectDebit(Method method) {
        testCase = method.getName();
        extentTest = extent.createTest("Create Membership Transaction And DirectDebit and Validate the response");
        request.header("Content-Type", "application/json");

        jsonBody = "{\n" +
                "  \"directDebitInfo\": {\n" +
                "    \"type\": 167410000,\n" +
                "    \"accountNumber\": \"12341234\",\n" +
                "    \"accountName\": \"API Testing\",\n" +
                "    \"sortCode\": \"121212\",\n" +
                "    \"bankName\": \"API Bank Ltd\",\n" +
                "    \"branchAddress\": \"string\",\n" +
                "    \"paymentFrequency\": 167410000\n" +
                "  },\n" +
                "  \"contactId\": \" "+ contactId + "\",\n" +
                "  \"membershipID\": \""+ membershipId + "\",\n" +
                "}";
        request.body(jsonBody);
        extentTest.log(Status.INFO," POST request Body : <br />"+ jsonBody);
        response = request.post(BASE_URL + testCase);

        verifyResponse.validateAssertion();
    }

    @Test(dependsOnMethods = {"CreateContactActivatedAndValidated","CreateMembership"})
    public void CreateGenericMembershipTransaction(Method method) {
        testCase = method.getName();
        extentTest = extent.createTest("Create Generic Membership Transaction and Validate the response");
        request.header("Content-Type", "application/json");

        jsonBody = "{\n" +
                "  \"netAmount\": 1025,\n" +
                "  \"vatId\": \"90409d5a-241c-e511-80c7-005056bf2f1c\",\n" +
                "  \"periodId\": \"ed70628e-8455-e611-80f8-005056bf72c1\",\n" +
                "  \"createAsComplete\": true,\n" +
                "  \"createAsInvoice\": true,\n" +
                "  \"description\": \"CreateGenericMembershipTransaction API Automation\",\n" +
                " \n" +
                "  \"contactId\": \" "+ contactId + "\",\n" +
                "  \"membershipID\": \""+ membershipId + "\",\n" +
                "}";
        request.body(jsonBody);
        extentTest.log(Status.INFO," POST request Body : <br />"+ jsonBody);
        response = request.post(BASE_URL + testCase);

        verifyResponse.validateAssertion();
    }

    @Test()
    public void RetrieveAllMethodsOfPayment(Method method) {
        testCase = method.getName();
        extentTest = extent.createTest("Retrieve All Methods Of Payment and Validate the response(GET Request)");
        request.header("Content-Type", "application/json");

        response = request.get(BASE_URL + testCase);

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
    }

    @Test(dependsOnMethods = {"CreateContactActivatedAndValidated","CreateMembership"})
    public void LapseMembership(Method method) {
        testCase = method.getName();
        extentTest = extent.createTest("Lapse Membership and Validate the response");
        request.header("Content-Type", "application/json");

        jsonBody = "{\n" +
                "  \"membershipID\": \""+ membershipId + "\",\n" +
                "  \"expiryType\": 167410004,\n" +
                "  \"reasonForLeaving\": \"b844025c-9833-ea11-a813-000d3a7ed588\",\n" +
                "  \"expirePaymentPlans\": true\n" +
                "}";
        request.body(jsonBody);
        extentTest.log(Status.INFO," POST request Body : <br />"+ jsonBody);
        response = request.post(BASE_URL + testCase);

        verifyResponse.validateAssertion();
    }

    @Test(dependsOnMethods = {"CreateContactActivatedAndValidated","CreateMembership"})
    public void UpgradeMembership(Method method) {
        testCase = method.getName();
        extentTest = extent.createTest("Upgrade Membership and Validate the response");
        request.header("Content-Type", "application/json");

        jsonBody = "{\n" +
                "  \"membershipID\": \""+ membershipId + "\",\n" +
                "  \"membershipType\": \"669b36c1-ddfc-e611-8100-005056bf72c1\", \n" +
                "  \"membershipGrade\": \"0d462ccb-ddfc-e611-8100-005056bf72c1\", \n" +
                "  \"membershipBand\": \"cdbb5ced-ddfc-e611-8100-005056bf72c1\", \n" +
                "  \"createTransaction\": true,\n" +
                "  \"writeoff\": true,\n" +
                "  \"createPayment\": true,\n" +
                "  \"createPaymentPlan\": true,\n" +
                "  \"mothodOfPayment\": \"77c3741e-2b1c-e511-80c7-005056bf2f1c\",\n" +
                "  \"feeOverride\": 0\n" +
                "}";
        request.body(jsonBody);
        extentTest.log(Status.INFO," POST request Body : <br />"+ jsonBody);
        response = request.post(BASE_URL + testCase);

        verifyResponse.validateAssertion();
    }
    @Test()
    public void RetrieveMembershipTransactions(Method method) {
        testCase = method.getName();
        extentTest = extent.createTest("Retrieve Membership Transactions and Validate the response");
        request.header("Content-Type", "application/json");

        jsonBody = "{\n" +
                "  \"contactId\": \"552bee56-214c-ea11-a812-000d3a7ed518\",\n" +
                "  \"membershipId\": \"16d9e85c-214c-ea11-a812-000d3a7ed518\"\n" +
                "}";
        request.body(jsonBody);
        extentTest.log(Status.INFO," POST request Body : <br />"+ jsonBody);
        response = request.post(BASE_URL + testCase);

        verifyResponse.validateAssertion();
    }

    @Test(dependsOnMethods = {"CreateContactActivatedAndValidated","CreateMembership"})
    // Response status is 200 but throwing an error "VAT is mandatory and cannot be empty"
    public void CreateMultipleMembershipInvoiceTransaction(Method method) {
        testCase = method.getName();
        extentTest = extent.createTest("Create Multiple Membership Invoice Transaction and Validate the response");
        request.header("Content-Type", "application/json");

        jsonBody = "{\n" +
                "  \"contactId\": \" "+ contactId + "\",\n" +
                "  \"poNumber\": \"poNumber\",\n" +
                "  \"transactionIds\": \"1a1a5b0d-194c-ea11-a812-000d3a7ed588\",\n" +
                "\"transactionIds\": \"5523ba2f-450c-438c-b1d0-459a91780a15\",\n" +
                "  \"membershipID\": \""+ membershipId + "\",\n" +
                "\"membershipIds\": \"e896fa0a-fb40-ea11-a812-000d3a7ed588\"\n" +
                "}";
        request.body(jsonBody);
        extentTest.log(Status.INFO," POST request Body : <br />"+ jsonBody);
        response = request.post(BASE_URL + testCase);

        verifyResponse.validateAssertion();
    }

    @Test(dependsOnMethods = {"CreateContactActivatedAndValidated","CreateMembership"})
    public void CreateMembershipTransactionsAsInvoice(Method method){
        // status code 200 and result is success but not transaction are created in CRM
        testCase = method.getName();
        extentTest = extent.createTest("Create Membership Transactions As Invoice and Validate the response");
        request.header("Content-Type", "application/json");

        jsonBody = "{\n" +
                "  \"contactId\": \" "+ contactId + "\",\n" +
                "   \"membershipGuids\": [\""+ membershipId + "\"\n" +
                "  ],\n" +
                "  \"createTransactionAsComplete\": true\n" +
                "}\n" +
                "ctionAsComplete\": true }";

        request.body(jsonBody);
        extentTest.log(Status.INFO," POST request Body : <br />"+ jsonBody);
        response = request.post(BASE_URL + testCase);

        verifyResponse.validateAssertion();

    }

}
