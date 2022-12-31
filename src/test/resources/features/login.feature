Feature: Login Test -The user should be able to login with valid credentials.

  Background: Go to home page
    Given The user ist on the login page


  Scenario: Positive Scenario 1: User should be able to login.
    When The user enters valid credentials
    Then verify "Welcome etsb5"


  Scenario: Positive Scenario 2: User should be able to login.
    When The user enters with "etsb5" and "Test12345" credentials
    Then verify "Welcome etsb5"


  Scenario Outline: Positive Scenario 3: User should be able to login.
    When The user enters with "<username>" and "<password>" credentials
    Then verify "<expectedText>"
    Examples:
      | username | password  | expectedText  |
      | etsb5    | Test12345 | Welcome etsb5 |
  @wip
  Scenario Outline: Positive Scenario 4: User should be able to login.
    When The user enters with valid username und password
      | username | <username>  |
      | password | <password> |

    Then verify "<expectedText>"
    Examples:
      | username | password  | expectedText  |
      | etsb5    | Test12345 | Welcome etsb5 |
      #| etsB3    | Test123+ | Welcome etsB3 |