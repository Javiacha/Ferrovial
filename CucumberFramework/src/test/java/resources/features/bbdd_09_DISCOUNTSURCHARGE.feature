Feature: bbdd_09_DISCOUNTANDSURCHARGE
Scenario: bbdd_09_DISCOUNTANDSURCHARGE
Given we access Task Maintenance to run "DISCOUNT SURCHARGE"
And select database schema
And run "DISCOUNT SURCHARGE"
And check "50" status 
Then test case is successful 