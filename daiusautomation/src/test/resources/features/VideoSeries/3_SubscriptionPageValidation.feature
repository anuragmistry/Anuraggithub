Feature: Video Series Portal Subscription Flow Validatio Validation

Scenario: Launching browser and setting headers
	Given Launch the browser 
	And  set headers with "NewUser" number
	Given Reading test data "VideoSeries_EXCEL_FILE_PATH"
	When navigate to url "VideoSeries_Portal_Url"
	
Scenario: Click On Image and Validating Portal Logo Menu icon and Search icon in Subscription Page
   	When Click on Swipe-boune Carousel Image
   	Then validate portal logo
   	Then Validate Menu icon is not present
   	Then Validate search icon is not present
   	
 Scenario: Validating Preview image Title and Rating image in Subscription Page  	
	 Then Validate preview image
	 And Validate preview image Title
	 And Validate preview image Dimension

Scenario: Validating  Cancel button and Click on Cancel in Subscription Page	 
	Then Click on "Cancel" Button
	
Scenario: Validating Terms and Condition link in Subscription Page
   	When Click on Swipe-boune Carousel Image
	Then Validate terms and condition link text
	Then Click on Terms and Conditions link
	Then validate portal logo
	Then Validate terms and condition page
	Then Click portal logo link and landing in Portal Home page
	
Scenario: Click on menu and Select one Image and validating Subscribed text in Subscription Page
     When Click on menu "Summer with Cimorelli" option
     Then Click on "1" Banner
     Then Click on "1" Carousel Thumbnail
	 Then Validate preview image
	 And Validate subscribe price text
	 And Validate subscribe smallprint text
	 
Scenario: Validating Active button and Click on Activate in Subscription Page	 	 
	Then Click on "Active" Button	

Scenario: Validating Portal logo Menu and Search icon in Confirmation Page
   	Then validate portal logo
   	Then Validate Menu icon is not present
    Then Validate search icon is not present
  	
Scenario: Validating user subscribed Image and Text in Confirmation Page  	
   	Then Validate subscribed image and text  
	 And Validate Subscribed image Dimension
	
Scenario: Validating subscribed image and title in Confirmation Page	
      Then Validate Subscribed Thumbnail
      And Validate Subscribed image Title
 
Scenario: Validating user subscribed points and link in Confirmation Page    
     And Validate all user subscribed points
     And Validate continue button and inside text
     Then Footer link section is present
     And Validate Many more Text and portal link
     And Validate Conditions link of service
     Then Validate terms and condition page
     
Scenario: Close the Browser after complete feature
  	Then close browser 