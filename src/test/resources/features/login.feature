Feature: Login Test -The user should be able to login with valid credentials.

  Background: Go to home page
    Given The user ist on the login page


  Scenario: Positive Scenario 1: Login without Parameters
    When The user enters valid credentials
    Then verify "Welcome etsb5"


  Scenario: Positive Scenario 2: Login with Parameters
    When The user enters with "etsb5" and "Test12345" credentials
    Then verify "Welcome etsb5"


  Scenario Outline: Positive Scenario 3: Login with scenario outline
    When The user enters with "<username>" and "<password>" credentials
    Then verify "<expectedText>"
    Examples:
      | username | password  | expectedText  |
      | etsb5    | Test12345 | Welcome etsb5 |


  Scenario Outline: Positive Scenario 4: Login with scenario outline und data table
    When The user enters with valid username und password
      | username | <username> |
      | password | <password> |

    Then verify "<expectedText>"
    Examples:
      | username | password  | expectedText  |
      | etsb5    | Test12345 | Welcome etsb5 |
      #| etsB3    | Test123+ | Welcome etsB3 |


  Scenario Outline: Negative Scenario : User should not be able to login with invalid credentials.
    When The user enters with "<invalidUsername>" and "<invalidPassword>" credentials
    Then verify invalid credential "<expectedMessage>"
    Examples:
      | invalidUsername | invalidPassword | expectedMessage                        |
      | etsb5           | invalidpassword | Wrong password.                        |
      | etsb5invalid    | Test12345       | User does not exist.                   |
      | etsb5invalid    | invalidpassword | User does not exist.                   |
      |                 | Test12345       | Please fill out Username and Password. |
      | etsb5           |                 | Please fill out Username and Password. |
      |                 |                 | Please fill out Username and Password. |