Feature: Identify and Check Status Flow for ONMO Paywall 

Scenario: Navigate the Portal with IdentifyMe API.
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
	When Navigate to url "Vodafone_IdentifyMe_API_URL"
	
Scenario: Validate the Identify API url with UIM Flow	 
	 Then Validate is Logo present
	  And Validate is Banner present
	 Then Enter the MSISDN "9877669999"
	 Then Click on Confirm Button
	 Then Validate is Logo present
	 And Validate is Banner present
	 Then Validate Re-Send OTP Text Link
	 Then Validate Cancel and Corfirm Button is Present
     Then Get the OTP Value for MSISDN "9877669999" from DB and Enter the OTP
     Then Click on Confirm Button
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=Vodafone"
     Then Validate the Check Status API
     
  