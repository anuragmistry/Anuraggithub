Feature: All Operators Flow-ROBI,

 Scenario: Launch the Browser then Add User Agent and Operator IP Range
   Given Launch the browser
   Given Set the Headers with "ROBI" IP range "23.92.73.0"

  ###### Wifi Flow #########
  ##### User Subscribe Flow######
  Scenario: Delete the DB Record fro Packs and DM log table.
    Then Delete the User "9998000011" records from Packs DB
    Then Delete "DIAUS_INDIA_DB" the Log Entry for User "8809998000011" form DM Log Table
    Then Delete "DIAUS_INDIA_DB" the Log Entry for User "NA" form DM Log Table

  Scenario: HIT IndetifyMe API and Identify the user status.
    When Navigate to url "ROBI_IdentifyMe_API_URL"
    Then Validate is Logo present
    And Validate is Banner present
    Then Enter the MSISDN "9998000011"
    Then Validate Cancel and Corfirm Button is Present
    Then Validate Terms and Conditions and Value
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Click on Confirm Button
    Then Validate is Logo present
    And Validate is Banner present
    Then Validate Re-Send OTP Text Link
    Then Validate Cancel and Corfirm Button is Present
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Insert "0000" in OTP field
    Then Click on Confirm Button
    And Check Error message in OTP Page "Incorrect OTP. Please enter again"
    Then Get the OTP Value for MSISDN "9998000011" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=ROBI"
    Then Validate the User Status "NOT_ACTIVE" using "ROBI_Check_Status_API" Check Status API

  Scenario: Navigate the Portal and Delete all the Cookies Value
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value

  Scenario: User Subscribe flow With out MSISDN Header
    When Navigate to url "ROBI_Subscribe_API_URL_CallBack"
    Then Validate is Logo present
    And Validate is Banner present
    Then Enter the MSISDN "9998000011"
    Then Validate Subscribe messages
    Then Validate Terms and Conditions and Value
    Then Validate Cancel and Corfirm Button is Present
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Click on Confirm Button
    Then Validate is Logo present
    And Validate is Banner present
    Then Validate Re-Send OTP Text Link
    Then Validate Cancel and Corfirm Button is Present
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Get the OTP Value for MSISDN "9998000011" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Validate User "NA" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "NA" DM Log Details for Activity Type "104" from DIAUS DB "DIAUS_DB_URL"
    Then Get the current domain Cookies value
    Then Validate is Logo present
    And Validate is Banner present
    Then Validate subscribed to the operator of your number
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
    Then Click on Terms and condition check box
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Get the current domain Cookies value
    #Enable in wifi and disable this step in with header case
    Then Click on Terms and condition check box
    Then Click on Subscribe Button
    Then Validate User "8809998000011" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "8809998000011" DM Log Details for Activity Type "103" from DIAUS DB "DIAUS_DB_URL"
    Then Click on Yes Button in CG Page
    Then Validate Subscribe thankyou messages and Status of User "9998000011"
    Then Validate User "8809998000011" DM Log Details for Activity Type "55" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "8809998000011" DM Log Details for Activity Type "53" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "8809998000011" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Click on Ok Button
    Then Validate Redirection url Parameter "u=XXXXXXXX&status=PENDING&opr=ROBI"

  Scenario: HIT IndetifyMe API and Identify the user status.
    Then Activate or DeActivate the User "9998000011,ROBI_MAIN_1,50,ROBI,ACT" using "Packs_CallBack_API" Packs Callback API
    When Navigate to url "Page_Load_Url"
    When Navigate to url "ROBI_IdentifyMe_API_URL"
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=ROBI"
    Then Validate the User Status "ACTIVE" using "ROBI_Check_Status_API" Check Status API


  #######   3G Flow  #########
  ####### Subscribe Flow ######
  
  Scenario: Delete the DB Record fro Packs and DM log table.
    Then Delete the User "9998000012" records from Packs DB
    Then Delete "DIAUS_INDIA_DB" the Log Entry for User "8809998000012" form DM Log Table
    Then Delete "DIAUS_INDIA_DB" the Log Entry for User "NA" form DM Log Table

  Scenario: Navigate the Page_Load_Url Delete all the Domain Cookie and  and Set the with MSISDN in Header
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    Given Open New Tab and Set "x-up-subno" with Number "8809998000012" in Mod Header
    Then Delete the User "9998000012" records from Packs DB
    Then Delete "DIAUS_INDIA_DB" the Log Entry for User "8809998000012" form DM Log Table

  Scenario: HIT IndetifyMe API and Identify the user status.
    When Navigate to url "ROBI_IdentifyMe_API_URL"
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=ROBI"
    Then Validate the User Status "NOT_ACTIVE" using "ROBI_Check_Status_API" Check Status API

  Scenario: User Subscribe flow via Data flow With MSISDN Header
    When Navigate to url "ROBI_Subscribe_API_URL_CallBack"
    Then Validate User "8809998000012" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is Logo present
    And Validate is Banner present
    Then Validate subscribed to the operator of your number
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Get the current domain Cookies value
    #####Enable in wifi and disable this step in with header case
    ####Then Click on Terms and condition check box
    Then Click on Subscribe Button
    Then Validate User "8809998000012" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "8809998000012" DM Log Details for Activity Type "103" from DIAUS DB "DIAUS_DB_URL"
    Then Click on Yes Button in CG Page
    Then Validate Subscribe thankyou messages and Status of User "9998000012"
    Then Validate User "8809998000012" DM Log Details for Activity Type "55" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "8809998000012" DM Log Details for Activity Type "53" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "8809998000012" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Click on Ok Button
    Then Validate Redirection url Parameter "u=XXXXXXXX&status=PENDING&opr=ROBI"

  Scenario: Active the user using call back API and HIT IndetifyMe API and Identify the user status.
    Then Activate or DeActivate the User "9998000012,ROBI_MAIN_1,50,ROBI,ACT" using "Packs_CallBack_API" Packs Callback API
    When Navigate to url "Page_Load_Url"
    When Navigate to url "ROBI_IdentifyMe_API_URL"
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=ROBI"
    Then Validate the User Status "ACTIVE" using "ROBI_Check_Status_API" Check Status API

  Scenario: Close the Browser
    Given Open New Tab and remove the Number "8809998000012" in Mod Header
    #Then Close the browser

  ######### User UnSubscribe Flow#####
  #########   3G Flow  #########
  
  Scenario: Navigate to Page_Load_Url Delete all the Domain Cookie and Set MSISDN in Header
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    Given Open New Tab and Set "x-up-subno" with Number "8809998000013" in Mod Header
    
  Scenario: HIT IndetifyMe API and Identify the user status.
    When Navigate to url "ROBI_IdentifyMe_API_URL"
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=ROBI"
    Then Activate or DeActivate the User "9998000013,ROBI_MAIN_1,50,ROBI,ACT" using "Packs_CallBack_API" Packs Callback API
    Then Validate the User Status "ACTIVE" using "ROBI_Check_Status_API" Check Status API

  Scenario: User Unsubscribe flow With MSISDN in Header
    When Navigate to url "Page_Load_Url"
    When Navigate to url "ROBI_Unsubscribe_API_URL_CallBack"
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
    Then Validate User "9998000013" current Status in DB
    Then Click on Ok Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=XXXXXXXX&opr=ROBI"

  Scenario: Deactivate the user using call back API and HIT IndetifyMe API and Identify the user status.
    Then Activate or DeActivate the User "9998000013,ROBI_MAIN_1,50,ROBI,DCT" using "Packs_CallBack_API" Packs Callback API
    When Navigate to url "ROBI_IdentifyMe_API_URL"
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=ROBI"
    Then Validate the User Status "NOT_ACTIVE" using "ROBI_Check_Status_API" Check Status API

  Scenario: Open the New and Remove the Number from Mod Header
    Given Open New Tab and remove the Number "8809998000013" in Mod Header


  #######   Wifi Flow  #########
  ####### User UnSubscribe Flow #####
  Scenario: Activate the user using call back API before going to Deactivation flow.
    Then Activate or DeActivate the User "9998000013,ROBI_MAIN_1,50,ROBI,ACT" using "Packs_CallBack_API" Packs Callback API

  Scenario: HIT IndetifyMe API and Identify the user status.
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    When Navigate to url "ROBI_IdentifyMe_API_URL"
    Then Enter the MSISDN "9998000013"
    Then Click on Confirm Button
    Then Get the OTP Value for MSISDN "9998000013" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=ROBI"
    Then Validate the User Status "ACTIVE" using "ROBI_Check_Status_API" Check Status API

  Scenario: Launch the Unsubscribe API url
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    When Navigate to url "ROBI_Unsubscribe_API_URL_CallBack"

  Scenario: User Unsubscribe flow via UIM Page(With out MSISDN Header)
    Then Validate is Logo present
    And Validate is Banner present
    Then Enter the MSISDN "9998000013"
    Then Click on Confirm Button
    Then Validate is Logo present
    And Validate is Banner present
    Then Validate Re-Send OTP Text Link
    Then Validate Cancel and Corfirm Button is Present
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Get the OTP Value for MSISDN "9998000013" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Get the current domain Cookies value
    Then Validate is Logo present
    And Validate is Banner present
    Then Validate Cancel and Corfirm Button is Present
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Click on Confirm Button
    Then Validate Unsubscribe user thankyou messages
    Then Validate User "9998000013" current Status in DB
    Then Click on Ok Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=XXXXXXXX&opr=ROBI"

  Scenario: Hit DCT callback. Hit IndetifyMe API and check the user status.
    Then Activate or DeActivate the User "9998000013,ROBI_MAIN_1,50,ROBI,DCT" using "Packs_CallBack_API" Packs Callback API
    When Navigate to url "Page_Load_Url"
    When Navigate to url "ROBI_IdentifyMe_API_URL"
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=ROBI"
    Then Validate the User Status "NOT_ACTIVE" using "ROBI_Check_Status_API" Check Status API

  #Scenario: Close the Browser
    #Then Close the browser


  #######   DM Flow  #########
  #### User Subscribe Flow######
  Scenario: Delete the DB Record fro Packs and DM log table.
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    Then Delete the User "9998000011" records from Packs DB
    Then Delete "DIAUS_INDIA_DB" the Log Entry for User "8809998000011" form DM Log Table
    Then Delete "DIAUS_INDIA_DB" the Log Entry for User "NA" form DM Log Table

  Scenario: HIT IndetifyMe API and Identify the user status.
    When Navigate to url "ROBI_IdentifyMe_API_URL"
    Then Validate is Logo present
    And Validate is Banner present
    Then Enter the MSISDN "9998000011"
    Then Validate Cancel and Corfirm Button is Present
    Then Validate Terms and Conditions and Value
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Click on Confirm Button
    Then Validate is Logo present
    And Validate is Banner present
    Then Validate Re-Send OTP Text Link
    Then Validate Cancel and Corfirm Button is Present
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Get the OTP Value for MSISDN "9998000011" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=ROBI"
    Then Validate the User Status "NOT_ACTIVE" using "ROBI_Check_Status_API" Check Status API

  Scenario: Navigate to onmopay with DM Subscribe API.
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    When Navigate to url "ROBI_Subscribe_DM_URL"

  Scenario: User Subscribe flow without MSISDN Header
    Then Validate is Logo present
    And Validate is Banner present
    Then Enter the MSISDN "9998000011"
    Then Validate Subscribe messages
    Then Validate Terms and Conditions and Value
    Then Validate Cancel and Corfirm Button is Present
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Click on Confirm Button
    Then Validate is Logo present
    And Validate is Banner present
    Then Validate Re-Send OTP Text Link
    Then Validate Cancel and Corfirm Button is Present
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Get the OTP Value for MSISDN "9998000011" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Validate User "NA" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "NA" DM Log Details for Activity Type "104" from DIAUS DB "DIAUS_DB_URL"
    Then Get the current domain Cookies value
    Then Validate is Logo present
    And Validate is Banner present
    Then Validate subscribed to the operator of your number
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
    Then Click on Terms and condition check box
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Get the current domain Cookies value
    ###Enable in wifi and disable this step in with header case
    Then Click on Terms and condition check box
    Then Click on Subscribe Button
    Then Validate User "8809998000011" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "8809998000011" DM Log Details for Activity Type "103" from DIAUS DB "DIAUS_DB_URL"
    Then Click on Yes Button in CG Page
    Then Validate Subscribe thankyou messages and Status of User "9998000011"
    Then Validate Subscribe thankyou messages and Status of User "9999000066"
    Then Validate User "8809998000011" DM Log Details for Activity Type "55" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "8809998000011" DM Log Details for Activity Type "53" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "8809998000011" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Click on Ok Button
    Then Validate Redirection url Parameter "status=PENDING&u=xxxxxxxxx&opr=ROBI"

  Scenario: HIT IndetifyMe API and Identify the user status.
    Then Activate or DeActivate the User "9998000011,ROBI_MAIN_1,50,ROBI,ACT" using "Packs_CallBack_API" Packs Callback API
    When Navigate to url "Page_Load_Url"
    When Navigate to url "ROBI_IdentifyMe_API_URL"
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=ROBI"
    Then Validate the User Status "ACTIVE" using "ROBI_Check_Status_API" Check Status API
    Then Validate DM task information after redirect with callBack url

  #######   DM Flow with MSISDN in Header #########
  ######## User Subscribe Flow ###########
  Scenario: Delete the DB Record fro Packs and DM log table.
    Then Delete the User "9998000012" records from Packs DB
    Then Delete "DIAUS_INDIA_DB" the Log Entry for User "8809998000012" form DM Log Table
    Then Delete "DIAUS_INDIA_DB" the Log Entry for User "NA" form DM Log Table

  Scenario: Navigate the Page_Load_Url Delete all the Domain Cookie and  and Set the with MSISDN in Header
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    Given Open New Tab and Set "x-up-subno" with Number "8809998000012" in Mod Header
    Then Delete the User "9998000012" records from Packs DB
    Then Delete "DIAUS_INDIA_DB" the Log Entry for User "8809998000012" form DM Log Table

  Scenario: HIT IndetifyMe API and Identify the user status.
    When Navigate to url "ROBI_IdentifyMe_API_URL"
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=ROBI"
    Then Validate the User Status "NOT_ACTIVE" using "ROBI_Check_Status_API" Check Status API

  Scenario: User DM Subscribe flow via Data flow With MSISDN Header
    When Navigate to url "ROBI_Subscribe_DM_URL"
    Then Validate User "8809998000012" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is Logo present
    And Validate is Banner present
    Then Get the current domain Cookies value
    Then Validate subscribed to the operator of your number
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Get the current domain Cookies value
    ####Enable in wifi and disable this step in with header case
    ####Then Click on Terms and condition check box
    Then Click on Subscribe Button
    Then Validate User "8809998000012" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "8809998000012" DM Log Details for Activity Type "103" from DIAUS DB "DIAUS_DB_URL"
    Then Click on Yes Button in CG Page
    Then Validate Subscribe thankyou messages and Status of User "9998000012"
    Then Validate User "8809998000012" DM Log Details for Activity Type "55" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "8809998000012" DM Log Details for Activity Type "53" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "8809998000012" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is PoweredBy Logo present
    Then Validate footer links text and link url
    Then Click on Ok Button
    Then Validate Redirection url Parameter "u=XXXXXXXX&status=PENDING&opr=ROBI"

  Scenario: Active the user using call back API and HIT IndetifyMe API and Identify the user status.
    Then Activate or DeActivate the User "9998000012,ROBI_MAIN_1,50,ROBI,ACT" using "Packs_CallBack_API" Packs Callback API
    When Navigate to url "Page_Load_Url"
    When Navigate to url "ROBI_IdentifyMe_API_URL"
    Then Validate DM task information after redirect with callBack url
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=ROBI"
    Then Validate the User Status "ACTIVE" using "ROBI_Check_Status_API" Check Status API

 #Scenario: Close the browser
  #Then Close the browser
 #Then Quit the browser


