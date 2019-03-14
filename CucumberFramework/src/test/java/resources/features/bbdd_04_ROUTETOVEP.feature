Feature: bbdd_04_ROUTETOVEP
Scenario: bbdd_04_ROUTETOVEP
Given we access Task Maintenance to run "ROUTING TO VEP""
And select database schema
And run "ROUTING TO VEP"
And check "15" status 
Then test case is successful 