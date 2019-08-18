Feature: DM Log Validation for Subscription Flow

  Scenario: Launch the portal with DM URL for Intimax Portal (Generic Flow) and with x-up-subno Header
    Given Launch the browser
    Then Deactivate the Active User msisdn "110333990777406" from app "141" and pack "16"
    Then Delete "DIAUS_UK_DB" the Log Entry for User "110333990777406" form DM Log Table
    Given Set the Headers with User Agent
    Given Set "x-up-subno" with "110333990777406" in Header
    When Navigate to url "Intimax_DM_URL_GenericFlow"

  Scenario: Validate DM subscriptions flow
    Then Validate "DIAUS_UK_DB" User "110333990777406" DM Log details with Action "Landing_Subscription_Page" for DM Subscription flow
    Then Get all Cookies value
    Then Validate is Portal Banner present
    Then Validate is Subscribe Text
    Then Click on Subscribe Active Button
    Then Validate is Subscribe Tick image and Text
    Then Validate "DIAUS_UK_DB" User "110333990777406" DM Log details with Action "Click_Subscription_Successfully" for DM Subscription flow
    Then Click on Continue Button

  Scenario: Launch the portal with DM URL for Intimax Portal (Content Flow) and with x-up-subno Header
    Then Deactivate the Active User msisdn "110333990777407" from app "141" and pack "16"
    Then Delete "DIAUS_UK_DB" the Log Entry for User "110333990777407" form DM Log Table
    Given Change the Number "110333990777407" in Mod Header
    When Navigate to url "Intimax_DM_URL_ContentFlow"

  Scenario: Validate DM subscriptions flow
    Then Validate "DIAUS_UK_DB" User "110333990777407" DM Log details with Action "Landing_Subscription_Page" for DM Subscription flow
    Then Get all Cookies value
    Then Validate is Portal Banner present
    Then Validate is Subscribe Text
    Then Click on Subscribe Active Button
    Then Validate is Subscribe Tick image and Text
    Then Validate "DIAUS_UK_DB" User "110333990777407" DM Log details with Action "Click_Subscription_Successfully" for DM Subscription flow
    Then Click on Continue Button

  Scenario: Close the Browser after complete feature
    Then Deactivate the Active User msisdn "110333990777406" from app "141" and pack "16"
    Then Deactivate the Active User msisdn "110333990777407" from app "141" and pack "16"
    Then close browser