###OMAN - OMANTEL Feature
 
Scenario: OMANTEL Flow Started - Remove the MSISDN header from browser
Given Open New Tab and remove the Number "8809998000012" in Mod Header

##Feature: ALL Flow for Onmopay Oman Omantel
##Scenario: Launch the Browser then Add User Agent and Operator IP Range
##Given Launch the browser

Scenario: Navigate the Portal and Delete all the Cookies Value
	 When Navigate to url "Page_Load_Url"
	 When Delete all domain Cookies Value

####### Wifi Flow ###########
###### User Subscribe Flow######
Scenario: Delete the DB Record from Packs and DM log table.
	 Then Delete the User "8889000001" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "9688889000001" form DM Log Table
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "NA" form DM Log Table
	 
Scenario: HIT IndetifyMe API and Identify the user status.
	 When Navigate to url "OMANTEL_IdentifyMe_API_URL"
	 Then Click on identify button "without" msisdn
	 Then Validate is Logo present
	 And Validate is Banner present
	 Then Enter the MSISDN "8889000001"
	 Then Validate Cancel and Corfirm Button is Present
	 Then Validate Terms and Conditions and Value
	 Then Validate is PoweredBy Logo present
	 Then Validate footer links text and link url
	 Then Click on Confirm Button
	 Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OMANTEL"
	 Then Validate the User Status "NOT_ACTIVE" using "OMANTEL_Check_Status_API" Check Status API


