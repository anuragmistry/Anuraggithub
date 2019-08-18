Feature: Subscription Flow for APPLAND via Wifi and 3G Flow

Scenario: Launch the Browser then Add User Agent and Operator IP Range
	Given Launch the browser
    Given Set the Headers with "OmanOoredoo" IP range "5.1.46.255"

####   3G Flow  #########   
#### User Subscribe with Basic Plan ######   
Scenario: Delete the DB Record for Packs and DM log table.
	 Then Delete the User "6666633333" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "9686666633333" form DM Log Table
	 
Scenario: User Subscribe Flow with Basic Plan with out MSISDN in Header
    When Navigate to url "OmanOoredoo_Plans_API_URL"
    Then Validate is Logo Image present
    Then Validate AlbumImg is present
	Then Click on "oman_pack1" Plan Continue Button
	Then Validate is Logo Image present
	Then Validate AlbumImg is present
	Then Enter the MSISDN "6666633333"
	Then Validate Subscribe messages
	Then Validate Terms and Conditions and Value
	Then Click on the Confirm Button
	Then Validate is Logo Image present
	Then Validate AlbumImg is present
	Then Validate Re-Send OTP Text Link
    Then Get the OTP Value for MSISDN "6666633333" from DB and Enter the OTP
    Then Click on the Confirm Button
	Then Validate AlbumImg is present
	Then Validate User "9686666633333" DM Log Details for Activity Type "103" from DIAUS DB "DIAUS_DB_URL"
	Then Click on Subscribe Button in CG Page
	Then Validate is Logo Image present
	Then Validate AlbumImg is present
    Then Get the current domain Cookies value
	Then Validate Subscribe thankyou messages and Status of User "6666633333"
	Then Validate User "9686666633333" DM Log Details for Activity Type "55" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "9686666633333" DM Log Details for Activity Type "53" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "9686666633333" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
	Then Click on Ok Button

 Scenario: Active the user using call back API and HIT Myaccount API and Validate the user status.
     Then Activate or DeActivate the User "6666633333,OMAN_PACK_1,50.00,Ooredoo,ACT" using "Packs_CallBack_API" Packs Callback API
	 When Navigate to url "Page_Load_Url"
	 When Navigate to url "OmanOoredoo_Myaccount_API_URL"
     Then Validate is Logo Image present
	 Then Validate AlbumImg is present
     Then Validate Current Plan Heading and All Active Plan text is Present
     Then Validate Access Service and UnSubscribe Button is Present
     Then Validate Current Active plan Amount with Symbol
     Then Click on "Access Service" Button in MyAccount Page


#######   DM Flow  #########   
#### User Subscribe Flow###### 

Scenario: Add MSISDN in Mod Header.
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
	     
Scenario: Delete the DB Record for Packs and DM log table.
	 Then Delete the User "8888833333" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "9688888833333" form DM Log Table
	 
Scenario: User Subscribe Flow with Basic Plan with out MSISDN in Header
    When Navigate to url "OmanOoredoo_Plans_API_DM_URL"
    Then Validate is Logo Image present
    Then Validate AlbumImg is present
	Then Click on "oman_pack2" Plan Continue Button
	Then Validate is Logo Image present
	Then Validate AlbumImg is present
	Then Enter the MSISDN "8888833333"
	Then Validate Subscribe messages
	Then Validate Terms and Conditions and Value
	Then Click on the Confirm Button
	Then Validate is Logo Image present
	Then Validate AlbumImg is present
	Then Validate Re-Send OTP Text Link
    Then Get the OTP Value for MSISDN "8888833333" from DB and Enter the OTP
    Then Click on the Confirm Button
	Then Validate AlbumImg is present
	Then Validate User "9688888833333" DM Log Details for Activity Type "103" from DIAUS DB "DIAUS_DB_URL"
	Then Click on Subscribe Button in CG Page
	Then Validate is Logo Image present
	Then Validate AlbumImg is present
    Then Get the current domain Cookies value
	Then Validate Subscribe thankyou messages and Status of User "8888833333"
	Then Validate User "9688888833333" DM Log Details for Activity Type "55" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "9688888833333" DM Log Details for Activity Type "53" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "9688888833333" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
	Then Click on Ok Button

 Scenario: Active the user using call back API and HIT Myaccount API and Validate the user status.
     Then Activate or DeActivate the User "8888833333,OMAN_PACK_2,50.00,Ooredoo,ACT" using "Packs_CallBack_API" Packs Callback API
     Then Validate DM task information after redirect with callBack url
	 When Navigate to url "Page_Load_Url"
	 When Navigate to url "OmanOoredoo_Myaccount_API_URL"
     Then Validate is Logo Image present
	 Then Validate AlbumImg is present
     Then Validate Current Plan Heading and All Active Plan text is Present
     Then Validate Access Service and UnSubscribe Button is Present
     Then Validate Current Active plan Amount with Symbol
     Then Click on "Access Service" Button in MyAccount Page     
      