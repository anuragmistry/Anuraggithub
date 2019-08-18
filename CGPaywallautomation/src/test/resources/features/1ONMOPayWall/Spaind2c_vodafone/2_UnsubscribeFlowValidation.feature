Feature: UnSubscribe Flow for ONMO Paywall 

#Scenario: Launch the Browser then Add User Agent and Operator IP Range
#	Given Launch the browser
#    Given Set the Headers with "Safaricom" IP range "41.223.113.168"

 #######   Wifi Flow  #########   
#### User UnSubscribe Flow######   
 Scenario: HIT IndetifyMe API and Identify the user status.
     When Navigate to url "Page_Load_Url"
     When Delete all domain Cookies Value
	 When Navigate to url "OmanOoredoo_IdentifyMe_API_URL"
	 Then Enter the MSISDN "9000001111"
	 Then Click on Confirm Button
     Then Get the OTP Value for MSISDN "9000001111" from DB and Enter the OTP
     Then Click on Confirm Button
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OOREDOO"
     Then Validate the User Status "ACTIVE" using "OmanOoredoo_Check_Status_API" Check Status API    

Scenario: Launch the Unsubscribe API url Default packId
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    When Navigate to url "OmanOoredoo_Unsubscribe_API_URL_CallBack"
	 
Scenario: User Unsubscribe flow via UIM Page(With out MSISDN Header)
    Then Validate is Logo present
	And  Validate is Banner present
	Then Enter the MSISDN "9000001111"
	Then Click on Confirm Button
	Then Validate is Logo present
	 And Validate is Banner present
	Then Validate Re-Send OTP Text Link
	Then Validate Cancel and Corfirm Button is Present
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Get the OTP Value for MSISDN "9000001111" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Get the current domain Cookies value
    Then Validate is Logo present
	 And Validate is Banner present
	Then Validate Cancel and Corfirm Button is Present	
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Click on Confirm Button
    Then Validate Unsubscribe user thankyou messages
    Then Validate User "9000001111" current Status in DB
    Then Click on Ok Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=XXXXXXXX&opr=OOREDOO"
 
  Scenario: HIT IndetifyMe API and Identify the user status.
     Then Activate or DeActivate the User "9000001111,OMAN_PACK_1,50.00,Ooredoo,DCT" using "Packs_CallBack_API" Packs Callback API
     When Navigate to url "Page_Load_Url"
	 When Navigate to url "OmanOoredoo_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OOREDOO"
     Then Validate the User Status "NOT_ACTIVE" using "OmanOoredoo_Check_Status_API" Check Status API
     Then Validate User "9689000001111" DM Log Details for Activity Type "99" from DIAUS DB "DIAUS_DB_URL"

 #######   Wifi Flow  #########   
#### User UnSubscribe Flow######      
Scenario: Launch the Unsubscribe API url with CallBack PackId
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    When Navigate to url "OmanOoredoo_Unsubscribe_API_URL_CallBack_WithPackId"     
 
   Scenario: User Unsubscribe flow via UIM Page(With out MSISDN Header)
    Then Validate is Logo present
	And  Validate is Banner present
	Then Enter the MSISDN "9000006666"
	Then Click on Confirm Button
	Then Validate is Logo present
	 And Validate is Banner present
	Then Validate Re-Send OTP Text Link
	Then Validate Cancel and Corfirm Button is Present
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Get the OTP Value for MSISDN "9000006666" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Get the current domain Cookies value
    Then Validate is Logo present
	 And Validate is Banner present
	Then Validate Cancel and Corfirm Button is Present	
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Click on Confirm Button
    Then Validate Unsubscribe user thankyou messages
    Then Validate User "9000006666" current Status in DB
    Then Click on Ok Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=XXXXXXXX&opr=OOREDOO"
 
  Scenario: HIT IndetifyMe API and Identify the user status.
     Then Activate or DeActivate the User "9000006666,OMAN_PACK_2,50.00,Ooredoo,DCT" using "Packs_CallBack_API" Packs Callback API
     When Navigate to url "Page_Load_Url"
	 When Navigate to url "OmanOoredoo_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OOREDOO"
     Then Validate the User Status "NOT_ACTIVE" using "OmanOoredoo_Check_Status_API" Check Status API
     Then Validate User "9689000006666" DM Log Details for Activity Type "99" from DIAUS DB "DIAUS_DB_URL"
     