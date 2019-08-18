Feature: Onmopay Test Feature File


 #Scenario: Launch the Browser then Add User Agent and Operator IP Range
    #Given Launch the browser
    #Given Set the Headers with "ROBI" IP range "41.57.111.111"
    #Given Open New Tab and Set "x-up-subno" with Number "8809998000012" in Mod Header
    #Given Open New Tab and remove entry "3" in Mod Header
		
#
  #Scenario: Onmopay callback test
#	#Then Hit Onmopay CallbakURL from Griff Session for number "9998000012"
#	Then Hit Onmopay CallbakURL from Griff Session for number "9998000012" amount "30.0" operator "ROBI" circle "ALL" action "ACT"
#	Then Hit Onmopay CallbakURL from Griff Session for number "9998000011" amount "30.0" operator "ROBI" circle "ALL" action "ACT"
#	#Then Hit Onmopay CallbakURL from Griff Session for number "889998000012" amount "30.0" operator "ROBI" circle "ALL" action "ACT"

Scenario: Delete Appland Accounts
Then Delete All Signed Users from DIAUS DB