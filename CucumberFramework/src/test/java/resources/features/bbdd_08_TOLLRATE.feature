Feature: bbdd_08_TOLLRATE
Scenario: bbdd_08_TOLLRATE
Given we access Task Maintenance to run "TOLL RATE"
And select database schema
And run "TOLL RATE"
And check "45" status 
Then test case is successful 