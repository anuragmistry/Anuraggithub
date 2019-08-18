Feature: DM Log Validation for Subscription Flow

Scenario: Launch the portal with DM URL for Tourist Portal (Generic Flow) and with x-up-subno Header
    Then Validate Campaign Data in Prism TLogs
    Given Launch the browser
	
	Given Set the Headers with User Agent
	Given Set "x-up-subno" with "111333999777337" in Header
	When Navigate to url "DM_URL_GenericFlow"
	
Scenario: Validate DM subscriptions flow
    Then Validate "DIAUS_UK_DB" User "111333999777337" DM Log details with Action "Landing_Subscription_Page" for DM Subscription flow
    Then Get the current domain Cookies value
    Then Validate is Tourist Banner present
    Then Validate is Subscribe Text
    Then Click on Subscribe Active Button
    Then Validate is Subscribe Tick image and Text
    Then Validate "DIAUS_UK_DB" User "111333999777337" DM Log details with Action "Click_Subscription_Successfully" for DM Subscription flow
	Then Click on Continue Button
	
	
Scenario: Launch the portal with DM URL for Tourist Portal (Generic Flow) and with x-up-subno Header
	Given Change the Number "111333555779933" in Mod Header
	When Navigate to url "DM_URL_ContentFlow"

Scenario: Validate DM subscriptions flow
    Then Validate "DIAUS_UK_DB" User "111333555779933" DM Log details with Action "Landing_Subscription_Page" for DM Subscription flow
    Then Get the current domain Cookies value
    Then Validate is Tourist Banner present
    Then Validate is Subscribe Text
    Then Click on Subscribe Active Button
    Then Validate is Subscribe Tick image and Text
    Then Validate "DIAUS_UK_DB" User "111333555779933" DM Log details with Action "Click_Subscription_Successfully" for DM Subscription flow
    Then Click on Continue Button

Scenario: Close the Browser after complete feature
    Then Close the browser

Then Validate User "2549383883883" DM Log Details for Activity Type "7" and Campaign Data Set "CampaignSource=onmobile&CampaignMedium=onmobile&CampaignID=onmobile&CampaignSessionID=Tyroo" from DIAUS DB "DIAUS_DB_URL"
Then Validate User "2549383883883" DM Log Details for Activity Type "7" and Campaign Data Set "CampaignSource=onmobile&CampaignMedium=onmobile&CampaignID=onmobile&CampaignSessionID=Tyroo" from DIAUS DB "DIAUS_DB_URL"


