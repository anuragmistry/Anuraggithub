Feature: Subscription Flow for ONMO Paywall 

Scenario: Launch the portal with subscribe API with default callBack pack.
	Given Launch the browser
	Given Set the Headers with "MZVodacom" IP range
	When Navigate to url "Subscribe_API_URL_CallBack"

Scenario: User Subscribe flow via UIM Page(With out MSISDN Header)
    Then Delete the User "7059997771" records from Packs DB
    Then Validate is Logo present
	And  Validate is Banner present
	Then Enter the MSISDN "7059997771"
	Then Validate Subscribe messages
	Then Click on Confirm Button
	Then Validate is Logo present
	 And  Validate is Banner present
	Then Validate Re-Send OTP Text Link
	Then Validate Cancel and Corfirm Button is Present
    Then Get the OTP Value for MSISDN "7059997771" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Get the current domain Cookies value
    Then Validate is Logo present
	 And Validate is Banner present
 #   Then Validate subscribed to the operator of your number
   #  Then Click on Terms and condition check box
  # Then Click on Confirm Button
    Then Validate Subscribe thankyou messages and Status of User "7059997771"
    Then Click on Ok Button
    Then Validate Redirection url Parameter "u=XXXXXXXX&status=PENDING&opr=Safaricom"
    When Delete all domain Cookies Value
 
#Scenario: Launch the Portal with Subscribe API with Real Time PackId.
#    When Navigate to url "Page_Load_Url"
#    When Delete all domain Cookies Value
#	When Navigate to url "Subscribe_API_URL_RealTime"
#	
#Scenario: User Subscribe flow for Real Time Pack via UIM Page(With out MSISDN Header)
#    Then Delete the User "7058889999" records from Packs DB
# #   When Navigate to url "Subscribe_API_URL_RealTime"
#    Then Validate is Logo present
#	And  Validate is Banner present
#	Then Enter the MSISDN "7058889999"
#	Then Click on Confirm Button
#	Then Validate is Logo present
#	 And Validate is Banner present
#	Then Validate Re-Send OTP Text Link
#	Then Validate Cancel and Corfirm Button is Present
#    Then Get the OTP Value for MSISDN "7058889999" from DB and Enter the OTP
#    Then Click on Confirm Button
#    Then Get the current domain Cookies value
#    Then Validate is Logo present
#	 And Validate is Banner present
 #   Then Validate subscribed to the operator of your number
 #   Then Click on Terms and condition check box
 #   Then Click on Confirm Button
    Then Validate Subscribe thankyou messages and Status of User "7058889999"
    Then Click on Ok Button
    Then Validate Redirection url Parameter "u=XXXXXXXX&status=ACTIVE&opr=Safaricom"
    When Delete all domain Cookies Value

#Scenario: Navigate the subscribe API and Set the with MSISDN in Header
#    When Navigate to url "Page_Load_Url"
#    When Delete all domain Cookies Value
#    Then Delete the User "8111811121" records from Packs DB
#    Given Open New Tab and Set "x-msisdn" with Number "rrBZ9ieSYX8vvQ==" in Mod Header
#	When Navigate to url "Subscribe_API_URL_RealTime"
#
#Scenario: User Subscribe flow With MSISDN in Header
#    Then Validate is Logo present
#	And  Validate is Banner present
#	Then Get the current domain Cookies value
#    Then Validate Already Subscribed messages
#    Then Click on Confirm Button
# #  Then Validate User "8111811121" Subscribe Status in UI and Status in DB
#    Then Validate Subscribe thankyou messages and Status of User "8111811121"
# #   Then Click on Terms and condition check box
#    Then Click on Confirm Button
#    Then Validate Redirection url Parameter "status=ACTIVE&u=YYY&opr=Vodacom"
#
#Scenario: Close the Browser after complete feature
#    Then Close the browser
  
  
  
  
  
   
# Scenario: User DM flow via UIM Page(With out MSISDN Header)  
#   Then Validate DM task information afetr redirect with callBack url
   
###########CG Flow#######
#Scenario: Launch the portal with subscribe API with default callBack pack.
#	Given Launch the browser
#	Given Set the Headers with "INDIA_IP" IP range
#	 When Navigate to url "Subscribe_API_URL_CallBack"
#
#Scenario: User Subscribe flow via UIM Page(With out MSISDN Header)
#    Then Validate is Logo present
#	And  Validate is Banner present
#	Then Select the "Vodafone" Operator Name
#	Then Click on Confirm Button
#	Then Enter the MSISDN "9775555444"
#	Then Click on Confirm Button
#	Then Validate is Logo present
#	 And  Validate is Banner present
#	#Then Validate Re-Send OTP Text Link
#	Then Validate Cancel and Corfirm Button is Present
#    Then Get the OTP Value for MSISDN "9775555444" from DB and Enter the OTP
#    Then Click on Confirm Button
#    Then Get all Cookies value
#    Then Validate is Logo present
#	 And Validate is Banner present
#	Then Click on Terms and condition check box
#    Then Click on Confirm Button
#    Then Click on CG YES Button
#    Then Validate Subscribe thankyou messages and Status of User "9775555444"
#    Then Click on Confirm Button
#    Then Validate Redirection url Parameter "u=XXXXXXXX&status=PENDING&opr=Vodafone"
    