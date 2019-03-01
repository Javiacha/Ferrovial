Feature: bbdd_02_TOLLRATEANDEXEMPT
Scenario: bbdd_02_TOLLRATEANDEXEMPT
Given we access Task Maintenance to run VALIDATION MANAGER  FINAL VALIDATION
And select database schema
And run VALIDATION MANAGER INITIAL VALIDATION
And check "300" status
Then test case is successful