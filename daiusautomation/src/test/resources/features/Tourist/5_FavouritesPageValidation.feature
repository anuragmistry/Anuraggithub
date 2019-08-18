Feature: Favourites Page Validation 

Scenario: Launching browser and setting headers
	Given Launch the browser 
	And set headers with "SubscribeUser" number
	Given Reading test data "Tourist_EXCEL_FILE_PATH"
	When navigate to url "Tourist_Portal_Url"
	
Scenario: Validating Navigate to favourites flow
    When Click on Swipe-boune Carousel Image
	Then Add item in My favourite and validate all content
		
Scenario: Validating My favourites video in Favourites Page
    Then Click on menu "FAVORITOS" option
	Then Validate favourite page title and locker title
	Then Validate My favourite Content item Image title and Button
	Then Validate image and Button Dimension
	
Scenario: Validating Portal Logo,Menu and Search icon in watch video Page
    Then validate portal logo
    Then Validate Menu icon
    Then Validate search icon
    Then Footer link section is present
    Then Click portal logo link and landing in Portal Home page
   
Scenario: Go to the My Favourite page and perform delete operation
    Then Click on menu "FAVORITOS" option
	Then Select the Favourite item and click on delete
			
Scenario: Close the Browser after complete feature
  	Then close browser