Feature: UnSubscribe Flow for ONMO Paywall 

Scenario: Launch the Browser then Add User Agent and Operator IP Range
Given Launch the browser
Given Set the Headers with "SAFARICOM" IP range "41.223.113.168"

 #######   3G Flow  #########   
#### User UnSubscribe Flow######  
Scenario: Navigate the Page_Load_Url Delete all the Domain Cookie and  and Set the with MSISDN in Header
   When Navigate to url "Page_Load_Url"
   When Delete all domain Cookies Value
	Given Open New Tab and Set "x-up-subno" with Number "2547050002222" in Mod Header
	Then Activate or DeActivate the User "7050002222,SAFARI_MAIN_1,30.00,SAFARICOM,ACT" using "Packs_CallBack_API" Packs Callback API
	
  Scenario: HIT IndetifyMe API and Identify the user status.
     When Navigate to url "SAFARICOM_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=SAFARICOM"
     Then Validate the User Status "ACTIVE" using "SAFARICOM_Check_Status_API" Check Status API
     	
Scenario: User Unsubscribe flow With MSISDN in Header
    When Navigate to url "Page_Load_Url"
    When Navigate to url "SAFARICOM_Unsubscribe_API_URL_CallBack"
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
    Then Validate User "7050002222" current Status in DB
    Then Click on Ok Button
  Then Validate Redirection url Parameter "status=SUCCESS&u=XXXXXXXX&opr=SAFARICOM"
     
 Scenario: DeActive the user using call back API and HIT IndetifyMe API and Identify the user status.
     Then Activate or DeActivate the User "7050002222,SAFARI_MAIN_1,30.00,SAFARICOM,DCT" using "Packs_CallBack_API" Packs Callback API
     When Navigate to url "Page_Load_Url"
     When Delete all domain Cookies Value
		 When Navigate to url "SAFARICOM_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=SAFARICOM"
     Then Validate the User Status "NOT_ACTIVE" using "SAFARICOM_Check_Status_API" Check Status API
    
 Scenario: Open the New and Remove the Number from Mod Header
    	Given Open New Tab and remove entry "3" in Mod Header
 
 
 #######   Wifi Flow  #########   
#### User UnSubscribe Flow######   
 Scenario: HIT IndetifyMe API and Identify the user status.
     Then Activate or DeActivate the User "7050002221,SAFARI_MAIN_1,30.00,SAFARICOM,ACT" using "Packs_CallBack_API" Packs Callback API
     When Navigate to url "Page_Load_Url"
     When Delete all domain Cookies Value
     When Navigate to url "SAFARICOM_IdentifyMe_API_URL"
	 Then Enter the MSISDN "7050002221"
	 Then Click on Confirm Button
     
#     Then Get the OTP Value for MSISDN "7050002221" from DB and Enter the OTP
#     Then Click on Confirm Button
     
     #Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=SAFARICOM"
     Then Validate Redirection url Parameter "status=ACTIVE&u=xxxxxxxxx&opr=SAFARICOM"
     Then Validate the User Status "ACTIVE" using "SAFARICOM_Check_Status_API" Check Status API    

Scenario: Launch the Unsubscribe API url with (Realtime pack Id)
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    When Navigate to url "SAFARICOM_Unsubscribe_API_URL_CallBack"
	 
Scenario: User Unsubscribe flow via UIM Page(With out MSISDN Header)
    Then Validate is Logo present
	And  Validate is Banner present
	Then Enter the MSISDN "7050002221"
	Then Click on Confirm Button
	
#	Then Validate is Logo present
#	 And Validate is Banner present
#	Then Validate Re-Send OTP Text Link
#	Then Validate Cancel and Corfirm Button is Present
#	Then Validate is PoweredBy Logo present
#	Then Validate footer links text and link url
#    Then Get the OTP Value for MSISDN "7050002221" from DB and Enter the OTP
#    Then Click on Confirm Button
   
    Then Get the current domain Cookies value
    Then Validate is Logo present
	 And Validate is Banner present
	Then Validate Cancel and Corfirm Button is Present	
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Click on Confirm Button
    Then Validate Unsubscribe user thankyou messages
    Then Validate User "7050002221" current Status in DB
    Then Click on Ok Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=XXXXXXXX&opr=SAFARICOM"
 
  Scenario: DeActive the user using call back API and HIT IndetifyMe API and Identify the user status.
     Then Activate or DeActivate the User "7050002221,SAFARI_MAIN_1,30.00,SAFARICOM,DCT" using "Packs_CallBack_API" Packs Callback API
  	  When Navigate to url "Page_Load_Url"
	 		When Navigate to url "SAFARICOM_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=SAFARICOM"
     Then Validate the User Status "NOT_ACTIVE" using "SAFARICOM_Check_Status_API" Check Status API
 
  Scenario: Close the Browser
    # Then Close the browser
    Then Quit the browser