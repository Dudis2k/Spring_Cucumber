Feature: the version can be retrieved
  Scenario: client makes call to GET /version
    When the client calls /version
    Then the client receives status code of 200
    And the client receives server version 0

  Scenario: client makes call to POST /add-member
    Given the client is ready to add a new member
    When the client calls hits /add-member endpoint
    | id | name  | member_status |
    | 1  | Alice | active        |
    Then the client receives status code of 200