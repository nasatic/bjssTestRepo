Feature: Api Request on endpoints


  @Ibe1
  Scenario Outline: GET Request from USERS
    When User makes a GET request to endpoint "<endPoint>"
    Then Response code should be "<statusCode>" for "<case>"
    And  Response body for case "<case>" should contain response data "<data>"
    Examples:
      | endPoint                           | statusCode | data   | case   |
      | https://reqres.in/api/users?page=2 | 200        | Morris | many   |
      | https://reqres.in/api/users/2      | 200        | Janet  | single |
      | https://reqres.in/api/users/23     | 404        |        | none   |


#  Scenario: PUT Request on user to UPDATE data
#    When User makes a PUT request to endpoint "https://reqres.in/api/users/2"
##    "{"name": "morpheus","job": "Glasgowegian"}" -- payload
#    Then Response code should be "200"
#    And Response body should contain updated data "Glasgowegian"

#  Scenario: PATCH Request on user to UPDATE data
#    When User makes a PATCH request to endpoint "https://reqres.in/api/users/2"
#    #    "{"name": "IbeOkoro","job": "zion resident"}" -- payload
#    Then Response code should be "200"
#    And Response body should contain patched data "IbeOkoro"

#  Scenario: DELETE Request on user
#    When User makes a DELETE request to endpoint "https://reqres.in/api/users/2"
#    Then Response code should be "204"


  Scenario Outline: PUT PATCH and DELETE Requests
    When User makes a request to endpoint "<endPoint>" using payload for "<case>"
    Then Response code should be "<statusCode>"
    And Response body should contain data "<data>"
    Examples:
      | endPoint                      | statusCode | data         | case   |
      | https://reqres.in/api/users/2 | 200        | Glasgowegian | PUT    |
      | https://reqres.in/api/users/2 | 200        | IbeOkoro     | PATCH  |
      | https://reqres.in/api/users/2 | 204        |              | DELETE |









#  Scenario: POST: REGISTER - SUCCESSFUL
#    When User makes a POST request to endpoint "https://reqres.in/api/register"
##    "{"email": "sydney@fife","password": "pistol"}" --- payload
#    Then Response code should be "201"
#    And Response body should contain posted data "QpwL5tke4Pnpja7X"


#  Scenario: POST: REGISTER - UNSUCCESSFUL
#    When User makes a POST request to endpoint "https://reqres.in/api/register"
#    #    "{"email": "sydney@fife"}" --- payload
#    Then Response code should be "404"
#    And Response body should contain posted data "Missing password"


#  Scenario: POST: LOGIN - SUCCESSFUL
#    When User makes a POST request to endpoint "https://reqres.in/api/login"
##    "{  "email": "peter@klaven",  "password": "cityslicka" }" -- payload
#    Then Response code should be "200"
#    And Response body should contain posted data "QpwL5tke4Pnpja7X"


#  Scenario: POST: LOGIN - UNSUCCESSFUL
#    When User makes a POST request to endpoint "https://reqres.in/api/login"
#    #    "{"email": "peter@klaven"}" -- payload
#    Then Response code should be "400"
#    And Response body should contain posted data "Missing password"

#    Scenario: POST Request on user to CREATE data
#    When User makes a POST request to endpoint "https://reqres.in/api/users"
##    "{"name": "nasatic","job": "leader"}" -- payload
#    Then Response code should be "201"
#    And Response body should contain posted data "nasatic"


  Scenario Outline: POST: Requests for login and registration
    When User makes a POST request to endpoint "<endPoint>" using payload for "<case>"
 #    "{"email": "peter@klaven"}" -- payload
    Then Response code should be "<statusCode>"
    And Response body should contain posted data "<data>"

    Examples:
      | endPoint                       | statusCode | data             | case             |
      | https://reqres.in/api/login    | 400        | Missing password | loginMissingPswd |
      | https://reqres.in/api/login    | 200        | QpwL5tke4Pnpja7X | LoginCorrectPsw  |
      | https://reqres.in/api/register | 404        | Missing password | RegMissingPswd   |
      | https://reqres.in/api/register | 201        | QpwL5tke4Pnpja7X | RegCorrectPswd   |
      | https://reqres.in/api/users    | 201        | nasatic          | PostToAddUser    |