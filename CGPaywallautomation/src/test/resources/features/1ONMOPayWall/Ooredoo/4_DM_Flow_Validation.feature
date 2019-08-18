Feature: DM Flow for ONMO Paywall

#Scenario: Launch the portal with DM URL
#    Given Launch the browser
#	Given Set the Headers with "MZVodacom" IP range
#	When Navigate to url "DM_URL"
#	
#Scenario: User DM flow via UIM Page(With out MSISDN Header)
#   Then Click on Banner "cg-paywall-auto" Link in AD2C url
#    Then Validate is Logo present
#	And  Validate is Banner present
#	Then Validate DM task information from DIAUS DB
#	Then Enter the MSISDN "9999999933"
#	Then Click on Confirm Button
#	Then Validate is Logo present
#	 And Validate is Banner present
#	Then Validate Re-Send OTP Text Link
#	Then Validate Cancel and Corfirm Button is Present
#    Then Get the OTP Value for MSISDN "9999999933" from DB and Enter the OTP
#    Then Click on Confirm Button
#    Then Validate "DIAUS_INDIA_DB" User "9999999933" DM Log details with Action "Landing_Subscription_Page" for DM Subscription flow
#    Then Get the current domain Cookies value
#    Then Validate is Logo present
#	 And Validate is Banner present
#    Then Validate subscribed to the operator of your number
#    Then Validate Pack Detials messages
#    Then Click on Terms and condition check box
#    Then Click on Confirm Button
#    Then Validate Subscribe thankyou messages and Status of User "9999999933"
#    Then Validate "DIAUS_INDIA_DB" User "9999999933" DM Log details with Action "Click_Subscription_Successfully" for DM Subscription flow
#    Then Validate DM task information after redirect with callBack url
#    Then Click on Confirm Button
#    Then Waiting for few sec....
#    Then Validate "DIAUS_INDIA_DB" User "9999999933" DM Log details with Action "Landing_Confirmation_Page" for DM Subscription flow

# Scenario: Close the Browser after complete feature
#    Then Close the browser    
#
#
Scenario: Launch the portal with DM URL
    Given Launch the browser
	Given Set the Headers with "MZVodacom" IP range
	When Navigate to url "DM_url"
	
Scenario: User DM flow via UIM Page(With out MSISDN Header)
    Then Validate is Logo present
	And  Validate is Banner present
	Then Validate DM task information from DIAUS DB
	Then Enter the MSISDN "7999999991"
	Then Click on Confirm Button
	Then Validate is Logo present
	 And Validate is Banner present
	Then Validate Re-Send OTP Text Link
	Then Validate Cancel and Corfirm Button is Present
    Then Get the OTP Value for MSISDN "7999999991" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Get the current domain Cookies value
    Then Validate is Logo present
	 And Validate is Banner present
 #   Then Validate subscribed to the operator of your number
 #   Then Validate Pack Detials messages
 #   Then Click on Terms and condition check box
    Then Click on Ok Button
    Then Validate Subscribe thankyou messages and Status of User "7999999991"
    Then Validate DM task information after redirect with callBack url
    Then Click on Confirm Button
    
# Scenario: Close the Browser after complete feature
#    Then Close the browser    
#    
#Scenario: Launch the portal with DM URL(with callBack pack)
#	Given Launch the browser
#	Given Set the Headers with "MZVodacom" IP range
#	When Navigate to url "DM_url_callBack_Pack"
#	
#Scenario: User DM flow via UIM Page(With out MSISDN Header)
#    Then Validate is Logo present
#	And  Validate is Banner present
#	Then Validate DM task information from DIAUS DB
#	Then Enter the MSISDN "7788669999"
#	Then Click on Confirm Button
#	Then Validate is Logo present
#	 And Validate is Banner present
#	Then Validate Re-Send OTP Text Link
#	Then Validate Cancel and Corfirm Button is Present
#    Then Get the OTP Value for MSISDN "7788669999" from DB and Enter the OTP
#    Then Click on Confirm Button
#    Then Get the current domain Cookies value
#    Then Validate is Logo present
#	 And Validate is Banner present
#    Then Validate subscribed to the operator of your number
# #   Then Click on Terms and condition check box
#    Then Click on Confirm Button
#    Then Validate Subscribe thankyou messages and Status of User "7788669999"
#  #  Then Validate DM task information after redirect with callBack url
#    Then Click on Confirm Button    
    
    