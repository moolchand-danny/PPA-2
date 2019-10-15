# Professional Practice Assignment 1 - CIS4930

#### Authors: Danny Moolchand, Timothy Crowley  

----

### Table of Contents

- [Professional Practice Assignment 1 - CIS4930](#professional-practice-assignment-1---cis4930)
      - [Authors: Danny Moolchand, Timothy Crowley](#authors-danny-moolchand-timothy-crowley)
    - [Table of Contents](#table-of-contents)
    - [Naming and Organizational Conventions](#naming-and-organizational-conventions)
    - [Setup and Execution Instructions](#setup-and-execution-instructions)
    - [Output of All Test Suites](#output-of-all-test-suites)
    - [Test Coverage Report](#test-coverage-report)
    - [Danny's Unit Testing & TDD Experience](#dannys-unit-testing--tdd-experience)
    - [Timothy's Unit Testing & TDD Experience](#timothys-unit-testing--tdd-experience)
    - [Screencast #1: Two Iterations of RGR Process](#screencast-1-two-iterations-of-rgr-process)
    - [Screencast #2: All Functions](#screencast-2-all-functions)

----

### Naming and Organizational Conventions  

We followed accepted Java naming conventions when naming our tests to reflect the function they served to test. Due to the use of Java, we had one class for the suite of JUnit tests, then constructed a second class to perform the functions required by the prompt.

| Calculator Functions | Unit Test Function |
| --- | --- |
| bmi()  | testBMI()  |
| retire()  | testRetire()  |
| distance()  | testDistance()  |
| splitTip()  | testSplitTip()  |

The calculator functions were all located in a main class and then called by standard convention "class.function()" when it was needed in the unit test function. The unit test file was similarily structured by having a single class and having individual functions for testing each calculator function. The unit test functions contained different "assertTrue", "assertEquals", etc. calls for validating the functions. 

---

### Setup and Execution Instructions  

As stated previously, this project was coded in Java and testing using the JUnit4 framework. It was coded using the Eclipse IDE and compiled with the Java SE Development Kit 8. For testing code coverage, we used an eclipse plugin EclEmma. Listed below are the download links:

[Java SE Development Kit 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)  
[Eclipse IDE](https://www.eclipse.org/eclipseide/2018-12/)  
[JUnit4](https://github.com/junit-team/junit4/wiki/Download-and-Install)  
[EclEmma](https://www.eclemma.org/)  

All of the pieces of software presented above working in unison allows a user to access the offered functions, see that
a suite of JUnit tests serve as docuementation for functionality, and verify the code coverage put forth in this report.
To access function use, the user would run our main.java file in their Eclipse IDE, and answer the questions put forth
by the console. To access the suite of tests, the user would run mainTest.java to see all of the tests pass. EclEmma is 
the plug-in for Eclipse that grants access to comprehensive code coverage reports, and can be seen by pressing the button
directly to the right of the usual run button.

---

### Output of All Test Suites  

This is picture proof of all our test cases passes for all functions. 4/4 Runs with all green (pass).

![Output of test cases passing](https://raw.githubusercontent.com/moolchand-danny/PPA-2/master/readme_assets/Test_Outputs.JPG)

---

### Test Coverage Report  

This is the test coverage report for our unit tests. All of our functions and tests reached above the minimum 85% coverage.

![Test coverage report of PPA-1](https://raw.githubusercontent.com/moolchand-danny/PPA-2/master/readme_assets/Code%20Coverage.JPG)

---

### Danny's Unit Testing & TDD Experience  

I enjoyed the experience with unit testing and the whole TDD prcoess. I completly understand the use, benefits, cons, and practicality of TDD; however, sometimes I was confused on what exactly to test when in the RGR process. Generally in the last three years of college, I have always written code first and tested it later, which is the complete opposite of how TDD works. When writing the tests first, I sometimes became lost on how to break up the function into testable pieces. For instance, when writing the distance function, I was unsure if we were supposed to pass the parameters into the function or have the user enter the variables after the function had been called. After deciding to go with the second option, we ran into another road-block on how to simulate the user entering inputs into the system console. After researching, I learned about InputStream and System.in() which allows us to simulate user input. Overall though, this has been a great learning experience for me as I learned how to use TDD - its pros/cons, how to write JUnit4 tests, and how to write in markdown. 

---

### Timothy's Unit Testing & TDD Experience  

My personal experience with unit testing and TDD was overall a good one, but sometimes consisted of frustration at not
moving as efficiently as I believe it could be. It felt like if I began by addressing the tests I would make as I created 
my functions, rather than needing to lay them all out before writing any code, the two different aspects could have fed off 
of each other and led to more cohesion. I think it's extremely useful for a project to spend an explicit amount of time
laying out requirements and expectations. There can be no discipline without direction of knowing which way you wish to go,
and communicating clearly about what is expected surely ends in a better result. In short, I think TDD helps to flesh out 
specifications, but is a hinderance when it treated as a requirement before delving into functionality. 

---

### Screencast #1: Two Iterations of RGR Process

Screencast for the distance() and testDistance() functions. Using the Red-Green-Refactor process of Test Driven Development. Done by Danny Moolchand.
![RGR process for distance()](https://raw.githubusercontent.com/moolchand-danny/PPA-2/master/readme_assets/Screencast_Distance.gif)  

Screencast for the bmi() and testBMI() functions. Using the Red-Green-Refactor process of Test Driven Development. Done by Timothy Crowley.
![RGR process for bmi()](https://raw.githubusercontent.com/moolchand-danny/PPA-2/master/readme_assets/Screencast_bmi.gif)

---

### Screencast #2: All Functions

Screencast for running all functions.
![Running PPA-1 and testing all functions](https://raw.githubusercontent.com/TimCrowley99/PPA-1/master/readme_assets/Screencast_functions1.gif)  

