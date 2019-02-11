Feature: DMV Agreements
Scenario: Check DMV Agreements
Given we access DMV Agreements 
And select an State from the DMV Agreements list
And enable or disable an State from the DMV Agreements list
Then Modify DMV Agreements State modification is done successfully