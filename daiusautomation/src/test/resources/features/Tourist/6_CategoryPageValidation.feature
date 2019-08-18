Feature: Category Page Validation 

Scenario: Launching browser and setting headers
	 Given Launch the browser
	  And set headers with "SubscribeUser" number
	 Given Reading test data "Tourist_EXCEL_FILE_PATH"
	 When navigate to url "Tourist_Portal_Url"
	 
Scenario: Select the ASIA menu and validating Category Page
     When Click on menu "ASIA" option
	 Then validate banner image
	 Then Validate module title and carousel item
	 Then Validate module carousel slider and carousel item
     Then Validate CategoryPage module carousel no padding images and dimension
     Then Validate CSS property for banner images

Scenario: Select the AMERICA menu and validating Category Page
     When Click on menu "AMERICA" option
	 Then validate banner image
	 Then Validate module title and carousel item
	 Then Validate module carousel slider and carousel item
     Then Validate CategoryPage module carousel no padding images and dimension

Scenario: Validating Portal logo Menu Icon and Search icon in Category Page
   	 Then validate portal logo
   	 Then Validate Menu icon
   	 Then Validate search icon
   	 When Footer link section is present    
   	      
Scenario: Close the Browser after complete feature
  	 Then close browser     