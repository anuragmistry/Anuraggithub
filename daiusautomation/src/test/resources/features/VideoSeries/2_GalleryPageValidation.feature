Feature: Video Series Portal Gallery Page Validation

Scenario: Launching browser and setting headers
	Given Launch the browser
	And set headers with "NewUser" number
	Given Reading test data "VideoSeries_EXCEL_FILE_PATH"
	When navigate to url "VideoSeries_Portal_Url"
	
Scenario: Validating Banner Image in Gallery Page
       When Click on menu "The 4 to 9ers" option
       Then validate banner image
       
Scenario: Validating Footer links
	  When Footer link section is present
	  Then Check footer links are present
	  
Scenario: Validating Logo menu and Search icon Gallery Image in Gallery Page
     Then Click on "1" Banner
     Then validate portal logo
     Then Validate search icon
     Then Validate Menu icon 
	 Then Validate all Gallery item
      
Scenario: Validating Footer links
	  When Footer link section is present
	  Then Check footer links are present    
      
Scenario: Close the Browser after complete feature
  Then close browser