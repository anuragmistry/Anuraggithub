Feature: Subscription Flow for ONMO Paywall 

Scenario: Launch the Browser then Add User Agent and Operator IP Range
	Given Launch the browser
    Given Set the Headers with "Airtel" IP range "125.24.47.108"
    
Scenario: Delete the DB Record fro Packs and DM log table.
	 Then Delete the User "8710001025" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "918710001025" form DM Log Table
	 			
Scenario: Navigate the Portal with Subscribe API with Real Time PackId.
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
	When Navigate to url "Airtel_Subscribe_API_URL_RealTime"
   
Scenario: User Subscribe flow via UIM Page(With out MSISDN Header)
#    Then Validate is Logo present
#	And  Validate is Banner present
#	Then Enter the MSISDN "8710001025"
#	Then Validate Subscribe messages
#	Then Validate Terms and Conditions and Value
#	Then Validate Cancel and Corfirm Button is Present
#	Then Validate is PoweredBy Logo present
#	Then Validate footer links text and link url
#	Then Click on Confirm Button
#	Then Validate is Logo present
#	 And Validate is Banner present
#	Then Validate Re-Send OTP Text Link
#	Then Validate Cancel and Corfirm Button is Present
#	Then Validate is PoweredBy Logo present
#	Then Validate footer links text and link url
#    Then Get the OTP Value for MSISDN "8710001025" from DB and Enter the OTP
#    Then Click on Confirm Button
#    Then Get the current domain Cookies value
#    Then Validate is Logo present
#	 And Validate is Banner present
#    Then Validate subscribed to the operator of your number
#    Then Validate Pack Detials messages
#    Then Validate Terms and Conditions and Value
#   #  Then Click on Terms and condition check box
#    Then Validate is PoweredBy Logo present
#	Then Validate footer links text and link url
#	Then Click on Subscribe Button

    Then Validate User "918710001025" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "918710001025" DM Log Details for Activity Type "103" from DIAUS DB "DIAUS_DB_URL"
    Then Click on Success Button in Airtel CG Page
    Then Validate Subscribe thankyou messages and Status of User "8871234567"
    Then Validate User "918710001025" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "918710001025" DM Log Details for Activity Type "53" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "918710001025" DM Log Details for Activity Type "55" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Click on Ok Button
    Then Validate Redirection url Parameter "u=XXXXXXXX&status=PENDING&opr=Airtel"
    Then Activate or DeActivate the User "8710001025,AIRTEL,30.00,Airtel,ACT" using "Packs_CallBack_API" Packs Callback API
 
