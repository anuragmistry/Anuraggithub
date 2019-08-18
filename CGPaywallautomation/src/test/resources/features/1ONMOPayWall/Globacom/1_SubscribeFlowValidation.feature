Feature: Subscription Flow for ONMO Paywall 

Scenario: Launch the Browser then Add User Agent and Operator IP Range
	Given Launch the browser
    Given Set the Headers with "Globacom" IP range "41.194.25.64"
 
 ######### Wifi Flow ########  
 ##### User Subscribe Flow######  
Scenario: Delete the DB Record fro Packs and DM log table.
	 Then Delete the User "8110001111" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2348110001111" form DM Log Table
	 	
Scenario: HIT IndetifyMe API and Identify the user status.
	 When Navigate to url "Globacom_IdentifyMe_API_URL"
	 Then Validate is Logo present
	  And Validate is Banner present
	 Then Enter the MSISDN "8110001111"
	 Then Validate Cancel and Corfirm Button is Present
	 Then Validate Terms and Conditions and Value
	 Then Validate is PoweredBy Logo present
	 Then Validate footer links text and link url
	 Then Click on Confirm Button
	 Then Validate is Logo present
	  And Validate is Banner present
	 Then Validate Re-Send OTP Text Link
	 Then Validate Cancel and Corfirm Button is Present
	 Then Validate is PoweredBy Logo present
	 Then Validate footer links text and link url
     Then Get the OTP Value for MSISDN "8110001111" from DB and Enter the OTP
     Then Click on Confirm Button
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=GLOBACOM"
     Then Validate the User Status "NOT_ACTIVE" using "Globacom_Check_Status_API" Check Status API
		
Scenario: Navigate the Portal with Subscribe API
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
	When Navigate to url "Globacom_Subscribe_API_URL_CallBack"
   
Scenario: User Subscribe flow via UIM Page
    Then Validate is Logo present
	And  Validate is Banner present
	Then Enter the MSISDN "8110001111"
	Then Validate Subscribe messages
	Then Validate Terms and Conditions and Value
	Then Validate Cancel and Corfirm Button is Present
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
	Then Click on Confirm Button
	Then Validate is Logo present
	 And Validate is Banner present
	Then Validate Re-Send OTP Text Link
	Then Validate Cancel and Corfirm Button is Present
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Get the OTP Value for MSISDN "8110001111" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Validate User "2348110001111" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Get the current domain Cookies value
    Then Validate is Logo present
	 And Validate is Banner present
    Then Validate subscribed to the operator of your number
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
    
     #Then Click on Terms and condition check box
     
    Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
	Then Click on Subscribe Button
    Then Validate Subscribe thankyou messages and Status of User "8110001111"
    Then Validate User "2348110001111" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2348110001111" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2348110001111" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Click on Ok Button
    Then Validate Redirection url Parameter "u=XXXXXXXX&status=PENDING&opr=GLOBACOM"
    When Delete all domain Cookies Value
 
 Scenario: HIT IndetifyMe API and Identify the user status.
     Then Activate or DeActivate the User "8110001111,GLOBACOM_MAIN_1,30.00,Globacom,ACT" using "Packs_CallBack_API" Packs Callback API
     When Navigate to url "Page_Load_Url"
     When Delete all domain Cookies Value
	 When Navigate to url "Globacom_IdentifyMe_API_URL"
	 Then Enter the MSISDN "8110001111"
	 Then Click on Confirm Button
     Then Get the OTP Value for MSISDN "8110001111" from DB and Enter the OTP
     Then Click on Confirm Button
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=GLOBACOM"
     Then Validate the User Status "ACTIVE" using "Globacom_Check_Status_API" Check Status API

######   DM Flow  #########   
### User Subscribe Flow###### 

Scenario: Delete the DB Record fro Packs and DM log table.
     When Navigate to url "Page_Load_Url"
     When Delete all domain Cookies Value
	 Then Delete the User "8110002222" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2348110002222" form DM Log Table
	 	
Scenario: HIT IndetifyMe API and Identify the user status.
	 When Navigate to url "Globacom_IdentifyMe_API_URL"
	 Then Validate is Logo present
	  And Validate is Banner present
	 Then Enter the MSISDN "8110002222"
	 Then Validate Cancel and Corfirm Button is Present
	 Then Validate Terms and Conditions and Value
	 Then Validate is PoweredBy Logo present
	 Then Validate footer links text and link url
	 Then Click on Confirm Button
	 Then Validate is Logo present
	  And Validate is Banner present
	 Then Validate Re-Send OTP Text Link
	 Then Validate Cancel and Corfirm Button is Present
	 Then Validate is PoweredBy Logo present
	 Then Validate footer links text and link url
     Then Get the OTP Value for MSISDN "8110002222" from DB and Enter the OTP
     Then Click on Confirm Button
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=GLOBACOM"
     Then Validate the User Status "NOT_ACTIVE" using "Globacom_Check_Status_API" Check Status API
		
Scenario: Navigate the Portal with Subscribe API.
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
	When Navigate to url "Globacom_Subscribe_DM_URL"
   
