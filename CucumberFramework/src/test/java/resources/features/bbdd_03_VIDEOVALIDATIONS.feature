Feature: bbdd_03_VIDEOVALIDATIONS
Scenario: bbdd_03_VIDEOVALIDATIONS
Given we access Task Maintenance to run "VALIDATION MANAGER VIDEO VALIDATION""
And select database schema
And run "VALIDATION MANAGER VIDEO VALIDATION" 
And check "60" status 
Then test case is successful 