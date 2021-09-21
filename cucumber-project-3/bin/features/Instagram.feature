Feature:
As a user
I want to navigate to the Instagram login page
from there enter username and password to go to the home page of Instagram

Scenario: Enter login details
Given the user launches login Page of Instagram
When the user is redirected to login page
And the user provides username as hari
And the user provides the password as hari
And the user clicks on login button
Then the user should be redirected to home page of Instagram
And the user sees their home page of Instagram

Scenario Outline: Enter login details
Given the user launches login Page of Instagram
When the user is redirected to login page
And the user provides username as <username>
And the user provides the password as <password>
And the user clicks on login button
Then the user should be redirected to home page of Instagram
And the user sees their home page of Instagram

Examples:
|username|password|
|guru|guru|
|shiva|shiva|