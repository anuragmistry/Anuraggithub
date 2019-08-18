Feature: Ugmaes Portal Validation

 
####Home Page Validation ####
Scenario: Launching browser and setting headers
	Given Launch the browser
	And set headers with "NewUser" number
	Given Reading test data "UGames_EXCEL_FILE_PATH"
	When navigate to url "UGames_Portal_Url"

Scenario: Validating Home page logo image
	  Then Validate portal Logo Text
   	  Then Click and Validate Portal logo link
   	  Then Validate cookie notice and click on Entendido button
   	  
Scenario: Validating Menu Option 
	  Then Validate ic-Menu Image
	  Then Click on Ic-Menu icon
	  Then Validate Menu Header Title
	  Then Validate Menu Header text
      Then Validate Menu name and Image
   	  
Scenario: Validating service promotion text banner
 	 Then Validate the Service promotion text
 		 
Scenario: Validate Content Banner
	Then Validate is Content banner present
	
Scenario: Validate Categories Button	
	Then Validate all Categories Button Set
	
Scenario: Validate Download Banner and download icon	
    Then Validate Download Banner in Home page 
    
Scenario: Validate module header and carousel item
    Then Validate module header and carousel item
    Then Validate module content list item
    
Scenario: Validate Footer link
    Then Footer section is present
    Then Validate footer links are present
    
Scenario: Validating Search in HomePage
  	 Then Validate ic search icon
  	 And  Validate search box inside text
  	 Then Click on Search icon
	 Then Validate ic-Search operation with "Success Content"
  	 Then Click on Search icon
     Then Validate ic-Search operation with "Noresults Content" 
       
Scenario: Close the Browser after complete feature
  	Then close browser


####Gallery Page###
Scenario: Launching browser and setting headers
	Given Launch the browser
	And set headers with "NewUser" number
	Given Reading test data ""
	When navigate to url "Portal_Url"
#	Then Deactivate the Active User msisdn "112345678673"
	
Scenario: Validating gallery in GellaryPage
     Then Click on Category Button "TOP DESCARGAS" Name
  	 Then Validate Category title in Gallery Page
  	 Then Validate all Ranking item
  	 Then Validate all Gallery Content list item

#####Category Page###
Scenario: Validating Categories Page
	  Then Click on Ic-Menu icon
	  Then Click on Categories Option
	  Then Validate All Category List in Category Page
	  
Scenario: Close the Browser after complete feature
  	Then close browser
  		  
#Preview Page Subscribe and Download Page#

Scenario: Launching browser and setting headers
	Given Launch the browser
	And set headers with "NewUser" number
	Given Reading test data ""
	When navigate to url "Portal_Url"

 Scenario: Validating Preview Page
	  Then Click on Ic-Menu icon
	  Then Click on Categories Option
	  Then Click on Category Name and go to Gallery Page
	  Then Click on Game Thumbnail Text and go to Preview Page
	  Then Validate Preview product image and Title Description
	  Then Validate Download thumbnail screenshot
	  Then Validate Preview Thumbnail File Size
	  Then Validate module header and carousel item
	  
 Scenario: Click on Download Icon and Validate Subscribe Image Title
	  Then Click on Download icon and go to Subscribe Page
	  Then Validate Subscribe Image and Title
	  Then Validate Subscirbe Box and Text
	  Then Click on Active Button
	  
 Scenario: Click on Download Icon and Validate
	  Then Validate subscription confirmation image and text
	  Then Validate Downloading Image
	  And Validate Download Image Title and Size text
	  And Validate Download does Not start Text and link
	  And Validate all download subscribed points
	  Then Validate Download Note Text
	  Then Click on Download Close Button

Scenario: Validating Navigate flow for Active user
     Then Click on Category Button "TOP DESCARGAS" Name
     Then Click on Game Name "Rayman Jungle Run" in Gallery Page
     Then Click on Product Download icon
     Then Click on Product Download icon and Validate the Download file
     
Scenario: Validating My Downloaded Games
	 Then Click on Ic-Menu icon
	 Then Click on ic-menu "Mis juegos descargados" option
	 Then Validate My Downloded Games
	 
Scenario: Close the Browser after complete feature
  	Then close browser