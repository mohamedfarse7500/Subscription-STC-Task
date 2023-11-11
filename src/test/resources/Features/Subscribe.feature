Feature: Subscribe

  Background:
    Given User opens STC website

  Scenario Outline: Validate the Subscription Packages Prices  for all Countries
    When User can open countries list
    And User choose <countryName> from countries list
    Then Validate plans prices for <countryName>
    Examples:
      | countryName |
      | "KSA" |
      | "Bahrain" |
      | "Kuwait" |

  Scenario Outline: Validate the Subscription Packages Currency for all Countries
    When User can open countries list
    And User choose <countryName> from countries list
    Then Validate plans currency for <countryName>
    Examples:
      | countryName |
      | "KSA" |
      | "Bahrain" |
      | "Kuwait" |

  Scenario Outline: Validate the Subscription Packages Type for all Countries
    When User can open countries list
    And User choose <countryName> from countries list
    Then Validate plans type for <countryName>
    Examples:
      | countryName |
      | "KSA" |
      | "Bahrain" |
      | "Kuwait" |

