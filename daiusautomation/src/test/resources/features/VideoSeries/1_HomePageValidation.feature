Feature: Video Series Portal Validation

#Home Page Validation #
Scenario: Launching browser and setting headers
	Given Launch the browser
	And set headers with "NewUser" number
	Given Reading test data "VideoSeries_EXCEL_FILE_PATH"
	When navigate to url "VideoSeries_Portal_Url"
	
Scenario: Validating home logo image
	  Then validate portal logo
	   And Validate portal logo Dimension
   	  Then validate portal logo link

Scenario: Validating Menu in HomePage
     Then Validate Menu icon
	 Then Validate menu image Dimension
	 Then Click on Menu icon and validate menu option

Scenario: Validating unsubscribed user text banner
 	 Then validate the unsubscribed user text banner
 	 Then Validate the Unsubscribed text
	
Scenario: Validating Search in HomePage
  	 Then Validate search icon
  	 And  Click on Search icon and validate search box widget
	 Then Validate Search operation with "Success Content"
	 Then Validate Search operation with "Noresults Content"
   	 And  Validate search image Dimension
   	 	
Scenario: Validate Banner
	Then validate is banner present
	Then validate banner image
	Then validate the dimension of banner
	   
Scenario: Validating module slider in Home Page	
	  Then Validate swipe module
	  Then Validate carousel module swipe
      
Scenario: Validating Footer links
	  When Footer link section is present
	  Then Check footer links are present
	  Then Validate footers	
	  
Scenario: Check cookie message displayed at the bottom of the page
	 Then Validate cookie message
	 Then Click on aqui link within the message and Navigate the cookie Page
	 Then Click portal logo link and landing in Portal Home page
	 
Scenario: Close the Browser after complete feature
  Then close browser	 
