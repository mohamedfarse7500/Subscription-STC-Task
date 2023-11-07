Feature: Subscribe

  Background:
    Given User opens STC website

  Scenario Outline: Check Data
    When User can open countries list
    And User choose "<countryName>" from countries list
    Then Validate type , price and Currency for "<countryName>"


    Examples:
      | countryName |
      | KSA         |
      | BAH         |
      | KUW         |