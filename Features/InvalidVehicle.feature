Feature: Test the existence of vehicle

  Scenario Outline: Verify error message for invalid registration number
    Given I launch Insurance portal URL
    When I enter invalid vehicle <RegistrationNumber> into Find Vehicle textbox
    Then I click on Find Vehicle search button
    Then I should get an appropriate Error Message <Error>
    And I close the browser

    Examples: 
      | RegistrationNumber | Error                  |
      | ABCDEFGHIJ         | Sorry record not found |

  Scenario Outline: Verify error message for invalid registration number
    Given I launch Insurance portal URL
    When I enter invalid vehicle <RegistrationNumber> into Find Vehicle textbox
    Then I click on Find Vehicle search button
    Then I should see the Error Message <Error>
    And I close the browser

    Examples: 
      | RegistrationNumber | Error                                 |
      | $%^&%$$            | Please enter a valid car registration |
