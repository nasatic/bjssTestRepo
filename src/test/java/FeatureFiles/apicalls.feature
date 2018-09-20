Feature: Api Request on endpoints

  Scenario Outline: 1. GET Request from USERS
    When User makes a request to endpoint "<endPoint>" using payload for "<case>"
    Then Response code should be "<statusCode>" for "<case>"
    And  Response body for case "<case>" should contain response data "<data>"
    Examples:
      | endPoint                           | statusCode | data   | case   |
      | https://reqres.in/api/users?page=2 | 200        | Morris | many   |
      | https://reqres.in/api/users/2      | 200        | Janet  | single |
      | https://reqres.in/api/users/23     | 404        |        | none   |


  Scenario Outline: 2. PUT PATCH and DELETE Requests
    When User makes a request to endpoint "<endPoint>" using payload for "<requestType>"
    Then Response code for "<requestType>" should be "<statusCode>"
    And Response body for case "<requestType>" should contain response data "<data>"
    Examples:
      | endPoint                      | statusCode | data         | requestType |
      | https://reqres.in/api/users/2 | 200        | Glasgowegian | PUT         |
      | https://reqres.in/api/users/2 | 200        | IbeOkoro     | PATCH       |
      | https://reqres.in/api/users/2 | 204        |              | DELETE      |


  Scenario Outline: 3. POST: Requests for login and registration
    When User makes a request to endpoint "<endPoint>" using payload for "<case>"
    Then Response code for "<case>" should be "<statusCode>"
    And Response body for case "<case>" should contain response data "<data>"

    Examples:
      | endPoint                       | statusCode | data             | case             |
      | https://reqres.in/api/login    | 400        | Missing password | loginMissingPswd |
      | https://reqres.in/api/login    | 200        | QpwL5tke4Pnpja7X | LoginCorrectPswd |
      | https://reqres.in/api/register | 400        | Missing password | RegMissingPswd   |
      | https://reqres.in/api/register | 201        | QpwL5tke4Pnpja7X | RegCorrectPswd   |
      | https://reqres.in/api/users    | 201        | nasatic          | PostToAddUser    |