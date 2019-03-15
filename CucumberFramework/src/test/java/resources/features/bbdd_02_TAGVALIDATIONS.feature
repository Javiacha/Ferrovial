Feature: bbdd_02_TAGVALIDATIONS
Scenario: bbdd_02_TAGVALIDATIONS
Given we access Task Maintenance to run "TAG VALIDATION"
And select database schema
And run "TAG VALIDATION""
And check "301" status
Then test case is successful