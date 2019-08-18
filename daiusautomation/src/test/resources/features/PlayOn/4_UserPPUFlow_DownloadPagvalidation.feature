####User PPU flow and Download Page Validation
Feature: User PPU flow and Download Page Validation

Scenario: Launching browser and setting headers
	Given Launch the browser
	And set headers with "UnSubscribeUser" number
	Given Reading test data "PlayOn_EXCEL_FILE_PATH"
	When navigate to url "PlayOn_Portal_Url"
	
Scenario: Validating user PPU flow
      When Click on menu "DEPORTES & MOTOR" option
      Then Navigate to subscription page based on Gallery Image
      And Validate PPU price text
     Then Click on Buy button and Validate the Download file
      And Validate Previous and current page link
      
Scenario: Validating Download page for user PPU flow      
      Then Validate Download thumbnail
      And Validate Download thumbnail Title
	  And Validate Download thumbnail description
	  And Validate Download thumbnail Rating
	  And Validate thumbnail Download button
	  
Scenario: Validating Download page for user PPU flow 	  
	#  And Validate Download credit message button
      And Validate subscribe purchase and Download Button
      And Validate Download thumbnail screenshot Section
	  Then Validate Download thumbnail Description Title and description text
	  Then Validate Download thumbnail rating title and ratingshistogram section
      Then Validate Download thumbnail recomendation section
      
Scenario: Close the Browser after complete feature
  Then close browser      