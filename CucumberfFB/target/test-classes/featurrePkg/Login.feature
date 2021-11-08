Feature: Application Login

Scenario Outline: Login with valid data.
Given Initialize the browser
And User will land to Login page "https://www.facebook.com/" and need to input credentials
When User enters <username> and <password>
Then User will redirect to Home page and acces the track specified courses
Then User click profile section


Examples:

|username                     |password 	|
|xyz@gmail.com                |123456789  |