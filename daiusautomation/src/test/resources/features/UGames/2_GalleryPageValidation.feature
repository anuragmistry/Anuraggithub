Feature: Ugmaes Portal Gallery Page Validation

#Scenario: Launching browser and setting headers
#	Given Launch the browser
#	And set headers with "NewUser" number
#	Given Reading test data "UGames_EXCEL_FILE_PATH"
#	When navigate to url "UGames_Portal_Url"
	
Scenario: Validating gallery in GellaryPage
     Then Click on Category Button "TOP DESCARGAS" Name
   #  Then Click on "1" Category Button
     Then Validate portal Logo Text
     Then Footer section is present
  	 Then Validate footer links are present
  	 Then Validate Category title in Gallery Page
  	 Then Validate all Ranking item
  	 Then Validate all Gallery Content list item
  	 
  	 
