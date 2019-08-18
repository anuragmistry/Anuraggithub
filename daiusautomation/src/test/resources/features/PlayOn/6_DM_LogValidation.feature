Feature: DM Log Validation for Subscription Flow

  Scenario: Launch the portal with DM URL for PlayOn Portal (Generic Flow) and with x-up-subno Header
    Given Launch the browser
    Then Deactivate the Active User msisdn "111333999771391" from app "153" and pack "18"
    Then Delete "DIAUS_UK_DB" the Log Entry for User "111333999771391" form DM Log Table
    Given Set the Headers with User Agent
    Given Set "x-up-subno" with "111333999771391" in Header
    When Navigate to url "PlayOn_DM_URL_GenericFlow"

  Scenario: Validate DM subscriptions Generic flow
    Then Validate "DIAUS_UK_DB" User "111333999771391" DM Log details with Action "Landing_Subscription_Page" for DM Subscription flow
    Then Get all Cookies value
    Then Validate is Portal Banner present
    Then Validate is Subscribe Text
    Then Click on Subscribe Active Button
    Then Validate is Subscribe Tick image and Text
    Then Validate "DIAUS_UK_DB" User "111333999771391" DM Log details with Action "Click_Subscription_Successfully" for DM Subscription flow
    Then Click on Continue Button

  Scenario: Launch the portal with DM URL for PlayOn Portal (Content Flow) and with x-up-subno Header
    Then Deactivate the Active User msisdn "111333555779961" from app "153" and pack "18"
    Then Delete "DIAUS_UK_DB" the Log Entry for User "111333555779961" form DM Log Table
    Given Change the Number "111333555779961" in Mod Header
    When Navigate to url "PlayOn_DM_URL_ContentFlow"

  Scenario: Validate DM subscriptions Content flow
    Then Validate "DIAUS_UK_DB" User "111333555779961" DM Log details with Action "Landing_Subscription_Page" for DM Subscription flow
    Then Get all Cookies value
    Then Validate is Portal Banner present
    Then Validate is Subscribe Text
    Then Click on Subscribe Active Button
    Then Validate is Subscribe Tick image and Text
    Then Validate "DIAUS_UK_DB" User "111333555779961" DM Log details with Action "Click_Subscription_Successfully" for DM Subscription flow
    Then Click on Continue Button

  Scenario: Close the Browser after complete feature
    Then Deactivate the Active User msisdn "111333999771391" from app "153" and pack "18"
    Then Deactivate the Active User msisdn "111333555779961" from app "153" and pack "18"
    Then close browser
