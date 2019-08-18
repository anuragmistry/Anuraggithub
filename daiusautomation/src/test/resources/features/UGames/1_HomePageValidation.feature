Feature: Ugmaes Portal Home Page Validation

Scenario: Launching browser and setting headers
	Given Launch the browser
	And set headers with "NewUser" number
	Given Reading test data "UGames_EXCEL_FILE_PATH"
	When navigate to url "UGames_Portal_Url"

Scenario: Validating Home page logo image
	  Then Validate portal Logo Text
   	  Then Click and Validate Portal logo link
   	  Then Validate cookie notice and click on Entendido button
   	  Then Validate cookie notice
   	  Then Click on aqui link and Navigate to cookie Page
   	  
Scenario: Validating Menu Option 
	  Then Validate ic-Menu Image
	  Then Click on Ic-Menu icon
	  Then Validate Menu Header Title
	  Then Validate Menu Header text
      Then Validate Menu name and Image
   	  
Scenario: Validating service promotion text banner
 	 Then Validate the Service promotion text
 		 
Scenario: Validate Content Banner
	Then Validate is Content banner present
	
Scenario: Validate Categories Button	
	Then Validate all Categories Button Set
	
Scenario: Validate Download Banner and download icon	
    Then Validate Download Banner in Home page 
    
Scenario: Validate module header and carousel item
    Then Validate module header and carousel item
    Then Validate module content list item
    
Scenario: Validate Footer link
    Then Footer section is present
    Then Validate footer links are present
    
Scenario: Validating Search in HomePage
  	 Then Validate ic search icon
  	 And  Validate search box inside text
  	 Then Click on Search icon
  	 Then Validate Search "Pang Adventures" text with "Success Content"
  	 Then Click on Search icon
  	 Then Validate Search "NotFound" text with "Noresults Content"
  	       
#Scenario: Close the Browser after complete feature
#  	Then close browser
#  	Given KIll the Chrome exe Process
  	