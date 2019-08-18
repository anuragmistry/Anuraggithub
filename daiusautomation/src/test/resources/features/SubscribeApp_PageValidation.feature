Feature: Subscribe App Page Validation 

Scenario: Launching browser with  headers
	Given Launch the browser with arguments
    When navigate to url "Tourist_URL_Subcribe_GenericFlow"
    
Scenario: Validating Subscribe App flow 	
   Then Validate the "Tourist" portal logo
   Then Validate Banner Image
   Then Validate subscribe price text
   Then Validate Cancel and Acitve Button is Present
   Then Click on "Active" Button
   Then Validate subscribed image and text
   Then Validate Banner Image  