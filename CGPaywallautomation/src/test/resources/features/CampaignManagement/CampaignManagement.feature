Feature: Create a Partner in CampaignManagement

Scenario: Launch the portal and Login in CampaignManagement
	Given Launch the browser
	When Navigate to url "CampaignManagement_URL"
	When I Login as UserName "Onmobile" and Password "OnMobile1!"
	
Scenario Outline: Create a New Partner
        When I Click on Add Partner Tab
        Then Click on Add Partner Button
        Then I Validate General Information Label
        And I Enter the Name "<Name>" 
        And I Enter the Email "<Email>"
        And I Enter the Phone "<Phone>"
        And I Enter the Company "<Company>"
        And I Enter the AddressLine1 "<AddressLine1>"
        And I Enter the AddressLine2 "<AddressLine2>"
        And I Enter the Partner URL Params "<PartnerUrl>"
       Then I Validate CallBack Configuration Label
        And I Select the Call Back Option "<CallBackOption>" from DropDown
        And I Enter the CallBack URL "<CallBackURL>"
       Then I Validate Restrictions Label
        And I Select the Campaign Type Restrictions "<CampaignType>" from DropDown
        And I Select the Service WhiteList Type Restrictions "<ServiceWhiteListType>" from DropDown
       Then I Click on Create Button
       Then I Validate Created New Partner "<Name>" in Partners Table
       
Examples:
| Name                     |    Email           | Phone      | Company  | AddressLine1 | AddressLine2 |PartnerUrl|CallBackOption|CallBackURL|CampaignType|              ServiceWhiteListType              |
| Partner_Automation_Onmo  |Partner@onmobile.com|9000009999  | Onmobile | EC Bengalore |EC Bengalore  | ad2c     |Subscription  |callbackurl| CPM,CPA    |Sports_Mozambique-Vodacom,Games_Spain-VodafoneES|
| Partner_Asif       |Partner@onmobile.com|9000009991  | Onmobile | EC Bengalore |EC Bengalore  | ad2c     |Subscription  |callbackurl| CPM        |Sports_Mozambique-Vodacom,Sports_India-Airtel   |




Scenario Outline: Edit Exiting Partner Details
        When I Click on Add Partner Tab
        When I Search "<Name>" Key Word
       When I Click on "<Name>" Edit Button
        Then I Validate General Information Label
         And I Enter the Name "<EditName>" 
         And I Enter the Email "<Email>"
         And I Enter the Phone "<Phone>"
         And I Enter the Company "<Company>"
         And I Enter the AddressLine1 "<AddressLine1>"
         And I Enter the AddressLine2 "<AddressLine2>"
         And I Enter the Partner URL Params "<PartnerUrl>"
        Then I Validate CallBack Configuration Label
        Then I Edit the Selected Call Back Option "<CallBackOption>" from DropDown
         And I Enter the CallBack URL "<CallBackURL>"
        Then I Click on Add CallBack Event Button
         And I Select the Call Back Option "<CallBackOption>" from DropDown
         And I Enter the CallBack URL "<CallBackURL>"
        Then I Validate Restrictions Label
         And I Select the Campaign Type Restrictions "<CampaignType>" from DropDown
         And I Select the Service WhiteList Type Restrictions "<ServiceWhiteListType>" from DropDown
        Then I Click on Save Button
       
Examples:
|      Name             | EditName              |    Email               | Phone      | Company      | AddressLine1      | AddressLine2      |PartnerUrl  |CallBackOption    |CallBackURL|CampaignType|ServiceWhiteListType     |
|Partner_Automation_Onmo|Edit_Partner_Automation|editpartner@onmobile.com|9000009991  | Edit_Onmobile| Edit EC Bangalore |Edit EC Bangalore  | TYROOX     |Click             |callbackurl| CPM,CPC    |Sports_Mozambique-Vodacom|




