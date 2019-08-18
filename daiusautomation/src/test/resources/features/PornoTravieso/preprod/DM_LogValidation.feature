Feature: DM Log Validation for Subscription Flow

  Scenario: Launch the portal with DM URL for PornoTravieso Portal (Generic Flow) and with x-up-subno Header
    Given Launch the browser "preprodconfig"
    Then Deactivate the Active User msisdn "111343999771403" from app "605" and pack "60501"
    Then Delete "DIAUS_UK_DB" the Log Entry for User "111343999771403" form DM Log Table
    Given Set the Headers with User Agent
    Given Set "x-up-subno" with "111343999771403" in Header
    When Navigate to url "PornoTravieso_DM_URL_GenericFlow"

  Scenario: Validate DM subscriptions Generic flow
    Then Validate "DIAUS_UK_DB" User "111343999771403" DM Log details with Action "Landing_Subscription_Page" for DM Subscription flow
    Then Get all Cookies value
    Then Validate is Portal Banner present
    Then Validate is Subscribe Text
    Then Click on Subscribe Active Button
    Then Validate is Subscribe Tick image and Text
    Then Validate "DIAUS_UK_DB" User "111343999771403" DM Log details with Action "Click_Subscription_Successfully" for DM Subscription flow
    Then Click on Continue Button
    Then Delete "DIAUS_UK_DB" the Log Entry for User "111343999771403" form DM Log Table

  Scenario: Launch the portal with DM URL for PornoTravieso Portal (Content Flow) and with x-up-subno Header
    Then Deactivate the Active User msisdn "111343999771404" from app "605" and pack "60501"
    Then Delete "DIAUS_UK_DB" the Log Entry for User "111343999771404" form DM Log Table
    Given Change the Number "111343999771404" in Mod Header
    When Navigate to url "PornoTravieso_DM_URL_ContentFlow"

  Scenario: Validate DM subscriptions Content flow
    Then Validate "DIAUS_UK_DB" User "111343999771404" DM Log details with Action "Landing_Subscription_Page" for DM Subscription flow
    Then Get all Cookies value
    Then Validate is Portal Banner present
    Then Validate is Subscribe Text
    Then Click on Subscribe Active Button
    Then Validate is Subscribe Tick image and Text
    Then Validate "DIAUS_UK_DB" User "111343999771404" DM Log details with Action "Click_Subscription_Successfully" for DM Subscription flow
    Then Click on Continue Button
    Then Delete "DIAUS_UK_DB" the Log Entry for User "111343999771404" form DM Log Table

  Scenario: Close the Browser after complete feature
    Then Deactivate the Active User msisdn "111343999771403" from app "605" and pack "60501"
    Then Deactivate the Active User msisdn "111343999771404" from app "605" and pack "60501"
    Then close browser
