Feature: UnSubscribe Flow for ONMO Paywall 

#Scenario: Launch the Unsubscribe API url with (Default Pack Id) 
#	Given Launch the browser
#	Given Set the Headers with "" IP range
#	 When Navigate to url "Globacom_Unsubscribe_API_URL_CallBack" 
Scenario: Navigate the Portal with UnSubscribe API (Default Pack Id).
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
	When Navigate to url "Vodafone_Unsubscribe_API_URL_CallBack"
		 
Scenario: User Unsubscribe flow via UIM Page(With out MSISDN Header)
    Then Validate is Logo present
	And  Validate is Banner present
	Then Enter the MSISDN "9110001112"
	Then Click on Confirm Button
	Then Validate is Logo present
	 And Validate is Banner present
	Then Validate Re-Send OTP Text Link
	Then Validate Cancel and Corfirm Button is Present
    Then Get the OTP Value for MSISDN "9110001112" from DB and Enter the OTP
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
    Then Validate User "9110001112" current Status in DB
    Then Click on Confirm Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=XXXXXXXX&opr=Vodafone"
    When Delete all domain Cookies Value
    

Scenario: Launch the Unsubscribe API url with (Realtime pack Id)
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    When Navigate to url "Vodafone_Unsubscribe_API_URL_RealTime"
	 
Scenario: User Unsubscribe flow via UIM Page(With out MSISDN Header)
    Then Validate is Logo present
	And  Validate is Banner present
	Then Enter the MSISDN "9110001113"
	Then Click on Confirm Button
	Then Validate is Logo present
	 And Validate is Banner present
	Then Validate Re-Send OTP Text Link
	Then Validate Cancel and Corfirm Button is Present
    Then Get the OTP Value for MSISDN "9110001113" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Get the current domain Cookies value
    Then Validate is Logo present
	 And Validate is Banner present
	Then Validate Unsubscribe messages
	Then Validate Cancel and Corfirm Button is Present	
    Then Click on Confirm Button
    Then Validate Unsubscribe user thankyou messages
    Then Validate User "9110001113" current Status in DB
    Then Click on Confirm Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=XXXXXXXX&opr=Vodafone"
    When Delete all domain Cookies Value

#Scenario: Close the Browser after complete feature
#    Then Quit the browser	 