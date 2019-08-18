Feature: Home Page Validation 

# @scenarioTag
Scenario: Launching browser and setting headers
	Given Launch the browser
	And set headers with "NewUser" number
	Given Reading test data "Tourist_EXCEL_FILE_PATH"
	When navigate to url "Tourist_Portal_Url"
	Then Deactivate the Active User msisdn "112345678673"

Scenario: Validating home logo image
	  Then validate portal logo
      #Then Validate CSS property for portal logo
   	  Then validate portal logo link
      And Validate portal logo Dimension
      
Scenario: Validating Menu in HomePage
     Then Validate Menu icon
	 Then Validate menu image Dimension
#     Then Validate CSS property for Menu icon
	 Then Click on Menu icon and validate menu option
 #    Then Select the menu option and validate Page navigation

Scenario: Validating unsubscribed user text banner
 	 Then validate the unsubscribed user text banner
 	 Then Validate the Unsubscribed text
# 	 Then Validate CSS property for unsubscribed user text
 	
Scenario: Validating Search in HomePage
  	 Then Validate search icon
#     Then Validate CSS property for Search icon
  	 And  Click on Search icon and validate search box widget
	 Then Validate Search operation with "Success Content"
	 Then Validate Search operation with "Noresults Content"
   	 And  Validate search image Dimension
   	 	
Scenario: Validate Banner
	Then validate is banner present
	Then validate banner image
	Then validate the dimension of banner
#	Then Validate CSS property for banner images
	
Scenario: Validating Module carousel no padding Images in HomePage	
     Then Validate HomePage module carousel no padding images and dimension

Scenario: Validating Module link in HomePage	
	  Then Validate Module Link Text	
	  Then Compare Module LinkText with excel test data
      Then Validate CSS property for Module links
	   
Scenario: Validating module slider in Home Page	
	  Then Validate swipe module
	  Then Validate carousel module swipe
      Then Validate CSS property for Module Swipe Bounce Image Title and Rating Image
      
Scenario: Validating Footer links
	  When Footer link section is present
	  Then Check footer links are present
	  Then Validate footers
		  
Scenario: Check cookie message displayed at the bottom of the page
	 Then Validate cookie message
	 Then Click on aqui link within the message and Navigate the cookie Page
	 Then Click portal logo link and landing in Portal Home page

Scenario: Click on internal link and validate pages
    Then Validate footer Internal Link Pages
    
#Scenario: Check Broken Links
#     When navigate to url "Portal_Url"
#     Then validate Broken Links

Scenario: Close the Browser after complete feature
  Then close browser
  