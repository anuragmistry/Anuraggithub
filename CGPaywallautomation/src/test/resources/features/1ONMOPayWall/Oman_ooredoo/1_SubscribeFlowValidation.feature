Feature: Subscription Flow for ONMO Paywall 

Scenario: Launch the Browser then Add User Agent and Operator IP Range
	Given Launch the browser
    Given Set the Headers with "OmanOoredoo" IP range "5.1.46.255"

########   Wifi Flow  #########   
##### User Subscribe Flow######      
Scenario: Delete the DB Record fro Packs and DM log table.
	 Then Delete the User "9000001111" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "9689000001111" form DM Log Table
	 	
Scenario: HIT IndetifyMe API and Identify the user status.
	 When Navigate to url "OmanOoredoo_IdentifyMe_API_URL"
	 Then Validate is Logo present
	  And Validate is Banner present
	 Then Enter the MSISDN "9000001111"
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
     Then Get the OTP Value for MSISDN "9000001111" from DB and Enter the OTP
     Then Click on Confirm Button
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OOREDOO"
     Then Validate the User Status "NOT_ACTIVE" using "OmanOoredoo_Check_Status_API" Check Status API
		
Scenario: Navigate the Portal and Delete all the Cookies Value
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value

Scenario: User Subscribe flow With out MSISDN Header
    When Navigate to url "OmanOoredoo_Subscribe_API_URL_CallBack"
    Then Validate is Logo present
	And  Validate is Banner present
	Then Enter the MSISDN "9000001111"
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
    Then Get the OTP Value for MSISDN "9000001111" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Validate User "9689000001111" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Get the current domain Cookies value
	Then Click on Subscribe Button in CG Page
	Then Validate User "9689000001111" DM Log Details for Activity Type "103" from DIAUS DB "DIAUS_DB_URL"
    Then Validate Subscribe thankyou messages and Status of User "9000001111"
    Then Validate User "9689000001111" DM Log Details for Activity Type "55" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "9689000001111" DM Log Details for Activity Type "53" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "9689000001111" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Click on Ok Button
    When Delete all domain Cookies Value
 
 Scenario: HIT IndetifyMe API and Identify the user status.
     Then Activate or DeActivate the User "9000001111,OMAN_PACK_1,50.00,Ooredoo,ACT" using "Packs_CallBack_API" Packs Callback API
     When Navigate to url "Page_Load_Url"
     When Delete all domain Cookies Value
	 When Navigate to url "OmanOoredoo_IdentifyMe_API_URL"
	 Then Enter the MSISDN "9000001111"
	 Then Click on Confirm Button
     Then Get the OTP Value for MSISDN "9000001111" from DB and Enter the OTP
     Then Click on Confirm Button
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OOREDOO"
     Then Validate the User Status "ACTIVE" using "OmanOoredoo_Check_Status_API" Check Status API

########   Wifi Flow  #########   
##### User Subscribe Flow(Pass Pack Id in Url)######   
Scenario: Delete the DB Record fro Packs and DM log table.
	 Then Delete the User "9000006666" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "9689000006666" form DM Log Table
	 
Scenario: Navigate the Portal and Delete all the Cookies Value
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    	 	
Scenario: HIT IndetifyMe API and Identify the user status.
	 When Navigate to url "OmanOoredoo_IdentifyMe_API_URL"
	 Then Validate is Logo present
	  And Validate is Banner present
	 Then Enter the MSISDN "9000006666"
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
     Then Get the OTP Value for MSISDN "9000006666" from DB and Enter the OTP
     Then Click on Confirm Button
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OOREDOO"
     Then Validate the User Status "NOT_ACTIVE" using "OmanOoredoo_Check_Status_API" Check Status API
		
Scenario: Navigate the Portal and Delete all the Cookies Value
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value

