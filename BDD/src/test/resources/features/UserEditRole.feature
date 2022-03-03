Feature: Users Page
Description: Edit the admin role in Users Page for OrangeHRM application

Background: To launch the chrome browser
						Given Open Browser
						
Scenario: Modify the admin role 
					Given Username is 'Admin' and password is 'U@qBLVtm09'
					When user click on login button
					Then user should navigate to Dashboard
					When user click on admin option
					And user click on user management option
					And user click on users option
					Then user should navigate to Users Page
					When user click on edit icon where Username is amanda
					And user click on admin role dropdown
					Then user should select Global Admin
					And user should click on save button
					Then user should be able to see Global Admin under User Role(s) for amanda
					When user click on edit icon where Username is amanda
					And user click on admin role dropdown
					Then user should select --Select--
					And user should click on save button
					Then Global Admin should not be present under User Role(s) for amanda
					When user click on dropdown
					And user click on Logout button
					Then user should navigate to Login Page
