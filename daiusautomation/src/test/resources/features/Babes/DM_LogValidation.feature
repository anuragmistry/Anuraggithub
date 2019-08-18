Feature: DM Log Validation for Subscription Flow

  Scenario: Launch the portal with DM URL for Babes Portal (Generic Flow) and with x-up-subno Header
    Given Launch the browser
    Then Deactivate the Active User msisdn "116643999771405" from app "577" and pack "57701"
    Then Delete "DIAUS_UK_DB" the Log Entry for User "116643999771405" form DM Log Table
    Given Set the Headers with User Agent
    Given Set "x-up-subno" with "116643999771405" in Header
    When Navigate to url "Babes_DM_URL_GenericFlow"

  Scenario: Validate DM subscriptions Generic flow
	  Then Validate User "116643999771405" DM Log Details for Activity Type "48" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_UK_DB_URL"
#   Then Validate "DIAUS_UK_DB" User "116643999771405" DM Log details with Action "Landing_Subscription_Page" for DM Subscription flow
    Then Get all Cookies value
    Then Validate is Portal Banner present
    Then Validate is Subscribe Text
    Then Click on Subscribe Active Button
    Then Validate User "116643999771405" DM Log Details for Activity Type "7" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_UK_DB_URL"
    Then Validate is Subscribe Tick image and Text
    Then Validate User "116643999771405" DM Log Details for Activity Type "25" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_UK_DB_URL"
    Then Validate User "116643999771405" DM Log Details for Activity Type "14" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_UK_DB_URL"    
#   Then Validate "DIAUS_UK_DB" User "116643999771405" DM Log details with Action "Click_Subscription_Successfully" for DM Subscription flow
    Then Click on Continue Button

  Scenario: Launch the portal with DM URL for Babes Portal (Content Flow) and with x-up-subno Header
    Then Deactivate the Active User msisdn "117643999771406" from app "577" and pack "57701"
    Then Delete "DIAUS_UK_DB" the Log Entry for User "117643999771406" form DM Log Table
    Given Change the Number "117643999771406" in Mod Header
    When Navigate to url "Babes_DM_URL_ContentFlow"

  Scenario: Validate DM subscriptions Content flow
   Then Validate User "117643999771406" DM Log Details for Activity Type "48" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_UK_DB_URL"
#  Then Validate "DIAUS_UK_DB" User "117643999771406" DM Log details with Action "Landing_Subscription_Page" for DM Subscription flow
   Then Get all Cookies value
   Then Validate is Portal Banner present
   Then Validate is Subscribe Text
   Then Click on Subscribe Active Button
   Then Validate User "117643999771406" DM Log Details for Activity Type "7" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_UK_DB_URL"
   Then Validate is Subscribe Tick image and Text
   Then Validate User "117643999771406" DM Log Details for Activity Type "25" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_UK_DB_URL"
   Then Validate User "117643999771406" DM Log Details for Activity Type "14" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_UK_DB_URL"
#  Then Validate "DIAUS_UK_DB" User "117643999771406" DM Log details with Action "Click_Subscription_Successfully" for DM Subscription flow
   Then Click on Continue Button

  Scenario: Close the Browser after complete feature
    Then Deactivate the Active User msisdn "116643999771405" from app "577" and pack "57701"
    Then Deactivate the Active User msisdn "117643999771406" from app "577" and pack "57701"
    Then close browser
