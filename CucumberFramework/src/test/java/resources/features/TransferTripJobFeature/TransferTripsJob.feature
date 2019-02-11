Feature: Task Database
Scenario: Modify Task Status
Given we access task maintenance
And select jobs
And run jobs
Then check on DataBase Transfer trips job is successful

