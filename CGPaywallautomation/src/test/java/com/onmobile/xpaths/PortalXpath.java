package com.onmobile.xpaths;

import org.openqa.selenium.By;

public interface PortalXpath {
	//Menu in Home Page
	By Logo						=By.xpath("//*[contains(@class,'logo-image')]");
	By BannerImg				=By.xpath("//*[@class='player_album_bg']/img");
	By SubscribeBTN	     	  	=By.xpath("//*[contains(@class,'btn_subscribe') and contains(@class,'pointer')]");
	By Omantel_IdentifyBtn_with_msisdn		=By.xpath("//*[@class='button1']");
	By Omantel_IdentifyBtn_without_msisdn	=By.xpath("//*[@class='button2']");
	//By SubscribeBtn 	       =By.xpath("//*[contains(@class,'light_blue_btn_new_b btn_subscribe')]");
	By ConfirmBtn				=By.xpath("//*[@class='light_blue_btn_new_b btn_subscribe']");
	By CancelBtn				=By.xpath("//*[contains(@class,'cancel-btn')]");
	By SmallText				=By.xpath("//*[contains(@class,'small_txt_box')]");
	By TextInBeforeBox			=By.xpath("//*[contains(@class,'small_text_digital_medium')]");
	By InputBoxMSISDN			=By.xpath("//input[@id='MSISDN' and @name='MSISDN']");
	By InputBoxOTP				=By.xpath("//input[@id='OTP' and @name='OTP']");
	By ResendOTPText			=By.xpath("//*[text()='Click here to re-send OTP']");
	By ErrorMsgOTPPage			=By.xpath("//*[(@class='center error_msg')]");
	By StatusText				=By.xpath("//*[@class='small_text_digital_medium']/span");
    By SubscribeText			=By.xpath("//*[@class='small_text_digital_medium'][2]");
    By UnSubscribeText			=By.xpath("//*[contains(@class,'small_text_digital_medium')]");
    By AlreadySubscribeText		=By.xpath("//*[@class='small_text_digital_medium'][1]");
    By SubscribeStatusText		=By.xpath("//*[contains(@class,'small_text_digital_medium')]/span");
    By ThankUText				=By.xpath("//*[contains(@class,'small_text_thankyou')]");
    By Thickimg					=By.xpath("//img[contains(@src,'ic_check')]");
    By CountryCodeMobileText	=By.xpath("//*[@class='input_wrap']/input");
    By MobileNumber				=By.xpath(" //*[@class='big_txt_box']");
  //  By SubscribeBTN			=By.xpath("//*[contains(@class,'btn_subscribe')]");
    By SubscribeOperatorText	=By.xpath("//*[@class='small_text_digital']");
    By TermsConCheckBox			=By.xpath("//*[@class='checkbox' and @type='checkbox']");
    By BannerLink				=By.xpath("//a[contains(@href,'replaceMe')]");
    By CG_YES					=By.xpath("//*[text()='YES']");			
    
    By OkButton					=By.xpath("//*[text()='Okay']");
    By Subscribe_Active_Btn		=By.xpath("//*[@id='btnSubscribe']/div");
    By Banner_Img				=By.xpath("//img[@class='banner-header-image']");
    By Subscription_Title		=By.xpath("//*[@class='subscription-title']");
    By Subscription_Text		=By.xpath("//*[@class='subscription-text']");
    By Subscribed_IMG			=By.xpath("//*[@class='tick-image']/img");
    By Subscribed_Text			=By.xpath("//*[@class='tick-text confirmation-header']");
    By Continue_Btn				=By.xpath("//*[contains(@class,'button')]");
    
    By Powered_Logo				=By.xpath("//img[contains(@src,'Poweredby_logo.png')]");
    By TermsConditionsLink		=By.xpath("//*[contains(@class,'small_text_digital_medium')]/a");
    By FooterLink				=By.xpath("//*[contains(@class,'footer-link')]/a");
    By CG_YES_Btn				=By.xpath("//a[text()='YES' or text()='Yes']");
    By CG_SUBSCRIBE_BTN			=By.xpath("//a[text()='SUBSCRIBE']");

  
  