Scenario: Navigate the Portal and Delete all the Cookies Value
	 When Navigate to url "Page_Load_Url"
	 When Delete all domain Cookies Value

Scenario: User Subscribe flow With out MSISDN Header
	 When Navigate to url "OMANTEL_Subscribe_API_URL_CallBack"
	 Then Click on identify button "without" msisdn
	 Then Validate is Logo present
	 And  Validate is Banner present
	 Then Enter the MSISDN "8889000001"
	 Then Validate Subscribe messages
	 Then Validate Terms and Conditions and Value
	 Then Validate Cancel and Corfirm Button is Present
	 Then Validate is PoweredBy Logo present
	 Then Validate footer links text and link url
	 Then Click on Confirm Button
	 Then Validate is Logo present
	 And Validate is Banner present
	 Then Validate Re-Send OTP Text Link
	 Then Validate Cancel and Corfirm Button is Present
	 Then Validate is PoweredBy Logo present
	 Then Validate footer links text and link url
	 Then Insert "0000" in OTP field
	 Then Click on Confirm Button
	 Then Validate User "NA" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
	 Then Validate User "NA" DM Log Details for Activity Type "104" from DIAUS DB "DIAUS_DB_URL"
	 Then Get the current domain Cookies value
     Then Validate is Logo present
	 And Validate is Banner present
	 Then Validate Subscribe thankyou messages and Status of User "8889000001"
	 Then Validate User "9688889000001" DM Log Details for Activity Type "106" from DIAUS DB "DIAUS_DB_URL"
	 Then Validate User "9688889000001" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
     Then Validate is PoweredBy Logo present
	 Then Validate footer links text and link url
     Then Click on Ok Button
     Then Validate Redirection url Parameter "u=XXXXXXXX&status=ACT_PENDING&opr=OMANTEL"

 
 Scenario: HIT IndetifyMe API and Identify the user status.
	 Then Activate or DeActivate the User "8889000001,omantel_oman_pack1,30,OMANTEL,ACT" using "Packs_CallBack_API" Packs Callback API
     When Navigate to url "Page_Load_Url"
	 When Navigate to url "OMANTEL_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OMANTEL"
     Then Validate the User Status "ACTIVE" using "OMANTEL_Check_Status_API" Check Status API


