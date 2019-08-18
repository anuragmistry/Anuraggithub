Feature: Gallery Page Validation 

Scenario: Launching browser and setting headers
	 Given Launch the browser 
	 And set headers with "SubscribeUser" number
	 Given Reading test data "Tourist_EXCEL_FILE_PATH"
	 When navigate to url "Tourist_Portal_Url"
	 	
Scenario: Validating Gallery Image in Gallery Page
       When Click on menu "ASIA" option
       Then Navigate to Gallery page based on Banner Image
       Then Navigate to Gallery page based on category title
       Then Validate Gallery Banner and Description
       Then Validate current Gallery Page Link
       Then Validate all Gallery item

Scenario: Validating Portal logo Menu and Search icon in Gallery Page
       Then validate portal logo
       Then Validate Menu icon
       Then Validate search icon  
       Then Footer link section is present
       
Scenario: Close the Browser after complete feature
  	Then close browser