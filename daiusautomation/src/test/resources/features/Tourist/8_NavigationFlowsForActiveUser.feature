Feature: Potal Navigation flows for Active Users.

Scenario: Launching browser and setting headers
	Given Launch the browser 
	And set headers with "SubscribeUser" number
	Given Reading test data "Tourist_EXCEL_FILE_PATH"
	When navigate to url "Tourist_Portal_Url"
	
Scenario: Validating Portal Logo and navigate Menu and Unsubcribed text for Active User
      Then validate portal logo
      Then Validate the subscribed user text
      When Click on menu "ASIA" option
 	 # Then Validate the subscribed user text
 	  Then Click portal logo link and landing in Portal Home page
 	  
Scenario: Validating Watch video test cases for Active User     
      When Click on Swipe-boune Carousel Image
#	  When Validate Watch Video Title
	  Then Validate Video container and click on Play Button
	  Then Validate Live video control bar and video display time
	  Then Click on Favourite Button
	  
Scenario: Validating Favourite test cases for Active User	  
	  When Click on menu "FAVORITOS" option
      Then Validate favourite page title and locker title
      Then Validate My favourite Content item Image title and Button
      
Scenario: Close the Browser after complete feature
  	 Then close browser 	