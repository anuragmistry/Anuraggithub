Feature: UnSubscribe Flow for ONMO Paywall 

Scenario: Launch the Unsubscribe API url with (Default Pack Id) 
	Given Launch the browser
	Given Set the Headers with "MZVodacom" IP range
	 When Navigate to url "Unsubscribe_API_URL_CallBack"
	 
Scenario: User Unsubscribe flow via UIM Page(With out MSISDN Header)
    Then Validate is Logo present
	And  Validate is Banner present
	Then Enter the MSISDN "8877888661"
	Then Click on Confirm Button
	Then Validate is Logo present
	 And Validate is Banner present
	Then Validate Re-Send OTP Text Link
	Then Validate Cancel and Corfirm Button is Present
    Then Get the OTP Value for MSISDN "8877888661" from DB and Enter the OTP
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
    Then Validate User "8877888661" current Status in DB
    Then Click on Confirm Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=XXXXXXXX&opr=Vodacom"
    When Delete all domain Cookies Value
    

#Scenario: Launch the Unsubscribe API url with (Realtime pack Id)
#    When Navigate to url "Page_Load_Url"
#    When Delete all domain Cookies Value
#    When Navigate to url "Unsubscribe_API_URL_RealTime"
#	 
#Scenario: User Unsubscribe flow via UIM Page(With out MSISDN Header)
#    Then Validate is Logo present
#	And  Validate is Banner present
#	Then Enter the MSISDN "8888889999"
#	Then Click on Confirm Button
#	Then Validate is Logo present
#	 And Validate is Banner present
#	Then Validate Re-Send OTP Text Link
#	Then Validate Cancel and Corfirm Button is Present
#    Then Get the OTP Value for MSISDN "8888889999" from DB and Enter the OTP
#    Then Click on Confirm Button
#    Then Get the current domain Cookies value
#    Then Validate is Logo present
#	 And Validate is Banner present
#	Then Validate Unsubscribe messages
#	Then Validate Cancel and Corfirm Button is Present	
#    Then Click on Confirm Button
#    Then Validate Unsubscribe user thankyou messages
#    Then Validate User "8888889999" current Status in DB
#    Then Click on Confirm Button
#    Then Validate Redirection url Parameter "status=SUCCESS&u=XXXXXXXX&opr=Vodacom"
#    When Delete all domain Cookies Value
#
# Scenario: Launch the portal with Unsubscribe API
#    When Navigate to url "Page_Load_Url"
#    When Delete all domain Cookies Value
#    Then Delete the User "8111811121" records from Packs DB
#    Given Open New Tab and Set "x-msisdn" with Number "rrBZ9ieSYX8vvQ==" in Mod Header
#	When Navigate to url "Unsubscribe_API_URL_RealTime"
#	 
#Scenario: User Unsubscribe flow With MSISDN in Header
#    Then Validate is Logo present
#	And  Validate is Banner present
#	Then Get the current domain Cookies value
#    Then Validate is Logo present
#	 And Validate is Banner present
#	Then Validate Unsubscribe messages
#	Then Validate Cancel and Corfirm Button is Present	
#    Then Click on Confirm Button
#    Then Validate Unsubscribe user thankyou messages
#    Then Validate User "8111811121" current Status in DB
#    Then Click on Confirm Button
#    Then Validate Redirection url Parameter "u=YYY&status=SUCCESS&opr=Vodacom"   
#    
#Scenario: Close the Browser after complete feature
#    Then Quit the browser	 