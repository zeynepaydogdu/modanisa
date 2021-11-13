@wip
Feature: Todomvc_01
  Background:
    Given Empty ToDo list
   # @wip
  Scenario:1
    Then I should see empty todo list
    When I write "buy some milk" to <text box> and press <enter>
    Then I should see "buy some milk" item in Todo list
    And sayfayi kapatir
 #@wip
Scenario: 2
    Given ToDo list with "buy some milk" item
    When I write "enjoy the assignment" to <text box> and press <enter>
    Then I should see "enjoy the assignment" item insterted to ToDo list below "buy some milk" item
  And sayfayi kapatir
 #@wip
  Scenario: 3
   Given ToDo list with "buy some milk" item
   When I click on <checkbox> next to "buy some milk" item
   Then I should see "buy some milk" item marked as DONE
    And sayfayi kapatir
  Scenario: 4
    Given todo list with marked item
    When I click on <check box> next to item
    Then I should see "buy some milk" item marked as UNDONE
    And sayfayi kapatir
#@wip
  Scenario: 5
    Given ToDo list with "rest for a while" item
    When I click on <delete button> next to "rest for a while" item
    Then List should be empty
    And sayfayi kapatir
 #@wip
  Scenario: 6
    Given ToDo list with "rest for a while" and "drink water" item in order
    When I click on <delete button> next to "rest for a while"item
    Then I should see "drink water" item in ToDo list
    And sayfayi kapatir

