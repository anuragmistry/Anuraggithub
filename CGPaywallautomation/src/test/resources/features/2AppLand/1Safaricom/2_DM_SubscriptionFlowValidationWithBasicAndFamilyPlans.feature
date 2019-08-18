Feature: Subscription Flow for APPLAND Using DM URL via Wifi and 3G Flow

 Scenario: Navigate the Portal and Delete all the Cookies Value
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    Then Delete All Signed Users from DIAUS DB 
    
Scenario: Delete the DB Record fro Packs and DM log table.
	 Then Delete the User "7057777777" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2547057777777" form DM Log Table
	 

Scenario: User Subscribe Flow with Basic Plan via DM url(With out MSISDN Header)
    When Navigate to url "Safaricom_Plans_API_DM_URL"
    Then Validate is Logo Image present
	Then Click on "Basic" Button
	Then Validate "Basic" Subscribe Packs details message
	Then Validate Joint Family Account Button is Present
	Then Validate Terms and Conditions text and Value
	Then Click on "Basic" Continue Button
	Then Validate is Logo Image present
	Then Validate AlbumImg is present
	Then Enter the MSISDN "7057777777"
	Then Validate Subscribe messages
	Then Validate Terms and Conditions and Value
	Then Click on the Confirm Button
	
#	Then Validate is Logo Image present
#	Then Validate AlbumImg is present
#	Then Validate Re-Send OTP Text Link
#    Then Get the OTP Value for MSISDN "7057777777" from DB and Enter the OTP
#    Then Click on the Confirm Button
    
    Then Get the current domain Cookies value
    Then Validate User "2547057777777" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is Logo Image present
	Then Validate AlbumImg is present
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
    Then Click on Subscribe Button
    Then Validate is Logo Image present
	Then Validate AlbumImg is present
	Then Validate Subscribe thankyou messages and Status of User "7057777777"
	Then Validate User "2547057777777" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547057777777" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547057777777" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
	Then Click on Ok Button

 Scenario: Active the user using call back API and DM Task Details.
     Then Activate or DeActivate the User "7057777777,SAFARI_MAIN_1,30.00,Safaricom,ACT" using "Packs_CallBack_API" Packs Callback API
     Then Validate DM task information after redirect with callBack url
     Then Validate User "2547057777777" DM Log Details for Activity Type "25" from DIAUS DB "DIAUS_DB_URL"
     
 Scenario: HIT Myaccount API and Validate the user status.
	 When Navigate to url "Page_Load_Url"
	 When Delete all domain Cookies Value
	 When Navigate to url "Safaricom_Myaccount_API_URL"
	 Then Validate is Logo Image present
	 Then Validate AlbumImg is present
	 Then Enter the MSISDN "7057777777"
	 Then Validate Subscribe messages
	 Then Validate Terms and Conditions and Value
	 Then Click on the Confirm Button
	 
#	 Then Validate is Logo Image present
#	 Then Validate AlbumImg is present
#	 Then Validate Re-Send OTP Text Link
#     Then Get the OTP Value for MSISDN "7057777777" from DB and Enter the OTP
#     Then Click on the Confirm Button
     
     Then Validate is Logo Image present
	 Then Validate AlbumImg is present
     Then Validate Current Plan Heading and All Active Plan text is Present
     Then Validate Access Service and UnSubscribe Button is Present
     Then Validate Current Active plan Amount with Symbol
     Then Click on "Access Service" Button in MyAccount Page
 
# ####Subscription Flow for Family pack with DM url
 Scenario: Navigate the Portal and Delete all the Cookies Value
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    
Scenario: Delete the DB Record fro Packs and UserManagement and DM log table.
	 Then Delete the User "7058888888" records from Packs DB
	 Then Delete "DIAUS_DB_URL" the User Entry "7058888888" form DIAUS UserManagement Table
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2547058888888" form DM Log Table
	
Scenario: User Subscribe Flow with Family Plan with out MSISDN in Header
    When Navigate to url "Safaricom_Plans_API_DM_URL"
    Then Validate is Logo Image present
	Then Click on "Family" Button
	Then Validate "Family" Subscribe Packs details message
	Then Validate Joint Family Account Button is Present
	Then Validate Terms and Conditions text and Value
	Then Click on "Family" Continue Button
	Then Validate is Logo Image present
	Then Validate AlbumImg is present
	Then Enter the MSISDN "7058888888"
	Then Validate Subscribe messages
	Then Validate Terms and Conditions and Value
	Then Click on the Confirm Button
	
