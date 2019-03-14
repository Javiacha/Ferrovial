Feature: bbdd_02_TAGVALIDATIONS
Scenario: bbdd_02_TAGVALIDATIONS
Given we access Task Maintenance to run "VALIDATION MANAGER TAG VALIDATION"
And select database schema
And run "VALIDATION MANAGER TAG VALIDATION""
And check "301" status
Then test case is successful