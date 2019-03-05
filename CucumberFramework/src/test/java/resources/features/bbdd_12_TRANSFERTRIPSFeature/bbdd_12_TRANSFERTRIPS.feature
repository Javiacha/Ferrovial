Feature: bbdd_12_TRANSFERTRIPS
Scenario: bbdd_12_TRANSFERTRIPS
Given we access Task Maintenance to run TRANSFER TRIPS
And select database schema
And run TRANSFER TRIPS
And check "52" status 
Then test case is successful 