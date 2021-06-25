@web @todoMVCExamples @automated
Feature: ToDo Task Examples Page Scenarios

  @create @test
  Scenario: Verify creation of new ToDo
    Given Navigate to Examples Home Page
    When User enters new Task in ToDo Bar
    Then New Todo Task is displayed in list post creation

  @delete
  Scenario: Verify deletion of new ToDo post creation
    Given Navigate to Examples Home Page
    When User enters new Task in ToDo Bar
    Then New Todo Task is displayed in list post creation
    When User clicks on delete icon in list
    Then ToDo task is deleted

  @createMultiple
  Scenario Outline: Verify when multiple ToDo task are created one by one
    Given Navigate to Examples Home Page
    When User enters new Task in ToDo Bar-<Title>
    Then New Todo Task is displayed in list post creation-<Title>
    Examples:
      | Title    |
      | Testing1 |
      | Testing2 |

  @createMultiple
  Scenario: Verify when multiple ToDo task are created together
    Given Navigate to Examples Home Page
    When User enters new Task in ToDo Bar- Testing1
    Then New Todo Task is displayed in list post creation-Testing1
    When User enters new Task in ToDo Bar- Testing2
    Then New Todo Task is displayed in list post creation-Testing2
    And verify the total count Of created task in list

  @complete @active @fromToggleOption
  Scenario: Verify the user can complete & un complete the task once created from top
    Given Navigate to Examples Home Page
    When User enters new Task in ToDo Bar
    Then New Todo Task is displayed in list post creation
    When user completes the task from top
    Then the count of items is reduced in list
    And Clear Completed Button is displayed
    When user unCompletes the task from top
    Then the count of items is increased in list
    And Clear Completed Button is notDisplayed

  @complete @fromListItem
  Scenario: Verify the user can complete the task once created from list/top
    Given Navigate to Examples Home Page
    When User enters new Task in ToDo Bar
    Then New Todo Task is displayed in list post creation
    # the below step has issue in click on toogle in list as Element is not visible and is dimmed
#    When user completes the task from list
    When user completes the task from top
    Then the count of items is reduced in list
    And Clear Completed Button is displayed

  @edit @pending
  Scenario: Verify the edit scenarios for created ToDo task
    Given Navigate to Examples Home Page
    When User enters new Task in ToDo Bar
    Then New Todo Task is displayed in list post creation
#    the below test step is not automated, because the page doesn't supports double click/click using Actions class
    When User edits the task
#    Then edited task is displayed in list
