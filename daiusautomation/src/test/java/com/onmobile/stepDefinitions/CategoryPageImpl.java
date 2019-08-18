package com.onmobile.stepDefinitions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.onmobile.utils.Util;
import com.onmobile.xpaths.PortalXpath;

import cucumber.api.java.en.Then;


public class CategoryPageImpl implements PortalXpath{
	static Logger Log = LogManager.getLogger("test");
	Util util=new Util();
	PageConfirmation pageconfirmation=new PageConfirmation();
	ModuleCarouselnopaddingImpl modulecarouselnopaddingImpl=new ModuleCarouselnopaddingImpl();
	By temp;
	WebDriver webdriver=Launcher.getdriver();
	
	/***************************************************************************************
	 * @Function_Name :  validate_moduleTitle_CarousalImg
	 * @Description   :  validate module title and carousel item and compare with excel test data in Category Page
	 ***************************************************************************************/
	@Then("^Validate module title and carousel item$")
	public void validate_moduleTitle_CarousalImg() throws Exception{
		String menu=Util.getCurrentMenuSelection();
		String ExpectedModuleTitle=Launcher.getvaluefromExcelDataMap("CategoryPage_SliderModuleTitles");
		Map<String, List<String>> data = new HashMap<String, List<String>>();
		//Fetch the data from excel sheet and Store in Map
		data= Util.SplitStringAndStoreInMap(ExpectedModuleTitle);
		//Pass the Key value and get the Value
		List<String> Titlelist=Util.GetValuefromMap(data,menu);
		
		List<String> moduleTitle=util.getOptionValue(ModuleTitle);
		//Remove the CATEGORÍAS for Play On Portal
		 moduleTitle.remove("CATEGORÍAS");
		
		int num = moduleTitle.size();
		Log.info("Num of ["+num+"] Module title Present and Title are["+moduleTitle+"]");
		util.ComparetoListvalue(moduleTitle, Titlelist);
		Log.info("Compare Expected  Excel test Data ["+Titlelist+"] with Actual Module Title["+moduleTitle+"]");
		
		for(String title : moduleTitle) {
			temp=util.modifyXpath(ValidateTitle,title);
			util.ScrollDown(temp);
			webdriver.findElement(temp).isDisplayed();
			Log.info("Verify module Title-->"+title);
			
			temp=util.modifyXpath(MoreButton,title);
			Assert.assertTrue(webdriver.findElement(temp).isDisplayed());
			Log.info("Verify More button is present");
            
	
			temp=util.modifyXpath(ThumbnailImage,title);
			int numImg=webdriver.findElements(temp).size();
			Log.info("Num of Image Present under module title["+title+"] is-->"+numImg);
		}

	}
	@Then("^Click on carousel Image based on Title Name$")
	public void ClickOn_CarousalImg_title() throws Exception{
		String menu=Util.getCurrentMenuSelection();
		String ExpectedModuleTitle=Launcher.getvaluefromExcelDataMap("Subscription_CategoryTitleName");
		temp=util.modifyXpath(ThumbnailImage,ExpectedModuleTitle);
		util.ScrollDown(temp);
		util.safeJavaScriptClick(temp);
		Log.info("Click on Frist Image inside ["+menu+"] menu and under module title==>"+ExpectedModuleTitle);
	}
	/***************************************************************************************
	 * @Function_Name :  validate_module_carousel_dimesion
	 * @Description   :  validate num of module carousel Banner and Banner dimension in Category Page
	 ***************************************************************************************/	
	@Then("^Validate CategoryPage module carousel no padding images and dimension$")
	public void validate_module_carousel_dimesion() throws Exception{
		String Data=Launcher.getvaluefromExcelDataMap("CategoryPage_Menu_PaddingCount_EachSectionCarouselCount");
		modulecarouselnopaddingImpl.validate_ModuleCarousel_NoPaddingBanner_ImgDimension(Data);
	}
//Ugames	
	@Then("^Validate all Categories Button Set$")
	public void Validate_CategoriesName_HomePage() throws Exception{
		String cateName=Launcher.getvaluefromExcelDataMap("CategoryPage_CategoriesName");
		List<String> ExpectedCategoriesName = new ArrayList<String>(Arrays.asList(cateName.split("::")));
		List<String> ActualCategoriesName=util.getOptionValue(CategoriesName);
		int num = ActualCategoriesName.size();
		Log.info("Num of ["+num+"] Module Categories Present Home Page");
		util.ComparetoListvalue(ExpectedCategoriesName, ActualCategoriesName);
		Log.info("Compare Expected  Excel test Data ["+ExpectedCategoriesName+"] with Actual Module Title["+ActualCategoriesName+"]");
	}
	
	
	@Then("^Validate module header and more button$")
	public void validate_module_header_morenbtn() throws Exception{

		List<String> moduleHeader=util.getOptionValue(ModuleheaderName);
		int num = moduleHeader.size();
		Log.info("Num of ["+num+"] Module header Present and Title are["+moduleHeader+"]");

		for(String title : moduleHeader) {
			temp=util.modifyXpath(ValidateHeaderName,title);
			util.ScrollDown(temp);
			util.isElementPresent(temp);
			Log.info("Verify module Title-->"+title);

			temp=util.modifyXpath(ValidateHeaderMoreBtn,title);
			Assert.assertTrue(util.isElementPresent(temp));
			Log.info("Verify More button under ["+title+"] is present");

		}

	}

