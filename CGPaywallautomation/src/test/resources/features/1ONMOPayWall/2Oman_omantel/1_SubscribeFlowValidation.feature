Feature: Subscription Flow for Onmopay Oman Omantel

Scenario: Launch the Browser then Add User Agent and Operator IP Range
	Given Launch the browser

####### Wifi Flow #########   
###### User Subscribe Flow######      
Scenario: Delete the DB Record from Packs and DM log table.
	 Then Delete the User "8889000001" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "9688889000001" form DM Log Table
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "NA" form DM Log Table
	 
Scenario: HIT IndetifyMe API and Identify the user status.
	 When Navigate to url "OMANTEL_IdentifyMe_API_URL"
	 Then Click on identify button "without" msisdn
	 Then Validate is Logo present
	 And Validate is Banner present
	 Then Enter the MSISDN "8889000001"
	 Then Validate Cancel and Corfirm Button is Present
	 Then Validate Terms and Conditions and Value
	 Then Validate is PoweredBy Logo present
	 Then Validate footer links text and link url
	 Then Click on Confirm Button
	 Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OMANTEL"
	 Then Validate the User Status "NOT_ACTIVE" using "OMANTEL_Check_Status_API" Check Status API


Scenario: Navigate the Portal and Delete all the Cookies Value
	 When Navigate to url "Page_Load_Url"
	 When Delete all domain Cookies Value

Scenario: User Subscribe flow With out MSISDN Header
	 When Navigate to url "OMANTEL_Subscribe_API_URL_CallBack"
	 Then Click on identify button "without" msisdn
	 Then Validate is Logo present
	 And  Validate is Banner present
	 Then Enter the MSISDN "8889000001"
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
	 Then Insert "0000" in OTP field
	 Then Click on Confirm Button
	 Then Validate User "NA" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
	 Then Validate User "NA" DM Log Details for Activity Type "104" from DIAUS DB "DIAUS_DB_URL"
	 Then Get the current domain Cookies value
     Then Validate is Logo present
	 And Validate is Banner present
	 Then Validate Subscribe thankyou messages and Status of User "8889000001"
	 Then Validate User "9688889000001" DM Log Details for Activity Type "106" from DIAUS DB "DIAUS_DB_URL"
	 Then Validate User "9688889000001" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
     Then Validate is PoweredBy Logo present
	 Then Validate footer links text and link url
     Then Click on Ok Button
     Then Validate Redirection url Parameter "u=XXXXXXXX&status=ACT_PENDING&opr=OMANTEL"

 
 Scenario: HIT IndetifyMe API and Identify the user status.
	 Then Activate or DeActivate the User "8889000001,omantel_oman_pack1,30,OMANTEL,ACT" using "Packs_CallBack_API" Packs Callback API
     When Navigate to url "Page_Load_Url"
	 When Navigate to url "OMANTEL_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OMANTEL"
     Then Validate the User Status "ACTIVE" using "OMANTEL_Check_Status_API" Check Status API


########   3G Flow  #########   
######## User Subscribe Flow######
Scenario: Delete the DB Record from Packs and DM log table.
	Then Delete the User "8889000012" records from Packs DB
	Then Delete "DIAUS_INDIA_DB" the Log Entry for User "9688889000012" form DM Log Table
	Then Delete "DIAUS_INDIA_DB" the Log Entry for User "NA" form DM Log Table
	
Scenario: Navigate the Page_Load_Url Delete all the Domain Cookie and  and Set the with MSISDN in Header
	When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
	Then Delete the User "8889000012" records from Packs DB
	Then Delete "DIAUS_INDIA_DB" the Log Entry for User "9688889000012" form DM Log Table

Scenario: HIT IndetifyMe API and Identify the user status.
	When Navigate to url "OMANTEL_IdentifyMe_API_URL"
	Then Click on identify button "with" msisdn
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OMANTEL"
    Then Validate the User Status "NOT_ACTIVE" using "OMANTEL_Check_Status_API" Check Status API


Scenario: User Subscribe flow via Data flow With MSISDN Header
	When Navigate to url "OMANTEL_Subscribe_API_URL_CallBack"
	Then Validate User "9688889000012" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is Logo present
	And Validate is Banner present
    Then Validate subscribed to the operator of your number
    Then Validate Pack Detials messages
	Then Validate Terms and Conditions and Value
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
	Then Get the current domain Cookies value	
	Then Click on Subscribe Button
	Then Validate is Logo present
	And Validate is Banner present
	Then Validate Re-Send OTP Text Link
	Then Validate Cancel and Corfirm Button is Present
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Insert "0000" in OTP field
    Then Click on Confirm Button
	Then Validate User "9688889000012" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
	Then Validate Subscribe thankyou messages and Status of User "8889000012"
	Then Validate User "9688889000012" DM Log Details for Activity Type "106" from DIAUS DB "DIAUS_DB_URL"
	Then Validate User "9688889000012" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
   	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
  	Then Click on Ok Button
  	Then Validate Redirection url Parameter "u=XXXXXXXX&status=ACT_PENDING&opr=OMANTEL"
  
  
 Scenario: Active the user using call back API and HIT IndetifyMe API and Identify the user status.
    Then Activate or DeActivate the User "8889000012,omantel_oman_pack1,30,OMANTEL,ACT" using "Packs_CallBack_API" Packs Callback API
    When Navigate to url "Page_Load_Url"
	When Navigate to url "OMANTEL_IdentifyMe_API_URL"
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OMANTEL"
    Then Validate the User Status "ACTIVE" using "OMANTEL_Check_Status_API" Check Status API
     
 Scenario: Close the Browser
    Then Close the browser