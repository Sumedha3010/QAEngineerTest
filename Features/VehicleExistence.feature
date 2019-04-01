Feature: Test the existence of vehicle

  Scenario Outline: Verify Vehicle existence using registration number
    Given I launch Insurance portal URL
    When I enter valid vehicle <RegistrationNumber> into Find Vehicle textbox
    Then I click on Find Vehicle search button
    Then I should see the registered Vehicle details
    And I close the browser

    
    Examples: 
      | RegistrationNumber | 
      | OV12UYY        	   |