Feature: Ugmaes Portal User Subscribe via Service Presentation Page Validation

Scenario: Launching browser and setting headers
	Given Launch the browser
	And set headers with "NewUser" number
	Given Reading test data "UGames_EXCEL_FILE_PATH"
	When navigate to url "UGames_Portal_Url"

 Scenario: Click on subscribe text and Validate all content in Service Presentation Page
      Then Click on service presentation subscribe Text link
      Then Validate Service Presentation Logo Text
      Then Validate service presentation slide show section
      Then Validate service presentation Subscirbe Text
      Then Validate Subscribe and No Thanks Button is Present
      Then Validate Subscribe category text and image in service presentation Page
      Then Validate service presentation Footer Section
      
 Scenario: Click on No Thanks Button and Rendered in Home Page
      Then Click on Service presentation NoThanks Button
      Then Confirm Home Page Navigation
            
  Scenario: Click on Subscribe button and validate Subscribe flow
      Then Click on service presentation subscribe Text link
      Then Click on Service presentation Subscribe Button
      Then Confirm Subsciption Confirmation Page Navigation
      Then Validate the Service presentation Subscribe text
       And Validate all download subscribed points
      Then Validate the Service presentation Devices image
      Then Click on Google Play Image
      Then Click on Enjoy your Games button
      Then Validate the App Promotion text
      
Scenario: Click on Content Banner and validate Subscribe flow
      Then Validate is Content banner present
      Then Click on Content banner
      Then Validate content banner product image
      Then Validate content banner product Title and description
	  Then Validate Download thumbnail screenshot
	  Then Validate Preview Thumbnail File Size
	  Then Validate module header and carousel item
	                      
 Scenario: Close the Browser after complete feature
  	Then close browser