Feature: UIM Flow Validation 

Scenario: Launching browser and setting headers
	Given Launch the browser
	And set headers with "UIM" number
	When navigate to url "Tourist_Portal_Url"
	Then Validate UIM Gateway Page
	Then Validate UIM View Page and Enter MSISDN "112345674222"
	
Scenario: Close the Browser after complete feature
  Then close browser	