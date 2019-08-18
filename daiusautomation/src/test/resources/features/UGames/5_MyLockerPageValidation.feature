Feature: Ugmaes Portal User Subscribe Preview Page and Download Page  Validation

Scenario: Launching browser and setting headers
	Given Launch the browser
	And set headers with "NewUser" number
	Given Reading test data "UGames_EXCEL_FILE_PATH"
	When navigate to url "UGames_Portal_Url"

Scenario: Validating My Downloaded Games
	 Then Click on Ic-Menu icon
	 Then Click on ic-menu "Mis juegos descargados" option
	 Then Validate My Downloded Games
	 
#Scenario: Close the Browser after complete feature
#  	Then close browser