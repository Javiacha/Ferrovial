Feature: bbdd_01_INITIALVALIDATIONS
Scenario: bbdd_01_INITIALVALIDATIONS
Given we access Task Maintenance to run "VALIDATION MANAGER  INITIAL VALIDATION"
And select database schema
And run "VALIDATION MANAGER INITIAL VALIDATION"
And check "300" status
Then test case is successful