Feature: UnSubscribe Flow for OnmoPay - Bangladesh ROBI

Scenario: Launch the Browser then Add User Agent and Operator IP Range
	Given Launch the browser
  Given Set the Headers with "ROBI" IP range "23.92.73.0"

#########   3G Flow  #########   
######### User UnSubscribe Flow#####

Scenario: Navigate to Page_Load_Url Delete all the Domain Cookie and Set the  MSISDN in Header
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
	Given Open New Tab and Set "x-up-subno" with Number "8809998000013" in Mod Header

Scenario: HIT IndetifyMe API and Identify the user status.
	 When Navigate to url "ROBI_IdentifyMe_API_URL"
   Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=ROBI"
   Then Activate or DeActivate the User "9998000013,ROBI_MAIN_1,50,ROBI,ACT" using "Packs_CallBack_API" Packs Callback API
   Then Validate the User Status "ACTIVE" using "ROBI_Check_Status_API" Check Status API
     	
Scenario: User Unsubscribe flow With MSISDN in Header
    When Navigate to url "Page_Load_Url"
    When Navigate to url "ROBI_Unsubscribe_API_URL_CallBack"
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
    Then Validate User "9998000013" current Status in DB
    Then Click on Ok Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=XXXXXXXX&opr=ROBI"
     
 Scenario: Deactivate the user using call back API and HIT IndetifyMe API and Identify the user status.
     Then Activate or DeActivate the User "9998000013,ROBI_MAIN_1,50,ROBI,DCT" using "Packs_CallBack_API" Packs Callback API
     When Navigate to url "ROBI_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=ROBI"
     Then Validate the User Status "NOT_ACTIVE" using "ROBI_Check_Status_API" Check Status API
    
 Scenario: Open the New and Remove the Number from Mod Header
     Given Open New Tab and remove the Number "8809998000013" in Mod Header 


#######   Wifi Flow  #########   
####### User UnSubscribe Flow #####

Scenario: Activate the user using call back API before going to Deactivation flow.
     Then Activate or DeActivate the User "9998000013,ROBI_MAIN_1,50,ROBI,ACT" using "Packs_CallBack_API" Packs Callback API

 Scenario: HIT IndetifyMe API and Identify the user status.
     When Navigate to url "Page_Load_Url"
     When Delete all domain Cookies Value
	 When Navigate to url "ROBI_IdentifyMe_API_URL"
	 Then Enter the MSISDN "9998000013"
	 Then Click on Confirm Button
     Then Get the OTP Value for MSISDN "9998000013" from DB and Enter the OTP
     Then Click on Confirm Button
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=ROBI"
     Then Validate the User Status "ACTIVE" using "ROBI_Check_Status_API" Check Status API    

Scenario: Launch the Unsubscribe API url
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    When Navigate to url "ROBI_Unsubscribe_API_URL_CallBack"

Scenario: User Unsubscribe flow via UIM Page(With out MSISDN Header)
    Then Validate is Logo present
	And  Validate is Banner present
	Then Enter the MSISDN "9998000013"
	Then Click on Confirm Button
	Then Validate is Logo present
	 And Validate is Banner present
	Then Validate Re-Send OTP Text Link
	Then Validate Cancel and Corfirm Button is Present
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Get the OTP Value for MSISDN "9998000013" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Get the current domain Cookies value
    Then Validate is Logo present
	 And Validate is Banner present
	Then Validate Cancel and Corfirm Button is Present	
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Click on Confirm Button
    Then Validate Unsubscribe user thankyou messages
    Then Validate User "9998000013" current Status in DB
    Then Click on Ok Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=XXXXXXXX&opr=ROBI"
 
  Scenario: Hit DCT callback. Hit IndetifyMe API and check the user status.
     Then Activate or DeActivate the User "9998000013,ROBI_MAIN_1,50,ROBI,DCT" using "Packs_CallBack_API" Packs Callback API
     When Navigate to url "Page_Load_Url"
	 When Navigate to url "ROBI_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=ROBI"
     Then Validate the User Status "NOT_ACTIVE" using "ROBI_Check_Status_API" Check Status API 
 	 
 Scenario: Close the Browser
    Then Close the browser
