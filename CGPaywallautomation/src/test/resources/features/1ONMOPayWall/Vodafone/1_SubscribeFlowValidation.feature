Feature: Subscription Flow for ONMO Paywall 

Scenario: Launch the Browser then Add User Agent and Operator IP Range
	Given Launch the browser
    Given Set the Headers with "Vodafone" IP range "182.19.25.1"
    
Scenario: Delete the DB Record fro Packs and DM log table.
	 Then Delete the User "9110001112" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "919110001112" form DM Log Table
	 	
Scenario: HIT IndetifyMe API and Identify the user status.
	 When Navigate to url "Vodafone_IdentifyMe_API_URL"
	 Then Validate is Logo present
	  And Validate is Banner present
	 Then Enter the MSISDN "9110001112"
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
     Then Get the OTP Value for MSISDN "9110001112" from DB and Enter the OTP
     Then Click on Confirm Button
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=Vodafone"
     Then Validate the User Status "NOT_ACTIVE" using "VODAFONE" Check Status API
		
Scenario: Navigate the Portal with Subscribe API with Real Time PackId.
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
	When Navigate to url "Vodafone_Subscribe_API_URL_CallBack"
   
Scenario: User Subscribe flow via UIM Page(With out MSISDN Header)
    Then Validate is Logo present
	And  Validate is Banner present
	Then Enter the MSISDN "9110001112"
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
    Then Get the OTP Value for MSISDN "9110001112" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Validate User "919110001112" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
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
    Then Validate Subscribe thankyou messages and Status of User "9110001112"
    Then Validate User "919110001112" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "919110001112" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "919110001112" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Click on Ok Button
    Then Validate Redirection url Parameter "u=XXXXXXXX&status=PENDING&opr=Vodafone"
    When Delete all domain Cookies Value
 
 Scenario: HIT IndetifyMe API and Identify the user status.
     When Navigate to url "Page_Load_Url"
     When Delete all domain Cookies Value
	 When Navigate to url "Vodafone_IdentifyMe_API_URL"
	 Then Enter the MSISDN "9110001112"
	 Then Click on Confirm Button
     Then Get the OTP Value for MSISDN "9110001112" from DB and Enter the OTP
     Then Click on Confirm Button
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=Vodafone"
     Then Validate the User Status "PENDING" using "VODAFONE" Check Status API


Scenario: Navigate the Portal with Subscribe API with Real Time PackId.
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
	When Navigate to url "Vodafone_Subscribe_API_URL_CallBack"
	
Scenario: Delete the DB Record for Packs and DM log table.
	 Then Delete the User "9110007777" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "919110007777" form DM Log Table
	 	
Scenario: User Subscribe flow for Real Time Pack via UIM Page(With out MSISDN Header)
    Then Validate is Logo present
	 And Validate is Banner present
	Then Enter the MSISDN "9110007777"
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
    Then Get the OTP Value for MSISDN "9110007777" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Validate User "919110007777" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
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
    Then Validate Subscribe thankyou messages and Status of User "9110007777"
    Then Validate User "919110007777" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "919110007777" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "919110007777" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Click on Ok Button
    Then Validate Redirection url Parameter "u=XXXXXXXX&status=ACTIVE&opr=Vodafone"
    When Delete all domain Cookies Value
 
 Scenario: HIT IndetifyMe API and Identify the user status.
     When Navigate to url "Page_Load_Url"
     When Delete all domain Cookies Value
	 When Navigate to url "Vodafone_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=Vodafone"
     Then Validate the User Status "ACTIVE" using "VODAFONE" Check Status API   


Scenario: Delete the DB Record fro Packs and DM log table.
	 Then Delete the User "9119999999" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "919119999999" form DM Log Table
	 
Scenario: Navigate the subscribe API and Set the with MSISDN in Header(for 3G Flow)
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    Given Open New Tab and Set "x-up-subno" with Number "919119999999" in Mod Header
	When Navigate to url "Vodafone_Subscribe_API_URL_CallBack"
	Then Validate User "919119999999" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"

Scenario: User Subscribe flow via Data flow (With MSISDN Header)
    Then Validate is Logo present
	 And Validate is Banner present
    Then Validate subscribed to the operator of your number
    Then Validate Pack Detials messages
	Then Validate Terms and Conditions and Value
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
	Then Get the current domain Cookies value
	Then Click on Subscribe Button
	Then Validate User "919119999999" DM Log Details for Activity Type "103" from DIAUS DB "DIAUS_DB_URL"
	Then Click on Yes Button in CG Page
    Then Validate Subscribe thankyou messages and Status of User "9119999999"
    Then Validate User "919119999999" DM Log Details for Activity Type "55" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "919119999999" DM Log Details for Activity Type "53" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "919119999999" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Click on Ok Button
    Then Validate Redirection url Parameter "u=XXXXXXXX&status=ACCEPTED&opr=Vodafone"
    When Delete all domain Cookies Value
 
 Scenario: HIT IndetifyMe API and Identify the user status.
     When Navigate to url "Page_Load_Url"
     When Delete all domain Cookies Value
	 When Navigate to url "Vodafone_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=Vodafone"
     Then Validate the User Status "PENDING" using "VODAFONE" Check Status API 
 
 Scenario: Active the user using call back API and HIT IndetifyMe API and Identify the user status.
     Then Activate the User "8119999999" using Packs Callback API for "VODAFONE" Operator
     When Navigate to url "Page_Load_Url"
     When Delete all domain Cookies Value
	 When Navigate to url "Vodafone_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=Vodafone"
     Then Validate the User Status "PENDING" using "VODAFONE" Check Status API 


     
     
      