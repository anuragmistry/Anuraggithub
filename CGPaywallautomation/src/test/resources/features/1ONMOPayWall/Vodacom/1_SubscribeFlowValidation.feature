Feature: Subscription Flow for ONMO Paywall 

Scenario: Launch the Browser then Add User Agent and Operator IP Range
	Given Launch the browser
    Given Set the Headers with "Vodacom" IP range "41.76.148.0"
#######   Wifi Flow  #########   
#### User Subscribe Flow######      
Scenario: Delete the DB Record fro Packs and DM log table.
	 Then Delete the User "9999000011" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2589999000011" form DM Log Table
	 	
Scenario: HIT IndetifyMe API and Identify the user status.
	 When Navigate to url "Vodacom_IdentifyMe_API_URL"
	 Then Validate is Logo present
	  And Validate is Banner present
	 Then Enter the MSISDN "9999000011"
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
     Then Get the OTP Value for MSISDN "9999000011" from DB and Enter the OTP
     Then Click on Confirm Button
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=VODACOM"
     Then Validate the User Status "NOT_ACTIVE" using "Vodacom_Check_Status_API" Check Status API
		
Scenario: Navigate the Portal and Delete all the Cookies Value
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value

Scenario: User Subscribe flow With out MSISDN Header
    When Navigate to url "Vodacom_Subscribe_API_URL_CallBack"
    Then Validate is Logo present
	And  Validate is Banner present
	Then Enter the MSISDN "9999000011"
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
    Then Get the OTP Value for MSISDN "9999000011" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Validate User "2589999000011" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
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
    Then Validate Subscribe thankyou messages and Status of User "9999000011"
    Then Validate User "2589999000011" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2589999000011" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2589999000011" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Click on Ok Button
    Then Validate Redirection url Parameter "u=XXXXXXXX&status=PENDING&opr=VODACOM"

 
 Scenario: HIT IndetifyMe API and Identify the user status.
     Then Activate or DeActivate the User "9999000011,VODACOM_KEY_1,30.00,Vodacom,ACT" using "Packs_CallBack_API" Packs Callback API
     When Navigate to url "Page_Load_Url"
	 When Navigate to url "Vodacom_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=VODACOM"
     Then Validate the User Status "ACTIVE" using "Vodacom_Check_Status_API" Check Status API

########   3G Flow  #########   
##### User Subscribe Flow###### 
Scenario: Delete the DB Record fro Packs and DM log table.
	 Then Delete the User "9999000033" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2589999000033" form DM Log Table
	 
Scenario: Navigate the Page_Load_Url Delete all the Domain Cookie and  and Set the with MSISDN in Header
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    Given Open New Tab and Set "x-up-subno" with Number "2589999000033" in Mod Header

 Scenario: HIT IndetifyMe API and Identify the user status.
	 When Navigate to url "Vodacom_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=SAFARICOM"
     Then Validate the User Status "NOT_ACTIVE" using "Vodacom_Check_Status_API" Check Status API

Scenario: User Subscribe flow via Data flow With MSISDN Header
    When Navigate to url "Safaricom_Subscribe_API_URL_CallBack"
	Then Validate User "2589999000033" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is Logo present
	 And Validate is Banner present
    Then Validate subscribed to the operator of your number
    Then Validate Pack Detials messages
	Then Validate Terms and Conditions and Value
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
	Then Get the current domain Cookies value
	Then Click on Subscribe Button
    Then Validate Subscribe thankyou messages and Status of User "9999000033"
    Then Validate User "2589999000033" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2589999000033" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2589999000033" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Click on Ok Button
    Then Validate Redirection url Parameter "u=XXXXXXXX&status=SUCCESS&opr=SAFARICOM"
  
 Scenario: Active the user using call back API and HIT IndetifyMe API and Identify the user status.
     Then Activate or DeActivate the User "9999000033,VODACOM_KEY_1,30.00,Vodacom,ACT" using "Packs_CallBack_API" Packs Callback API
     When Navigate to url "Page_Load_Url"
	 When Navigate to url "Vodacom_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=VODACOM"
     Then Validate the User Status "ACTIVE" using "Vodacom_Check_Status_API" Check Status API
     
 Scenario: Open the New and Remove the Number from Mod Header
     Given Open New Tab and remove the Number "2589999000033" in Mod Header   
     
      