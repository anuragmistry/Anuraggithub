Feature: Identify and Check Status Flow for ONMO Paywall 

#Scenario: Launch the Identify API url
#	Given Launch the browser
#	Given Set the Headers with "MZVodacom" IP range
#	Given Set MSISDN "rrBZ9ieSYX8vvQ==" in Header
#	 When Navigate to url "Identify_API_URL"
#	 Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=Vodacom"
#     Then Validate the Check Status API 


Scenario: Launch the Identify API url with UIM Flow
     Given Launch the browser
	 Given Set the Headers with "MZVodacom" IP range
	  When Navigate to url "Identify_API_URL"	 
	 Then Validate is Logo present
	  And Validate is Banner present
	 Then Enter the MSISDN "8877669999"
	 Then Click on Confirm Button
	 Then Validate is Logo present
	 And Validate is Banner present
	 Then Validate Re-Send OTP Text Link
	 Then Validate Cancel and Corfirm Button is Present
     Then Get the OTP Value for MSISDN "8877669999" from DB and Enter the OTP
     Then Click on Confirm Button
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=Vodacom"
     Then Validate the Check Status API