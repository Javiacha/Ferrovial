Feature: bbdd_07_TRIPBUILDING
Scenario: bbdd_07_TRIPBUILDING
Given we access Task Maintenance to run "TRIP BUILDING"
And select database schema
And run "TRIP BUILDING"
And check "40" status 
Then test case is successful 