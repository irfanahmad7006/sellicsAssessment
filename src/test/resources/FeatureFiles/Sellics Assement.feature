Feature: Sellics Assessment Phptravel

  Scenario Outline: USXX123_TC_User submits a visa enquiry
    Given User is on home page
    And User prints the current url
    And User clicks on "visa" tab
    And User selects From Country "india" from the dropdown
    And User selects To Country "germany" from the dropdown
    And User enters "16-12-2021" date
    And User clicks on Submit button
    When User is on Submission form page
    And user fills personal info data "<firstName>", "<lastName>","<email>","<phone>","<date>" and "<notes>"
    Then user clicks on submit button
    And user is on submission page and with given text "Your visa form has been submitted" displayed


    Examples:
      | firstName | lastName | email          | phone      | date       | notes                   |
      | Irfan     | Ahmad    | test@gmail.com | 1293291239 | 12-12-2021 | This is test notes text |


