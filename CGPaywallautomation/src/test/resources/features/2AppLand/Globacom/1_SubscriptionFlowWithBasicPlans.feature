Feature: Subscription Flow for APPLAND via Wifi and 3G Flow

Scenario: Launch the Browser then Add User Agent and Operator IP Range
	Given Launch the browser
    Given Set the Headers with "Globacom" IP range "41.194.25.64"

######   3G Flow  #########   
###### User Subscribe with Basic Plan ######   
Scenario: Delete the DB Record for Packs and DM log table.
	 Then Delete the User "7019999999" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2347019999999" form DM Log Table
	 
Scenario: User Subscribe Flow with Basic Plan with out MSISDN in Header
    Given Open New Tab and Set "x-up-subno" with Number "2347019999999" in Mod Header
    When Navigate to url "Globacom_Plans_API_URL"
    Then Validate is Logo Image present
    Then Validate AlbumImg is present
	Then Click on "globacom_daily" Plan Continue Button
	Then Validate is Logo Image present
	Then Validate AlbumImg is present
	Then Validate Terms and Conditions and Value
	Then Click on Subscribe Button
	Then Validate User "2347019999999" DM Log Details for Activity Type "103" from DIAUS DB "DIAUS_DB_URL"
	Then Click on Yes Button in CG Page
	Then Validate is Logo Image present
	Then Validate AlbumImg is present
    Then Get the current domain Cookies value
	Then Validate Subscribe thankyou messages and Status of User "7019999999"
	Then Validate User "2347019999999" DM Log Details for Activity Type "55" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2347019999999" DM Log Details for Activity Type "53" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2347019999999" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
	Then Click on Ok Button

 Scenario: Active the user using call back API and HIT Myaccount API and Validate the user status.
     Then Activate or DeActivate the User "7019999999,GLOBACOM_DAILY,10.00,Globacom,ACT" using "Packs_CallBack_API" Packs Callback API
	 When Navigate to url "Page_Load_Url"
	 When Delete all domain Cookies Value
	 When Navigate to url "Globacom_Myaccount_API_URL"
     Then Validate is Logo Image present
	 Then Validate AlbumImg is present
     Then Validate Current Plan Heading and All Active Plan text is Present
     Then Validate Access Service and UnSubscribe Button is Present
     Then Validate Current Active plan Amount with Symbol
     Then Click on "Access Service" Button in MyAccount Page


Scenario: Open the New and Remove the Number from Mod Header
     Given Open New Tab and remove the Number "2347019999999" in Mod Header
 
 ####   DM Flow(Via 3G)  #########   
#### User Subscribe with Basic Plan ######  
   
Scenario: Navigate to url Page_Load_Url and  Add MSISDN in Mod Header.
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
	Given Open New Tab and Set "x-up-subno" with Number "2347016666666" in Mod Header
	     
Scenario: Delete the DB Record for Packs and DM log table.
	 Then Delete the User "7016666666" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2347016666666" form DM Log Table
	 
Scenario: User Subscribe Flow with Basic Plan with out MSISDN in Header
    When Navigate to url "Globacom_Plans_API_DM_URL"
    Then Validate is Logo Image present
    Then Validate AlbumImg is present
	Then Click on "globacom_weekly" Plan Continue Button
	Then Validate is Logo Image present
	Then Validate AlbumImg is present
	Then Validate Terms and Conditions and Value
	Then Click on Subscribe Button
	Then Validate User "2347016666666" DM Log Details for Activity Type "103" from DIAUS DB "DIAUS_DB_URL"
	Then Click on Yes Button in CG Page
	Then Validate is Logo Image present
	Then Validate AlbumImg is present
    Then Get the current domain Cookies value
	Then Validate Subscribe thankyou messages and Status of User "7016666666"
	Then Validate User "2347016666666" DM Log Details for Activity Type "55" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2347016666666" DM Log Details for Activity Type "53" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2347016666666" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
	Then Click on Ok Button
	
 Scenario: Active the user using call back API and HIT Myaccount API and Validate the user status.
     Then Activate or DeActivate the User "7016666666,GLOBACOM_WEEKLY,30.00,Globacom,ACT" using "Packs_CallBack_API" Packs Callback API
     Then Validate DM task information after redirect with callBack url
	 When Navigate to url "Page_Load_Url"
	 When Delete all domain Cookies Value
	 When Navigate to url "Globacom_Myaccount_API_URL"
     Then Validate is Logo Image present
	 Then Validate AlbumImg is present
     Then Validate Current Plan Heading and All Active Plan text is Present
     Then Validate Access Service and UnSubscribe Button is Present
     Then Validate Current Active plan Amount with Symbol
     Then Click on "Access Service" Button in MyAccount Page     
 
 Scenario: Open the New and Remove the Number from Mod Header
     Given Open New Tab and remove the Number "2347016666666" in Mod Header    

 ####   Wifi Flow  #########   
