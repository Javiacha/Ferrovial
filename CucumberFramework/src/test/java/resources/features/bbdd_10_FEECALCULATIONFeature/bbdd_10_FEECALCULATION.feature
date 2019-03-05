Feature: bbdd_10_FEECALCULATION
Scenario: bbdd_10_FEECALCULATION
Given we access Task Maintenance to run FEE CALCULATION
And select database schema
And run FEE CALCULATION
And check "51" status 
Then test case is successful 