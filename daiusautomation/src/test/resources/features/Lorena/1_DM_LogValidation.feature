Feature: DM Log Validation for Subscription Flow

  Scenario: Launch the portal with DM URL for Lorena Portal (Generic Flow) and with x-up-subno Header
    Given Launch the browser
    Then Deactivate the Active User msisdn "111330099771393" from app "630" and pack "63001"
    Then Delete "DIAUS_UK_DB" the Log Entry for User "111330099771393" form DM Log Table
    Given Set the Headers with User Agent
    Given Set "x-up-subno" with "111330099771393" in Header
    When Navigate to url "Lorena_DM_URL_GenericFlow"

  Scenario: Validate DM subscriptions Generic flow
    Then Validate "DIAUS_UK_DB" User "111330099771393" DM Log details with Action "Landing_Subscription_Page" for DM Subscription flow
    Then Get all Cookies value
    Then Validate is Portal Banner present
    Then Validate is Subscribe Text
    Then Click on Subscribe Active Button
    Then Validate is Subscribe Tick image and Text
    Then Validate "DIAUS_UK_DB" User "111330099771393" DM Log details with Action "Click_Subscription_Successfully" for DM Subscription flow
    Then Click on Continue Button

  Scenario: Launch the portal with DM URL for Lorena Portal (Content Flow) and with x-up-subno Header
    Then Deactivate the Active User msisdn "111003555779972" from app "630" and pack "63001"
    Then Delete "DIAUS_UK_DB" the Log Entry for User "111003555779972" form DM Log Table
    Given Change the Number "111003555779972" in Mod Header
    When Navigate to url "Lorena_DM_URL_ContentFlow"

  Scenario: Validate DM subscriptions Content flow
    Then Validate "DIAUS_UK_DB" User "111003555779972" DM Log details with Action "Landing_Subscription_Page" for DM Subscription flow
    Then Get all Cookies value
    Then Validate is Portal Banner present
    Then Validate is Subscribe Text
    Then Click on Subscribe Active Button
    Then Validate is Subscribe Tick image and Text
    Then Validate "DIAUS_UK_DB" User "111003555779972" DM Log details with Action "Click_Subscription_Successfully" for DM Subscription flow
    Then Click on Continue Button

  Scenario: Close the Browser after complete feature
    Then Deactivate the Active User msisdn "111330099771393" from app "630" and pack "63001"
    Then Deactivate the Active User msisdn "111003555779972" from app "630" and pack "63001"
    Then close browser
