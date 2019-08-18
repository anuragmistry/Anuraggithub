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

#Scenario: Validating Menu in HomePage
#     Then Validate Menu icon
#	 Then Validate menu image Dimension
#	 Then Click on Menu icon and validate menu option
#
#Scenario: Validating unsubscribed user text banner
# 	 Then validate the unsubscribed user text banner
# 	 Then Validate the Unsubscribed text
#	
#Scenario: Validating Search in HomePage
#  	 Then Validate search icon
#  	 And  Click on Search icon and validate search box widget
#	 Then Validate Search operation with "Success Content"
#	 Then Validate Search operation with "Noresults Content"
#   	 And  Validate search image Dimension
#   	 	
#Scenario: Validate Banner
#	Then validate is banner present
#	Then validate banner image
#	Then validate the dimension of banner
#	   
#Scenario: Validating module slider in Home Page	
#	  Then Validate swipe module
#	  Then Validate carousel module swipe
#      
#Scenario: Validating Footer links
#	  When Footer link section is present
#	  Then Check footer links are present
#	  Then Validate footers	
#	  
#Scenario: Check cookie message displayed at the bottom of the page
#	 Then Validate cookie message
#	 Then Click on aqui link within the message and Navigate the cookie Page
#	 Then Click portal logo link and landing in Portal Home page
#	 
#####Click on Menu and Validating Gallery Page####	
#
#Scenario: Validating Banner Image in Gallery Page
#       When Click on menu "The 4 to 9ers" option
#       Then validate banner image
#       
#Scenario: Validating Footer links
#	  When Footer link section is present
#	  Then Check footer links are present
#	  
#Scenario: Validating Logo menu and Search icon Gallery Image in Gallery Page
#     Then Click on "1" Banner
#     Then validate portal logo
#     Then Validate search icon
#     Then Validate Menu icon 
#	 Then Validate all Gallery item
#      
#Scenario: Validating Footer links
#	  When Footer link section is present
#	  Then Check footer links are present    
#      
#Scenario: Close the Browser after complete feature
#  Then close browser
#  
#####Subscription Flow Validation######
#Scenario: Launching browser and setting headers
#	Given Launch the browser 
#	And  set headers with "NewUser" number
#	Given Reading test data
#	When navigate to url "Portal_Url"
#	
#Scenario: Click On Image and Validating Portal Logo Menu icon and Search icon in Subscription Page
#   	When Click on Swipe-boune Carousel Image
#   	Then validate portal logo
#   	Then Validate Menu icon is not present
#   	Then Validate search icon is not present
#   	
# Scenario: Validating Preview image Title and Rating image in Subscription Page  	
#	 Then Validate preview image
#	 And Validate preview image Title
#	 And Validate preview image Dimension
#
#Scenario: Validating  Cancel button and Click on Cancel in Subscription Page	 
#	Then Click on "Cancel" Button
#	
#Scenario: Validating Terms and Condition link in Subscription Page
#   	When Click on Swipe-boune Carousel Image
#	Then Validate terms and condition link text
#	Then Click on Terms and Conditions link
#	Then validate portal logo
#	Then Validate terms and condition page
#	Then Click portal logo link and landing in Portal Home page
#	
#Scenario: Click on menu and Select one Image and validating Subscribed text in Subscription Page
#     When Click on menu "Summer with Cimorelli" option
#     Then Click on "1" Banner
#     Then Click on "1" Carousel Thumbnail
#	 Then Validate preview image
#	 And Validate subscribe price text
#	 And Validate subscribe smallprint text
#	 
#Scenario: Validating Active button and Click on Activate in Subscription Page	 	 
#	Then Click on "Active" Button	
#
#Scenario: Validating Portal logo Menu and Search icon in Confirmation Page
#   	Then validate portal logo
#   	Then Validate Menu icon is not present
#    Then Validate search icon is not present
#  	
#Scenario: Validating user subscribed Image and Text in Confirmation Page  	
#   	Then Validate subscribed image and text  
#	 And Validate Subscribed image Dimension
#	
#Scenario: Validating subscribed image and title in Confirmation Page	
#      Then Validate Subscribed Thumbnail
#      And Validate Subscribed image Title
# 
#Scenario: Validating user subscribed points and link in Confirmation Page    
#     And Validate all user subscribed points
#     And Validate continue button and inside text
#     Then Footer link section is present
#     And Validate Many more Text and portal link
#     And Validate Conditions link of service
#     Then Validate terms and condition page
#     
#Scenario: Close the Browser after complete feature
#  	Then close browser 
# 
# #### Watch Video Page Validation######
# 
# Scenario: Launching browser and setting headers
#	Given Launch the browser
#	And set headers with "NewUser" number
#	Given Reading test data
#	When navigate to url "Portal_Url"
#	 
# Scenario: Validating Video player container in Watch Video Page
#   	When Click on Swipe-boune Carousel Image
#	When Validate Watch Video Title
#	Then Validate Video container and click on Play Button
#	Then Validate Live video control bar and video display time
#	
# Scenario: Validating Dscription Module Link favourite section in Watch Video Page	
#	Then Validate Description Title and Text
#	Then Validate Module Link Text
#    Then Validate favourite section in watch video page
#    Then Validate Upcoming episode recomendation section
#    
#Scenario: Validating Portal logo Menu and Search icon in watch video Page
#    Then validate portal logo
#    Then Validate Menu icon
#    Then Validate search icon
#    Then Footer link section is present
#    
#Scenario: Close the Browser after complete feature
#  	Then close browser  
#
######Favourites Page Validation#######
#
# Scenario: Launching browser and setting headers
#	Given Launch the browser 
#	And set headers with "SubscribeUser" number
#	Given Reading test data
#	When navigate to url "Portal_Url"
#
#Scenario: Validating Navigate to favourites flow
#    When Click on Swipe-boune Carousel Image
#	Then Add item in My favourite and validate all content
#		
#Scenario: Validating My favourites video in Favourites Page
#    Then Click on menu "Favoritos" option
#	Then Validate favourite page title and locker title
#	Then Validate My favourite Content item Image title and Button
#	Then Validate image and Button Dimension
#	
#Scenario: Validating Portal Logo,Menu and Search icon in watch video Page
#    Then validate portal logo
#    Then Validate Menu icon
#    Then Validate search icon
#    Then Footer link section is present
#    Then Click portal logo link and landing in Portal Home page
#   
#Scenario: Go to the My Favourite page and perform delete operation
#    Then Click on menu "Favoritos" option
#	Then Select the Favourite item and click on delete
#	
#Scenario: Validating Navigate to favourites flow
#    When Click on Swipe-boune Carousel Image
#	Then Add item in My favourite and validate all content
#		
#Scenario: Close the Browser after complete feature
#  	Then close browser 