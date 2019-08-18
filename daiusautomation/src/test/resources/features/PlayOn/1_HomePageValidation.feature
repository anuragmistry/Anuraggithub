####Home Page Validation ####
Feature: Home Page Validation 

Scenario: Launching browser and setting headers
	Given Launch the browser
	And set headers with "NewUser" number
	Given Reading test data ""
	When navigate to url "Portal_Url"
	Then Deactivate the Active User msisdn "112345678673"

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
	Then Click on "1" Banner
	Then Click portal logo link and landing in Portal Home page  

Scenario: Validate Carousel item in Home Page
	 Then Validate module title and carousel item
	 Then Validate module carousel slider and carousel item 
	    
Scenario: Validating Footer links
	  When Footer link section is present
	  Then Check footer links are present
	  Then Validate footers
  
Scenario: Check cookie message displayed at the bottom of the page
	 Then Validate cookie message
	 Then Click on aqui link within the message and Navigate the cookie Page
	 Then Click portal logo link and landing in Portal Home page
	
##Scenario: Check Broken Links
##     When navigate to url "Portal_Url"
##     Then validate Broken Links
#
Scenario: Close the Browser after complete feature
  Then close browser