#	Then Validate is Logo Image present
#	Then Validate AlbumImg is present
#	Then Validate Re-Send OTP Text Link
#    Then Get the OTP Value for MSISDN "7058888888" from DB and Enter the OTP
#    Then Click on the Confirm Button
    
    Then Get the current domain Cookies value
    Then Validate User "2547058888888" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is Logo Image present
	Then Validate AlbumImg is present
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
    Then Click on Subscribe Button
    Then Validate is Logo Image present
	Then Validate AlbumImg is present
	Then Validate Subscribe thankyou messages and Status of User "7058888888"
	Then Validate User "2547058888888" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547058888888" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547058888888" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
	Then Click on Ok Button
	
Scenario: Create a User Account using Signup Page
	Then Validate SignUp is present
	Then Validate Mobile Number Label and inside Value "7058888888" in SignUp Page
	Then Enter the Password and Confrim Password "7058888888"
	Then Validate Cancel and Continue Button is Present in SignUp Page
	Then Click on Continue Button in SignUp Page
	Then Validate SignUp User "7058888888" data from DIAUS DB

 Scenario: Active the user using call back API and DM Task Details.
     Then Activate or DeActivate the User "7058888888,SAFARI_MAIN_2,50.00,Safaricom,ACT" using "Packs_CallBack_API" Packs Callback API
     Then Validate DM task information after redirect with callBack url
     Then Validate User "2547058888888" DM Log Details for Activity Type "25" from DIAUS DB "DIAUS_DB_URL"
 
 Scenario: Active the User using call back API and HIT Myaccount API and Validate the User Status.
	 When Navigate to url "Page_Load_Url"
	 When Delete all domain Cookies Value
	 When Navigate to url "Safaricom_Myaccount_API_URL"
	 Then Validate is Logo Image present
	 Then Validate AlbumImg is present
	 Then Enter the MSISDN "7058888888"
	 Then Validate Subscribe messages
	 Then Validate Terms and Conditions and Value
	 Then Click on the Confirm Button
	 
#	 Then Validate is Logo Image present
#	 Then Validate AlbumImg is present
#	 Then Validate Re-Send OTP Text Link
#     Then Get the OTP Value for MSISDN "7058888888" from DB and Enter the OTP
#     Then Click on the Confirm Button
     
     Then Validate is Logo Image present
	 Then Validate AlbumImg is present
     Then Validate Current Plan Heading and All Active Plan text is Present
     Then Validate Access Service and UnSubscribe Button is Present
     Then Validate Current Active plan Amount with Symbol
     Then Click on "Access Service" Button in MyAccount Page
     
Scenario: Join My Family Account     
     Then Validate My Family is present
     Then Enter the Mobile Number "7058888888" and Password "7058888888"
     Then Click on Join Button
     
Scenario: Navigate Plan API and Join My Family Account Using Click on Join Account Button
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    When Navigate to url "Safaricom_Plans_API_URL"
    Then Click on "Family" Button
    Then Click on Joint Family Account Button
    Then Validate My Family is present
    Then Enter the Mobile Number "7058888888" and Password "7058888888"
    Then Click on Join Button  


########   3G Flow  ##############   
######## User Subscribe with Basic Plan ###########

Scenario: Delete the DB Record fro Packs and DM log table.
	 Then Delete the User "7054444444" records from Packs DB
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2547054444444" form DM Log Table
	 
Scenario: Navigate the Plans API and Set the with MSISDN in Header (for 3G Flow)
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    Given Open New Tab and Set "x-up-subno" with Number "2547054444444" in Mod Header
    
Scenario: User Subscribe Flow with Basic Plan with out MSISDN in Header
    When Navigate to url "Safaricom_Plans_API_DM_URL"
    Then Validate is Logo Image present
	Then Click on "Basic" Button
	Then Validate "Basic" Subscribe Packs details message
	Then Validate Joint Family Account Button is Present
	Then Validate Terms and Conditions text and Value
	Then Click on "Basic" Continue Button
    Then Get the current domain Cookies value
    Then Validate User "2547054444444" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is Logo Image present
	Then Validate AlbumImg is present
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
    Then Click on Subscribe Button
    Then Validate is Logo Image present
	Then Validate AlbumImg is present
	Then Validate Subscribe thankyou messages and Status of User "7054444444"
	Then Validate User "2547054444444" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547054444444" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547054444444" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
	Then Click on Ok Button
    
 Scenario: Active the user using call back API and HIT Myaccount API and Validate the user status.
     Then Activate or DeActivate the User "7054444444,SAFARI_MAIN_1,30.00,Safaricom,ACT" using "Packs_CallBack_API" Packs Callback API
	 When Navigate to url "Page_Load_Url"
	 When Delete all domain Cookies Value
	 When Navigate to url "Safaricom_Myaccount_API_URL"
	 Then Validate is Logo Image present
	 Then Validate AlbumImg is present
	 Then Validate Current Active plan Amount with Symbol
     Then Validate Current Plan Heading and All Active Plan text is Present
     Then Validate Access Service and UnSubscribe Button is Present
     Then Click on "Access Service" Button in MyAccount Page
     
