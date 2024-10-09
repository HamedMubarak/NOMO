Feature: Validate login functionality

  Scenario Outline: Validate login with valid credentials
    Given myDemo app is opened
    When  click on menu icon
    Then  side menu should be displayed
    When  logout from myDemo app
    Then  login form should be displayed
    When  login with "<username>""<password>"
    Then  checkout screen should be displayed
    Examples:
      | username         | password     |
      | standardUsername | standardPass |

  Scenario Outline: Validate login with invalid or empty credentials
    Given myDemo app is opened
    When  click on menu icon
    And   logout from myDemo app
    And   login with "<username>""<password>"
    Then  error message "<errorMessage>" should be displayed when login with "<username>""<password>"
    Examples:
      | username         | password     | errorMessage              |
      | noMatchUsername  | noMatchPass  | noMatchErrorMessage       |
      | emptyUsername    | emptyPass    | noUserDetailsErrorMessage |
      | emptyUsername    | standardPass | noUsernameErrorMessage    |
      | standardUsername | emptyPass    | noPasswordErrorMessage    |
      | lockedUsername   | standardPass | lockedUserErrorMessage    |