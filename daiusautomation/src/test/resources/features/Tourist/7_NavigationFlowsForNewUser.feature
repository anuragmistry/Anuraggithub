Feature: Potal Navigation flows for New Users.

Scenario: Launching browser and setting headers
	Given Launch the browser 
	And  set headers with "UnSubscribeUser" number
	Given Reading test data "Tourist_EXCEL_FILE_PATH"
	When navigate to url "Tourist_Portal_Url"

	
Scenario: Validating Portal Logo and navigate Menu and Unsubcribed text for New User	
      Then validate portal logo
      Then validate the unsubscribed user text banner
 	  Then Validate the Unsubscribed text
 	  When Click on menu "ASIA" option
 	  Then validate the unsubscribed user text banner
 	  Then Validate the Unsubscribed text
 	  Then Click portal logo link and landing in Portal Home page
 	  
Scenario: Validating subscribe text and Cancel and Active button for New User	  
 	  When Click on Swipe-boune Carousel Image
	  Then Validate preview image
      And Validate subscribe price text
	  And Validate subscribe smallprint text
	  Then Validate Cancel and Acitve Button is Present
	  
Scenario: Validating Favurite flows for New User	  
	  Then Click portal logo link and landing in Portal Home page
	  When Click on menu "FAVORITOS" option
      Then Validate favourite page title and locker title
      Then Validate No favourites content
      
Scenario: Validating Gallery page for New User    
      When Click on menu "ASIA" option
      Then validate the unsubscribed user text banner
 	  Then Validate the Unsubscribed text
 	  Then Navigate to Gallery page based on category title
      Then Validate Gallery Banner and Description
      Then Click portal logo link and landing in Portal Home page
      
Scenario: Check cookie message displayed at the bottom of the page
	 Then Validate cookie message
	 Then Click on aqui link within the message and Navigate the cookie Page
	 Then Click portal logo link and landing in Portal Home page
	    
Scenario: Close the Browser after complete feature
  	Then close browser	
	