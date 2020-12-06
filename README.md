# Clean Code with Java - Simple Design, Refactoring & TDD

### :sparkles: Clarity in Code - Problem 1 - Gilded Rose - Introduction :sparkles:

Refer
- Problem statement: GildedRoseProblemStatement.md
- Before refactoring: GildedRoseADefaultItemTest.java
- After refactoring: GildedRoseRefactoredTest.java

Shortcuts
- Refactor (2 options):
	- Right Click on a value/variable -> Select Refactor
	- Alt + Shift + T

- Rename: Alt + Shift + R
- Extract Method: Alt + Shift + M
- Extract Local Variable: Alt + Shift + L
- Inline: Alt + Shift + I
- Outline: Ctrl + O

Few recommendations
- Use constants where ever applicable. (This is good coding standard and also, we can have a meaningful name)
- Extract method to keep the common lines of code/common functionality at one place.

### :sparkles: 4 Principles of Simple Design :sparkles:

- Run all tests
- Minimize Duplication
- Maximize Clarity
- Keep it small

##### Run all tests

- Code should work
- (Recommended) Have automated tests
- Design evolves (Design is not created in 1 day)
	```
		Need automated tests
		Developers should not be reluctant to make changes
	```
- (Recommended) TDD (Test Driven Development) leads to better tests and better design.

##### Minimize Duplication

- Must not keep same code in multiple places

Duplication leads to:
	- More bugs
	- More maintenance
	
##### Maximize Clarity

Code we write today will be maintained by someone else later

- That someone might be you a couple of months later.

Good starting point

- Focusing on Naming - Methods, Variables, Classes etc.

##### Keep it small

Effort involved in making something perfect is high

- Effort to improve Design - 90 to 99 is greater than 60 to 90

Does that effort give you significant returns ?

- Extra layer -> Additional complexity
- Extra code -> More code to maintain

So, keep it small

##### Summary

Simplest possible testable approach while

- Maximizing clarity and
- Reducing duplication

##### Exercise

- Refactor Code
```
	StudentHelper.isGradeB()
	StudentHelper.getGrade()
	StudentHelper.willQualifyForQuiz()
	
	After refactoring: StudentHelperRefactored.java
```

##### Most difficult challenge in programming

Naming!

- Creating good names is hard
- Make names as long as necessary
- Length of variable name is inversly proportional to scope
- Follow conventions
```
	Packages, Classes, Interfaces, Methods, Variables, Constants
	Project specific (get vs retrieve vs..)
```

##### Exercise

- Write code
```
	TextHelper.swapLastTwoCharacters()
	TextHelper.truncateAInFirst2Positions()
	
	Code implemented in TextHelperRefactored.java
```

##### Comments

Different types

- Type 1: API Comments
- Type 2: Comments to help other programmers understand your code
- Type 3: TODO, FIXME

Use Type 1 and Type 3 liberally!
Type 2 should focus on Why but not on What!

- Example: Sorting, Performance Optimizations
- In the above examples, we should have comments on why we chose this sorting
  and not on what this sorting is doing.
 
##### Exercise

- Refactor code
```
	Before refactoring: CustomerBOTest.java 
	After refactoring: CustomerBORefactoredTest.java
```

##### Attitude towards Unit Testing

- More important than code
```
	Lead to better design (Due to continuous refactoring)
```
- Unit tests are best written before code (TDD)
```
	TDD improves design and code quality
```
- Separated from production code
- Find defects early
```
	Continuous Integration
```

##### Unit Testing Principles

- Easy to understand
```
	Test should not take more than 15 seconds to read
```
- Test should fail only when there's a problem with the production code
- Test should find all problems with production code
- Tests should have as minimum duplication as possible
- Tests should run quickly

##### Principle 1: Easy to Understand

- Name of the Unit Test
```
	Should indicate the condition being tested and (if needed) the result
	1. testCustomerProductSum_AllProductsSameCurrency vs testCustomerProductSum
	2. testCustomerProductSum_DifferentCurrencies_ThrowsException vs testCustomerProductSum
```
- Highlight values important to the test
- One condition per test
- No exception handling in a test method

