Feature: bbdd_06_FINALVALIDATIONS
Scenario: bbdd_06_FINALVALIDATIONS
Given we access Task Maintenance to run "FINAL VALIDATIONS"
And select database schema
And run "FINAL VALIDATIONS"
And check "150" status 
Then test case is successful 