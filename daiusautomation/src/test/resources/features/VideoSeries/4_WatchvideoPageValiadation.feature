 Feature: Video Series Portal Watch Video Page Validation

 Scenario: Launching browser and setting headers
	Given Launch the browser
	And set headers with "NewUser" number
	Given Reading test data "VideoSeries_EXCEL_FILE_PATH"
	When navigate to url "VideoSeries_Portal_Url"
	 
 Scenario: Validating Video player container in Watch Video Page
   	When Click on Swipe-boune Carousel Image
	When Validate Watch Video Title
	Then Validate Video container and click on Play Button
	Then Validate Live video control bar and video display time
	
 Scenario: Validating Dscription Module Link favourite section in Watch Video Page	
	Then Validate Description Title and Text
	Then Validate Module Link Text
    Then Validate favourite section in watch video page
    Then Validate Upcoming episode recomendation section
    
Scenario: Validating Portal logo Menu and Search icon in watch video Page
    Then validate portal logo
    Then Validate Menu icon
    Then Validate search icon
    Then Footer link section is present
    
Scenario: Close the Browser after complete feature
  	Then close browser  