@web @todoMVCExamples @manual
Feature: ToDo Task Examples Page Scenarios

  @statusDisplay
  Scenario: Verify different status display for task items in list-Complete, Active, All
    #Creation of multiple task
    # Then Complete first task
    When user clicks on Active button
    Then validates that only active task is displayed
    When user clicks on Completed button
    Then validates that only completed task are displayed
    When user clicks on All Button
    Then all the task are displayed
    When user clicks on Clear Completed button
    Then completed task is removed from list

  @deleteMultiple
  Scenario: Verify deletion of multiple ToDo post creation
    Given Navigate to Examples Home Page
    When User enters new Task in ToDo Bar- Testing1
    Then New Todo Task is displayed in list post creation-Testing1
    When User enters new Task in ToDo Bar- Testing2
    Then New Todo Task is displayed in list post creation-Testing2
    And verify the total count Of created task in list
    When User deletes all task in list
    Then list of items should be empty

  @completedListItems
  Scenario: List of completed items should be empty if nothing has been completed
    Given Navigate to Examples Home Page
    When User enters new Task in ToDo Bar
    Then New Todo Task is displayed in list post creation
    When User navigates to Completed List
    Then list of items in completed list should be empty






