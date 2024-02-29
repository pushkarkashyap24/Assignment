Feature: POST feature 1

Background:

* def requestPayload =
	"""
	{
    "name": "morpheus",
    "job": "leader"
	}
	
	"""
	Scenario: Create a new booking
	Given url 'https://reqres.in/api/users'
	And request requestPayload
	When method post
	Then status 201