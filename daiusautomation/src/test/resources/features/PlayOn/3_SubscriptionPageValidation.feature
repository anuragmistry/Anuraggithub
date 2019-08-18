### Subscription Page Validation##
Feature: PlayOn Subscription Page Validation

Scenario: Launching browser and setting headers
	Given Launch the browser 
	And  set headers with "NewUser" number
	Given Reading test data "PlayOn_EXCEL_FILE_PATH"
	When navigate to url "PlayOn_Portal_Url"
	
Scenario: Click On Image and Validating Portal Logo Menu icon and Search icon in Subscription Page
     When Click on menu "DEPORTES & MOTOR" option
   	 Then Navigate to subscription page based on Gallery Image
   	 Then validate portal logo
   	 Then Validate Menu icon
   	 Then Validate search icon
   	
 Scenario: Validating Preview image Title and Rating image in Subscription Page  	
	 Then Validate Thumbnail image
	 And Validate preview thumbnail image Title
	 And Validate preview image Rating
	 And Validate thumbnail image Dimension

Scenario: Validating CSS property for Cancel button and Cancel flow in Subscription Page	 
#    Then Validate CSS property for "Cancel" Button
	 Then Click on "Cancel" Button
	
Scenario: Validating Terms and Condition link in Subscription Page
    Then Navigate to subscription page based on Gallery Image
	Then Validate terms and condition link text
	Then Click on Terms and Conditions link
	Then validate portal logo
	Then Validate terms and condition page
	Then Click portal logo link and landing in Portal Home page
	       	
Scenario: Click on menu and Select one Image and validating Subscribed text in Subscription Page
   	 Then Click on carousel Image based on Title Name
   	 Then Validate Thumbnail image
	 And Validate subscribe price text
	 And Validate subscribe smallprint text
	 
Scenario: Validating Active button and click on Action button	 	 
	 Then Click on "Active" Button	

Scenario: Validating Portal logo Menu and Search icon in Confirmation Page
   	Then validate portal logo
   	Then Validate Menu icon
  	Then Validate search icon
  
Scenario: Validating user subscribed Image and Text in Confirmation Page  	
   	Then Validate subscribed image and text  
	 And Validate Subscribed image Dimension
	
Scenario: Validating subscribed image title and rating image in Confirmation Page	
    Then Validate Subscribed thumbnail image
    Then Validate preview thumbnail image Title
  
Scenario: Validating user subscribed points and link in Confirmation Page    
     And Validate all user subscribed points
     And Validate continue button and inside text
     Then Footer link section is present
     And Validate Many more Text and portal link
     And Validate Conditions link of service
     Then Validate terms and condition page    
  
Scenario: Close the Browser after complete feature
  	Then close browser