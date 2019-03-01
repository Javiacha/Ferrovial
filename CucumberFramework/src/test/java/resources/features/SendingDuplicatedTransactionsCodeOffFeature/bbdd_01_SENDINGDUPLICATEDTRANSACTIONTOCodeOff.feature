Feature: bbdd_01_SENDINGDUPLICATEDTRANSACTIONTOCodeOff
Scenario: bbdd_01_SENDINGDUPLICATEDTRANSACTIONTOCodeOff
Given we access Final Code Off Review 
And select database schema
And select date 
And click Search button
And select a transaction
And click Discard button 
Then transaction has been correctly discarded