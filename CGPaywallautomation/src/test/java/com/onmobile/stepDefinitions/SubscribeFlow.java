package com.onmobile.stepDefinitions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.onmobile.dataProvider.PropertyReader;
import com.onmobile.utils.Util;
import com.onmobile.xpaths.PortalXpath;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SubscribeFlow implements PortalXpath {
	static Logger Log = LogManager.getLogger("test");
	static WebDriver webdriver = Launcher.getdriver();
	Util util = new Util();
	DB_Connection dbconnection = new DB_Connection();
	By temp;

	@And("^Validate is Banner present$")
	public void validate_Banner() throws Exception {
		util.isElementPresent(BannerImg);
		Log.info("Banner is present");
	}

	@Then("^Validate is Logo present$")
	public void validate_Logo() throws Exception {
		util.isElementPresent(Logo);
		Log.info("Logo is present");
	}

	@Then("^Validate is PoweredBy Logo present$")
	public void validate_PoweredBy_Logo() throws Exception {
		util.ScrollDown(Powered_Logo);
		util.isElementPresent(Powered_Logo);
		Log.info("PoweredBy Logo is present");
	}

	@Then("^Select the \"([^\"]*)\" Operator Name$")
	public void Select_Operator_Name(String operator) throws Exception {
		WebElement mySelectElement = webdriver.findElement(By.name("opr"));
		util.SelectValuefromDropdown(mySelectElement, operator);
		Log.info("Select the [ " + operator + " ] Operator");
	}

	@Then("^Click on Ok Button$")
	public void Click_on_Ok_btn() throws Exception {
		String text = webdriver.findElement(OkButton).getText();
		Log.info("Button text is-->" + text);
		util.safeJavaScriptClick(OkButton);
		Log.info("Click on OK Button");
		util.GetCurrenturlAndTitle();
	}

	@Then("^Enter the MSISDN \"([^\"]*)\"$")
	public void Enter_MSISDN(String msisdn) throws Exception {
		Thread.sleep(500);
		String text = webdriver.findElement(SmallText).getAttribute("value");
		Log.info("Country Code in text box-->" + text);
		util.sendKeysValue(InputBoxMSISDN, msisdn);
		Log.info("Enter the MSISDN " + msisdn);
	}

	@Then("^Validate Terms and Conditions and Value$")
	public void Validate_TeemsConditions_Link() throws Exception {
		util.isElementPresent(TermsConditionsLink);
		Log.info("Terms Conditions Link  is present");
		String text = webdriver.findElement(TermsConditionsLink).getAttribute("href");
		Log.info("Terms Conditions Link valiue-->" + text);
	}

	@Then("^Click on Confirm Button$")
	public void Click_on_Confirm_btn() throws Exception {
		String btntext = webdriver.findElement(ConfirmBtn).getText();
		Log.info("Button text is-->" + btntext);
		util.safeJavaScriptClick(ConfirmBtn);
		Log.info("Click on OK Button");
		util.GetCurrenturlAndTitle();

	}

	@Then("^Click on identify button \"([^\"]*)\" msisdn$")
	public void Click_on_Identify_btn(String with_or_without) throws Exception {
		 util.GetCurrenturlAndTitle();
		 Log.info("Click on Identify Button");
		 if (with_or_without.equalsIgnoreCase("with"))
		 util.safeJavaScriptClick(Omantel_IdentifyBtn_with_msisdn);
		 else if (with_or_without.equalsIgnoreCase("without"))
		 util.safeJavaScriptClick(Omantel_IdentifyBtn_without_msisdn);
		 else {
		 Log.info("Button not present in Identify page.");
		 Assert.fail("Given Button not present in the page.");
		 }

	// Vineet's implementation commented 
//		Log.info("Click on Identify Button");
//		if (with_or_without.equalsIgnoreCase("with")) {
//			String btntext1 = webdriver.findElement(Omantel_IdentifyBtn_with_msisdn).getText();
//			Log.info("Button text is-->" + btntext1);
//			webdriver.findElement(By.linkText(btntext1)).click();
//		} else {
//			String btntext2 = webdriver.findElement(Omantel_IdentifyBtn_without_msisdn).getText();
//			Log.info("Button text is-->" + btntext2);
//			webdriver.findElement(By.linkText(btntext2)).click();
//		}
//		util.GetCurrenturlAndTitle();

	}

	@Then("^Get the OTP Value for MSISDN \"([^\"]*)\" from DB and Enter the OTP$")
	public void Enter_OTP(String msisdn) throws Exception {
		Thread.sleep(500);
		String query = "select OTP from uim_messaging where MSISDN='" + msisdn
				+ "' and CREATED in (select max(CREATED) from uim_messaging where MSISDN='" + msisdn + "')";
		String otp = DB_Connection.Connect_to_DB_And_fetch_Data(query, "Griff_DB");
		Log.info("For MSISDN [" + msisdn + "] OTP is-->" + otp);
		String text = webdriver.findElement(TextInBeforeBox).getText();
		Log.info("Small_text_digital_medium-->" + text);
		util.sendKeysValue(InputBoxOTP, otp);
		Log.info("Enter the OTP " + otp);
		Thread.sleep(500);
	}

	@Then("^Insert \"([^\"]*)\" in OTP field$")
	public void Insert_OTP(String otp) throws Exception {
		Thread.sleep(500);
		util.sendKeysValue(InputBoxOTP, otp);
		Log.info("Entered the OTP :" + otp);
	}

	@And("^Check Error message in OTP Page \"([^\"]*)\"$")
	public void Check_Error_Message_OTP_Page(String expectedErrorText) throws Exception {
		String actualErrorText = webdriver.findElement(ErrorMsgOTPPage).getText();
		if (expectedErrorText.equals(actualErrorText))
			Log.info("Actual and Expected error message are same : " + expectedErrorText);
		else {
			Log.info("Actual and Expected error messages are not same.Hence failing");
			Assert.fail("Expected error message \"" + expectedErrorText
					+ "\" not present OR not matchnig with actual message \"" + actualErrorText + "\"");
		}
	}

	@Then("^Validate Re-Send OTP Text Link$")
	public void validate_ReSend_OTP_Link() throws Exception {
		util.isElementPresent(ResendOTPText);
		Log.info("Resend OTP Text is present");
		String text = webdriver.findElement(ResendOTPText).getText();
		Log.info("Re-send OTP Link Text-->" + text);
	}

	@Then("^Validate Cancel and Corfirm Button is Present$")
	public void validate_Cancel_Corfirm_BTN() throws Exception {
		util.isElementPresent(ConfirmBtn);
		Log.info("Confirm Button is present");
		String btntext = webdriver.findElement(ConfirmBtn).getText();
		Log.info("Confirm Button text is-->" + btntext);
		String btntext1 = webdriver.findElement(CancelBtn).getText();
		Log.info("Cancel Button text is-->" + btntext1);
	}

	@Then("^Validate Subscribe messages$")
	public void validate_Subscribe_msg() throws Exception {
		util.isElementPresent(SubscribeText);
		Log.info("SubscribeText is present");
		String text = webdriver.findElement(SubscribeText).getText();
		Log.info("Subscribe Text-->" + text);
	}

	@Then("^Validate Unsubscribe messages$")
	public void validate_Unsubscribe_msg() throws Exception {
		util.isElementPresent(UnSubscribeText);
		Log.info("Unsubscribe text is present");
		String text = webdriver.findElement(UnSubscribeText).getText();
		Log.info("Unsubscribe Text-->" + text);
	}

	@Then("^Validate subscribed to the operator of your number$")
	public void validate_operator_msg_Number_CountryCode() throws Exception {

		util.isElementPresent(SubscribeOperatorText);
		Log.info("Subscribe Operator Text is present");

		String text = webdriver.findElement(SubscribeOperatorText).getText();
		Log.info("Operator mobile Text-->" + text);

		String code = webdriver.findElement(CountryCodeMobileText).getAttribute("value");

		if (code == null)
			Assert.fail("Mobile Number not auto populated.");
		else
			Log.info("Operator Country code and Mobile Num Text-->" + code);
	}

	@Then("^Click on Subscribe Button$")
	public void Click_on_Subscribe_btn() throws Exception {
		util.ScrollDown(SubscribeBTN);
		util.isElementPresent(SubscribeBTN);
		String btntext = webdriver.findElement(SubscribeBTN).getText();
		Log.info("Button text is-->" + btntext);
		util.safeJavaScriptClick(SubscribeBTN);
		Log.info("Click on Subscribe Button");
		util.GetCurrenturlAndTitle();
	}

	@Then("^Validate Subscribe thankyou messages and Status of User \"([^\"]*)\"$")
	public void validate_thankyou_msg_status(String msisdn) throws Exception {
		util.ScrollDown(Thickimg);
		util.isElementPresent(Thickimg);
		Log.info("Thick img is present");
		util.isElementPresent(ThankUText);
		Log.info("Thank you text is present");
		String text = webdriver.findElement(ThankUText).getText();
		Log.info("User Subscribe Thank you text-->" + text);
		String status = util.FindStatus(text);
		Log.info("User current Status is-->" + status);
		// Fetch the Status From DB
		String query = "select STATUS from pack_subscription_status where SUBSCRIBER_ID=(select SUBSCRIBER_ID from pack_subscriber_master where MOBILE_NUMBER='"
				+ msisdn + "')";
		String DB_Status = DB_Connection.Connect_to_DB_And_fetch_Data(query, "Packs_DB");
		Log.info("User current Status in UI-->" + status + "User Status from DB-->" + DB_Status);
	}

	@Then("^Validate Unsubscribe user thankyou messages$")
	public void validate_Unsubscribe_thankyou_msg() throws Exception {
		util.isElementPresent(ThankUText);
		Log.info("Thank you text is present");
		String text = webdriver.findElement(ThankUText).getText();
		Log.info("User Subscribe Thank you text-->" + text);

	}

	@When("^Delete all domain Cookies Value$")
	public void Delete_all_Cookies() throws Exception {

		Set<Cookie> Cookies = null;
		try {
			Cookies = webdriver.manage().getCookies();
			System.err.println("Total Number Of cookies : " + Cookies.size());
		} catch (Exception e) {
			System.err.println("Cookies is Empty");
		}
		if (Cookies.isEmpty()) {
			System.err.println("Cookies is Empty");
		} else {

			for (Cookie currentCookie : Cookies) {
				System.err.println(String.format("%s -> %s -> %s", "Domain Name : " + currentCookie.getDomain(),
						"Cookie Name : " + currentCookie.getName(), "Cookie Value : " + currentCookie.getValue()));
			}
			Log.info("Browser all Cookies value-->" + Cookies);

			webdriver.manage().deleteAllCookies();
		}

	}

	@Then("^Get the current domain Cookies value$")
	public void Get_all_Cookies() throws Exception {

		Set<Cookie> Cookies = Util.getCookieValue();
		Log.info("Browser all Cookies value-->" + Cookies);
	}

	@Then("^Validate Cookie Name \"([^\"]*)\" and value$")
	public void Validate_Cookies_name_Value(String CookiesName) throws Exception {

		Set<Cookie> Cookies = Util.getCookieValue();
		Log.info("Browser all Cookies value-->" + Cookies);

		String[] cookies = CookiesName.split(",");
		for (String cookie : cookies) {

			boolean status = IsCookiePresent(cookie);
			Cookie cookieName = webdriver.manage().getCookieNamed(cookie);

			String cookieValue = webdriver.manage().getCookieNamed(cookie).getValue();
			System.out.println(status);
			System.out.println(cookieValue);
			System.out.println(cookieName);
		}
	}

	public static boolean IsCookiePresent(String cookieName) {
		return webdriver.manage().getCookieNamed(cookieName) != null;
	}

	@Then("^Validate Already Subscribed messages$")
	public void validate_AlreadySubscribed_msg() throws Exception {
		util.isElementPresent(AlreadySubscribeText);
		Log.info("Already Subscribe Text is present");
		String text = webdriver.findElement(AlreadySubscribeText).getText();
		Log.info("User Subscribe Thank you text-->" + text);

	}

	@Then("^Validate Pack Detials messages$")
	public void validate_Pack_Detial_msg() throws Exception {
		util.isElementPresent(AlreadySubscribeText);
		Log.info("Pack_Detial_msg is present");
		String text = webdriver.findElement(AlreadySubscribeText).getText();
		Log.info("User Pack Details msg-->" + text);

	}

	@Then("^Validate User \"([^\"]*)\" Subscribe Status in UI and Status in DB$")
	public void validate_subscribe_Status(String msisdn) throws Exception {
		util.isElementPresent(SubscribeStatusText);
		String status = webdriver.findElement(SubscribeStatusText).getText();
		Log.info("User current Status in UI is-->" + status);
		// Fetch the user Status from DB
		String query = "select STATUS from pack_subscription_status where SUBSCRIBER_ID=(select SUBSCRIBER_ID from pack_subscriber_master where MOBILE_NUMBER='"
				+ msisdn + "')";
		String DB_Status = DB_Connection.Connect_to_DB_And_fetch_Data(query, "Packs_DB");
		Log.info("User current Status in UI-->[" + DB_Status + "] User Status from DB-->" + DB_Status);
	}

	@Then("^Validate footer links text and link url$")
	public void validate_footer_links() throws Exception {
		util.ScrollDown(FooterLink);
		List<WebElement> footerlink = webdriver.findElements(FooterLink);
		int footerlinkNum = footerlink.size();
		Log.info("Num of footer links Present in this Page-->" + footerlinkNum);
		for (WebElement element : footerlink) {
			String linkText = element.getText();
			String linkurl = element.getAttribute("href");

			if (linkurl == null)
				Assert.fail("Footer Link missing for text Name [" + linkText + "] and Link URL-->[" + linkurl + "]");
			else
				Log.info("Footer Link text Name [" + linkText + "] and Link URL-->[" + linkurl + "]");
		}
	}

	@Then("^Validate Redirection url Parameter \"([^\"]*)\"$")
	public void validate_redirection_url_Parameter(String ExpectedParams) throws Exception {
		String currentURL = webdriver.getCurrentUrl();
		Log.info("Fetch redirection Page url is-->" + currentURL);
		int index = currentURL.indexOf("?");
		String currentURLallparams = currentURL.substring(index + 1);

		// For testing
		// String ExpectedParams1="u=YYY&status=SUCCESS&opr=Vodacom";
		// String
		// currentURLallparams="p1=q324&u=JgXmzMYoEdbdCSXJVgEepA%3d%3d&opr=VODACOM&status=SUCCESS";

		Map<String, String> expected = util.SplitString(ExpectedParams);
		Map<String, String> actual = util.SplitString(currentURLallparams);

		Log.info("Fetch Actual Redirection Page url parameter-->" + actual);
		Log.info("Fetch Expected Redirection Page url parameter-->" + expected);

		Assert.assertTrue("Return True If Value is Present", CompareTheRedirectionurlParams(expected, actual));
		Log.info("Expected Parameter are present in Redirection Url");

		// String[] expected =argu.split("&");
		// String[] actual =allpara.split("&");
	}

	public static boolean CompareTheRedirectionurlParams(Map<String, String> map1, Map<String, String> map2) {
		Boolean status = true;

		if (map1 == null || map2 == null)
			return false;

		for (Map.Entry<String, String> entry : map1.entrySet()) {
			Log.info("Expeted Key name-->" + entry.getKey() + " and Value-->" + entry.getValue());
			// Check if the current key exists in the 2nd map
			if (!entry.getKey().equalsIgnoreCase("u")) {
				if (map2.containsKey(entry.getKey())) {// If Map1 key is present
														// in Map2 then Get both
														// value from Map and
														// Compare the value
					String actualVal = entry.getValue();
					String ExpectedVal = GetValuefromMap(map2, entry.getKey());
					Log.info(entry.getKey() + "-->Compare with Actual Parameter Value is -->" + ExpectedVal);
					if (!actualVal.equalsIgnoreCase(ExpectedVal) || ExpectedVal == null) {
						status = false;
					}
				} else {
					status = false;
				}
			} else {
				if (entry.getKey().equalsIgnoreCase("u")) {
					String expected = GetValuefromMap(map2, entry.getKey());
					Log.info(entry.getKey() + "-->Expected [u] Parameter Value is-->" + expected);
					if (expected.isEmpty()) {
						status = false;
					}
				}
			}
		}
		return status;
	}

	public static String GetValuefromMap(Map<String, String> map, String key) {
		String values = null;
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (key.equalsIgnoreCase(entry.getKey())) {
				values = entry.getValue();
				Log.info("Key [" + key + "] and Values = " + values);
			}

		}
		return values;
	}

	public static boolean compareTwoArrary(String[] expected, String[] actual) {
		Boolean status = false;
		for (int i = 0; i < expected.length; i++) {

			String[] split1 = expected[i].split("=");
			String[] split2 = actual[i].split("=");

			if (!split1[0].equalsIgnoreCase("u")) {
				if (split1[0].contentEquals(split2[0]) && split1[1].contentEquals(split2[1]))
					System.out.println(true);
				status = true;
			} else {
				System.out.println(split2[1]);
				if (split2[1] != null) {
					System.out.println(split2[1]);
					status = false;
				}
			}

		}
		return status;
	}

	@Then("^Validate User \"([^\"]*)\" current Status in DB$")
	public void validate_Unsubscribe_Status_DB(String msisdn) throws Exception {
		// Fetch the user Status from DB
		String query = "select STATUS from pack_subscription_status where SUBSCRIBER_ID=(select SUBSCRIBER_ID from pack_subscriber_master where MOBILE_NUMBER='"
				+ msisdn + "')";
		String DB_Status = DB_Connection.Connect_to_DB_And_fetch_Data(query, "Packs_DB");
		Log.info("User [" + msisdn + "] current Status in DB-->" + DB_Status);
	}

	@Then("^Validate the User Status \"([^\"]*)\" using \"([^\"]*)\" Check Status API$")
	public void validate_Identify_checkStatus(String ExpectedStatus, String checkstatusApi) throws Exception {
		String currentURL = webdriver.getCurrentUrl();
		Log.info("Fetch redirection Page url is-->" + currentURL);
		int index = currentURL.indexOf("?");
		String ActualParameter = currentURL.substring(index + 1);
		Map<String, String> actual = util.SplitString(ActualParameter);
		String encrypteduser = GetValuefromMap(actual, "u");
		Log.info("Expected encrypted [u] Parameter Value is-->" + encrypteduser);
		String opr = GetValuefromMap(actual, "opr");
		String userIdentifyurl = PropertyReader.baseurl
				+ (PropertyReader.readItem(opr + "_Identification_API_URL").replaceFirst("ReplaceMe", encrypteduser));
		Log.info("User Identification Decrypted API url-->" + userIdentifyurl);
		String decriptedNum = util.GetJSONResponseValue(userIdentifyurl);
		Log.info("Expected Encrypted [" + encrypteduser + "] number after Decrypted is-->" + decriptedNum);

		String checkstatusurl = PropertyReader.baseurl + PropertyReader.readItem(checkstatusApi);
		String apiurl = checkstatusurl.replaceAll("ReplaceMe", encrypteduser);
		Log.info("Check Status API url-->" + apiurl);

		JSONObject checkstausData = util.GetJSONArray(apiurl);
		Log.info("Check Status API JSON Response-->" + checkstausData);

		Map<String, Object> ActualCheckStausData = new LinkedHashMap<String, Object>();

		if (checkstausData != null) {
			int httpStatus = checkstausData.optInt("HTTPStatus");
			ActualCheckStausData.put("HTTPStatus", httpStatus);
			String user = checkstausData.optString("User");
			ActualCheckStausData.put("User", user);
			String Status = checkstausData.optString("status");
			ActualCheckStausData.put("status", Status);
			String Message = checkstausData.optString("message");
			ActualCheckStausData.put("message", Message);
			String Operator = checkstausData.optString("operator");
			ActualCheckStausData.put("operator", Operator);
			String Activationdate = checkstausData.optString("activationdate");
			ActualCheckStausData.put("activationdate", Activationdate);
			String Renewal_date = checkstausData.optString("renewal_date");
			ActualCheckStausData.put("renewal_date", Renewal_date);
			String Error = checkstausData.optString("error");
			ActualCheckStausData.put("error", Error);
			String Currency = checkstausData.optString("currency");
			ActualCheckStausData.put("currency", Currency);
			int Price = checkstausData.optInt("price");
			ActualCheckStausData.put("price", Price);
			int Packid = checkstausData.optInt("packid");
			ActualCheckStausData.put("packid", Packid);

			Log.info("Actual JSON Reponse Data for Check Status API-->" + ActualCheckStausData);
			String ActualStatus = String.valueOf(ActualCheckStausData.get("status"));
			Assert.assertTrue("Compare with User Status", ActualStatus.equalsIgnoreCase(ExpectedStatus));
			Log.info("Compare User Expected Status [" + ExpectedStatus + "] with Actual user staus from JSON Reponse ["
					+ ActualStatus + "]");

		} else {
			Log.info("jsonArray is getting NULL....");
		}

	}

	@Then("^Click on CG YES Button$")
	public void Click_on_CG_YES_btn() throws Exception {
		util.safeJavaScriptClick(CG_YES);
		Log.info("Click on CG YES Button");
		util.GetCurrenturlAndTitle();
	}

	@Then("^Click on Terms and condition check box$")
	public void Click_on_TermsCondition_CheckBox() throws Exception {
		util.safeJavaScriptClick(TermsConCheckBox);
		Log.info("Click on Terms Condition Check Box");

	}

	@Then("^Delete the User \"([^\"]*)\" records from Packs DB$")
	public void validate_DM_Log(String Number) throws Exception {

		String Get_SubscribeID_query = PropertyReader.readItem("Query_Get_Subscriber_ID");

		Get_SubscribeID_query = Get_SubscribeID_query.replaceFirst("Number", Number);
		Log.info("Query for get Subscriber ID from pack_subscriber_master Table==>" + Get_SubscribeID_query);

		String SubscribeID = DB_Connection.Connect_to_DB_And_fetch_Data(Get_SubscribeID_query, "Packs_DB");

		String Tables[] = { "pack_content_usage_tracking", "pack_subscription_status", "pack_subscriber_master" };
		if (SubscribeID != null) {
			Log.info("User [" + Number + "] Get Subscriber ID in Packs DB-->" + SubscribeID);
			for (String tablename : Tables) {
				String Delete_query = PropertyReader.readItem("Delete_Query");
				Delete_query = Delete_query.replaceFirst("TABLE_NAME", tablename).replaceFirst("Replace_SUB_ID",
						SubscribeID);
				Log.info("Query for delete record from [" + tablename + "] Table==>" + Delete_query);
				DB_Connection.DeleteRow("Packs_DB", Delete_query);
			}
		} else {
			Log.info("Record is not available for the User/MSISDN");
		}
	}

	@Then("^Click on Yes Button in CG Page$")
	public void Click_on_yes_btn_CG_Page() throws Exception {
		util.safeJavaScriptClick(CG_YES_Btn);
		Log.info("Click on CG YES Button");
		util.GetCurrenturlAndTitle();
	}

	@Then("^Click on Success Button in Airtel CG Page$")
	public void Click_on_Success_btn_CG_Page() throws Exception {
		util.safeJavaScriptClick(CG_YES_Btn);
		Log.info("Click on CG Success Button");
		util.GetCurrenturlAndTitle();
	}

	@Then("^Click on Subscribe Button in CG Page$")
	public void Click_on_Subscribe_btn_CG_Page() throws Exception {
		util.safeJavaScriptClick(CG_SUBSCRIBE_BTN);
		Log.info("Click on CG Subscribe Button");
		util.GetCurrenturlAndTitle();
	}

	@Then("^Activate or DeActivate the User \"([^\"]*)\" using \"([^\"]*)\" Packs Callback API$")
	public void ActivateDeActivate_User_Using_Packs_CallBackAPI(String Parameter, String callbackurl) throws Exception {
		// Fetch the user Status from DB
		String packscallbackurl = PropertyReader.readItem(callbackurl);
		String[] para = Parameter.split(",");

		String query = "select USERINFO from pack_subscription_status where SUBSCRIBER_ID=(select SUBSCRIBER_ID from pack_subscriber_master where MOBILE_NUMBER='"
				+ para[0] + "')";
		String userInfo = DB_Connection.Connect_to_DB_And_fetch_Data(query, "Packs_DB");
		Log.info("Get User [" + para[0] + "] userInfo from Packs DB-->" + userInfo);

		if (userInfo == null)
			userInfo = "dummyuserinfo";
		// http://172.16.5.108:7070/packs/callback?msisdn=ReplaceMSISDN&status=SUCCESS&srvkey=ReplaceSrvkey&amount=ReplaceAmount&operatorname=ReplaceOperator&action=ReplaceAction&userinfo=ReplaceUserInfo

		packscallbackurl = packscallbackurl.replaceFirst("ReplaceMSISDN", para[0])
				.replaceFirst("ReplaceSrvkey", para[1]).replaceFirst("ReplaceAmount", para[2])
				.replaceFirst("ReplaceOperator", para[3]).replaceFirst("ReplaceAction", para[4])
				.replaceFirst("ReplaceUserInfo", userInfo);

		Log.info(para[0] + "-Packs Call Back  API url-->" + packscallbackurl);

		String response = util.GetJSONResponseValue(packscallbackurl);
		Log.info("Packs Call Back API JSON Response-->" + response);

		String status_query = "select STATUS from pack_subscription_status where SUBSCRIBER_ID=(select SUBSCRIBER_ID from pack_subscriber_master where MOBILE_NUMBER='"
				+ para[0] + "')";
		String DB_Status = DB_Connection.Connect_to_DB_And_fetch_Data(status_query, "Packs_DB");
		Log.info("Current User Status from Packs DB after HIT the Pack CallBack API-->" + DB_Status);
	}

	@Then("^The User \"([^\"]*)\" Activate or DeActivate \"([^\"]*)\" using \"([^\"]*)\" Packs Callback API$")
	public void Activate_User_CallBackAPI(String msisdn, String action, String callbackurl) throws Exception {
		// Fetch the user Status from DB
		String packscallbackurl = PropertyReader.readItem(callbackurl);

		String query = "select USERINFO from pack_subscription_status where SUBSCRIBER_ID=(select SUBSCRIBER_ID from pack_subscriber_master where MOBILE_NUMBER='"
				+ msisdn + "')";
		String userInfo = DB_Connection.Connect_to_DB_And_fetch_Data(query, "Packs_DB");
		Log.info("Get User [" + msisdn + "] userInfo from Packs DB-->" + userInfo);

		if (action.equalsIgnoreCase("ACT")) {
			packscallbackurl = packscallbackurl.replaceFirst("ReplaceMSISDN", msisdn)
					.replaceFirst("ReplaceAction", "ACT").replaceFirst("ReplaceUserInfo", userInfo);
			Log.info(msisdn + "-Packs Call Back  API url-->" + packscallbackurl);
		}
		if (action.equalsIgnoreCase("DCT")) {
			packscallbackurl = packscallbackurl.replaceFirst("ReplaceMSISDN", msisdn)
					.replaceFirst("ReplaceAction", "DCT").replaceFirst("ReplaceUserInfo", userInfo);
			Log.info(msisdn + "-Packs Call Back  API url-->" + packscallbackurl);
		}
		String response = util.GetJSONResponseValue(packscallbackurl);
		Log.info("Packs Call Back API JSON Response-->" + response);

		String status_query = "select STATUS from pack_subscription_status where SUBSCRIBER_ID=(select SUBSCRIBER_ID from pack_subscriber_master where MOBILE_NUMBER='"
				+ msisdn + "')";
		String DB_Status = DB_Connection.Connect_to_DB_And_fetch_Data(status_query, "Packs_DB");
		Log.info("Current User Status from Packs DB after HIT the Pack CallBack API-->" + DB_Status);
	}

	// @Then("^Hit Onmopay CallbakURL from Griff Session for number
	// \"([^\"]*)\"$")
	// public void hit_Onmopay_CallbakURL_from_Griff_Session_for_number(String
	// msisdn) throws Exception {

	@Then("^Hit Onmopay CallbakURL from Griff Session for number \"([^\"]*)\" amount \"([^\"]*)\" operator \"([^\"]*)\" circle \"([^\"]*)\" action \"([^\"]*)\"$")
	public void hit_Onmopay_CallbakURL_from_Griff_Session_for_number_amount_operator_circle_action(String msisdn,
			String amount, String operator, String circle, String action) throws Exception {

		String onmopayCallbackUrl = null;

		String query = "SELECT CG_INFO FROM griff_session WHERE ID LIKE '" + msisdn + "%' ORDER BY ID DESC LIMIT 1";
		String griffSession = DB_Connection.Connect_to_DB_And_fetch_Data(query, "Griff_DB");
		Log.info("Session details from Griff Session -->" + griffSession);

		if (griffSession == null) {
			Log.info("griff_session not found for number" + msisdn + ".Hence failing.");
			Assert.fail("griff_session not found for number" + msisdn);
		}

		Map<String, String> griffSessionMap = util.SplitStringSeparator(griffSession, "||");
		onmopayCallbackUrl = GetValuefromMap(griffSessionMap, "CALLBACKURL");
		Log.info("Onmopay CallbackUrl Value from griff session is-->" + onmopayCallbackUrl);

		if (onmopayCallbackUrl == null) {
			Log.info("Onmopay Callback URL not found in griff_session table.Hence failing.");
			Assert.fail("Onmopay Callback URL not found in GRIFF Session");
		}

		// onmopayCallbackUrl="http://172.19.110.140/cg-paywall-auto/api/griffCallback/5/0/8809998000012/341/6256/411?tid=21842&channel=TYROO&atype=SUB&ctype=Pack_341&cpp=$AMOUNT$&arpu=$AMOUNT$&operator=$OPERATOR$&circle=$CIRCLE$&amount=$AMOUNT$&action=$ACTION$&sid=WZfPUVtLh-QBrRen8j5JctBDwtiQySGA0vKafqFFRbI&t=TYROOX&ctry=BD&opr=ROBI";
		// onmopayCallbackUrl = onmopayCallbackUrl.replace("$AMOUNT$",
		// "30.0").replace("$OPERATOR$", "ROBI")
		// .replace("$CIRCLE$", "ALL").replace("$ACTION$", "ACT");

		onmopayCallbackUrl = onmopayCallbackUrl.replace("$AMOUNT$", amount).replace("$OPERATOR$", operator)
				.replace("$CIRCLE$", circle).replace("$ACTION$", action);

		Log.info("URL after replacement:" + onmopayCallbackUrl);

		String onmopayCallbackResponse = util.GetJSONResponseValue(onmopayCallbackUrl);
		Log.info("Response on hitting callback url of onmopay taken from griff session : " + onmopayCallbackResponse);

	}
}
