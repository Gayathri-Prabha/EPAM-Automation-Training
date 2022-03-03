Feature: Login Page
Description: Test the login functionality for OrangeHRM application

Background: To launch the chrome browser
						Given Open Browser
						
Scenario Outline: Login Page with various credential
					Given Login Page is Opened
					Given Username is '<username>' and password is '<password>'
					When user click on login button
					Then user should navigate to '<page>'
					
					Examples:
							| username | password   | page       |
							| Admin    | U@qBLVtm09 | dashboard  |
							| Ad       | abcd       | retryLogin |
							