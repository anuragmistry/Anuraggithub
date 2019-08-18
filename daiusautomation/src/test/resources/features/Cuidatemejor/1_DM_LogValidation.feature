Feature: DM Log Validation for Subscription Flow

  Scenario: Launch the portal with DM URL for Cuidate Mejor Portal (Generic Flow) and with x-up-subno Header
    Given Launch the browser
    Then Deactivate the Active User msisdn "111033909781397" from app "438" and pack "43802"
    Then Delete "DIAUS_UK_DB" the Log Entry for User "111033909781397" form DM Log Table
    Given Set the Headers with User Agent
    Given Set "x-up-subno" with "111033909781397" in Header
    When Navigate to url "Cuidatemejor_DM_URL_GenericFlow"

  Scenario: Validate DM subscriptions Generic flow
    Then Validate User "111033909781397" DM Log Details for Activity Type "48" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_UK_DB_URL"
#   Then Validate "DIAUS_UK_DB" User "111233909781395" DM Log details with Action "Landing_Subscription_Page" for DM Subscription flow
    Then Get all Cookies value
    Then Validate is Portal Banner present
    Then Validate is Subscribe Text
    Then Click on Subscribe Active Button
    Then Validate User "111033909781397" DM Log Details for Activity Type "7" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_UK_DB_URL"
    Then Validate is Subscribe Tick image and Text
    Then Validate User "111033909781397" DM Log Details for Activity Type "25" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_UK_DB_URL"
    Then Validate User "111033909781397" DM Log Details for Activity Type "14" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_UK_DB_URL"
#   Then Validate "DIAUS_UK_DB" User "111233909781395" DM Log details with Action "Click_Subscription_Successfully" for DM Subscription flow
    Then Click on Continue Button

  Scenario: Launch the portal with DM URL for Cuidate Mejor Portal (Content Flow) and with x-up-subno Header
    Then Deactivate the Active User msisdn "111033909781398" from app "438" and pack "43802"
    Then Delete "DIAUS_UK_DB" the Log Entry for User "111033909781398" form DM Log Table
    Given Change the Number "111033909781398" in Mod Header
    When Navigate to url "Cuidatemejor_DM_URL_ContentFlow"

  Scenario: Validate DM subscriptions Content flow
    Then Validate User "111033909781398" DM Log Details for Activity Type "48" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_UK_DB_URL"
    Then Validate "DIAUS_UK_DB" User "111033909781398" DM Log details with Action "Landing_Subscription_Page" for DM Subscription flow
    Then Get all Cookies value
    Then Validate is Portal Banner present
    Then Validate is Subscribe Text
    Then Click on Subscribe Active Button
    Then Validate User "111033909781398" DM Log Details for Activity Type "25" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_UK_DB_URL"
    Then Validate User "111033909781398" DM Log Details for Activity Type "14" and Campaign Data Set "CampaignSource=auto-source&CampaignMedium=auto-medium&CampaignID=auto-campaign&CampaignSessionID=AdvanceMobile" from DIAUS DB "DIAUS_UK_DB_URL"
    Then Validate is Subscribe Tick image and Text
#   Then Validate "DIAUS_UK_DB" User "111233909781396" DM Log details with Action "Click_Subscription_Successfully" for DM Subscription flow
    Then Click on Continue Button

  Scenario: Close the Browser after complete feature
    Then Deactivate the Active User msisdn "111033909781397" from app "438" and pack "43802"
    Then Deactivate the Active User msisdn "111033909781398" from app "438" and pack "43802"
    Then close browser
