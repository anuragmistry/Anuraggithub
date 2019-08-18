Feature: UnSubscription Flow for APPLAND via Wifi Flow

#Scenario: Launch the Browser then Add User Agent and Operator IP Range
#	Given Launch the browser
#    Given Set the Headers with "Globacom" IP range "41.194.25.64"

 ######### 3G Flow ########  
 ##### User UnSubscribe Flow######  
 Scenario: Navigate the Portal and Delete all the Cookies Value
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
        
Scenario: Delete the DB Record fro Packs and DM log table.
	 Then Delete the User "9999988888" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2349999988888" form DM Log Table
     
Scenario: User Subscribe Flow with Basic Plan with MSISDN in Header
    Given Open New Tab and Set "x-up-subno" with Number "2349999988888" in Mod Header
    When Navigate to url "Globacom_Plans_API_URL"
    Then Validate is Logo Image present
    Then Validate AlbumImg is present
	Then Click on "globacom_daily" Plan Continue Button
	Then Validate is Logo Image present
	Then Validate AlbumImg is present
	Then Validate Terms and Conditions and Value
	Then Click on Subscribe Button
	Then Validate User "2349999988888" DM Log Details for Activity Type "103" from DIAUS DB "DIAUS_DB_URL"
	Then Click on Yes Button in CG Page
	Then Validate is Logo Image present
	Then Validate AlbumImg is present
    Then Get the current domain Cookies value
	Then Validate Subscribe thankyou messages and Status of User "9999988888"
	Then Validate User "2349999988888" DM Log Details for Activity Type "55" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2349999988888" DM Log Details for Activity Type "53" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2349999988888" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
	Then Click on Ok Button

 Scenario: Active the user using call back API and HIT Myaccount API and Validate the user status and Unsubscribe the User.
     Then Activate or DeActivate the User "9999988888,GLOBACOM_DAILY,10.00,Globacom,ACT" using "Packs_CallBack_API" Packs Callback API
	 When Navigate to url "Page_Load_Url"
	 When Navigate to url "Globacom_Myaccount_API_URL"
     Then Validate is Logo Image present
	 Then Validate AlbumImg is present
     Then Validate Current Plan Heading and All Active Plan text is Present
     Then Validate Access Service and UnSubscribe Button is Present
     Then Validate Current Active plan Amount with Symbol
     Then Click on "UnSubscribe" Button in MyAccount Page
     Then Activate or DeActivate the User "9999988888,GLOBACOM_DAILY,10.00,Globacom,DCT" using "Packs_CallBack_API" Packs Callback API
     Then Validate is Logo Image present
	 Then Validate AlbumImg is present
     Then Validate Unsubscribe user thankyou messages
     Then Click on Ok Button
 

 Scenario: Open the New and Remove the Number from Mod Header
     Given Open New Tab and remove the Number "2349999988888" in Mod Header 

 ####   Wifi Flow with DM URL  #########   
#### User Subscribe with Specific Plan ######  
 Scenario: HIT Myaccount API and Validate the user status and Unsubscribe the User.
     When Navigate to url "Page_Load_Url"
	 When Delete all domain Cookies Value
	 When Navigate to url "Globacom_Myaccount_API_URL"
	 Then Validate is Logo Image present
	 Then Validate AlbumImg is present
	 Then Enter the MSISDN "7018888666"
	 Then Validate Subscribe messages
	 Then Validate Terms and Conditions and Value
	 Then Click on the Confirm Button
	 Then Validate is Logo Image present
	 Then Validate AlbumImg is present
	 Then Validate Re-Send OTP Text Link
     Then Get the OTP Value for MSISDN "7018888666" from DB and Enter the OTP
     Then Click on the Confirm Button
     Then Validate is Logo Image present
	 Then Validate AlbumImg is present
     Then Validate Current Plan Heading and All Active Plan text is Present
     Then Validate Access Service and UnSubscribe Button is Present
     Then Validate Current Active plan Amount with Symbol
     Then Click on "UnSubscribe" Button in MyAccount Page
     Then Activate or DeActivate the User "7018888666,GLOBACOM_MONTHLY,50.00,Globacom,DCT" using "Packs_CallBack_API" Packs Callback API
     Then Validate is Logo Image present
	 Then Validate AlbumImg is present
     Then Validate Unsubscribe user thankyou messages
     Then Click on Ok Button
     
     