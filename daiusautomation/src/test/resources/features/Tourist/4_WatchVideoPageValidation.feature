Feature: Watch Video Page Validation 

Scenario: Launching browser and setting headers
	Given Launch the browser 
	And set headers with "SubscribeUser" number
	Given Reading test data "Tourist_EXCEL_FILE_PATH"
	When navigate to url "Tourist_Portal_Url"
	
Scenario: Validating video title and Video container and Click on Play button in Watch Video Page
   	When Click on Swipe-boune Carousel Image
#	When Validate Watch Video Title
	Then Validate Video container and click on Play Button
	
Scenario: Validating Video player control bar and  image in Watch Video Page	
	Then Validate Live video control bar and video display time
	Then Validate Live Video Title and Rating Image
	Then Validate all types of ratings info
	
Scenario: Validating favourite section and add video in My Favourite list in Watch Video Page	
    Then Validate favourite section in watch video page
    
Scenario: Validating Portal logo Menu and Search icon in watch video Page
    Then validate portal logo
    Then Validate Menu icon
    Then Validate search icon
    Then Footer link section is present
    
Scenario: Close the Browser after complete feature
  	Then close browser 