#####   3G Flow  #########   
##### User Subscribe Flow######
Scenario: Delete the DB Record from Packs and DM log table.
	Then Delete the User "8889000012" records from Packs DB
	Then Delete "DIAUS_INDIA_DB" the Log Entry for User "9688889000012" form DM Log Table
	Then Delete "DIAUS_INDIA_DB" the Log Entry for User "NA" form DM Log Table
	
Scenario: Navigate the Page_Load_Url Delete all the Domain Cookie and  and Set the with MSISDN in Header
	When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
	Then Delete the User "8889000012" records from Packs DB
	Then Delete "DIAUS_INDIA_DB" the Log Entry for User "9688889000012" form DM Log Table

Scenario: HIT IndetifyMe API and Identify the user status.
	When Navigate to url "OMANTEL_IdentifyMe_API_URL"
	Then Click on identify button "with" msisdn
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OMANTEL"
    Then Validate the User Status "NOT_ACTIVE" using "OMANTEL_Check_Status_API" Check Status API


Scenario: User Subscribe flow via Data flow With MSISDN Header
	When Navigate to url "OMANTEL_Subscribe_API_URL_CallBack"
	Then Validate User "9688889000012" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is Logo present
	And Validate is Banner present
    Then Validate subscribed to the operator of your number
    Then Validate Pack Detials messages
	Then Validate Terms and Conditions and Value
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
	Then Get the current domain Cookies value	
	Then Click on Subscribe Button
	Then Validate is Logo present
	And Validate is Banner present
	Then Validate Re-Send OTP Text Link
	Then Validate Cancel and Corfirm Button is Present
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Insert "0000" in OTP field
    Then Click on Confirm Button
	Then Validate User "9688889000012" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
	Then Validate Subscribe thankyou messages and Status of User "8889000012"
	Then Validate User "9688889000012" DM Log Details for Activity Type "106" from DIAUS DB "DIAUS_DB_URL"
	Then Validate User "9688889000012" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
   	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
  	Then Click on Ok Button
  	Then Validate Redirection url Parameter "u=XXXXXXXX&status=ACT_PENDING&opr=OMANTEL"
  
  
 Scenario: Active the user using call back API and HIT IndetifyMe API and Identify the user status.
    Then Activate or DeActivate the User "8889000012,omantel_oman_pack1,30,OMANTEL,ACT" using "Packs_CallBack_API" Packs Callback API
    When Navigate to url "Page_Load_Url"
	When Navigate to url "OMANTEL_IdentifyMe_API_URL"
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OMANTEL"
    Then Validate the User Status "ACTIVE" using "OMANTEL_Check_Status_API" Check Status API


