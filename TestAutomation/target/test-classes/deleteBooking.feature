Feature: As a user I can delete a booking at a hotel website

  @Sanity @Delete
  Scenario Outline: As a user I must be able to delete my room booking
    Given the user is on the hotel booking website
    When the user enters their firstname "Sue"
    And the user enters their lastname "Williams"
    And the user enters "100"
    And the value of the deposit is "false"
    And the checkin date is selected "<checkin>"
    And the checkout date is selected "<checkout>"
    And the user selects Save to book their room
    Then the user selects Delete
    And the user can no longer see the booking "Sue"

    Examples:
      |checkin|checkout|
      | 30    |31      |
      | 24    |26      |