Scenario: User Subscribe flow via UIM Page
    Then Validate is Logo present
	And  Validate is Banner present
	Then Enter the MSISDN "8110002222"
	Then Validate Subscribe messages
	Then Validate Terms and Conditions and Value
	Then Validate Cancel and Corfirm Button is Present
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
	Then Click on Confirm Button
	Then Validate is Logo present
	 And Validate is Banner present
	Then Validate Re-Send OTP Text Link
	Then Validate Cancel and Corfirm Button is Present
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Get the OTP Value for MSISDN "8110002222" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Validate User "2348110002222" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Get the current domain Cookies value
    Then Validate is Logo present
	 And Validate is Banner present
    Then Validate subscribed to the operator of your number
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
     Then Click on Terms and condition check box
    Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
	Then Click on Subscribe Button
    Then Validate Subscribe thankyou messages and Status of User "8110002222"
    Then Validate User "2348110002222" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2348110002222" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2348110002222" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Click on Ok Button
 
 
 Scenario: HIT IndetifyMe API and Identify the user status.
     Then Activate or DeActivate the User "8110002222,GLOBACOM_MAIN_1,30.00,Globacom,ACT" using "Packs_CallBack_API" Packs Callback API
     Then Validate DM task information after redirect with callBack url
     When Navigate to url "Page_Load_Url"
	 When Navigate to url "Globacom_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=GLOBACOM"
     Then Validate the User Status "ACTIVE" using "Globacom_Check_Status_API" Check Status API
     
     
######   3G Flow  #########   
### User Subscribe Flow######

Scenario: Delete the DB Record fro Packs and DM log table.
	 Then Delete the User "8110007777" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2348110007777" form DM Log Table
	 
Scenario: Navigate the Portal with Subscribe API and MSISDN with Header
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
	Given Open New Tab and Set "x-up-subno" with Number "2348110007777" in Mod Header
	
 Scenario: HIT IndetifyMe API and Identify the user status.
     When Navigate to url "Page_Load_Url"
	 When Navigate to url "Globacom_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=GLOBACOM"
     Then Validate the User Status "NOT_ACTIVE" using "Globacom_Check_Status_API" Check Status API 
     	
Scenario: User Subscribe flow pass Pack  Id via UIM Page
    When Navigate to url "Globacom_Subscribe_API_URL_CallBack_WithPackId"
    Then Validate is Logo present
	 And Validate is Banner present
    Then Validate User "2348110007777" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Get the current domain Cookies value
    Then Validate subscribed to the operator of your number
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
     Then Click on Terms and condition check box
    Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
	Then Click on Subscribe Button
	Then Validate User "2348110007777" DM Log Details for Activity Type "103" from DIAUS DB "DIAUS_DB_URL"
	Then Click on Yes Button in CG Page
    Then Validate Subscribe thankyou messages and Status of User "8110007777"
    Then Validate User "2348110007777" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2348110007777" DM Log Details for Activity Type "55" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2348110007777" DM Log Details for Activity Type "53" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2348110007777" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Click on Ok Button
    Then Validate Redirection url Parameter "u=XXXXXXXX&status=ACTIVE&opr=GLOBACOM"
 
 Scenario: HIT IndetifyMe API and Identify the user status.
     When Navigate to url "Page_Load_Url"
     Then Activate or DeActivate the User "8110007777,GLOBACOM_MONTHLY,30.00,Globacom,ACT" using "Packs_CallBack_API" Packs Callback API
	 When Navigate to url "Globacom_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=GLOBACOM"
     Then Validate the User Status "ACTIVE" using "Globacom_Check_Status_API" Check Status API   

 Scenario: Open the New and Remove the Number from Mod Header
     Given Open New Tab and remove the Number "2348110007777" in Mod Header 
     
  
######   DM Flow with MSISDN in Header #########   
   ### User Subscribe Flow  ###### 
    
Scenario: Delete the DB Record fro Packs and DM log table.
	 Then Delete the User "8110008888" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2348110008888" form DM Log Table
	 
Scenario: Navigate the Portal with Subscribe API and MSISDN with Header
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
	Given Open New Tab and Set "x-up-subno" with Number "2348110008888" in Mod Header
	
 Scenario: HIT IndetifyMe API and Identify the user status.
     When Navigate to url "Page_Load_Url"
	 When Navigate to url "Globacom_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=GLOBACOM"
     Then Validate the User Status "NOT_ACTIVE" using "Globacom_Check_Status_API" Check Status API 
     	
Scenario: User Subscribe flow with MSISDN in Header
    When Navigate to url "Globacom_Subscribe_DM_URL"
    Then Validate is Logo present
	 And Validate is Banner present
    Then Validate User "2348110008888" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Get the current domain Cookies value
    Then Validate subscribed to the operator of your number
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
     Then Click on Terms and condition check box
    Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
	Then Click on Subscribe Button
	Then Validate User "2348110008888" DM Log Details for Activity Type "103" from DIAUS DB "DIAUS_DB_URL"
	Then Click on Yes Button in CG Page
    Then Validate Subscribe thankyou messages and Status of User "8110008888"
    Then Validate User "2348110008888" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2348110008888" DM Log Details for Activity Type "55" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2348110008888" DM Log Details for Activity Type "53" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2348110008888" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Click on Ok Button

 
 Scenario: HIT IndetifyMe API and Identify the user status.
     When Navigate to url "Page_Load_Url"
     Then Activate or DeActivate the User "8110008888,GLOBACOM_MAIN_1,30.00,Globacom,ACT" using "Packs_CallBack_API" Packs Callback API
	 Then Validate DM task information after redirect with callBack url
	 When Navigate to url "Globacom_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=GLOBACOM"
     Then Validate the User Status "ACTIVE" using "Globacom_Check_Status_API" Check Status API   

 Scenario: Open the New and Remove the Number from Mod Header
     Given Open New Tab and remove the Number "2348110008888" in Mod Header 
     
     
     
     