#######   3G Flow  #########   
####### User UnSubscribe Flow#####

Scenario: Navigate to Page_Load_Url Delete all the Domain Cookie
    When Navigate to url "Page_Load_Url"
    Then Delete all domain Cookies Value
    
Scenario: HIT IndetifyMe API and Identify the user status.
	When Navigate to url "OMANTEL_IdentifyMe_API_URL"
	Then Click on identify button "with" msisdn
	Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OMANTEL"
	Then Validate the User Status "ACTIVE" using "OMANTEL_Check_Status_API" Check Status API
     	
Scenario: User Unsubscribe flow With MSISDN in Header
    When Navigate to url "Page_Load_Url"
    When Navigate to url "OMANTEL_Unsubscribe_API_URL_CallBack"
    Then Validate is Logo present
	And  Validate is Banner present
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
    Then Validate User "8889000012" current Status in DB
    Then Click on Ok Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=XXXXXXXX&opr=OMANTEL"
     
 Scenario: Deactivate the user using call back API and HIT IndetifyMe API and Identify the user status.
     Then Activate or DeActivate the User "8889000012,omantel_oman_pack1,30,OMANTEL,DCT" using "Packs_CallBack_API" Packs Callback API
     When Navigate to url "OMANTEL_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OMANTEL"
     Then Validate the User Status "NOT_ACTIVE" using "OMANTEL_Check_Status_API" Check Status API
    

