Feature: Sample Code

Scenario Outline: USXX123_TC_User books a return flight
Given User is on home page
And User prints the current url
And User clicks on "flights" tab
And User select "round trip" radio button
#    And User select "one way" radio button
And User enters flying from "Indira Gandhi" source aiport name or IATA code
And User enters "FRA" destination aiport name or IATA code
And user enters departure date "01-12-2021"
And user enters return date "15-12-2021"
Then user clicks on search button
#    And user sees the flight result
#    And user select the flight
#    And user is on Flight booking page
#    And user fills personal info data "<firstName>", "<lastName>","<email>","<phone>","<address>","<country>" and "<nationality>"

Examples:
| firstName | lastName | email          | phone      | address                               | country | nationality |
| Irfan     | Ahmad    | test@gmail.com | 1293291239 | John street cena house new wark state | India   | India       |