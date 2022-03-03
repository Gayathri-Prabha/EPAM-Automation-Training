#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Calculator Application

Background: To launch the chrome browser
						Given Browser is open

  @UITest
  Scenario Outline: Calculator UI Test number button
    Given Calculator page is open
    Then Calculator has number '<number>'
    
    Examples: 
    		|number|
    		|0     |
    		|1     |
    		|2     |
    		|3     |
    		|4     |
    		|5     |
    		|6     |
    		|7     |
    		|8     |
    		|9     |

  @UITest
  Scenario Outline: Calculator UI Test operators
    Given Calculator page is open
    Then Calculator has operator '<operator>'

    Examples: 
      |operator|
      |+       |
      |-       |
      |*       |
      |/       |
      |=       |
      
  @UITest
  Scenario: Calculator UI Test display screen
    Given Calculator page is open
    Then Calculator has display field
    
  @UITest
  Scenario Outline: Calculator UI Test button color
    Given Calculator page is open
    Then Calculator '<button>' has color '<color>'
    
    Examples: 
      |button| color |
      |2     | Black |
      |5     | Black |
      |*     | Blue  |
      |/     | Blue  |
      |=     | Red   |
      
  @Functional 		
  Scenario Outline: Calculator number should come on display scree
    Given Calculator page is open
    And number button is clicked '<number>'
    Then display screen should have number '<number>'
    
    Examples:
			|number|
			|0     |
			|1     |
			|2     |
			|3     |
			|4     |
			|5     |
			|6     |
			|7     |			
			|8     |
			|9     |

  @Functional 		
  Scenario Outline: Calculator Add functionality
    Given Calculator page is open
    And number button is clicked '<number>'
    And Operator button is clicked '<operator>'
    And Number button is click '<number2>'
    And Operator button is clicked '<operator2>'
    Then display screen should have number '<result>'
    
    Examples:
				|number | operator |number2 | operator2 | result |
				|2      | +      	 | 4 	    | =				  |  6     |

	@DataTable
	Scenario: 
		Given Calculator page is open
		And Following button are clicked
			|2|
			|+|
			|1|
			|=|
		Then Display field should have 3

	@DataTableExample
	Scenario: Library add book functionality
		Given Library has following book
				|bookName| author |
				|ABC     | Mr ABC |
				|DEF     | Mr. DEF|
				|FGH     | Ms EFG |
		When you add a new book with name 'LMN' and author name 'VGH'
		
		Then Final book list is
				|book| author |
				|ABC | Mr ABC |
				|DEF | Mr. DEF|
				|FGH | Ms EFG |
				|LMN | VGH    |