####   Wifi Flow  #########   
#### User UnSubscribe Flow #####

Scenario: Activate the user using call back API before going to Deactivation flow.
     Then Activate or DeActivate the User "8898010013,omantel_oman_pack1,30,OMANTEL,ACT" using "Packs_CallBack_API" Packs Callback API

 Scenario: HIT IndetifyMe API and Identify the user status.
     When Navigate to url "Page_Load_Url"
     When Delete all domain Cookies Value
	 When Navigate to url "OMANTEL_IdentifyMe_API_URL"
	 Then Click on identify button "without" msisdn
	 Then Enter the MSISDN "8898010013"
	 Then Click on Confirm Button
     Then Get the OTP Value for MSISDN "8898010013" from DB and Enter the OTP
     Then Click on Confirm Button
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OMANTEL"
     Then Validate the User Status "ACTIVE" using "OMANTEL_Check_Status_API" Check Status API    

Scenario: Launch the Unsubscribe API url
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    When Navigate to url "OMANTEL_Unsubscribe_API_URL_CallBack"
    Then Click on identify button "without" msisdn

Scenario: User Unsubscribe flow via UIM Page(With out MSISDN Header)
    Then Validate is Logo present
	And  Validate is Banner present
	Then Enter the MSISDN "8898010013"
	Then Click on Confirm Button
	Then Validate is Logo present
	 And Validate is Banner present
	Then Validate Re-Send OTP Text Link
	Then Validate Cancel and Corfirm Button is Present
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Get the OTP Value for MSISDN "8898010013" from DB and Enter the OTP
    Then Click on Confirm Button
    Then Get the current domain Cookies value
    Then Validate is Logo present
	 And Validate is Banner present
	Then Validate Cancel and Corfirm Button is Present	
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Click on Confirm Button
    Then Validate Unsubscribe user thankyou messages
    Then Validate User "8898010013" current Status in DB
    Then Click on Ok Button
    Then Validate Redirection url Parameter "status=SUCCESS&u=XXXXXXXX&opr=OMANTEL"
 
  Scenario: Hit DCT callback. Hit IndetifyMe API and check the user status.
     Then Activate or DeActivate the User "8898010013,omantel_oman_pack1,30,OMANTEL,DCT" using "Packs_CallBack_API" Packs Callback API
     When Navigate to url "Page_Load_Url"
	 When Navigate to url "OMANTEL_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OMANTEL"
     Then Validate the User Status "NOT_ACTIVE" using "OMANTEL_Check_Status_API" Check Status API 
 	 
