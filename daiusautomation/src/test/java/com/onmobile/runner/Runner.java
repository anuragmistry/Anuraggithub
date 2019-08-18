package com.onmobile.runner;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//Tourist
/*@@CucumberOptions(features={/*"src/test/resources/features/Tourist/1_HomePageValidation.feature",
                           "src/test/resources/features/Tourist/2_GalleryPageValidation.feature",
                           "src/test/resources/features/Tourist/3_SubscriptionPageValidation.feature",
                           "src/test/resources/features/Tourist/4_WatchVideoPageValidation.feature",
		                   "src/test/resources/features/Tourist/5_FavouritesPageValidation.feature",
		                   "src/test/resources/features/Tourist/6_CategoryPageValidation.feature",
		                   "src/test/resources/features/Tourist/7_NavigationFlowsForNewUser.feature",
		                   "src/test/resources/features/Tourist/8_NavigationFlowsForActiveUser.feature",
		                   "src/test/resources/features/Tourist/10_DM_Log_ValidationForSubscriptionFlow.feature",
		                   },*/

//PlayOn
/*@CucumberOptions(features={"src/test/resources/features/PlayOn/1_HomePageValidation.feature",
                             "src/test/resources/features/PlayOn/2_GalleryPageValidation.feature",
                             "src/test/resources/features/PlayOn/3_SubscriptionPageValidation.feature",
                             "src/test/resources/features/PlayOn/4_UserPPUFlow_DownloadPagvalidation.feature",
                             "src/test/resources/features/PlayOn/5_Preview_DownloadPageValidation.feature",
                             },*/

//VideoSeries
/*@CucumberOptions(features={"src/test/resources/features/VideoSeries/1_HomePageValidation.feature",
		                   "src/test/resources/features/VideoSeries/2_GalleryPageValidation.feature",
		                   "src/test/resources/features/VideoSeries/3_SubscriptionPageValidation.feature",
	                   	   "src/test/resources/features/VideoSeries/4_WatchvideoPageValiadation.feature",
		                   "src/test/resources/features/VideoSeries/5_FavouritePageValidation.feature",
		                   },*/

/*//UGames
  @CucumberOptions(features={"src/test/resources/features/UGames/1_HomePageValidation.feature",
		                     "src/test/resources/features/UGames/2_GalleryPageValidation.feature",
		                     "src/test/resources/features/UGames/3_CategoryPageValidation.feature",
		                     "src/test/resources/features/UGames/4_UserSubscrobePreview_DownloadPageValidation.feature",
		                     "src/test/resources/features/UGames/5_SubscriptionViaServicePresentationPageValidation.feature",
		                     "src/test/resources/features/UGames/6_DM_LogValidation.feature",
		                     },*/

/*@CucumberOptions(features={"src/test/resources/features/UGames/6_DM_LogValidation.feature",},*/
                                                      
@CucumberOptions(features={"src/test/resources/featuresforTest",},

glue={"com.onmobile.stepDefinitions"},
plugin={"html:target/cucumber-html-report","json:target/cucumber.json","pretty:target/cucumber-pretty.txt","junit:target/cucumber-results.xml"})

public class Runner {

	
}

//@Cucumber.Options(features={"automatedTestingServices.feature", "smoketest.feature"})

//@CucumberOptions(features={/*"src/test/resources/features/"}


