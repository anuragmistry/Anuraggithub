Feature: UnSubscribe Flow for ONMO Paywall 

#Scenario: Launch the Browser then Add User Agent and Operator IP Range
#	Given Launch the browser
#    Given Set the Headers with "Globacom" IP range "41.194.25.64" 
       
 #######   Wifi Flow  #########   
#### User UnSubscribe Flow######

Scenario: Delete the DB Record fro Packs and DM log table.
	 Then Delete the User "8110005555" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2348110005555" form DM Log Table
 
Scenario: Navigate the Portal with Subscribe API.
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
	When Navigate to url "Globacom_Subscribe_API_URL_CallBack_WithPackId"
   
Scenario: User Subscribe flow via UIM Page
    Then Validate is Logo present
	And  Validate is Banner present
	Then Enter the MSISDN "8110005555"
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
    Then Get the OTP Value for MSISDN "8110005555" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Validate User "2348110005555" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Get the current domain Cookies value
    Then Validate is Logo present
	 And Validate is Banner present
    Then Validate subscribed to the operator of your number
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
   #  Then Click on Terms and condition check box
    Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
	Then Click on Subscribe Button
    Then Validate Subscribe thankyou messages and Status of User "8110005555"
    Then Validate User "2348110005555" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2348110005555" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2348110005555" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Click on Ok Button
    Then Validate Redirection url Parameter "u=XXXXXXXX&status=PENDING&opr=GLOBACOM"
 
 Scenario: HIT IndetifyMe API and Identify the user status.
     Then Activate or DeActivate the User "8110005555,GLOBACOM_MONTHLY,30.00,Globacom,ACT" using "Packs_CallBack_API" Packs Callback API
     When Navigate to url "Page_Load_Url"
	 When Navigate to url "Globacom_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=GLOBACOM"
     Then Validate the User Status "ACTIVE" using "Globacom_Check_Status_API" Check Status API

Scenario: User Unsubscribe flow
    When Navigate to url "Page_Load_Url"
    When Navigate to url "Globacom_Unsubscribe_API_URL_CallBack"
    Then Validate is Logo present
	And  Validate is Banner present
	Then Validate Cancel and Corfirm Button is Present
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
	Then Click on Confirm Button
	Then Validate is Logo present
	 And Validate is Banner present
    Then Get the current domain Cookies value
    Then Validate Unsubscribe user thankyou messages
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Validate User "8110005555" current Status in DB
    Then Click on Ok Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=XXXXXXXX&opr=GLOBACOM"
    
  Scenario: HIT IndetifyMe API and Identify the user status.
     When Navigate to url "Page_Load_Url"
     Then Activate or DeActivate the User "8110005555,GLOBACOM_MONTHLY,30.00,Globacom,DCT" using "Packs_CallBack_API" Packs Callback API
	 When Navigate to url "Globacom_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=GLOBACOM"
     Then Validate the User Status "NOT_ACTIVE" using "Globacom_Check_Status_API" Check Status API 
     Then Validate User "2348110005555" DM Log Details for Activity Type "99" from DIAUS DB "DIAUS_DB_URL"  


#######   3G Flow  #########   
#### User UnSubscribe Flow######


Scenario: Delete the DB Record fro Packs and DM log table.
	 Then Delete the User "8110004444" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2348110004444" form DM Log Table
	 
Scenario: Navigate the Portal with Subscribe API and MSISDN with Header
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
	Given Open New Tab and Set "x-up-subno" with Number "2348110004444" in Mod Header
	
 Scenario: HIT IndetifyMe API and Identify the user status.
     When Navigate to url "Page_Load_Url"
	 When Navigate to url "Globacom_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=GLOBACOM"
     Then Validate the User Status "NOT_ACTIVE" using "Globacom_Check_Status_API" Check Status API 
     	
Scenario: User Subscribe flow for Real Time Pack via UIM Page
    When Navigate to url "Globacom_Subscribe_API_URL_CallBack_WithPackId"
    Then Validate is Logo present
	 And Validate is Banner present
    Then Validate User "2348110004444" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Get the current domain Cookies value
    Then Validate subscribed to the operator of your number
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
   #  Then Click on Terms and condition check box
    Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
	Then Click on Subscribe Button
	Then Validate User "2348110004444" DM Log Details for Activity Type "103" from DIAUS DB "DIAUS_DB_URL"
	Then Click on Yes Button in CG Page
    Then Validate Subscribe thankyou messages and Status of User "8110004444"
    Then Validate User "2348110004444" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2348110004444" DM Log Details for Activity Type "55" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2348110004444" DM Log Details for Activity Type "53" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2348110004444" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Click on Ok Button
    Then Validate Redirection url Parameter "u=XXXXXXXX&status=PENDING&opr=GLOBACOM"
 
 Scenario: HIT IndetifyMe API and Identify the user status.
     When Navigate to url "Page_Load_Url"
     Then Activate or DeActivate the User "8110004444,GLOBACOM_MONTHLY,30.00,Globacom,ACT" using "Packs_CallBack_API" Packs Callback API
	 When Navigate to url "Globacom_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=GLOBACOM"
     Then Validate the User Status "ACTIVE" using "Globacom_Check_Status_API" Check Status API
  
 Scenario: User Unsubscribe flow
    When Navigate to url "Page_Load_Url"
    When Navigate to url "Globacom_Unsubscribe_API_URL_CallBack"
    Then Validate is Logo present
	And  Validate is Banner present
	Then Validate Cancel and Corfirm Button is Present
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
	Then Click on Confirm Button
	Then Validate is Logo present
	 And Validate is Banner present
    Then Get the current domain Cookies value
    Then Validate Unsubscribe user thankyou messages
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Validate User "8110004444" current Status in DB
    Then Click on Ok Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=XXXXXXXX&opr=GLOBACOM"
    
  Scenario: HIT IndetifyMe API and Identify the user status.
     When Navigate to url "Page_Load_Url"
     Then Activate or DeActivate the User "8110004444,GLOBACOM_MONTHLY,30.00,Globacom,DCT" using "Packs_CallBack_API" Packs Callback API
	 When Navigate to url "Globacom_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=GLOBACOM"
     Then Validate the User Status "NOT_ACTIVE" using "Globacom_Check_Status_API" Check Status API 
     Then Validate User "2348110004444" DM Log Details for Activity Type "99" from DIAUS DB "DIAUS_DB_URL" 
 
    