#### DM Wifi Flow #########   
### User Subscribe Flow######      
Scenario: Delete the DB Record from Packs and DM log table.
	 When Navigate to url "Page_Load_Url"
	 When Delete all domain Cookies Value
	 Then Delete the User "8889000001" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "9688889000001" form DM Log Table
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "NA" form DM Log Table
	 
Scenario: HIT IndetifyMe API and Identify the user status.
	 When Navigate to url "OMANTEL_IdentifyMe_API_URL"
	 Then Click on identify button "without" msisdn
	 Then Validate is Logo present
	 And Validate is Banner present
	 Then Enter the MSISDN "8889000001"
	 Then Validate Cancel and Corfirm Button is Present
	 Then Validate Terms and Conditions and Value
	 Then Validate is PoweredBy Logo present
	 Then Validate footer links text and link url
	 Then Click on Confirm Button
	 Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OMANTEL"
	 Then Validate the User Status "NOT_ACTIVE" using "OMANTEL_Check_Status_API" Check Status API


Scenario: Navigate to onmopay with DM Subscribe API.
	 When Navigate to url "Page_Load_Url"
	 When Delete all domain Cookies Value
	 When Navigate to url "OMANTEL_Subscribe_DM_URL"

Scenario: User Subscribe flow without MSISDN Header
	 Then Click on identify button "without" msisdn
	 Then Validate is Logo present
	 And  Validate is Banner present
	 Then Enter the MSISDN "8889000001"
	 Then Validate Subscribe messages
	 Then Validate Terms and Conditions and Value
	 Then Validate Cancel and Corfirm Button is Present
	 Then Validate is PoweredBy Logo present
	 Then Validate footer links text and link url
	 Then Click on Confirm Button
	 Then Validate is Logo present
	 And Validate is Banner present
	 Then Validate Re-Send OTP Text Link
	 Then Validate Cancel and Corfirm Button is Present
	 Then Validate is PoweredBy Logo present
	 Then Validate footer links text and link url
	 Then Insert "0000" in OTP field
	 Then Click on Confirm Button
	 Then Validate User "NA" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
	 Then Validate User "NA" DM Log Details for Activity Type "104" from DIAUS DB "DIAUS_DB_URL"
	 Then Get the current domain Cookies value
     Then Validate is Logo present
	 And Validate is Banner present
	 Then Validate Subscribe thankyou messages and Status of User "8889000001"
	 Then Validate User "9688889000001" DM Log Details for Activity Type "106" from DIAUS DB "DIAUS_DB_URL"
	 Then Validate User "9688889000001" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
     Then Validate is PoweredBy Logo present
	 Then Validate footer links text and link url
     Then Click on Ok Button
     Then Validate Redirection url Parameter "u=XXXXXXXX&status=ACT_PENDING&opr=OMANTEL"

 
 Scenario: HIT IndetifyMe API and Identify the user status.
	 Then Activate or DeActivate the User "8889000001,omantel_oman_pack1,30,OMANTEL,ACT" using "Packs_CallBack_API" Packs Callback API
     When Navigate to url "Page_Load_Url"
	 When Navigate to url "OMANTEL_IdentifyMe_API_URL"
     Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OMANTEL"
     Then Validate the User Status "ACTIVE" using "OMANTEL_Check_Status_API" Check Status API
     Then Validate DM task information after redirect with callBack url


