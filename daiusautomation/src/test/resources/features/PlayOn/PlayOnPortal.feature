Feature: PlayOn Portal Validation

 
####Home Page Validation ####
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
  
 
#### Gallery Page Validation ####
Scenario: Launching browser and setting headers
	 Given Launch the browser 
	 And set headers with "SubscribeUser" number
	 Given Reading test data
	 When navigate to url "Portal_Url"
	 	
Scenario: Validating Gallery Image in Gallery Page
       When Click on menu "DEPORTES & MOTOR" option
       Then Validate current Gallery Page Link
       Then Validate all Gallery item
       Then Validate Back-Arrow link is present
       
Scenario: Validating Portal logo Menu and Search icon in Gallery Page
       Then validate portal logo
       Then Validate Menu icon
       Then Validate search icon  
       Then Footer link section is present
       
Scenario: Close the Browser after complete feature
  	Then close browser


### Subscription Page Validation##
Scenario: Launching browser and setting headers
	Given Launch the browser 
	And  set headers with "NewUser" number
	Given Reading test data
	When navigate to url "Portal_Url"
	
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

####User PPU flow and Download Page Validation
Scenario: Launching browser and setting headers
	Given Launch the browser
	And set headers with "UnSubscribeUser" number
	Given Reading test data
	When navigate to url "Portal_Url"
	
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
     
#### Download or Preview Page Validation ####
Scenario: Launching browser and setting headers
	Given Launch the browser 
	And set headers with "SubscribeUser" number
	Given Reading test data
	When navigate to url "Portal_Url"
	
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