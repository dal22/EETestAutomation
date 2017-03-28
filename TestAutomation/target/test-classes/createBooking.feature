Feature: As a user I can save a booking or a delete a booking at a hotel website

  @Sanity @Save
  Scenario Outline: As a user I must be able to book a room using the hotel booking system

    Given the user is on the hotel booking website
    When the user enters their firstname "<firstname>"
    And the user enters their lastname "<lastname>"
    And the user enters "<price>"
    And the value of the deposit is "<boolean>"
    And the checkin date is selected "<checkin>"
    And the checkout date is selected "<checkout>"
    Then the user selects Save to book their room
    And the user can see all booking details "<firstname>" and "<lastname>" and "<price>"

    Examples:
    |firstname                        |lastname                                |price     |boolean|checkin|checkout|
    |firstnameaaOnes                  |surname1sm                              |100       |true   |29     |30      |
    |Spencer Sally Middleton          |Praya Singh Matthews                    |0         |false  |30     |31      |
    |x                                |x                                       |0000000000|false  |29     |31      |
    |a                                |a                                       |  -7      |true   |1      | 2      |

