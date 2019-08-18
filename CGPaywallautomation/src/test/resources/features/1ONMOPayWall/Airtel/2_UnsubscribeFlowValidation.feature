Feature: UnSubscribe Flow for ONMO Paywall 

Scenario: Navigate the Portal with UnSubscribe API (Default Pack Id).
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
	When Navigate to url "Airtel_Unsubscribe_API_URL_CallBack"
		 
Scenario: User Unsubscribe flow via UIM Page(With out MSISDN Header)
    Then Validate is Logo present
	And  Validate is Banner present
	Then Enter the MSISDN "8710001025"
	Then Click on Confirm Button
	Then Validate is Logo present
	 And Validate is Banner present
	Then Validate Re-Send OTP Text Link
	Then Validate Cancel and Corfirm Button is Present
    Then Get the OTP Value for MSISDN "8710001025" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Get the current domain Cookies value
    Then Validate is Logo present
	 And Validate is Banner present
	Then Validate Unsubscribe messages
	Then Validate Cancel and Corfirm Button is Present	
    Then Click on Confirm Button
    Then Validate is Logo present
	 And Validate is Banner present
    Then Validate Unsubscribe user thankyou messages
    Then Validate User "8710001025" current Status in DB
    Then Click on Confirm Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=XXXXXXXX&opr=Airtel"


 Scenario: HIT IndetifyMe API and Identify the user status.
     When Navigate to url "Page_Load_Url"
	 When Navigate to url "Airtel_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=Airtel"
     Then Validate the User Status "NOT_ACTIVE" using "Airtel_Check_Status_API" Check Status API
    
    
Scenario: Launch the Unsubscribe API url with (Realtime pack Id)
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    When Navigate to url "Airtel_Unsubscribe_API_URL_RealTime"
	 
Scenario: User Unsubscribe flow via UIM Page(With out MSISDN Header)
    Then Validate is Logo present
	And  Validate is Banner present
	Then Enter the MSISDN "8710001130"
	Then Click on Confirm Button
	Then Validate is Logo present
	 And Validate is Banner present
	Then Validate Re-Send OTP Text Link
	Then Validate Cancel and Corfirm Button is Present
    Then Get the OTP Value for MSISDN "8710001130" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Get the current domain Cookies value
    Then Validate is Logo present
	 And Validate is Banner present
	Then Validate Unsubscribe messages
	Then Validate Cancel and Corfirm Button is Present	
    Then Click on Confirm Button
    Then Validate Unsubscribe user thankyou messages
    Then Validate User "8710001130" current Status in DB
    Then Click on Confirm Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=XXXXXXXX&opr=Airtel"
    When Delete all domain Cookies Value

    
