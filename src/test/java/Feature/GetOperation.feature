Feature: GET feature 1


Scenario: Get id's of all booking
Given url 'https://restful-booker.herokuapp.com/booking'
When method GET
Then status 200
And print response