##### Principle 2: Fail only when there's a defect in CUT (Code Under Test)

- No dependencies between test conditions
- Avoid external dependencies
```
	Avoid depending on (db, external interface, network connection, container).
	Use Stubs/Mocks.
```
- Avoid depending on system date and random
```
	Avoid hard-coding of paths ("C:\TestData\dataSet1.dat"); // Runs well on my machine.
```

##### Principle 3: Test should find all defects in code

- Why else do we write test :)
- Test everything that could possibly break
```
	Test exceptions
	Test boundary conditions
```
- Use strong assertions
```
	Do not write "Tests for Coverage"
```
- Favorite maxim from JUnit FAQ
```
	"Test until fear turns to boredom."
```

##### Principle 4: Less duplication

- Avoid using the same code in multiple places which leads to duplication

##### Principle 5: Tests should run quickly

- (FACT) Long running tests are NOT run often
```
	Avoid reading from a File system or a Network
```
- A temporary solution might be to "collect long running tests into a separate test suite" and run it less often.

##### Result: Tests as Documentation

- Well written tests act as a great documentation
- Examples:
```
	1. testCustomerProductSum_AllProductsSameCurrency
	2. testCustomerProductSum_DifferentCurrencies_ThrowsException
	3. testCustomerProductSum_NoProducts
```

##### Exercise

To be refactored:
- UserLoginCheckerTest.java
- MenuAccessTest.java

After refactoring:
- UserLoginCheckerTestRefactored.java
- MenuAccessTestRefactored.java

### :sparkles: Refactoring :sparkles:

- Altering structure of code without affecting "Behavior"
- Toughest part of Refactoring is the order or sequencing of steps
- Continuous Refactoring aided by Tests - Leads to "Clean Code"

##### Refactoring - Best Practices

- Have Unit Tests
- Take small steps
- Run tests at each step

##### InfiniteTest Plugin

- Link: https://marketplace.eclipse.org/content/infinitest

```
	Infinitest is a continuous test runner for Java, and is valuable to developers using a
	unit testing tool called JUnit.
	This plugin is available for Eclipse and IntelliJ.
	
	Plugin configuration:
	Window -> Preferences -> Infinitest
```

##### Exercise

To be refactored:
- CustomerBOImpl.java
- Movie.java
- MenuAccess.java
- MenuAccessTest.java

After refactoring:
- CustomerBOImplRefactored.java
- MovieRefactored.java
- MenuAccessRefactored.java
- MenuAccessTestRefactored.java

##### Exercise

To be refactored:
- UserLoginChecker.java
- UserLoginCheckerTest.java

After refactoring:
- UserLoginCheckerRefactored.java
- UserLoginCheckerTestRefactored.java

### :sparkles: 10 Tips for Good Programmer :sparkles:

- Pair programming (2 people solving a problem)
- Boy Scout Rule (When modifying an existing code, make it better than it was)
- Continuous learning
- Learn Touch Typing
- Use keyboard (Use/Learn shortcuts of IDE/Tool which we use mostly)
- Ask why ?
- Work with smart people
- Understand all tools - IDE, Maven etc.
- Play with other languages and frameworks
- Understand different programming approaches (Object oriented, Functional programming, Structured)

### :sparkles: Test Driven Development (TDD) :sparkles:

##### TDD - 3 Steps

- RED - Write a simple test that fails
- GREEN - Write a simple code to make it succeed
- REFACTOR
```
	Make code adhere to "4 Principles of Simple Design"
	While keeping it at GREEN
```

##### TDD - 3 Laws

- No production code without failing tests
- Just enough test to make the code fail
- Just enough code to make the test pass

##### TDD Exercises

Refer tdd.md file for the exercises.

Refer com.d.tdd package for solutions

##### TDD - 3 Tips

- Unlearn
- Practice makes you perfect
```
	Takes time (2 to 3 months)
```
- Get a Mentor

### :sparkles: "Clean Code is a journey, not a destination" :sparkles:
