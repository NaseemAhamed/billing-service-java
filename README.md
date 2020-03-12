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

100% coverage, 22 unit and integration tests, 0 bug, 0 vulnerability, 0 code smell, 0 debt and 0% duplication.


![Image](SonarQube%20results.jpg)

# Executables

Main class - src\main\java\com\retail\pricing\billing\CalculateBill.java

System Integration Test class - src\test\java\com\retail\pricing\billing\CalculateBillTest.java

# Maven Script

1) Execute 'mvn clean install' to build, run unit test cases and generate Jacoco coverage report.

2) After the execution, the coverage report can be viewed from target\jacoco-ut\index.html.

3) To run SonarQube, download it from https://www.sonarqube.org/downloads/ and execute sonarqube-7.4\bin\windows-x86-64\StartSonar.bat depending on the OS

4) Execute 'mvn sonar:sonar' to analyse the package for comprehensive report on code quality.