  //APPLAND
    By AppLandLogoImg			=By.xpath("//*[contains(@class,'logo-image')]");
    By AppLandConfirmBtn 	    =By.xpath("//*[contains(@class,'light_blue_btn_new_b btn_subscribe')]"); 
    By BasicBTN					=By.xpath("//img[@id='imgBasic']/parent::a");
    By FamilyBTN				=By.xpath("//img[@id='imgFamily']/parent::a");
    By BasicPackDetails			=By.xpath("//*[@id='divBasic']/descendant::p");
    By FamilyPackDetails		=By.xpath("//*[@id='divFamily']/descendant::p");
    //By BasicContinueBTN		=By.xpath("//*[@id='divBasic']/descendant::*[@id='btnContinue']");
    By BasicContinueBTN			=By.xpath("//*[@id='divBasic']/descendant::*[contains(@class,'card-link btn btn-primary')]");
    //By FamilyContinueBTN		=By.xpath("//*[@id='divFamily']/descendant::*[@id='btnContinue']");
    By FamilyContinueBTN		=By.xpath("//*[@id='divFamily']/descendant::*[contains(@class,'card-link btn btn-primary')]");
    By JointAccount				=By.xpath("//*[contains(@class,'color-green')]");
    By AlbumImg					=By.xpath("//*[contains(@class,'player_album_bg')]/img");
    By TermsCondition			=By.xpath("//*[text()='Terms & Conditions']");
   
    By EnterMobileNum				=By.xpath("//*[text()='Mobile Number']/following::input[@id='MobileNumber']");
    By EnterPassword				=By.xpath("//*[text()='Password']/following::input[@id='Password']");
    By EnterConfirmPassword			=By.xpath("//*[text()='Confirm Password']/following::input[@id='ConfirmPassword']");
    By JointBTN						=By.xpath("//input[@type='submit' and @value='Join']");
    By ContinueBTN					=By.xpath("//input[@type='submit' and @value='Continue']");
    By UnsubscribeBTN				=By.xpath("//input[@type='submit' and @value='Unsubscribe']");
    By SignUpHeading				=By.xpath("//h2[text()='Sign Up']");
    By CreateFamilyAccountText		=By.xpath("//p[@class='form-group']");
    By CancelBTN					=By.xpath("//a[contains(@class,'btn-cancel')]");
    
    By ActivePlans					=By.xpath("//*[text()='Current Plan']/../descendant::*[@class='center active-plan']");
    By ActivePlansHeading			=By.xpath("//*[text()='Current Plan']/../descendant::p");
    By ActivePlansValue				=By.xpath("//*[text()='Current Plan']/../descendant::*[@class='center active-plan']");
    By CurrentPlanHeading			=By.xpath("//h4[text()='Current Plan']");
    By AccessServiceBTN				=By.xpath("//a[contains(@class,'btn-block')]");
    
    By MyFamilyHeading				=By.xpath("//h2[text()='My Family']");
    By ForgotPassword				=By.xpath("//*[@id='btnForgotPassword']");
    
 // By ClickOnPackContinueBTN		=By.xpath("//*[contains(text(),'replaceMe')]/following-sibling::a[@id='btnContinue']");
    By ClickOnPackContinueBTN		=By.xpath("//*[contains(text(),'replaceMe')]/following-sibling::*[contains(@class,'btn-primary')]");
    
