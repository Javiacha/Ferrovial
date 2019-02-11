Feature: Journal Voucher Monitoring
Scenario: Journal Voucher Monitoring Lists Download
Given we access Journal Voucher Monitoring 
And Select file type
And select a date
And click Search button
And click PDF File Download
And click EXCEL File Download
Then Journal Voucher Monitoring is successful