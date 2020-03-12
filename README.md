# Billing Service
A utility that does discounting on the generated bills based on the entitlements of the user and price plans. The project is covered with extensive Unit test cases and coverage reports that are integrated with SonarQube.

# Technology stack 

Java - Employed Factory Design Pattern

Junit and Mockito - Unit testing with mocks

Maven - To Manage dependencies and plugins

Surefire - To generate JUnit test case reports in XML form

Jacoco - To generate JUnit code coverage reports

SonarQube - To perform code analysis and to record the coverage fed from Jacoco

# Resources 

UML - billing-service-java\uml.ucls

![Image](UML%20Diagram.png)

SonarQube report -  billing-service-java\sonarqube results.png

![Image](SonarQube%20results.jpg)

Main class - src\main\java\com\retail\pricing\billing\CalculateBill.java

Main Test Class - src\test\java\com\retail\pricing\billing\CalculateBillTest.java

# Maven Script

'mvn test' - To run unit test cases

To run SonarQube, download it from https://www.sonarqube.org/downloads/ and execute sonarqube-7.4\bin\windows-x86-64\StartSonar.bat depending on the OS and run 'mvn sonar:sonar' to deploy the package for code analysis.

# Project status

94.4% coverage, 15 unit tests, 0 bug, 0 vulnerabilities, 0 code smells, 0 debt and 0% duplications.




