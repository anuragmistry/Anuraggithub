Feature: Ugmaes Portal User Subscribe Preview Page and Download Page  Validation

#Scenario: Launching browser and setting headers
#	Given Launch the browser
#	And set headers with "NewUser" number
#	Given Reading test data "UGames_EXCEL_FILE_PATH"
#	When navigate to url "UGames_Portal_Url"

 Scenario: Validating Preview Page
	  Then Click on Ic-Menu icon
	  Then Click on Categories Option
	  Then Click on Category Name "Aventura" and go to Gallery Page
	  Then Click on Game Thumbnail Text and go to Preview Page
	  Then Validate Preview product image and Title Description
	  Then Validate Download thumbnail screenshot
	  Then Validate Preview Thumbnail File Size
	  Then Validate module header and carousel item
	  
 Scenario: Click on Download Icon and Validate Subscribe Image Title
	  Then Click on Download icon and go to Subscribe Page
	  Then Validate Subscribe Image and Title
	  Then Validate Subscirbe Box and Text
	  Then Validate Cancel and Active Button Preview Page
	  Then Click on Active Button
	  
 Scenario: Click on Download Icon and Validate
      Then Validate Movistar Header is present
	  Then Validate subscription confirmation image and text
	  Then Validate Downloading Image
#	  And Validate Download Image Title and Size text
#	  And Validate Download does Not start Text and link
	  And Validate all download subscribed points
	  Then Validate App Img is present
	  Then Validate Download Green Button
	#  Then Click on Download Green Button
      Then Click and Validate Portal logo link
      
Scenario: Validating App Promotion text 
    Then Close the Alert Container
    Then Validate the App Promotion text
    Then Click on App store link and Validate the App store Page
    Then Click on Close Button and validate app-promotion text is disappear

Scenario: Validating Navigate flow for Active user
    # Then Click on "1" Category Button
     Then Click on Category Button "TOP DESCARGAS" Name
     Then Click on Game Name "Rayman Jungle Run" in Gallery Page
 #    Then Click on Game index num "1" in Gallery Page
 #    Then Click on frist Game in Gallery Page
     Then Click on Product Download icon
     Then Click on Product Download icon and Validate the Download file

Scenario: Validating My Locker Page(Downloaded Games)
	 Then Click on Ic-Menu icon
	 Then Click on ic-menu "Mis juegos descargados" option
	 Then Validate portal Logo Text
	 Then Footer section is present
	 Then Validate footer links are present
	 Then Validate My Downloded Games
