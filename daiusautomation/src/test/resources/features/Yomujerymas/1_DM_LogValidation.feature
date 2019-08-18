Feature: DM Log Validation for Subscription Flow

  Scenario: Launch the portal with DM URL for Yo Mujer y Mas Portal (Generic Flow) and with x-up-subno Header
    Given Launch the browser
    Then Deactivate the Active User msisdn "111233909781393" from app "439" and pack "43902"
    Then Delete "DIAUS_UK_DB" the Log Entry for User "111233909781393" form DM Log Table
    Given Set the Headers with User Agent
    Given Set "x-up-subno" with "111233909781393" in Header
    When Navigate to url "Yomujerymas_DM_URL_GenericFlow"

  Scenario: Validate DM subscriptions Generic flow
    Then Validate "DIAUS_UK_DB" User "111233909781393" DM Log details with Action "Landing_Subscription_Page" for DM Subscription flow
    Then Get all Cookies value
    Then Validate is Portal Banner present
    Then Validate is Subscribe Text
    Then Click on Subscribe Active Button
    Then Validate is Subscribe Tick image and Text
    Then Validate "DIAUS_UK_DB" User "111233909781393" DM Log details with Action "Click_Subscription_Successfully" for DM Subscription flow
    Then Click on Continue Button

  Scenario: Launch the portal with DM URL for Yo Mujer y Mas Portal (Content Flow) and with x-up-subno Header
    Then Deactivate the Active User msisdn "111233909781394" from app "439" and pack "43902"
    Then Delete "DIAUS_UK_DB" the Log Entry for User "111233909781394" form DM Log Table
    Given Change the Number "111233909781394" in Mod Header
    When Navigate to url "Yomujerymas_DM_URL_ContentFlow"

  Scenario: Validate DM subscriptions Content flow
    Then Validate "DIAUS_UK_DB" User "111233909781394" DM Log details with Action "Landing_Subscription_Page" for DM Subscription flow
    Then Get all Cookies value
    Then Validate is Portal Banner present
    Then Validate is Subscribe Text
    Then Click on Subscribe Active Button
    Then Validate is Subscribe Tick image and Text
    Then Validate "DIAUS_UK_DB" User "111233909781394" DM Log details with Action "Click_Subscription_Successfully" for DM Subscription flow
    Then Click on Continue Button

  Scenario: Close the Browser after complete feature
    Then Deactivate the Active User msisdn "111233909781393" from app "439" and pack "43902"
    Then Deactivate the Active User msisdn "111233909781394" from app "439" and pack "43902"
    Then close browser
