#### Download or Preview Page Validation ####
Feature: User PPU flow and Download Page Validation

Scenario: Launching browser and setting headers
	Given Launch the browser 
	And set headers with "SubscribeUser" number
	Given Reading test data "PlayOn_EXCEL_FILE_PATH"
	When navigate to url "PlayOn_Portal_Url"
	
Scenario: Validating Portal logo Menu and Search icon in watch video Page
    Then validate portal logo
    Then Validate Menu icon
    Then Validate search icon
    Then Footer link section is present
    	
Scenario: Validating Download Thumbnail cases in Download Page
   	 When Click on menu "DEPORTES & MOTOR" option
  	 Then Navigate to subscription page based on Gallery Image
  	 Then Validate Thumbnail image
	 And Validate preview thumbnail image Title
	 And Validate Preview thumbnail description
	 And Validate thumbnail Download button
	 And Validate Preview subcription text
	 
Scenario: Validating Download Thumbnail cases in Download Page	 
	  And Validate Download thumbnail screenshot Section
	 Then Validate Download thumbnail Description Title and description text
	 Then Validate Download thumbnail rating title and ratingshistogram section
     Then Validate Download thumbnail recomendation section
     
Scenario: Validating Download Thumbnail cases in Download Page
     And Delete all the old download files	 
	 Then Click on Download button and Validate the Download file    
        
Scenario: Close the Browser after complete feature
  	Then close browser