# Scenario: HIT IndetifyMe API and Identify the user status.
#     When Navigate to url "Page_Load_Url"
#     When Delete all domain Cookies Value
#	 When Navigate to url "Airtel_IdentifyMe_API_URL"
#	 Then Enter the MSISDN "8710001025"
#	 Then Click on Confirm Button
#     Then Get the OTP Value for MSISDN "8710001025" from DB and Enter the OTP
#     Then Click on Confirm Button
#     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=Airtel"
#     Then Validate the User Status "PENDING" using "Airtel_Check_Status_API" Check Status API
#
#
#Scenario: Navigate the Portal with Subscribe API with Real Time PackId.
#    When Navigate to url "Page_Load_Url"
#    When Delete all domain Cookies Value
#	When Navigate to url "Airtel_Subscribe_API_URL_RealTime"
#	
#Scenario: Delete the DB Record fro Packs and DM log table.
#	 Then Delete the User "8710007773" records from Packs DB
#	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "918710007773" form DM Log Table
#	 	
#Scenario: User Subscribe flow for Real Time Pack via UIM Page(With out MSISDN Header)
#    Then Validate is Logo present
#	 And Validate is Banner present
#	Then Enter the MSISDN "8710007773"
#	Then Validate Subscribe messages
#	Then Validate Terms and Conditions and Value
#	Then Validate Cancel and Corfirm Button is Present
#	Then Validate is PoweredBy Logo present
#	Then Validate footer links text and link url
#	Then Click on Confirm Button
#	Then Validate is Logo present
#	 And Validate is Banner present
#	Then Validate Re-Send OTP Text Link
#	Then Validate Cancel and Corfirm Button is Present
#	Then Validate is PoweredBy Logo present
#	Then Validate footer links text and link url
#    Then Get the OTP Value for MSISDN "8710007773" from DB and Enter the OTP
#    Then Click on Confirm Button
#    Then Validate User "918710007773" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
#    Then Get the current domain Cookies value
#    Then Validate is Logo present
#	 And Validate is Banner present
#    Then Validate subscribed to the operator of your number
#    Then Validate Pack Detials messages
#    Then Validate Terms and Conditions and Value
#   #  Then Click on Terms and condition check box
#    Then Validate is PoweredBy Logo present
#	Then Validate footer links text and link url
#	Then Click on Subscribe Button
#    Then Validate Subscribe thankyou messages and Status of User "8710007773"
#    Then Validate User "918710007773" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
#    Then Validate User "918710007773" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
#    Then Validate User "918710007773" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
#    Then Validate is PoweredBy Logo present
#	Then Validate footer links text and link url
#    Then Click on Ok Button
#    Then Validate Redirection url Parameter "u=XXXXXXXX&status=ACTIVE&opr=Airtel"
#    When Delete all domain Cookies Value
# 
# Scenario: HIT IndetifyMe API and Identify the user status.
#     When Navigate to url "Page_Load_Url"
#	 When Navigate to url "Airtel_IdentifyMe_API_URL"
#     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=Airtel"
#     Then Validate the User Status "ACTIVE" using "Airtel_Check_Status_API" Check Status API   

##########3G Flow#################
#
#Scenario: Delete the DB Record fro Packs and DM log table.
#	 Then Delete the User "8719999992" records from Packs DB
#	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "918719999992" form DM Log Table
#	 
#Scenario: Navigate the subscribe API and Set the with MSISDN in Header
#    When Navigate to url "Page_Load_Url"
#    When Delete all domain Cookies Value
#    Given Open New Tab and Set "x-up-subno" with Number "918719999992" in Mod Header
#	When Navigate to url "Airtel_Subscribe_API_URL_CallBack"
#	Then Validate User "918719999992" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
#
#Scenario: User Subscribe flow via Data flow (With MSISDN Header)
#    Then Validate is Logo present
#	 And Validate is Banner present
#    Then Validate subscribed to the operator of your number
#    Then Validate Pack Detials messages
#	Then Validate Terms and Conditions and Value
#	Then Validate is PoweredBy Logo present
#	Then Validate footer links text and link url
#	Then Get the current domain Cookies value
#	Then Click on Subscribe Button
#	Then Validate User "918719999992" DM Log Details for Activity Type "103" from DIAUS DB "DIAUS_DB_URL"
#	Then Click on Yes Button in CG Page
#    Then Validate Subscribe thankyou messages and Status of User "8719999992"
#    Then Validate User "918719999992" DM Log Details for Activity Type "55" from DIAUS DB "DIAUS_DB_URL"
#    Then Validate User "918719999992" DM Log Details for Activity Type "53" from DIAUS DB "DIAUS_DB_URL"
#    Then Validate User "918719999992" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
#    Then Validate is PoweredBy Logo present
#	Then Validate footer links text and link url
#    Then Click on Ok Button
#    Then Validate Redirection url Parameter "u=XXXXXXXX&status=ACCEPTED&opr=Airtel"
#    When Delete all domain Cookies Value
# 
# Scenario: HIT IndetifyMe API and Identify the user status.
#     When Navigate to url "Page_Load_Url"
#     When Delete all domain Cookies Value
#	 When Navigate to url "Airtel_IdentifyMe_API_URL"
#     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=Airtel"
#     Then Validate the User Status "PENDING" using "Airtel_Check_Status_API" Check Status API 
#     
# Scenario: Open the New and Remove the Number from Mod Header
#     Given Open New Tab and remove the Number "918719999992" in Mod Header
     