Feature: Gap Features validation
@Function
Scenario: Category verification
  Given user navigate to main page
  When user click Men tab and Verify Categories text present
  And capture all the categories names
  Then close the driver