	@Then("^Validate module header and carousel item$")
	public void validate_module_carouselItem() throws Exception{

		List<String> moduleHeader=util.getOptionValue(ModuleheaderName);
		int num = moduleHeader.size();
		Log.info("Num of ["+num+"] Module header Present and Title are "+moduleHeader);

		for(int i=0;i<num-2;i++) {
			String title=moduleHeader.get(i);

			temp=util.modifyXpath(ModulecarouselImg,String.valueOf(i+1));
			util.ScrollDown(temp);
			List<WebElement> Img=webdriver.findElements(temp);
			temp=util.modifyXpath(Modulecarouselcaption,String.valueOf(i+1));
			List<WebElement> text=webdriver.findElements(temp);
			int numImg=Img.size();
			//Check ONLINE Flag present under module
			
			try {
				
				temp=util.modifyXpath(ModuleOnlineImg,String.valueOf(i+1));
			    WebElement element=webdriver.findElement(temp);
			    element.isDisplayed();
				List<WebElement> onlineImg=webdriver.findElements(temp);
				Log.info("Num of Online Image Present under module Header ["+title+"] is-->"+onlineImg.size());
			}catch (Exception e) {
				Log.info("Online Image NOT Present under module Header ["+title+"]");
			}
			
			
			Log.info("Num of carousel Image Present under module Header ["+title+"] is-->"+numImg);
			List<String> carouseltitle=new ArrayList<String>();
			for(int j=0;j<numImg;j++) {
				util.ScrollDown(Img.get(j));
				Img.get(j).isDisplayed();
				Log.info("Varify ["+(j+1)+"] carousel image is present");
				String ImgTitle=text.get(j).getText();
				
				carouseltitle.add(ImgTitle);
				
			}
			Log.info("All Carousel Title ["+carouseltitle+"] present under module Header-->["+title+"]");
		}

	}
	
	@Then("^Validate module content list item$")
	public void validate_module_contentList() throws Exception{

		List<WebElement> moduleContent=webdriver.findElements(ModuleContentListSection);
		int num = moduleContent.size();
		Log.info("Num of ["+num+"] Module content list Present");

		for(int i=0;i<num;i++) {
			
			temp=util.modifyXpath(ModuleContentListImg,String.valueOf(i+1));
			util.ScrollDown(temp);
			List<WebElement> Img=webdriver.findElements(temp);
			temp=util.modifyXpath(ModuleContentListcaption,String.valueOf(i+1));
			List<WebElement> text=webdriver.findElements(temp);
			
			int numImg=Img.size();
			Log.info("Num of Image Present under module Content List ["+(i+1)+"] is-->"+numImg);
			List<String> carouseltitle=new ArrayList<String>();
			for(int j=0;j<numImg;j++) {
				util.ScrollDown(Img.get(j));
				Img.get(j).isDisplayed();
				Log.info("Varify ["+(j+1)+"]  image is present");
				String ImgTitle=text.get(j).getText();
				
				carouseltitle.add(ImgTitle);
				
			}
			Log.info("All Image title "+carouseltitle+" present under module content list");
		}

	}
	@Then("^Click on Category Button \"([^\"]*)\" Name$")
	public void ClickOn_Category_Filter(String button) throws Exception{
		
	//	String CategoryTitle=Launcher.getvaluefromExcelDataMap("GalleryPage_Click_CategoryName").toUpperCase();
		temp=util.modifyXpath(CategoryLink,button);
		Thread.sleep(3000);
		util.safeJavaScriptClick(temp);
		Log.info("Click on Category link-->"+button);
		
		Assert.assertTrue("Page confirmation",pageconfirmation.isGalleryPage());
		Log.info("Validate we in our expected page");
	}
	