Scenario Outline: Create a New Campaign
        When I Click on Campaigns Tab
        Then Click on Create Campaign Button
        
        Then I Validate General Information Label
        And I Enter the Campaign Name "<CampaignName>"
        And I Select the Service Option "<ServiceOption>" from DropDown
        And I Select the Partner Option "<PartnerOption>" from DropDown
        And I Enter the Promotion Title "<PromotionTitle>"
        And I Enter the Promotion Description "<PromotionDesc>"
        And I Enter the OM Revenue Share "<RevenueShare>"
        And I Enter the OM Cost Share "<CostShare>"
       And I Select the Campaign Type Option "<CampaignType>" from DropDown
        And I Enter the Campaign Value Cost "99"
        And I Enter the Banner URL "<Banner_url>"
        And I Enter the Generic Redirection URL "<Generic_url>"
        And I Select the Language Option "<Language>" from DropDown
        And I Select the Landing Flow Option "<LandingFlow>" from DropDown
        And I Select the PricePoint Option "<PricePoint>" from DropDown
        And I Select the Recur Every Days To Run "<DaysToRun>" from DropDown
       
       Then I Validate Restrictions Label
        And I Enter Campaign blackout start time "12:47:47"
        And I Enter Campaign blackout End time "17:47:47"
        And I Select the Allowed Operating System "<OperatingSystem>" from DropDown
        And I Select the Allowed Countries "<AllowedCountries>" from DropDown
        And I Enter Callback Percentage "9"
        And I Enter Callback Cap Minutes "19"
        And I Enter Minimum price for Callback "7"
        
       Then I Validate Capping Configuration Label
        And I Select the Capping Type Option "<CappingType>" from DropDown
        And I Select the Capping Action Option "<CappingAction>" from DropDown
        And I Enter Capping Count Limit "9"
        And I Enter Capping Redirect URL "<Capping_url>"
        
       Then I Validate Campaign URL Label
        And I Enter Campaign URL "<Campaign_url>"
       Then I Click on CreateCampaign Button
       Then I Validate Created New Campaign "<CampaignName>" in Campaign Table

Examples:
| CampaignName         |    PromotionTitle           | PromotionDesc      | RevenueShare  | CostShare |ServiceOption      |PartnerOption|CampaignType|Language|LandingFlow   |PricePoint|DaysToRun    |OperatingSystem|AllowedCountries|CappingType               |CappingAction       |Banner_url|Generic_url|Capping_url|Campaign_url|
|Campaign_Automation   |       Test                  |      Test          |    3          |  33       |Sports-India-Airtel|   Onmo      |CPM         |English |Subscribe Page|30        |Monday,Friday|Android,Windows|     China      |Daily Subscription Capping|Redirect to Campaign|Banner_url|Generic_url|url|Testurl|

Scenario Outline: Edit Exiting Campaign Details
       When I Click on Campaigns Tab
       When I Search "<CampaignName>" Key Word
       When I Click on "<CampaignName>" Edit Button
        And I Enter Campaign Start and End Date Time "23:9:22"
       Then I Validate General Information Label
        And I Enter the Campaign Name "<EditCampaignName>"
        And I Enter the Promotion Title "<PromotionTitle>"
        And I Enter the Promotion Description "<PromotionDesc>"
        And I Enter the OM Revenue Share "<RevenueShare>"
        And I Enter the OM Cost Share "<CostShare>"
        And I Edit the Selected Campaign Type Option "<CampaignType>" from DropDown
        And I Enter the Campaign Value Cost "66"
        And I Enter the Banner URL "<Banner_url>"
        And I Enter the Generic Redirection URL "<Generic_url>"
        And I Edit the Selected Language Option "<Language>" from DropDown
        And I Edit the Selected Landing Flow Option "<LandingFlow>" from DropDown
        And I Edit the Selected Recur Days To Run "<DaysToRun>" from DropDown
        
       Then I Validate Restrictions Label
        And I Enter Campaign blackout start time "12:47:47"
        And I Enter Campaign blackout End time "17:47:47"
        And I Edit Select the Allowed Operating System "<OperatingSystem>" from DropDown
        And I Edit the Selected Allowed Countries "<AllowedCountries>" from DropDown
        And I Enter Callback Percentage "19"
        And I Enter Callback Cap Minutes "29"
        And I Enter Minimum price for Callback "9"
        
       Then I Validate Capping Configuration Label
        And I Edit the Selected Capping Type Option "<CappingType>" from DropDown
        And I Edit the Selected Capping Action Option "<CappingAction>" from DropDown
        And I Enter Capping Count Limit "8"
        And I Enter Capping Redirect URL "<Capping_url>"
        
       Then I Validate Campaign URL Label
        And I Enter Campaign URL "<Campaign_url>"
#       Then I Click on CreateCampaign Button
       
Examples:
| CampaignName         |  EditCampaignName      |  PromotionTitle           | PromotionDesc      | RevenueShare  | CostShare |ServiceOption      |PartnerOption|CampaignType|Language|LandingFlow                   |PricePoint|DaysToRun    |OperatingSystem|AllowedCountries|CappingType                |CappingAction       |Banner_url     |Generic_url     |Capping_url|Campaign_url|
|Campaign_Automation   |  Eidt_Campaign_Automation   |Test_Edit             |      Edit_Test     |    9          |  99       |Sports-India-Airtel|   Onmo      |CPC         |Bahasa  |Plans Display Page(ONMO Games)|30        |Sunday,Friday|Android,IOS    |     India      |Hourly Subscription Capping|Redirect to Home    |Edit_Banner_url|Edit_Generic_url| Edit_url  |Edit_campaign_url| 



    