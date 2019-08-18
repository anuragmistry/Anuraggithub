Feature: UnSubscription Flow for APPLAND via Wifi and 3G Flow

 Scenario: Navigate the Portal and Delete all the Cookies Value
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value

Scenario: Delete the DB Record fro Packs and DM log table.
	 Then Delete the User "7052222222" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2547052222222" form DM Log Table
	 
Scenario: User Subscribe Flow with Basic Plan with out MSISDN in Header
    When Navigate to url "Safaricom_Plans_API_URL"
    Then Validate is Logo Image present
	Then Click on "Basic" Button
	Then Validate "Basic" Subscribe Packs details message
	Then Validate Joint Family Account Button is Present
	Then Validate Terms and Conditions text and Value
	Then Click on "Basic" Continue Button
	Then Validate is Logo Image present
	Then Validate AlbumImg is present
	Then Enter the MSISDN "7052222222"
	Then Validate Subscribe messages
	Then Validate Terms and Conditions and Value
	Then Click on the Confirm Button
	
#	Then Validate is Logo Image present
#	Then Validate AlbumImg is present
#	Then Validate Re-Send OTP Text Link
#    Then Get the OTP Value for MSISDN "7052222222" from DB and Enter the OTP
#    Then Click on the Confirm Button
    
    Then Get the current domain Cookies value
    Then Validate User "2547052222222" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is Logo Image present
	Then Validate AlbumImg is present
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
    Then Click on Subscribe Button
    Then Validate is Logo Image present
	Then Validate AlbumImg is present
	Then Validate Subscribe thankyou messages and Status of User "7052222222"
	Then Validate User "2547052222222" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547052222222" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547052222222" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
	Then Click on Ok Button

 Scenario: Active the user using call back API and HIT Myaccount API and Validate the user status.
     Then Activate or DeActivate the User "7052222222,SAFARI_MAIN_1,30.00,Safaricom,ACT" using "Packs_CallBack_API" Packs Callback API
	 When Navigate to url "Page_Load_Url"
	 When Navigate to url "Safaricom_Myaccount_API_URL"
     Then Validate is Logo Image present
	 Then Validate AlbumImg is present
     Then Validate Current Plan Heading and All Active Plan text is Present
     Then Validate Access Service and UnSubscribe Button is Present
     Then Validate Current Active plan Amount with Symbol
     Then Click on "UnSubscribe" Button in MyAccount Page
     Then Activate or DeActivate the User "7052222222,SAFARI_MAIN_1,30.00,Safaricom,DCT" using "Packs_CallBack_API" Packs Callback API
     Then Validate is Logo Image present
	 Then Validate AlbumImg is present
     Then Validate Unsubscribe user thankyou messages
     Then Click on Ok Button


##########   3G Flow  ##############  
#### User Subscribe with Family Plan ######
    
 Scenario: Delete the DB Record fro Packs and DM log table.
	 Then Delete the User "7055555551" records from Packs DB
	 Then Delete "DIAUS_DB_URL" the User Entry "7055555551" form DIAUS UserManagement Table
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2547055555551" form DM Log Table
	 
Scenario: Navigate the Plans API and Set the with MSISDN in Header (for 3G Flow)
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    Given Open New Tab and Set "x-up-subno" with Number "2547055555551" in Mod Header
    
Scenario: User Subscribe Flow with Family Plan with out MSISDN in Header
    When Navigate to url "Safaricom_Plans_API_URL"
    Then Validate is Logo Image present
	Then Click on "Family" Button
	Then Validate "Family" Subscribe Packs details message
	Then Validate Joint Family Account Button is Present
	Then Validate Terms and Conditions text and Value
	Then Click on "Family" Continue Button
    Then Get the current domain Cookies value
    Then Validate User "2547055555551" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is Logo Image present
	Then Validate AlbumImg is present
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
    Then Click on Subscribe Button
    Then Validate is Logo Image present
	Then Validate AlbumImg is present
	Then Validate Subscribe thankyou messages and Status of User "7055555551"
	Then Validate User "2547055555551" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547055555551" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547055555551" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
	Then Click on Ok Button
	
Scenario: Create a User Account using Signup Page
	Then Validate SignUp is present
	Then Validate Mobile Number Label and inside Value "7055555551" in SignUp Page
	Then Enter the Password and Confrim Password "7055555551"
	Then Validate Cancel and Continue Button is Present in SignUp Page
	Then Click on Continue Button in SignUp Page
	Then Validate SignUp User "7055555551" data from DIAUS DB
 
 Scenario: Active the User using call back API and HIT Myaccount API and Validate the User Status.
     Then Activate or DeActivate the User "7055555551,SAFARI_MAIN_2,50.00,Safaricom,ACT" using "Packs_CallBack_API" Packs Callback API
	 When Navigate to url "Page_Load_Url"
	 When Delete all domain Cookies Value
	 When Navigate to url "Safaricom_Myaccount_API_URL"
	 Then Validate is Logo Image present
	 Then Validate AlbumImg is present
     Then Validate Current Plan Heading and All Active Plan text is Present
     Then Validate Access Service and UnSubscribe Button is Present
     Then Validate Current Active plan Amount with Symbol
     Then Click on "UnSubscribe" Button in MyAccount Page
     Then Activate or DeActivate the User "7055555551,SAFARI_MAIN_2,50.00,Safaricom,DCT" using "Packs_CallBack_API" Packs Callback API
     Then Validate is Logo Image present
	 Then Validate AlbumImg is present
     Then Validate Unsubscribe user thankyou messages
     Then Click on Ok Button
     