	@Then("^Click on \"([^\"]*)\" Category Button$")
	public void ClickOn_Category_Filter_WithIndex(String button) throws Exception{
	
		temp=util.modifyXpath(ClickOnNthCategoryButton,button);
		util.safeJavaScriptClick(temp);
		Log.info("Click on Category link "+button);
		Assert.assertTrue("Page confirmation",pageconfirmation.isGalleryPage());
		Log.info("Validate we in our expected page");
	}
	
	@Then("^Validate Category title in Gallery Page")
	public void Validate_Category_title() throws Exception{
		util.waitForLoad(webdriver);
		String Title=Launcher.getvaluefromExcelDataMap("GalleryPage_Click_CategoryName");
		temp=util.modifyXpath(CategoryTitle,Title);
		util.ScrollDown(temp);
		util.isElementPresent(temp);
		Log.info("Category title ["+Title+"] is present in Gallery Page ");
	}
	
	@Then("^Click on Categories Option$")
	public void ClickOn_Categories_Option() throws Exception{
		String CategoriesOption=Launcher.getvaluefromExcelDataMap("CategoryPage_ClickOnMenu");
		temp=util.modifyXpath(SelectMenu,CategoriesOption);
		util.ScrollDown(temp);
		util.safeJavaScriptClick(temp);
		Log.info("Click on Categoies option--> "+CategoriesOption);
		Assert.assertTrue("Confirm the Page",pageconfirmation.isCategoryPage());
		temp=util.modifyXpath(CategoryTitle,CategoriesOption);
		util.ScrollDown(temp);
		util.isElementPresent(temp);
		Log.info("Category title ["+CategoriesOption+"] is present in Category Page");
	}
	
	@Then("^Validate All Category List in Category Page")
	public void Validate_Category_List() throws Exception{
		List<String> ActualcategoryList=util.getOptionValue(CategoryList);
		int num = ActualcategoryList.size();
		Log.info("Num of ["+num+"] Category List is Present are ->"+ActualcategoryList);
		String List=Launcher.getvaluefromExcelDataMap("CategoryPage_CategoryList");
		List<String> ExpectedCateList = new ArrayList<String>(Arrays.asList(List.split("::")));
		Log.info("Fetch the Menu List from Excel are"+ExpectedCateList);
		Assert.assertTrue("Comapare both menu List",util.ComparetoListvalue(ActualcategoryList, ExpectedCateList));
		Log.info("Compare both Category List");
	}
	
	@Then("^Click on Category Name \"([^\"]*)\" and go to Gallery Page$")
	public void ClickOn_Category_Name(String categoryName) throws Exception{
		
	//	String categoryName=Launcher.getvaluefromExcelDataMap("Subscription_ClickOnCategoryName");
		temp=util.modifyXpath(SelectCategoryName,categoryName);
		util.ScrollDown(temp);
		util.safeJavaScriptClick(temp);
		Log.info("Click on Categoy Name--> "+categoryName);
		
        Assert.assertTrue("Confirm",pageconfirmation.isGalleryPage());
		
		temp=util.modifyXpath(CategoryTitle,categoryName);
		util.ScrollDown(temp);
		util.isElementPresent(temp);
		Log.info("Category title ["+categoryName+"] is present in Gallery Page");
	}
	@Then("^Click on Game Name \"([^\"]*)\" in Gallery Page$")
	public void ClickOn_Game_Name(String name) throws Exception{
		temp=util.modifyXpath(SelectGameName,name);
		util.safeJavaScriptClick(temp);
		Log.info("Click on Game Name--> "+name);
		String currentURL=webdriver.getCurrentUrl();
		util.waitForLoad(webdriver);
		Log.info("Fetch the Current Page url is-->"+currentURL);
	}
	@Then("^Click on Game index num \"([^\"]*)\" in Gallery Page$")
	public void ClickOn_Game_Name_withIndex(String num) throws Exception{
		temp=util.modifyXpath(SelectGameName,num);
		util.safeJavaScriptClick(temp);
		Log.info("Click on Game Name index--> "+num);
		String currentURL=webdriver.getCurrentUrl();
		util.waitForLoad(webdriver);
		Log.info("Fetch the Current Page url is-->"+currentURL);
	}
	
	@Then("^Click on frist Game in Gallery Page$")
	public void ClickOn_index_Game() throws Exception{
		List<WebElement> listOfGame=webdriver.findElements(ListOfGameName);
		listOfGame.get(0).click();
		Log.info("Click on frist Game");
		String currentURL=webdriver.getCurrentUrl();
		util.waitForLoad(webdriver);
		Log.info("Fetch the Current Page url is-->"+currentURL);
	}
}