Scenario: Open the New and Remove the Number from Mod Header
     Given Open New Tab and remove the Number "2547054444444" in Mod Header
     
    
############   3G Flow  ###############   
########### User Subscribe with Family Plan ###########
   
 Scenario: Delete the DB Record fro Packs and DM log table.
	 Then Delete the User "7056666666" records from Packs DB
	 Then Delete "DIAUS_DB_URL" the User Entry "7056666666" form DIAUS UserManagement Table
	 Then Delete "DIAUS_INDIA_DB" the Log Entry for User "2547056666666" form DM Log Table
	 
Scenario: Navigate the Plans API and Set the with MSISDN in Header (for 3G Flow)
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    Given Open New Tab and Set "x-up-subno" with Number "2547056666666" in Mod Header
    
Scenario: User Subscribe Flow with Family Plan with out MSISDN in Header
    When Navigate to url "Safaricom_Plans_API_DM_URL"
    Then Validate is Logo Image present
	Then Click on "Family" Button
	Then Validate "Family" Subscribe Packs details message
	Then Validate Joint Family Account Button is Present
	Then Validate Terms and Conditions text and Value
	Then Click on "Family" Continue Button
    Then Get the current domain Cookies value
    Then Validate User "2547056666666" DM Log Details for Activity Type "48" from DIAUS DB "DIAUS_DB_URL"
    Then Validate is Logo Image present
	Then Validate AlbumImg is present
    Then Validate Pack Detials messages
    Then Validate Terms and Conditions and Value
    Then Click on Subscribe Button
    Then Validate is Logo Image present
	Then Validate AlbumImg is present
	Then Validate Subscribe thankyou messages and Status of User "7056666666"
	Then Validate User "2547056666666" DM Log Details for Activity Type "7" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547056666666" DM Log Details for Activity Type "13" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "2547056666666" DM Log Details for Activity Type "60" from DIAUS DB "DIAUS_DB_URL"
	Then Click on Ok Button
	
Scenario: Create a User Account using Signup Page
	Then Validate SignUp is present
	Then Validate Mobile Number Label and inside Value "7056666666" in SignUp Page
	Then Enter the Password and Confrim Password "7056666666"
	Then Validate Cancel and Continue Button is Present in SignUp Page
	Then Click on Continue Button in SignUp Page
	Then Validate SignUp User "7056666666" data from DIAUS DB
 
 Scenario: Active the User using call back API and HIT Myaccount API and Validate the User Status.
     Then Activate or DeActivate the User "7056666666,SAFARI_MAIN_2,50.00,Safaricom,ACT" using "Packs_CallBack_API" Packs Callback API
	 When Navigate to url "Page_Load_Url"
	 When Delete all domain Cookies Value
	 When Navigate to url "Safaricom_Myaccount_API_URL"
	 Then Validate is Logo Image present
	 Then Validate AlbumImg is present
     Then Validate Current Plan Heading and All Active Plan text is Present
     Then Validate Access Service and UnSubscribe Button is Present
     Then Validate Current Active plan Amount with Symbol
     Then Click on "Access Service" Button in MyAccount Page
     
Scenario: Join My Family Account     
     Then Validate My Family is present
     Then Enter the Mobile Number "7056666666" and Password "7056666666"
     Then Click on Join Button
     
Scenario: Navigate Plan API and Join My Family Account Using Click on Join Account Button
    When Navigate to url "Page_Load_Url"
    When Delete all domain Cookies Value
    When Navigate to url "Safaricom_Plans_API_URL"
    Then Click on "Family" Button
    Then Click on Joint Family Account Button
    Then Validate My Family is present
    Then Enter the Mobile Number "7056666666" and Password "7056666666"
    Then Click on Join Button
    
Scenario: Open the New and Remove the Number from Mod Header
     Given Open New Tab and remove the Number "2547056666666" in Mod Header
        