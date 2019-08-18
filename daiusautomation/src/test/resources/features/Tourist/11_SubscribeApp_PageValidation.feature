Feature: Subscribe App Page Validation

  Scenario: Launching browser with  headers
    Given Launch the browser
    Then Deactivate the Active User msisdn "1133879971195" from app "578" and pack "57801"
    Then Deactivate the Active User msisdn "118888819927" from app "578" and pack "57801"
    And set headers with "1133879971195" number
    When navigate to url "Tourist_URL_Subcribe_GenericFlow"

  Scenario: Validating Subscribe App Generic flow
    Then Validate "Tourist" portal logo
    Then Validate "Tourist" Portal Banner Image
    Then Validate "Tourist" subscribe price text
    Then Validate "Tourist" Cancel and Acitve Button
    Then Validate Footer link section is present
    Then Click "Tourist" on Active Button
    Then Validate "Tourist" subscribed image and text
    Then Validate "Tourist" Portal Banner Image
    Then Validate user subscribed points
    Then Validate continue button is Present
    Then Validate Footer link section is present
    Then Click "Tourist" on Continue Button

  Scenario: Launching browser with  headers
    Given Change the Number "118888819927" in Mod Header
    When navigate to url "Tourist_URL_Subcribe_ContentFlow"

  Scenario: Validating Subscribe App Content flow
    Then Validate "Tourist" portal logo
    Then Validate "Tourist" Preview Image and Text
    Then Validate "Tourist" subscribe price text
    Then Validate "Tourist" Cancel and Acitve Button
    Then Click "Tourist" on Active Button
    Then Validate "Tourist" portal logo
    Then Validate preview image
    And Validate Subscribed image Title
    Then Validate user subscribed points
    Then Validate continue button is Present
    Then Validate Footer link section is present
    Then Click "Tourist" on Continue Button

  Scenario: Close the Browser after complete feature
    Then Deactivate the Active User msisdn "1133879971195" from app "578" and pack "57801"
    Then Deactivate the Active User msisdn "118888819927" from app "578" and pack "57801"
    Then close browser
