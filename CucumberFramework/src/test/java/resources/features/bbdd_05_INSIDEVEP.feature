Feature: bbdd_05_INSIDEVEP
Scenario: bbdd_05_INSIDEVEP
Given we access Task Maintenance to run "INSIDE VEP""
And select database schema
And run "INSIDE VEP"
And check "20" status 
Then test case is successful 