    By ChosePlanAndClickHeading		=By.xpath("//h5[text()='Please choose your plan and click on continue']");
    
    
  //Campain Management
    By UserName						=By.xpath("//input[@placeholder='Username']");
    By Password						=By.xpath("//input[@placeholder='Password']");
    By SubmitBTN					=By.xpath("//button[@type='submit']");
    By Onmo_Logo					=By.xpath("//img[contains(@src,'onmo-logo.png')]");
    By PartnerTab					=By.xpath("//span[contains(text(),'Partners')]");
    By AddPartnerBTN				=By.xpath("//a[@class='btn btn-sidebars']");
    By PartnerText					=By.xpath("//h3[@class='box-title' and text()='Partners']");
    By CreatePartnerHeading			=By.xpath("//h1[@class='box-title' and text()='Create Partner']");
    By General_Info					=By.xpath("//p[contains(text(),'General Information')]");
    By Input_Name					=By.xpath("//*[contains(text(),'Name')]/following-sibling::*/input");
    By Input_Email					=By.xpath("//*[contains(text(),'Email')]/following-sibling::*/input");
    By Input_Phone					=By.xpath("//*[contains(text(),'Phone')]/following-sibling::*/input");
    By Input_Comapny				=By.xpath("//*[contains(text(),'Company')]/following-sibling::*/input");
    By Input_AddressLine1			=By.xpath("//*[contains(text(),'Address Line 1')]/following-sibling::*/input");
    By Input_AddressLine2			=By.xpath("//*[contains(text(),'Address Line 2')]/following-sibling::*/input");
    By Input_PartnerUrl				=By.xpath("//*[contains(text(),'Partner URL Params')]/following-sibling::*/input");
    By Input_CallBackUrl			=By.xpath("//*[contains(text(),'Callback URL')]/following-sibling::*/input");
    By CallBackConfig				=By.xpath("//p[contains(text(),'Callback Configuration')]");
    By RestrictionLabel				=By.xpath("//p[contains(text(),'Restrictions')]");
    By Select_CallBackType			=By.xpath("//select[contains(@name,'CallbackConfiguration.CallbackTypeKey')]");
    By Edit_CallBackType			=By.xpath("//select[contains(@name,'CallbackConfiguration')]");
    By Select_CampaignTypeList		=By.xpath("//select[contains(@id,'Restrictions_CampaignTypeList')]");
    By Select_ProductWhitelist		=By.xpath("//select[contains(@id,'Restrictions_ProductWhitelist')]");
    By Select_Icon_CampaignType		=By.xpath("//div[contains(@class,'CampaignTypeList')]//p[@title='Select']//i");
    By TypeValue					=By.xpath("//label[contains(text(),'replaceMe')]");
    By ReplaceOptionValue			=By.xpath("//label[text()='replaceMe']");
    By Select_Icon_ServiceWhitelist=By.xpath("//div[contains(@class,'ProductWhitelist')]//p[@title='Select']//i");
    By CreateButton					=By.xpath("//input[@value='Create']");
    By TextBoxValue					=By.xpath("//span[contains(text(),'replaceMe')]");
    By CreatedPartnerName          =By.xpath("//td[contains(text(),'replaceMe')]");
    By EditPartnerName             =By.xpath("//td[contains(text(),'replaceMe')]/parent::*//i[contains(@class,'edit')]");
    By SaveButton                  =By.xpath("//input[@value='Save']");
    By AddEventButton              =By.xpath("//button[@id='btnAddCallbackEvent']");
    By SearchBox                   =By.xpath("//input[@placeholder='Enter Keyword']");
    
