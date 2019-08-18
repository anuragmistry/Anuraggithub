Feature: Subscription Flow for APPLAND via Wifi and 3G Flow

  Scenario: Launch the Browser then Add User Agent and Operator IP Range
   Given Launch the browser
   Given Set the Headers with "Saraficom" IP range "41.57.111.255"
   Then Delete All Signed Users from DIAUS DB
    
  ####   Wifi Flow  #########
  #### User Subscribe with Basic Plan ######
  Scenario: Delete the DB Record for Packs and DM log table.
    Then Delete the User "7059999999" records from Packs DB
    Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2547059999999" form DM Log Table

  Scenario: User Subscribe Flow with Basic Plan with out MSISDN in Header
    When Navigate to url "SAFARICOM_Plans_API_URL"
    Then Validate is Logo Image present
    Then Click on "Basic" Button
    Then Validate "Basic" Subscribe Packs details message
    Then Validate Joint Family Account Button is Present
    Then Validate Terms and Conditions text and Value
    Then Click on "Basic" Continue Button
    Then Validate is Logo Image present
    Then Validate AlbumImg is present
    Then Enter the MSISDN "7059999999"
    Then Validate Subscribe messages
    Then Validate Terms and Conditions and Value
    Then Click on the Confirm Button
    #	Then Validate is Logo Image present
    #	Then Validate AlbumImg is present
    #	Then Validate Re-Send OTP Text Link
    #    Then Get the OTP Value for MSISDN "7059999999" from DB and Enter the OTP
    #    Then Click on the Confirm Button
    Then Get the current domain Cookies value
    Then Validate User "NA" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "NA" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "NA" DM Log Details for Activity Type "104" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is Logo Image present
    Then Validate AlbumImg is present
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
    Then Click on Subscribe Button
    Then Validate is Logo Image present
    Then Validate AlbumImg is present
    Then Validate Subscribe thankyou messages and Status of User "7059999999"
    Then Validate User "2547059999999" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547059999999" DM Log Details for Activity Type "201" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547059999999" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547059999999" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Click on Ok Button

  Scenario: Active the user using call back API and HIT Myaccount API and Validate the user status.
    Then Activate or DeActivate the User "7059999999,SAFARI_MAIN_1,30.00,SAFARICOM,ACT" using "Packs_CallBack_API" Packs Callback API
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    Then Validate User "2547059999999" DM Log Details for Activity Type "25" from DIAUS DB "DIAUS_DB_URL"
    When Navigate to url "SAFARICOM_Myaccount_API_URL"
    Then Validate is Logo Image present
    Then Validate AlbumImg is present
    Then Enter the MSISDN "7059999999"
    Then Validate Subscribe messages
    Then Validate Terms and Conditions and Value
    Then Click on the Confirm Button
    #	 Then Validate is Logo Image present
    #	 Then Validate AlbumImg is present
    #	 Then Validate Re-Send OTP Text Link
    #     Then Get the OTP Value for MSISDN "7059999999" from DB and Enter the OTP
    #     Then Click on the Confirm Button
    Then Validate is Logo Image present
    Then Validate AlbumImg is present
    Then Validate Current Plan Heading and All Active Plan text is Present
    Then Validate Access Service and UnSubscribe Button is Present
    Then Validate Current Active plan Amount with Symbol
    Then Click on "Access Service" Button in MyAccount Page

  #####   Wifi Flow  #########
  #### User Subscribe with Family Plan ######
  Scenario: Navigate the Portal and Delete all the Cookies Value
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value

  Scenario: Delete the DB Record fro Packs and UserManagement and DM log table.
    Then Delete the User "7051111111" records from Packs DB
    Then Delete "DIAUS_DB_URL" the User Entry "7051111111" form DIAUS UserManagement Table
    Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2547051111111" form DM Log Table

  Scenario: User Subscribe Flow with Family Plan with out MSISDN in Header
    When Navigate to url "SAFARICOM_Plans_API_URL"
    Then Validate is Logo Image present
    Then Click on "Family" Button
    Then Validate "Family" Subscribe Packs details message
    Then Validate Joint Family Account Button is Present
    Then Validate Terms and Conditions text and Value
    Then Click on "Family" Continue Button
    Then Validate is Logo Image present
    Then Validate AlbumImg is present
    Then Enter the MSISDN "7051111111"
    Then Validate Subscribe messages
    Then Validate Terms and Conditions and Value
    Then Click on the Confirm Button
    #	Then Validate is Logo Image present
    #	Then Validate AlbumImg is present
    #	Then Validate Re-Send OTP Text Link
    #    Then Get the OTP Value for MSISDN "7051111111" from DB and Enter the OTP
    #    Then Click on the Confirm Button
    Then Get the current domain Cookies value
    Then Validate User "NA" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "NA" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "NA" DM Log Details for Activity Type "104" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is Logo Image present
    Then Validate AlbumImg is present
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
    Then Click on Subscribe Button
    Then Validate is Logo Image present
    Then Validate AlbumImg is present
    Then Validate Subscribe thankyou messages and Status of User "7051111111"
    Then Validate User "2547051111111" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547051111111" DM Log Details for Activity Type "201" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547051111111" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547051111111" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Click on Ok Button

  Scenario: Create a User Account using Signup Page
    Then Validate SignUp is present
    Then Validate Mobile Number Label and inside Value "7051111111" in SignUp Page
    Then Enter the Password and Confrim Password "7051111111"
    Then Validate Cancel and Continue Button is Present in SignUp Page
    Then Click on Continue Button in SignUp Page
    Then Validate SignUp User "7051111111" data from DIAUS DB

  Scenario: Active the User using call back API and HIT Myaccount API and Validate the User Status.
    Then Activate or DeActivate the User "7051111111,SAFARI_MAIN_2,50.00,SAFARICOM,ACT" using "Packs_CallBack_API" Packs Callback API
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    Then Validate User "2547051111111" DM Log Details for Activity Type "25" from DIAUS DB "DIAUS_DB_URL"
    When Navigate to url "SAFARICOM_Myaccount_API_URL"
    Then Validate is Logo Image present
    Then Validate AlbumImg is present
    Then Enter the MSISDN "7051111111"
    Then Validate Subscribe messages
    Then Validate Terms and Conditions and Value
    Then Click on the Confirm Button
    #	 Then Validate is Logo Image present
    #	 Then Validate AlbumImg is present
    #	 Then Validate Re-Send OTP Text Link
    #     Then Get the OTP Value for MSISDN "7051111111" from DB and Enter the OTP
    #     Then Click on the Confirm Button
    Then Validate is Logo Image present
    Then Validate AlbumImg is present
    Then Validate Current Plan Heading and All Active Plan text is Present
    Then Validate Access Service and UnSubscribe Button is Present
    Then Validate Current Active plan Amount with Symbol
    Then Click on "Access Service" Button in MyAccount Page

  #Scenario: Join My Family Account
  #     Then Validate My Family is present
  #     Then Enter the Mobile Number "7051111111" and Password "7051111111"
  #     Then Click on Join Button
  Scenario: Navigate Plan API and Join My Family Account Using Click on Join Account Button
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    When Navigate to url "SAFARICOM_Plans_API_URL"
    Then Click on "Family" Button
    Then Click on Joint Family Account Button
    Then Validate My Family is present
    Then Enter the Mobile Number "7051111111" and Password "7051111111"
    Then Click on Join Button
    

  #####   3G Flow  #########
  #### User Subscribe with Basic Plan ######
  Scenario: Delete the DB Record fro Packs and DM log table.
    Then Delete the User "7053333333" records from Packs DB
    Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2547053333333" form DM Log Table
    
  Scenario: Navigate the Plans API and Set the with MSISDN in Header (for 3G Flow)
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    Given Open New Tab and Set "x-up-subno" with Number "2547053333333" in Mod Header

  Scenario: User Subscribe Flow with Basic Plan with MSISDN in Header
    When Navigate to url "SAFARICOM_Plans_API_URL"
    Then Validate is Logo Image present
    Then Click on "Basic" Button
    Then Validate "Basic" Subscribe Packs details message
    Then Validate Joint Family Account Button is Present
    Then Validate Terms and Conditions text and Value
    Then Click on "Basic" Continue Button
    Then Get the current domain Cookies value
    Then Validate User "2547053333333" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547053333333" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is Logo Image present
    Then Validate AlbumImg is present
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
    Then Click on Subscribe Button
    Then Validate is Logo Image present
    Then Validate AlbumImg is present
    Then Validate Subscribe thankyou messages and Status of User "7053333333"
    Then Validate User "2547053333333" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547053333333" DM Log Details for Activity Type "201" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547053333333" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547053333333" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Click on Ok Button

  Scenario: Active the user using call back API and HIT Myaccount API and Validate the user status.
    Then Activate or DeActivate the User "7053333333,SAFARI_MAIN_1,30.00,SAFARICOM,ACT" using "Packs_CallBack_API" Packs Callback API
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    Then Validate User "2547053333333" DM Log Details for Activity Type "25" from DIAUS DB "DIAUS_DB_URL"
    When Navigate to url "SAFARICOM_Myaccount_API_URL"
    Then Validate is Logo Image present
    Then Validate AlbumImg is present
    Then Validate Current Active plan Amount with Symbol
    Then Validate Current Plan Heading and All Active Plan text is Present
    Then Validate Access Service and UnSubscribe Button is Present
    Then Click on "Access Service" Button in MyAccount Page

  Scenario: Open the New and Remove the Number from Mod Header
    Given Open New Tab and remove the Number "2547053333333" in Mod Header

  
  ######   3G Flow  #########
  ##### User Subscribe with Family Plan ######
  Scenario: Delete the DB Record fro Packs and DM log table.
    Then Delete the User "7059999333" records from Packs DB
    Then Delete "DIAUS_DB_URL" the User Entry "7059999333" form DIAUS UserManagement Table
    Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2547059999333" form DM Log Table

  Scenario: Navigate the Plans API and Set the with MSISDN in Header (for 3G Flow)
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    Given Open New Tab and Set "x-up-subno" with Number "2547059999333" in Mod Header

  Scenario: User Subscribe Flow with Family Plan with out MSISDN in Header
    When Navigate to url "SAFARICOM_Plans_API_URL"
    Then Validate is Logo Image present
    Then Click on "Family" Button
    Then Validate "Family" Subscribe Packs details message
    Then Validate Joint Family Account Button is Present
    Then Validate Terms and Conditions text and Value
    Then Click on "Family" Continue Button
    Then Get the current domain Cookies value
    Then Validate User "2547059999333" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547059999333" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is Logo Image present
    Then Validate AlbumImg is present
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
    Then Click on Subscribe Button
    Then Validate is Logo Image present
    Then Validate AlbumImg is present
    Then Validate Subscribe thankyou messages and Status of User "7059999333"
    Then Validate User "2547059999333" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547059999333" DM Log Details for Activity Type "201" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547059999333" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547059999333" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
    Then Click on Ok Button

  Scenario: Create a User Account using Signup Page
    Then Validate SignUp is present
    Then Validate Mobile Number Label and inside Value "7059999333" in SignUp Page
    Then Enter the Password and Confrim Password "7059999333"
    Then Validate Cancel and Continue Button is Present in SignUp Page
    Then Click on Continue Button in SignUp Page
    Then Validate SignUp User "7059999333" data from DIAUS DB

  Scenario: Active the User using call back API and HIT Myaccount API and Validate the User Status.
    Then Activate or DeActivate the User "7059999333,SAFARI_MAIN_2,50.00,SAFARICOM,ACT" using "Packs_CallBack_API" Packs Callback API
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    Then Validate User "2547059999333" DM Log Details for Activity Type "25" from DIAUS DB "DIAUS_DB_URL"
    When Navigate to url "SAFARICOM_Myaccount_API_URL"
    Then Validate is Logo Image present
    Then Validate AlbumImg is present
    Then Validate Current Plan Heading and All Active Plan text is Present
    Then Validate Access Service and UnSubscribe Button is Present
    Then Validate Current Active plan Amount with Symbol
    Then Click on "Access Service" Button in MyAccount Page


  Scenario: Navigate Plan API and Join My Family Account Using Click on Join Account Button
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    When Navigate to url "SAFARICOM_Plans_API_URL"
    Then Enter the Mobile Number "7059999333" and Password "7059999333"
    Then Click on Join Button

  Scenario: Open the New and Remove the Number from Mod Header
    Given Open New Tab and remove the Number "2547059999333" in Mod Header
    
    Scenario: Quit the Browser
    Then Quit the browser