Feature: PUT features

Background:

* def requestPayload =
	"""
	{
    "name": "morpheus",
    "job": "zion resident"
}
	
	"""
	Scenario: Create a new field
	Given url 'https://reqres.in/api/users/2'
	And request requestPayload
	When method put
	Then status 200