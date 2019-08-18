Feature: UnSubscribe Flow for ONMO Paywall 

Scenario: Launch the Browser
	Given Launch the browser

#########   3G Flow  #########   
######### User UnSubscribe Flow#####

Scenario: Navigate to Page_Load_Url Delete all the Domain Cookie
    When Navigate to url "Page_Load_Url"
    Then Delete all domain Cookies Value
    
Scenario: HIT IndetifyMe API and Identify the user status.
	When Navigate to url "OMANTEL_IdentifyMe_API_URL"
	Then Click on identify button "with" msisdn
	Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OMANTEL"
	Then Validate the User Status "ACTIVE" using "OMANTEL_Check_Status_API" Check Status API
     	
Scenario: User Unsubscribe flow With MSISDN in Header
    When Navigate to url "Page_Load_Url"
    When Navigate to url "OMANTEL_Unsubscribe_API_URL_CallBack"
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
    Then Validate User "8889000012" current Status in DB
    Then Click on Ok Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=XXXXXXXX&opr=OMANTEL"
     
 Scenario: Deactivate the user using call back API and HIT IndetifyMe API and Identify the user status.
     Then Activate or DeActivate the User "8889000012,omantel_oman_pack1,30,OMANTEL,DCT" using "Packs_CallBack_API" Packs Callback API
     When Navigate to url "OMANTEL_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OMANTEL"
     Then Validate the User Status "NOT_ACTIVE" using "OMANTEL_Check_Status_API" Check Status API
    

#######   Wifi Flow  #########   
####### User UnSubscribe Flow #####

Scenario: Activate the user using call back API before going to Deactivation flow.
     Then Activate or DeActivate the User "8898010013,omantel_oman_pack1,30,OMANTEL,ACT" using "Packs_CallBack_API" Packs Callback API

 Scenario: HIT IndetifyMe API and Identify the user status.
     When Navigate to url "Page_Load_Url"
     When Delete all domain Cookies Value
	 When Navigate to url "OMANTEL_IdentifyMe_API_URL"
	 Then Click on identify button "without" msisdn
	 Then Enter the MSISDN "8898010013"
	 Then Click on Confirm Button
     Then Get the OTP Value for MSISDN "8898010013" from DB and Enter the OTP
     Then Click on Confirm Button
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OMANTEL"
     Then Validate the User Status "ACTIVE" using "OMANTEL_Check_Status_API" Check Status API    

Scenario: Launch the Unsubscribe API url
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    When Navigate to url "OMANTEL_Unsubscribe_API_URL_CallBack"
    Then Click on identify button "without" msisdn

Scenario: User Unsubscribe flow via UIM Page(With out MSISDN Header)
    Then Validate is Logo present
	And  Validate is Banner present
	Then Enter the MSISDN "8898010013"
	Then Click on Confirm Button
	Then Validate is Logo present
	 And Validate is Banner present
	Then Validate Re-Send OTP Text Link
	Then Validate Cancel and Corfirm Button is Present
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Get the OTP Value for MSISDN "8898010013" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Get the current domain Cookies value
    Then Validate is Logo present
	 And Validate is Banner present
	Then Validate Cancel and Corfirm Button is Present	
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Click on Confirm Button
    Then Validate Unsubscribe user thankyou messages
    Then Validate User "8898010013" current Status in DB
    Then Click on Ok Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=XXXXXXXX&opr=OMANTEL"
 
  Scenario: Hit DCT callback. Hit IndetifyMe API and check the user status.
     Then Activate or DeActivate the User "8898010013,omantel_oman_pack1,30,OMANTEL,DCT" using "Packs_CallBack_API" Packs Callback API
     When Navigate to url "Page_Load_Url"
	 When Navigate to url "OMANTEL_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OMANTEL"
     Then Validate the User Status "NOT_ACTIVE" using "OMANTEL_Check_Status_API" Check Status API 
 	 
 Scenario: Close the Browser
    Then Close the browser
