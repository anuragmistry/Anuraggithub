Feature: Subscription Flow for ONMO Paywall

  Scenario: Launch the Browser then Add User Agent and Operator IP Range
    Given Launch the browser
	Given Set the Headers with "SAFARICOM" IP range "41.57.111.255"
	
  #######   Wifi Flow  #########
  #### User Subscribe Flow######
  Scenario: Delete the DB Record from Packs and DM log table.
    Then Delete the User "7050001111" records from Packs DB
    Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2547050001111" form DM Log Table

  Scenario: HIT IndetifyMe API and Identify the user status.
    When Navigate to url "SAFARICOM_IdentifyMe_API_URL"
    Then Validate is Logo present
    And Validate is Banner present
    Then Enter the MSISDN "7050001111"
    Then Validate Cancel and Corfirm Button is Present
    Then Validate Terms and Conditions and Value
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Click on Confirm Button
    #	 Then Validate is Logo present
    #	 And Validate is Banner present
    #	 Then Validate Re-Send OTP Text Link
    #	 Then Validate Cancel and Corfirm Button is Present
    #	 Then Validate is PoweredBy Logo present
    #	 Then Validate footer links text and link url
    #  Then Get the OTP Value for MSISDN "7050001111" from DB and Enter the OTP
    #  Then Click on Confirm Button
    Then Validate Redirection url Parameter "status=INACTIVE&u=xxxxxxxxx&opr=SAFARICOM"
    Then Validate the User Status "NOT_ACTIVE" using "SAFARICOM_Check_Status_API" Check Status API

  Scenario: Navigate the Portal and Delete all the Cookies Value
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value

  Scenario: User Subscribe flow Without MSISDN Header
    When Navigate to url "SAFARICOM_Subscribe_API_URL_CallBack"
    Then Validate is Logo present
    And Validate is Banner present
    Then Enter the MSISDN "7050001111"
    Then Validate Subscribe messages
    Then Validate Terms and Conditions and Value
    Then Validate Cancel and Corfirm Button is Present
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Click on Confirm Button
    ####Removed from SAFARICOM dur to flow change
    ##	Then Validate is Logo present
    ##	 And Validate is Banner present
    ##	Then Validate Re-Send OTP Text Link
    ##	Then Validate Cancel and Corfirm Button is Present
    ##	Then Validate is PoweredBy Logo present
    ##	Then Validate footer links text and link url
    ##  Then Get the OTP Value for MSISDN "7050001111" from DB and Enter the OTP
    ##  Then Click on Confirm Button
    ############# End of Removed steps ############
    Then Validate User "NA" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "NA" DM Log Details for Activity Type "104" from DIAUS DB "DIAUS_DB_URL"
    Then Get the current domain Cookies value
    Then Validate is Logo present
    And Validate is Banner present
    Then Validate subscribed to the operator of your number
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
    #Disabled this step it is checked by default
    #Then Click on Terms and condition check box
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Click on Subscribe Button
    Then Validate Subscribe thankyou messages and Status of User "7050001111"
    Then Validate User "2547050001111" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547050001111" DM Log Details for Activity Type "201" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547050001111" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547050001111" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Click on Ok Button
    Then Validate Redirection url Parameter "u=XXXXXXXX&status=PENDING&opr=SAFARICOM"
    When Delete all domain Cookies Value

  Scenario: HIT IndetifyMe API and Identify the user status.
    Then Activate or DeActivate the User "7050001111,SAFARI_MAIN_1,30.00,SAFARICOM,ACT" using "Packs_CallBack_API" Packs Callback API
    When Navigate to url "Page_Load_Url"
    #    When Delete all domain Cookies Value
    When Navigate to url "SAFARICOM_IdentifyMe_API_URL"
    #	 Then Enter the MSISDN "7050001111"
    #	 Then Click on Confirm Button
    #     Then Get the OTP Value for MSISDN "7050001111" from DB and Enter the OTP
    #     Then Click on Confirm Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=SAFARICOM"
    Then Validate the User Status "ACTIVE" using "SAFARICOM_Check_Status_API" Check Status API
    Then Validate User "2547050001111" DM Log Details for Activity Type "25" from DIAUS DB "DIAUS_DB_URL"

  #######   3G Flow  #########
  #### User Subscribe Flow######
  Scenario: Delete the DB Record fro Packs and DM log table.
    Then Delete the User "7050001112" records from Packs DB
    Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2547050001112" form DM Log Table

  Scenario: Navigate the Page_Load_Url Delete all the Domain Cookie and  and Set the with MSISDN in Header
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    Given Open New Tab and Set "x-up-subno" with Number "2547050001112" in Mod Header

  Scenario: HIT IndetifyMe API and Identify the user status.
    When Navigate to url "SAFARICOM_IdentifyMe_API_URL"
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=SAFARICOM"
    Then Validate the User Status "NOT_ACTIVE" using "SAFARICOM_Check_Status_API" Check Status API

  Scenario: User Subscribe flow via Data flow With MSISDN Header
    When Navigate to url "SAFARICOM_Subscribe_API_URL_CallBack"
    Then Validate User "2547050001112" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is Logo present
    And Validate is Banner present
    Then Validate subscribed to the operator of your number
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Get the current domain Cookies value
    Then Click on Subscribe Button
    Then Validate Subscribe thankyou messages and Status of User "7050001112"
    Then Validate User "2547050001112" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547050001112" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547050001112" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Click on Ok Button
    Then Validate Redirection url Parameter "u=XXXXXXXX&status=PENDING&opr=SAFARICOM"

  Scenario: Active the user using call back API and HIT IndetifyMe API and Identify the user status.
    Then Activate or DeActivate the User "7050001112,SAFARI_MAIN_1,30.00,SAFARICOM,ACT" using "Packs_CallBack_API" Packs Callback API
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    When Navigate to url "SAFARICOM_IdentifyMe_API_URL"
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=SAFARICOM"
    Then Validate the User Status "ACTIVE" using "SAFARICOM_Check_Status_API" Check Status API

  Scenario: Open the New and Remove the Number from Mod Header
    #Given Open New Tab and remove the Number "2547050001112" in Mod Header
    Given Open New Tab and remove entry "3" in Mod Header

  Scenario: Close the Browser
    # Then Close the browser
    Then Quit the browser
