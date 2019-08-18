Feature: Subscription CG Flow

Scenario: Subscribiption CG flow without header with DM
###########CG Flow#######
	Given Launch the browser
	Given Set the Headers with "Vodafone" IP range
	When Navigate to url "DM_URL"

Scenario: User Subscribe CG flow via UIM Page(With out MSISDN Header) with DM
    Then Click on Banner "cg-paywall-auto" Link in AD2C url
    Then Validate is Logo present
	And  Validate is Banner present
#	Then Select the "Vodafone" Operator Name
#	Then Click on Confirm Button
	Then Enter the MSISDN "9775555446"
	Then Click on Confirm Button
	Then Validate is Logo present
	And  Validate is Banner present
	Then Validate Re-Send OTP Text Link
	Then Validate Cancel and Corfirm Button is Present
	Then Get the OTP Value for MSISDN "9775555446" from DB and Enter the OTP
	Then Click on Confirm Button
	Then Get the current domain Cookies value
	Then Validate is Logo present
	And Validate is Banner present
	Then Click on Terms and condition check box
	Then Click on Confirm Button
	Then Click on CG YES Button
	Then Validate Subscribe thankyou messages and Status of User "9775555446"
	Then Click on Confirm Button
	Then Validate Redirection url Parameter "u=XXXXXXXX&status=PENDING&opr=Vodafone"
    
Scenario: Susbcription CG flow with header with DM
	When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    Given Open New Tab and Set "x-msisdn" with Number "9637381921" in Mod Header
    When Navigate to url "DM_URL"
	Then Click on Banner "cg-paywall-auto" Link in AD2C url
    Then Validate is Logo present
	And  Validate is Banner present
	Then Click on Confirm Button
	Then Get the current domain Cookies value
	Then Validate is Logo present
	And Validate is Banner present
	Then Click on Terms and condition check box
	Then Click on Confirm Button
	Then Click on CG YES Button
	Then Validate Subscribe thankyou messages and Status of User "9775555446"
	Then Click on Confirm Button
	Then Validate Redirection url Parameter "u=XXXXXXXX&status=PENDING&opr=Vodafone"
	
	
	