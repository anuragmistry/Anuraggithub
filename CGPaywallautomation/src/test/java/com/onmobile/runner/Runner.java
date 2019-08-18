package com.onmobile.runner;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@CucumberOptions(features={ "src/test/resources/features/1ONMOPayWall/Vodacom/1_SubscribeFlowValidation.feature",
//		                    "src/test/resources/features/1ONMOPayWall/Vodacom/2_UnsubscribeFlowValidation.feature",
//		                    "src/test/resources/features/1ONMOPayWall/Vodacom/3_DM_Flow_Validation.feature",
 //                         },

//@CucumberOptions(features={ "src/test/resources/features/1ONMOPayWall/Globacom/1_SubscribeFlowValidation.feature",
//                            "src/test/resources/features/1ONMOPayWall/Globacom/2_UnsubscribeFlowValidation.feature",
 //                       },

//@CucumberOptions(features={ "src/test/resources/features/1ONMOPayWall/Airtel/1_SubscribeFlowValidation.feature",
          //  "src/test/resources/features/1ONMOPayWall/Globacom/2_UnsubscribeFlowValidation.feature",
  //        },

//@CucumberOptions(features={"src/test/resources/features/1ONMOPayWall/Oman/1_SubscribeFlowValidation.feature",
//		                           "src/test/resources/features/1ONMOPayWall/Oman/2_UnsubscribeFlowValidation.feature",
//},

//@CucumberOptions(features={"src/test/resources/features/1ONMOPayWall/H3I/1_SubscribeFlowValidation.feature",
//                          "src/test/resources/features/1ONMOPayWall/H3I/2_UnsubscribeFlowValidation.feature",
//            },
@CucumberOptions(features={ 
                      // "src/test/resources/features/2AppLand/1Safaricom/1_SubscriptionFlowWithBasicAndFamilyPlans.feature",
//                     "src/test/resources/features/2AppLand/1Safaricom/2_DM_SubscriptionFlowValidationWithBasicAndFamilyPlans.feature",
//                     "src/test/resources/features/2AppLand/1Safaricom/3_UnsubscribeFlowValidationWithBasicAndFamilyPlans.feature",
		//		"src/test/resources/features/2AppLand/1Safaricom/4_Safaricom_Appland_All.feature",
 //                    },

//@CucumberOptions(features={ 
//                            "src/test/resources/features/2AppLand/Globacom/1_SubscriptionFlowWithBasicPlans.feature",
//                           "src/test/resources/features/2AppLand/Globacom/2_UnsubscribeFlowValidationWithBasicPlans.feature",
//                      },

//@CucumberOptions(features={ 
//		             "src/test/resources/features/2AppLand/OoredooOman/1_SubscriptionFlowWithBasicPlans.feature",
//		             "src/test/resources/features/2AppLand/OoredooOman/2_UnsubscribeFlowValidationWithBasicPlans.feature",
 //                },

//@CucumberOptions(features={ 
//                  "src/test/resources/features/CampaignManagement/CampaignManagement.feature",
//                },

//@CucumberOptions(features={ 
//                          "src/test/resources/features/BackUP/5_DM_Flow_For_Tourist.feature",
//                        },

//@CucumberOptions(features={
//  "src/test/resources/features/1ONMOPayWall/1BangladeshRobi/1_SubscribeFlowValidation.feature",
//	"src/test/resources/features/1ONMOPayWall/1BangladeshRobi/2_UnsubscribeFlowValidation.feature",
//	"src/test/resources/features/1ONMOPayWall/1BangladeshRobi/3_DM_Flow_Validation.feature",

//"src/test/resources/features/1ONMOPayWall/2Oman_omantel/1_SubscribeFlowValidation.feature",
//	"src/test/resources/features/1ONMOPayWall/2Oman_omantel/2_UnsubscribeFlowValidation.feature",		
//	"src/test/resources/features/1ONMOPayWall/2Oman_omantel/3_DM_Flow_Validation.feature",

//},

//@CucumberOptions(features={
		//"src/test/resources/features/1ONMOPayWall/3Safaricom/1_SubscribeFlowValidation.feature",
        //"src/test/resources/features/1ONMOPayWall/3Safaricom/2_UnsubscribeFlowValidation.feature",
       // "src/test/resources/features/1ONMOPayWall/3Safaricom/3_DM_Flow_Validation.feature",
       // "src/test/resources/features/1ONMOPayWall/3Safaricom/4_All_Safaricom.feature",
//},

//@CucumberOptions(features={
		//"src/test/resources/features/Test/1_Test.feature",
		"src/test/resources/features/1ONMOPayWall/1BangladeshRobi/4_AllBangladeshRobi.feature",
		"src/test/resources/features/1ONMOPayWall/2Oman_omantel/4_All_OMAN_OMANTEL.feature",
		"src/test/resources/features/1ONMOPayWall/3Safaricom/4_All_Safaricom.feature",
		"src/test/resources/features/2AppLand/1Safaricom/4_Safaricom_Appland_All.feature",
		//},
},

dryRun = false,
strict = true,
glue={"com.onmobile.stepDefinitions"},
plugin={"html:target/cucumber-html-report","json:target/cucumber.json","pretty:target/cucumber-pretty.txt","junit:target/cucumber-results.xml"})



public class Runner{

}

//@Cucumber.Options(features={"automatedTestingServices.feature", "smoketest.feature"})

//@CucumberOptions(features={/*"src/test/resources/features/"}


//Below the code if you integreted with TestNG
/*@CucumberOptions(
        format={"pretty","json:path/to/json_repot.json"},
        features = "Path_to_features_file",
        glue="com.sri.stepDefinition",
        tags={"@smoke,@regression")
        )

public class TestRunner extends AbstractTestNGCucumberTests{

}*/