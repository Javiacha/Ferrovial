Feature: tsm_demo
Scenario: tsm_demo
Given access Toll Control Management
And check string name is not present
And upload new document
Then check new document is uploaded