Scenario: User Subscribe flow With out MSISDN Header
    When Navigate to url "OmanOoredoo_Subscribe_API_URL_CallBack_WithPackId"
    Then Validate is Logo present
	And  Validate is Banner present
	Then Enter the MSISDN "9000006666"
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
    Then Get the OTP Value for MSISDN "9000006666" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Validate User "9689000006666" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Get the current domain Cookies value
	Then Click on Subscribe Button in CG Page
	Then Validate User "9689000006666" DM Log Details for Activity Type "103" from DIAUS DB "DIAUS_DB_URL"
    Then Validate Subscribe thankyou messages and Status of User "9000006666"
    Then Validate User "9689000006666" DM Log Details for Activity Type "55" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "9689000006666" DM Log Details for Activity Type "53" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "9689000006666" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Click on Ok Button
    When Delete all domain Cookies Value
 
 Scenario: HIT IndetifyMe API and Identify the user status.
     Then Activate or DeActivate the User "9000006666,OMAN_PACK_2,50.00,Ooredoo,ACT" using "Packs_CallBack_API" Packs Callback API
     When Navigate to url "Page_Load_Url"
     When Delete all domain Cookies Value
	 When Navigate to url "OmanOoredoo_IdentifyMe_API_URL"
	 Then Enter the MSISDN "9000006666"
	 Then Click on Confirm Button
     Then Get the OTP Value for MSISDN "9000006666" from DB and Enter the OTP
     Then Click on Confirm Button
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OOREDOO"
     Then Validate the User Status "ACTIVE" using "OmanOoredoo_Check_Status_API" Check Status API



#######   DM Flow  #########   
#### User Subscribe Flow###### 
Scenario: Delete the DB Record fro Packs and DM log table.
	 Then Delete the User "9000009999" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "9689000009999" form DM Log Table
	 
Scenario: Navigate the Portal and Delete all the Cookies Value
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    	 	
Scenario: HIT IndetifyMe API and Identify the user status.
	 When Navigate to url "OmanOoredoo_IdentifyMe_API_URL"
	 Then Validate is Logo present
	  And Validate is Banner present
	 Then Enter the MSISDN "9000009999"
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
     Then Get the OTP Value for MSISDN "9000009999" from DB and Enter the OTP
     Then Click on Confirm Button
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OOREDOO"
     Then Validate the User Status "NOT_ACTIVE" using "OmanOoredoo_Check_Status_API" Check Status API
		
Scenario: Navigate the Portal and Delete all the Cookies Value
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value

Scenario: User Subscribe flow With out MSISDN Header
    When Navigate to url "Oman_Subscribe_DM_URL"
    Then Validate is Logo present
	And  Validate is Banner present
	Then Enter the MSISDN "9000009999"
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
    Then Get the OTP Value for MSISDN "9000009999" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Validate User "9689000009999" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Get the current domain Cookies value
	Then Click on Subscribe Button in CG Page
	Then Validate User "9689000009999" DM Log Details for Activity Type "103" from DIAUS DB "DIAUS_DB_URL"
    Then Validate Subscribe thankyou messages and Status of User "9000009999"
    Then Validate User "9689000009999" DM Log Details for Activity Type "55" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "9689000009999" DM Log Details for Activity Type "53" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "9689000009999" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Click on Ok Button
    When Delete all domain Cookies Value
 
 Scenario: HIT IndetifyMe API and Identify the user status.
     Then Activate or DeActivate the User "9000009999,OMAN_PACK_1,50.00,Ooredoo,ACT" using "Packs_CallBack_API" Packs Callback API
     Then Validate DM task information after redirect with callBack url
     When Navigate to url "Page_Load_Url"
     When Delete all domain Cookies Value
	 When Navigate to url "OmanOoredoo_IdentifyMe_API_URL"
	 Then Enter the MSISDN "9000009999"
	 Then Click on Confirm Button
     Then Get the OTP Value for MSISDN "9000009999" from DB and Enter the OTP
     Then Click on Confirm Button
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OOREDOO"
     Then Validate the User Status "ACTIVE" using "OmanOoredoo_Check_Status_API" Check Status API
  
      