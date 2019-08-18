Feature: KENYA SAFARICOM - Subscription, Unsubscription and DM Flow

  Scenario: Launch the Browser then Add User Agent and Operator IP Range
    # Given Launch the browser
    Given Open New Tab and remove entry "2" in Mod Header
    Given Open New Tab and remove entry "1" in Mod Header
    Given Set the Headers with "SAFARICOM" IP range "41.57.111.255"
    
   Scenario: Navigate the Portal and Delete all the Cookies Value
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value

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
    Given Open New Tab and remove entry "3" in Mod Header

  #Scenario: Close the Browser
  # Then Close the browser
  #Then Quit the browser
  #######   3G Flow  #########
  #### User UnSubscribe Flow######
  Scenario: Unsubscribe Flow Started - Navigate the Page_Load_Url Delete all the Domain Cookie and  and Set the with MSISDN in Header
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    Given Open New Tab and Set "x-up-subno" with Number "2547050002222" in Mod Header
    Then Activate or DeActivate the User "7050002222,SAFARI_MAIN_1,30.00,SAFARICOM,ACT" using "Packs_CallBack_API" Packs Callback API

  Scenario: HIT IndetifyMe API and Identify the user status.
    When Navigate to url "SAFARICOM_IdentifyMe_API_URL"
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=SAFARICOM"
    Then Validate the User Status "ACTIVE" using "SAFARICOM_Check_Status_API" Check Status API

  Scenario: User Unsubscribe flow With MSISDN in Header
    When Navigate to url "Page_Load_Url"
    When Navigate to url "SAFARICOM_Unsubscribe_API_URL_CallBack"
    Then Validate is Logo present
    And Validate is Banner present
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
    Then Validate User "7050002222" current Status in DB
    Then Click on Ok Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=XXXXXXXX&opr=SAFARICOM"

  Scenario: DeActive the user using call back API and HIT IndetifyMe API and Identify the user status.
    Then Activate or DeActivate the User "7050002222,SAFARI_MAIN_1,30.00,SAFARICOM,DCT" using "Packs_CallBack_API" Packs Callback API
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    When Navigate to url "SAFARICOM_IdentifyMe_API_URL"
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=SAFARICOM"
    Then Validate the User Status "NOT_ACTIVE" using "SAFARICOM_Check_Status_API" Check Status API

  Scenario: Open the New and Remove the Number from Mod Header
    Given Open New Tab and remove entry "3" in Mod Header

  #######   Wifi Flow  #########
  #### User UnSubscribe Flow######
  Scenario: HIT IndetifyMe API and Identify the user status.
    Then Activate or DeActivate the User "7050002221,SAFARI_MAIN_1,30.00,SAFARICOM,ACT" using "Packs_CallBack_API" Packs Callback API
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    When Navigate to url "SAFARICOM_IdentifyMe_API_URL"
    Then Enter the MSISDN "7050002221"
    Then Click on Confirm Button
    #     Then Get the OTP Value for MSISDN "7050002221" from DB and Enter the OTP
    #     Then Click on Confirm Button
    #Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=SAFARICOM"
    Then Validate Redirection url Parameter "status=ACTIVE&u=xxxxxxxxx&opr=SAFARICOM"
    Then Validate the User Status "ACTIVE" using "SAFARICOM_Check_Status_API" Check Status API

  Scenario: Launch the Unsubscribe API url with (Realtime pack Id)
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    When Navigate to url "SAFARICOM_Unsubscribe_API_URL_CallBack"

  Scenario: User Unsubscribe flow via UIM Page(With out MSISDN Header)
    Then Validate is Logo present
    And Validate is Banner present
    Then Enter the MSISDN "7050002221"
    Then Click on Confirm Button
    #	Then Validate is Logo present
    #	 And Validate is Banner present
    #	Then Validate Re-Send OTP Text Link
    #	Then Validate Cancel and Corfirm Button is Present
    #	Then Validate is PoweredBy Logo present
    #	Then Validate footer links text and link url
    #    Then Get the OTP Value for MSISDN "7050002221" from DB and Enter the OTP
    #    Then Click on Confirm Button
    Then Get the current domain Cookies value
    Then Validate is Logo present
    And Validate is Banner present
    Then Validate Cancel and Corfirm Button is Present
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Click on Confirm Button
    Then Validate Unsubscribe user thankyou messages
    Then Validate User "7050002221" current Status in DB
    Then Click on Ok Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=XXXXXXXX&opr=SAFARICOM"

  Scenario: DeActive the user using call back API and HIT IndetifyMe API and Identify the user status.
    Then Activate or DeActivate the User "7050002221,SAFARI_MAIN_1,30.00,SAFARICOM,DCT" using "Packs_CallBack_API" Packs Callback API
    When Navigate to url "Page_Load_Url"
    When Navigate to url "SAFARICOM_IdentifyMe_API_URL"
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=SAFARICOM"
    Then Validate the User Status "NOT_ACTIVE" using "SAFARICOM_Check_Status_API" Check Status API

  # Scenario: Close the Browser
  # Then Close the browser
  #  Then Quit the browser
  #######   DM Flow  #########
  #### User Subscribe Flow######
  Scenario: DM FLOW started - Delete the DB Record fro Packs and DM log table.
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    Then Delete the User "7050002222" records from Packs DB
    Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2547050002222" form DM Log Table

  Scenario: HIT IndetifyMe API and Identify the user status.
    When Navigate to url "SAFARICOM_IdentifyMe_API_URL"
    Then Validate is Logo present
    And Validate is Banner present
    Then Enter the MSISDN "7050002222"
    Then Validate Cancel and Corfirm Button is Present
    Then Validate Terms and Conditions and Value
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Click on Confirm Button
    #	 Then Validate is Logo present
    #	  And Validate is Banner present
    #	 Then Validate Re-Send OTP Text Link
    #	 Then Validate Cancel and Corfirm Button is Present
    #	 Then Validate is PoweredBy Logo present
    #	 Then Validate footer links text and link url
    #     Then Get the OTP Value for MSISDN "7050002222" from DB and Enter the OTP
    #     Then Click on Confirm Button
    Then Validate Redirection url Parameter "status=INACTIVE&u=xxxxxxxxx&opr=SAFARICOM"
    Then Validate the User Status "NOT_ACTIVE" using "SAFARICOM_Check_Status_API" Check Status API

  Scenario: Navigate the DM Portal with Subscribe API.
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    When Navigate to url "SAFARICOM_Subscribe_DM_URL"

  Scenario: User Subscribe flow via UIM Page
    Then Validate is Logo present
    And Validate is Banner present
    Then Enter the MSISDN "7050002222"
    Then Validate Subscribe messages
    Then Validate Terms and Conditions and Value
    Then Validate Cancel and Corfirm Button is Present
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Click on Confirm Button
    #	Then Validate is Logo present
    #	 And Validate is Banner present
    #	Then Validate Re-Send OTP Text Link
    #	Then Validate Cancel and Corfirm Button is Present
    #	Then Validate is PoweredBy Logo present
    #	Then Validate footer links text and link url
    #    Then Get the OTP Value for MSISDN "7050002222" from DB and Enter the OTP
    #    Then Click on Confirm Button
    Then Validate User "NA" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "NA" DM Log Details for Activity Type "104" from DIAUS DB "DIAUS_DB_URL"
    Then Get the current domain Cookies value
    Then Validate is Logo present
    And Validate is Banner present
    Then Validate subscribed to the operator of your number
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
    #  Then Click on Terms and condition check box
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Click on Subscribe Button
    Then Validate Subscribe thankyou messages and Status of User "7050002222"
    Then Validate User "2547050002222" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547050002222" DM Log Details for Activity Type "201" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547050002222" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547050002222" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Click on Ok Button

  Scenario: HIT IndetifyMe API and Identify the user status.
    Then Activate or DeActivate the User "7050002222,SAFARI_MAIN_1,30.00,SAFARICOM,ACT" using "Packs_CallBack_API" Packs Callback API
    Then Validate DM task information after redirect with callBack url
    When Navigate to url "Page_Load_Url"
    When Navigate to url "SAFARICOM_IdentifyMe_API_URL"
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=SAFARICOM"
    Then Validate the User Status "ACTIVE" using "SAFARICOM_Check_Status_API" Check Status API
    Then Validate User "2547050002222" DM Log Details for Activity Type "25" from DIAUS DB "DIAUS_DB_URL"

  #######   DM Flow with MSISDN in Header #########
  ######## User Subscribe Flow ###########
  Scenario: Delete the DB Record fro Packs and DM log table.
    Then Delete the User "7050002221" records from Packs DB
    Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2547050002221" form DM Log Table

  Scenario: Navigate the Portal with Subscribe API and MSISDN with Header
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    Given Open New Tab and Set "x-up-subno" with Number "2547050002221" in Mod Header

  Scenario: HIT IndetifyMe API and Identify the user status.
    When Navigate to url "SAFARICOM_IdentifyMe_API_URL"
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=SAFARICOM"
    Then Validate the User Status "NOT_ACTIVE" using "SAFARICOM_Check_Status_API" Check Status API

  Scenario: User Subscribe flow for Real Time Pack via UIM Page
    When Navigate to url "SAFARICOM_Subscribe_DM_URL"
    Then Validate is Logo present
    And Validate is Banner present
    Then Validate User "2547050002221" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Get the current domain Cookies value
    Then Validate subscribed to the operator of your number
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
    #  Then Click on Terms and condition check box
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Click on Subscribe Button
    Then Validate Subscribe thankyou messages and Status of User "7050002221"
    Then Validate User "2547050002221" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547050002221" DM Log Details for Activity Type "201" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547050002221" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547050002221" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Click on Ok Button

  Scenario: HIT IndetifyMe API and Identify the user status.
    When Navigate to url "Page_Load_Url"
    Then Activate or DeActivate the User "7050002221,SAFARI_MAIN_1,30.00,SAFARICOM,ACT" using "Packs_CallBack_API" Packs Callback API
    Then Validate DM task information after redirect with callBack url
    When Navigate to url "SAFARICOM_IdentifyMe_API_URL"
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=SAFARICOM"
    Then Validate the User Status "ACTIVE" using "SAFARICOM_Check_Status_API" Check Status API
    Then Validate User "2547050002221" DM Log Details for Activity Type "25" from DIAUS DB "DIAUS_DB_URL"

  Scenario: Open the New and Remove the Number from Mod Header
    #Given Open New Tab and remove the Number "2547050002221" in Mod Header
    Given Open New Tab and remove entry "3" in Mod Header
    Given Open New Tab and remove entry "2" in Mod Header
    Given Open New Tab and remove entry "1" in Mod Header

  #Scenario: Close the Browser
    #Then Close the browser
    #Then Quit the browser
