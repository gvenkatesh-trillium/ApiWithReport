package com.api.data;


import com.api.utils.BaseClass;

import java.util.Random;

public class RcrData extends BaseClass {
    private String[] membershipTypes = {"cf42fe16-661d-e911-a973-002248072781", "9a12f9cc-721d-e911-a973-002248072781", "516cf028-661d-e911-a973-002248072781"};
    private String[] membershipReasonForJoiningIds = {"680969ad-8237-ea11-a813-000d3a0bad17", "d1756576-87f6-e511-80f2-005056bf72c1", "0517f962-87f6-e511-80f2-005056bf72c1"};

    public String membershipType(){
        Random random = new Random();
        int memTypes = random.nextInt(membershipTypes.length);
        membershipTypeId = membershipTypes[memTypes];
           if(membershipTypeId.contains("516cf028-661d-e911-a973-002248072781")){  //Oncology Membership
               membershipGrade = "d3727a01-681d-e911-a98a-00224801b4c8";
               membershipBand = "d5dded41-33fb-e911-a811-00224801a789";

        }
        else if (membershipTypeId.contains("cf42fe16-661d-e911-a973-002248072781")){   //Radiology Membership
            membershipGrade = "b7727a01-681d-e911-a98a-00224801b4c8";
            membershipBand = "cdaa1b55-6a1d-e911-a988-00224801ab04";

        }
        else if (membershipTypeId.contains("9a12f9cc-721d-e911-a973-002248072781")){    //Other Memberships
            membershipGrade = "92265fb1-9137-ea11-a813-000d3a0bad17";
            membershipBand = "70aed228-9237-ea11-a813-000d3a0bad17";
        }


        return membershipTypeId;
    }


    public String reasonForJoining(){
        Random random = new Random();
        int memTypes = random.nextInt(membershipReasonForJoiningIds.length);
        membershipReasonForJoiningId = membershipReasonForJoiningIds[memTypes];
        return membershipReasonForJoiningId;
            }

}
