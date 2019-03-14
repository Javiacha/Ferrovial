Feature: bbdd_11_TRANSFERIMAGES
Scenario: bbdd_11_TRANSFERIMAGES
Given we access Task Maintenance to run "TRANSFER IMAGES"
And select database schema
And run "TRANSFER IMAGES"
And check "51" status 
Then test case is successful 