#### User Subscribe with Specific Plan ######   
Scenario: Delete the DB Record for Packs and DM log table.
	 Then Delete the User "7018888999" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2347018888999" form DM Log Table
	 When Navigate to url "Page_Load_Url"
     When Delete all domain Cookies Value
     
Scenario: User Subscribe Flow with Basic Plan with out MSISDN in Header
    When Navigate to url "Globacom_Plans_API_DM_URL"
    Then Validate is Logo Image present
    Then Validate AlbumImg is present
	Then Click on "globacom_daily" Plan Continue Button
	Then Validate is Logo Image present
	Then Validate AlbumImg is present
	Then Enter the MSISDN "7018888999"
	Then Validate Subscribe messages
	Then Validate Terms and Conditions and Value
	Then Click on the Confirm Button
	Then Validate is Logo Image present
	Then Validate AlbumImg is present
	Then Validate Re-Send OTP Text Link
    Then Get the OTP Value for MSISDN "7018888999" from DB and Enter the OTP
    Then Click on the Confirm Button
    Then Get the current domain Cookies value
    Then Validate User "2347018888999" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is Logo Image present
	Then Validate AlbumImg is present
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
    Then Click on Subscribe Button
    Then Validate is Logo Image present
	Then Validate AlbumImg is present
	Then Validate Subscribe thankyou messages and Status of User "7018888999"
	Then Validate User "2347018888999" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2347018888999" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2347018888999" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
	Then Click on Ok Button

 Scenario: Active the user using call back API and HIT Myaccount API and Validate the user status.
     Then Activate or DeActivate the User "7018888999,GLOBACOM_DAILY,10.00,Globacom,ACT" using "Packs_CallBack_API" Packs Callback API
	 When Navigate to url "Page_Load_Url"
	 When Delete all domain Cookies Value
	 When Navigate to url "Globacom_Myaccount_API_URL"
	 Then Validate is Logo Image present
	 Then Validate AlbumImg is present
	 Then Enter the MSISDN "7018888999"
	 Then Validate Subscribe messages
	 Then Validate Terms and Conditions and Value
	 Then Click on the Confirm Button
	 Then Validate is Logo Image present
	 Then Validate AlbumImg is present
	 Then Validate Re-Send OTP Text Link
     Then Get the OTP Value for MSISDN "7018888999" from DB and Enter the OTP
     Then Click on the Confirm Button
     Then Validate is Logo Image present
	 Then Validate AlbumImg is present
     Then Validate Current Plan Heading and All Active Plan text is Present
     Then Validate Access Service and UnSubscribe Button is Present
     Then Validate Current Active plan Amount with Symbol
     Then Click on "Access Service" Button in MyAccount Page
     
     
 ####   Wifi Flow with DM URL  #########   
#### User Subscribe with Specific Plan ######   
Scenario: Delete the DB Record for Packs and DM log table.
	 Then Delete the User "7018888666" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2347018888666" form DM Log Table
	 When Navigate to url "Page_Load_Url"
     When Delete all domain Cookies Value
     
Scenario: User Subscribe Flow with Basic Plan with out MSISDN in Header
    When Navigate to url "Globacom_Plans_API_DM_URL"
    Then Validate is Logo Image present
    Then Validate AlbumImg is present
	Then Click on "globacom_monthly" Plan Continue Button
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
    Then Get the current domain Cookies value
    Then Validate User "2347018888666" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is Logo Image present
	Then Validate AlbumImg is present
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
    Then Click on Subscribe Button
    Then Validate is Logo Image present
	Then Validate AlbumImg is present
	Then Validate Subscribe thankyou messages and Status of User "7018888666"
	Then Validate User "2347018888666" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2347018888666" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2347018888666" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
	Then Click on Ok Button

 Scenario: Active the user using call back API and HIT Myaccount API and Validate the user status.
     Then Activate or DeActivate the User "7018888666,GLOBACOM_MONTHLY,50.00,Globacom,ACT" using "Packs_CallBack_API" Packs Callback API
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
     Then Click on "Access Service" Button in MyAccount Page
          
          
 #Then Validate User "2549383883883" DM Log Details for Activity Type "7" and Campaign Data Set "CampaignSource=onmobile&CampaignMedium=onmobile&CampaignID=onmobile&CampaignSessionID=Tyroo" from m DB "DIAUS_DB_URL"
##Petar Prism Tlog Case
# Then Then Validate User "2547050009999" DM Log Details for Activity Type "25" and Campaign Data Set "" and I want validate Prism TLogs Campaign Data "True" and compare with "DIAUS_DB_URL" Database