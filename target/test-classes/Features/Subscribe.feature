Feature: Subscribe

  Background:
    Given User opens STC website

  Scenario Outline: Validate the Subscription Packages – Type & Price and Currency for all Countries
    When User can open countries list
    And User choose "<countryName>" from countries list
    Then Validate plans "<lite>","<classic>" and "<premium>"  and Currency "<currency>" for all countries


    Examples:
      | countryName | currency | lite | classic | premium |
      | KSA         | SAR      | 15   | 25      | 60      |
      | BAH         | BHD      | 2    | 3       | 6       |
      | KUW         | KWD      | 1.2  | 2.5     | 4.8     |

