Feature: ROBI - Subscription Flow with DM URL

Scenario: Launch the Browser then Add User Agent and Operator IP Range
	Given Launch the browser
  Given Set the Headers with "ROBI" IP range "23.92.73.0"

#######   DM Flow  #########   
#### User Subscribe Flow###### 

Scenario: Delete the DB Record fro Packs and DM log table.
   When Navigate to url "Page_Load_Url"
   When Delete all domain Cookies Value
	 Then Delete the User "9998000011" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "8809998000011" form DM Log Table
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "NA" form DM Log Table
	 	
Scenario: HIT IndetifyMe API and Identify the user status.
	 When Navigate to url "ROBI_IdentifyMe_API_URL"
	 Then Validate is Logo present
	 And Validate is Banner present
	 Then Enter the MSISDN "9998000011"
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
   Then Get the OTP Value for MSISDN "9998000011" from DB and Enter the OTP
   Then Click on Confirm Button
   Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=ROBI"
   Then Validate the User Status "NOT_ACTIVE" using "ROBI_Check_Status_API" Check Status API
		
Scenario: Navigate to onmopay with DM Subscribe API.
  When Navigate to url "Page_Load_Url"
  When Delete all domain Cookies Value
  When Navigate to url "ROBI_Subscribe_DM_URL"
   
Scenario: User Subscribe flow without MSISDN Header 
  Then Validate is Logo present
	And  Validate is Banner present
	Then Enter the MSISDN "9998000011"
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
    Then Get the OTP Value for MSISDN "9998000011" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Validate User "NA" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
   Then Validate User "NA" DM Log Details for Activity Type "104" from DIAUS DB "DIAUS_DB_URL"
    Then Get the current domain Cookies value
    Then Validate is Logo present
    And Validate is Banner present
    Then Validate subscribed to the operator of your number
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
    Then Click on Terms and condition check box
    Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
 Then Get the current domain Cookies value
	
#Enable in wifi and disable this step in with header case
		Then Click on Terms and condition check box
Then Click on Subscribe Button

Then Validate User "8809998000011" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
Then Validate User "8809998000011" DM Log Details for Activity Type "103" from DIAUS DB "DIAUS_DB_URL"

Then Click on Yes Button in CG Page
 Then Validate Subscribe thankyou messages and Status of User "9998000011"

    Then Validate Subscribe thankyou messages and Status of User "9999000066"
    Then Validate User "8809998000011" DM Log Details for Activity Type "55" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "8809998000011" DM Log Details for Activity Type "53" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "8809998000011" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    
Then Validate is PoweredBy Logo present
Then Validate footer links text and link url
Then Click on Ok Button
Then Validate Redirection url Parameter "status=PENDING&u=xxxxxxxxx&opr=ROBI"

Scenario: HIT IndetifyMe API and Identify the user status.
    Then Activate or DeActivate the User "9998000011,ROBI_MAIN_1,50,ROBI,ACT" using "Packs_CallBack_API" Packs Callback API
    When Navigate to url "Page_Load_Url"
		When Navigate to url "ROBI_IdentifyMe_API_URL"
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=ROBI"
    Then Validate the User Status "ACTIVE" using "ROBI_Check_Status_API" Check Status API
    Then Validate DM task information after redirect with callBack url
    
     
 #######   DM Flow with MSISDN in Header #########   
 ######## User Subscribe Flow ########### 
    
Scenario: Delete the DB Record fro Packs and DM log table.
	Then Delete the User "9998000012" records from Packs DB
	Then Delete "DIAUS_INDIA_DB" the Log Entry for User "8809998000012" form DM Log Table
	Then Delete "DIAUS_INDIA_DB" the Log Entry for User "NA" form DM Log Table
	 
Scenario: Navigate the Page_Load_Url Delete all the Domain Cookie and  and Set the with MSISDN in Header
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    Given Open New Tab and Set "x-up-subno" with Number "8809998000012" in Mod Header
	 Then Delete the User "9998000012" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "8809998000012" form DM Log Table
	
 Scenario: HIT IndetifyMe API and Identify the user status.
	 When Navigate to url "ROBI_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=ROBI"
     Then Validate the User Status "NOT_ACTIVE" using "ROBI_Check_Status_API" Check Status API
  	
Scenario: User DM Subscribe flow via Data flow With MSISDN Header
    When Navigate to url "ROBI_Subscribe_DM_URL"
  Then Validate User "8809998000012" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"  
Then Validate is Logo present
    And Validate is Banner present
    Then Get the current domain Cookies value
    Then Validate subscribed to the operator of your number
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
    Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
Then Get the current domain Cookies value
	
	#Enable in wifi and disable this step in with header case
	#Then Click on Terms and condition check box

	Then Click on Subscribe Button
	Then Validate User "8809998000012" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
	Then Validate User "8809998000012" DM Log Details for Activity Type "103" from DIAUS DB "DIAUS_DB_URL"
		 
	Then Click on Yes Button in CG Page
	Then Validate Subscribe thankyou messages and Status of User "9998000012"
  
  Then Validate User "8809998000012" DM Log Details for Activity Type "55" from DIAUS DB "DIAUS_DB_URL"
  Then Validate User "8809998000012" DM Log Details for Activity Type "53" from DIAUS DB "DIAUS_DB_URL"
  Then Validate User "8809998000012" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
   
  Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
  Then Click on Ok Button
  Then Validate Redirection url Parameter "u=XXXXXXXX&status=PENDING&opr=ROBI"
  
 Scenario: Active the user using call back API and HIT IndetifyMe API and Identify the user status.
     Then Activate or DeActivate the User "9998000012,ROBI_MAIN_1,50,ROBI,ACT" using "Packs_CallBack_API" Packs Callback API
     When Navigate to url "Page_Load_Url"
	 When Navigate to url "ROBI_IdentifyMe_API_URL" 
	 Then Validate DM task information after redirect with callBack url
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=ROBI"
     Then Validate the User Status "ACTIVE" using "ROBI_Check_Status_API" Check Status API
     
Scenario: Close the browser
	Then Close the browser
     