#####  DM 3G Flow  #########   
##### User Subscribe Flow######
Scenario: Delete the DB Record from Packs and DM log table.
	Then Delete the User "8889000012" records from Packs DB
	Then Delete "DIAUS_INDIA_DB" the Log Entry for User "9688889000012" form DM Log Table
	Then Delete "DIAUS_INDIA_DB" the Log Entry for User "NA" form DM Log Table
	
Scenario: Navigate the Page_Load_Url Delete all the Domain Cookie and  and Set the with MSISDN in Header
	When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
	Then Delete the User "8889000012" records from Packs DB
	Then Delete "DIAUS_INDIA_DB" the Log Entry for User "9688889000012" form DM Log Table

Scenario: HIT IndetifyMe API and Identify the user status.
	When Navigate to url "OMANTEL_IdentifyMe_API_URL"
	Then Click on identify button "with" msisdn
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OMANTEL"
    Then Validate the User Status "NOT_ACTIVE" using "OMANTEL_Check_Status_API" Check Status API


Scenario: User DM Subscribe flow via Data flow With MSISDN Header
	When Navigate to url "OMANTEL_Subscribe_DM_URL"
	Then Validate User "9688889000012" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is Logo present
	And Validate is Banner present
	Then Get the current domain Cookies value
    Then Validate subscribed to the operator of your number
    Then Validate Pack Detials messages
	Then Validate Terms and Conditions and Value
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
	Then Get the current domain Cookies value	
	Then Click on Subscribe Button
	Then Validate is Logo present
	And Validate is Banner present
	Then Validate Re-Send OTP Text Link
	Then Validate Cancel and Corfirm Button is Present
	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
    Then Insert "0000" in OTP field
    Then Click on Confirm Button
	Then Validate User "9688889000012" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
	Then Validate Subscribe thankyou messages and Status of User "8889000012"
	Then Validate User "9688889000012" DM Log Details for Activity Type "106" from DIAUS DB "DIAUS_DB_URL"
	Then Validate User "9688889000012" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
   	Then Validate is PoweredBy Logo present
	Then Validate footer links text and link url
  	Then Click on Ok Button
  	Then Validate Redirection url Parameter "u=XXXXXXXX&status=ACT_PENDING&opr=OMANTEL"
  
  
 Scenario: Active the user using call back API and HIT IndetifyMe API and Identify the user status.
    Then Activate or DeActivate the User "8889000012,omantel_oman_pack1,30,OMANTEL,ACT" using "Packs_CallBack_API" Packs Callback API
    When Navigate to url "Page_Load_Url"
	When Navigate to url "OMANTEL_IdentifyMe_API_URL"
	Then Validate DM task information after redirect with callBack url
    Then Validate Redirection url Parameter "status=SUCCESS&u=xxxxxxxxx&opr=OMANTEL"
    Then Validate the User Status "ACTIVE" using "OMANTEL_Check_Status_API" Check Status API
     
 Scenario: Close the Browser
  # Then Close the browser
    Then Quit the browser

