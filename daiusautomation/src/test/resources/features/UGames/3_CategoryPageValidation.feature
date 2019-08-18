Feature: Ugmaes Portal Category Page Validation

#Scenario: Launching browser and setting headers
#	Given Launch the browser
#	And set headers with "NewUser" number
#	Given Reading test data "UGames_EXCEL_FILE_PATH"
#	When navigate to url "UGames_Portal_Url"

Scenario: Validating Categories Page
	  Then Click on Ic-Menu icon
	  Then Click on Categories Option
	  Then Validate portal Logo Text
	  Then Validate All Category List in Category Page
	  Then Footer section is present
	  Then Validate footer links are present
  	  Then Click and Validate Portal logo link