Feature: Subscribe App Page Validation 

Scenario: Launching browser with  headers
    Given Launch the browser
	And set headers with "1132879971197" number
	When navigate to url "Intimax_URL_Subcribe_GenericFlow"
    
Scenario: Validating Subscribe App Generic flow 	
   Then Validate "Intimax" portal logo
   Then Validate "Intimax" Portal Banner Image
   Then Validate "Intimax" subscribe price text
   Then Validate "Intimax" Cancel and Acitve Button
   Then Validate Footer link section is present
   Then Click "Intimax" on Active Button
   Then Validate "Intimax" subscribed image and text
   Then Validate "Intimax" Portal Banner Image
   Then Validate user subscribed points
   Then Validate continue button is Present
   Then Validate Footer link section is present
   Then Click "Intimax" on Continue Button
   
#Scenario: Close the Browser after complete feature
#  	Then close browser

Scenario: Launching browser with  headers
#    Given Launch the browser
#	And set headers with "118888819958" number
	Given Change the Number "1132879971198" in Mod Header
	When navigate to url "Intimax_URL_Subcribe_ContentFlow"
    
Scenario: Validating Subscribe App Content flow 	
   Then Validate "Intimax" portal logo
   Then Validate "Intimax" Preview Image and Text
   Then Validate "Intimax" subscribe price text
   Then Validate "Intimax" Cancel and Acitve Button
   Then Click "Intimax" on Active Button
   Then Validate "Intimax" portal logo
   Then Validate preview image
    And Validate Subscribed image Title
    Then Validate user subscribed points
   Then Validate continue button is Present
   Then Validate Footer link section is present
   Then Click "Intimax" on Continue Button
   
Scenario: Close the Browser after complete feature
  	Then close browser  