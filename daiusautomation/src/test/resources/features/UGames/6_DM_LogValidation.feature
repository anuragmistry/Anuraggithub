Feature: Ugames Portal DM Log Validation for Subscription Flow

  Scenario: Launch the portal with DM URL for Ugames Portal (Generic Flow)
    Given Launch the browser
    Then Deactivate the Active User msisdn "1113339996633" from app "200" and pack "20002"
    Then Delete "DIAUS_UK_DB" the Log Entry for User "1113339996633" form DM Log Table
    Given Set the Headers with User Agent
    Given Set "x-up-subno" with "1113339996633" in Header
    Given Add "x-control-id" with "2dfs01480" in Mod Header
    When Navigate to url "Ugames_DM_URL_GenericFlow"

  Scenario: Validate DM subscriptions flow
    Then Validate User "1113339996633" DM Log Details for Activity Type "48" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_UK_DB_URL"
#   Then Validate "DIAUS_UK_DB" User "1113339996633" DM Log details with Action "Landing_Subscription_Page" for DM Subscription flow
    Then Get all Cookies value
    Then Validate is Ugames SlideShow Banner present
    Then Click on "UGames" Subscribe Button
    Then Validate User "1113339996633" DM Log Details for Activity Type "7" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_UK_DB_URL"
    Then Validate portal Logo Text
    Then Validate Subscription Tick image and text
    Then Validate Download Green Button
#   Then Validate User "1113339996633" DM Log Details for Activity Type "48" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_DB_URL"
#   Then Validate User "1113339996633" DM Log Details for Activity Type "7" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_DB_URL"
    Then Validate User "1113339996633" DM Log Details for Activity Type "25" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_UK_DB_URL"
    Then Validate User "1113339996633" DM Log Details for Activity Type "14" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_UK_DB_URL"
#   Then Validate "DIAUS_UK_DB" User "1113339996633" DM Log details with Action "Click_Subscription_Successfully" for DM Subscription flow
    Then Click on Download Green Button
    Then Close the Alert Container
    Then Validate the App Promotion text

  Scenario: Launch the portal with DM URL for Ugames Portal (Content Flow)
    Then Deactivate the Active User msisdn "111333555779966" from app "200" and pack "20002"
    Then Delete "DIAUS_UK_DB" the Log Entry for User "111333555779966" form DM Log Table
    Given Change the Number "111333555779966" in Mod Header
    When Navigate to url "Ugames_DM_URL_ContentFlow"

  Scenario: Validate DM subscriptions flow
    Then Validate User "111333555779966" DM Log Details for Activity Type "48" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_UK_DB_URL"
#   Then Validate "DIAUS_UK_DB" User "111333555779966" DM Log details with Action "Landing_Subscription_Page" for DM Subscription flow
    Then Get all Cookies value
    Then Validate is Subscribe Game image and Name
    Then Validate is Promption Text
    Then Validate NoThanks and Active Button is Present
    Then Click on "UGamesContentFlow" Subscribe Button
    Then Validate User "111333555779966" DM Log Details for Activity Type "7" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DDIAUS_UK_DB_URL"
    Then Validate Subscription Tick image and text
    Then Validate Download Green Button
    Then Validate User "111333555779966" DM Log Details for Activity Type "25" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_UK_DB_URL"
    Then Validate User "111333555779966" DM Log Details for Activity Type "14" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_UK_DB_URL"
#   Then Validate "DIAUS_UK_DB" User "111333555779966" DM Log details with Action "Click_Subscription_Successfully" for DM Subscription flow
   
   #DM Log and tlog validation in single function
    
   Then Validate User "111333555779966" DM Log Details for Activity Type "7" and Campaign Data Set "Default" and I want validate Prism TLogs Campaign Data "true" and compare with "DIAUS_UK_DB_URL" Database
    
    Then Click on Download Green Button
    Then Close the Alert Container

  Scenario: Close the Browser after complete feature
    Then Deactivate the Active User msisdn "1113339996633" from app "200" and pack "20002"
    Then Deactivate the Active User msisdn "111333555779966" from app "200" and pack "20002"
    Then close browser