    By CampaignTab                 =By.xpath("//span[contains(text(),'Campaigns')]");
    By CampaignText                =By.xpath("//h3[@class='box-title' and text()='Campaign']");
    By CreateCampaignHeading       =By.xpath("//h1[@class='box-title' and text()='Create Campaign']");
    By Input_CampaignName          =By.xpath("//*[contains(text(),'Campaign Name')]/following-sibling::*/input");
    By BtnCheckCampaignName        =By.xpath("//a[@id='btnCheckCampaignName']");
    By CampaignNameAvailableText   =By.xpath("//div[contains(text(),'Campaign Name is available')]");
    By CampaignNameAlreadyExitText =By.xpath("//div[contains(text(),'Campaign Name already exists.')]");
    By OkBTN                       =By.xpath("//button[contains(text(),'ok')]");
    By Input_PromotionTitle        =By.xpath(" //*[contains(text(),'Promotion Title')]/following-sibling::*/input");
    By Input_PromotionDesc         =By.xpath("//*[contains(text(),'Promotion Description')]/following-sibling::*/input");
    By Input_OMRevenue             =By.xpath("//*[contains(text(),'OM Revenue Share')]/following-sibling::*/input");
    By Input_CampaignValueCost     =By.xpath("//*[contains(text(),'Campaign Value Cost')]/following-sibling::*/input");
    By Input_OMCost                =By.xpath("//*[contains(text(),'OM Cost Share')]/following-sibling::*/input");
    By Input_BannerURL             =By.xpath("//*[contains(text(),'Banner URL')]/following-sibling::*/input");
    By Input_RedirectionURL        =By.xpath("//*[contains(text(),'Generic Redirection URL')]/following-sibling::*/input");
    By LabelCappingConfig          =By.xpath("//p[contains(text(),'Capping Configuration')]");
    By Label_CampaignURL           =By.xpath("//p[contains(text(),'Campaign URL')]");
    By Input_txtCampaignURL        =By.xpath("//input[@id='txtCampaignURL']");
    By Input_GetCampaignURL        =By.xpath("//a[@id='btnGetCampaignURL']");
  //input[@value='Create Campaign']
    By Select_Service              =By.xpath("//select[@id='dpdService']");
    By Select_LandingFlow          =By.xpath("//select[@id='dpdLandingFlow']");
    By Select_CampaignType         =By.xpath("//span[contains(text(),'Select Campaign Type')]");
    By Select_Partner_Icon         =By.xpath("//p[contains(@title,'Select Partner')]//label//i");
    By Select_Option_Value         =By.xpath("//label[contains(text(),'replaceMe')]");
    By Select_CampaignType_Icon    =By.xpath("//p[contains(@title,'Select Campaign Type')]//label//i");
    By Edit_Select_CampaignTypeIcon=By.xpath("//*[contains(@class,'CampaignType')]/descendant::*//label//i");
    By Edit_CampaignType           =By.xpath("//select[@id='CampaignInformationModel_CampaignType']");
    By Select_Language_Icon        =By.xpath("//p[contains(@title,'Select Language')]//label//i");
    By Select_Language_Option      =By.xpath("//select[@id='dpdlanguage']");
    By Select_Landing_Icon         =By.xpath("//p[contains(@title,'Select Landing Flow')]//label//i");
    By EditSelect_Landing_Icon     =By.xpath("//*[contains(@class,'LandingFlow')]/descendant::*//label//i");
    By Select_PricePoint_Icon      =By.xpath("//p[contains(@title,'Select Price Point')]//label//i");
    By Select_DaysToRun_Icon       =By.xpath("//div[contains(@class,'DaysToRun')]//p[@title='Select Here']//i");
    By Select_DaysToRun            =By.xpath("//select[@id='CampaignInformationModel_DaysToRun']");
    By EditSelect_DaysToRun_Icon   =By.xpath("//div[contains(@class,'DaysToRun')]/descendant::*//label//i");
    By Campaign_StartDateTime      =By.xpath("//input[@id='txtStartDate']");
    By Campaign_EndDateTime        =By.xpath("//input[@id='txtEndDate']");
    By Input_StartTime             =By.xpath("//input[@id='txtBlacklistStartTime']");
    By Input_EndTime               =By.xpath("//input[@id='txtBlacklistEndTime']");
    By Select_SupportedOS_Icon     =By.xpath("//div[contains(@class,'SupportedOS')]//p[@title='Select Here']//i");
    By Select_SupportedOS          =By.xpath("//select[@id='CampaignInformationModel_SupportedOS']");
    By EditSelect_SupportedOS_Icon =By.xpath("//div[contains(@class,'SupportedOS')]/descendant::*//label//i");
    By Select_AllowedCountries_Icon=By.xpath("//div[contains(@class,'AllowedCountries')]//p[@title='Select Here']//i");
    By EditSelect_AllowedCountries_Icon=By.xpath("//div[contains(@class,'AllowedCountries')]/descendant::*//label//i");
    By Select_AllowedCountries     =By.xpath("//select[@id='CampaignInformationModel_AllowedCountries']");
  
    By Input_CallbackPercentage             =By.xpath("//input[@id='CampaignInformationModel_CallbackPercentage']");
    By Input_CallbackCapMinutes             =By.xpath("//input[@id='CampaignInformationModel_CallbackCapMinutes']");
    By Input_MinPriceForCallback            =By.xpath("//input[@id='CampaignInformationModel_MinPriceForCallback']");
    By CappingConfiguration                 =By.xpath("//p[contains(text(),'Capping Configuration')]");
  
    By Select_CappingType                 =By.xpath("//select[@id='CampaignInformationModel_CampaignCapping_CappingType']");
    By EditSelect_CappingType             =By.xpath("//select[contains(@id,'dpdCappingType')]");
    By Select_CampaignCapping_Action      =By.xpath("//select[@id='CampaignInformationModel_CampaignCapping_Action']");
    By EditSelect_CampaignCapping_Action  =By.xpath("//select[contains(@id,'dpdCappingAction')]");
    By Input_CappingCountLimit            =By.xpath("//input[@id='CampaignInformationModel_CampaignCapping_CountLimit']");
    By Input_CappingRedirectURL           =By.xpath("//input[@id='CampaignInformationModel_CampaignCapping_RedirectURL']");
    By CampaignURL                        =By.xpath("//p[contains(text(),'Campaign URL')]");
    By Prefix_CampaignURL                 =By.xpath("//input[@id='txtDomain']");
    By Input_CampaignURL                  =By.xpath("//input[@id='txtCampaignURL']");
    By Btn_CopyClipboard                  =By.xpath("//span[contains(@class,'glyphicon-copy')]");
    By Btn_CheckCampaignURL               =By.xpath("//a[@id='btnGetCampaignURL']");
    By Btn_CreateCampaign                 =By.xpath("//input[@value='Create Campaign']");
}
