selenium-cucumber-java-maven
=================

selenium-cucumber : Automation Testing Using Java

selenium-cucumber is a behavior driven development (BDD) approach to write automation test script to test Web.
It enables you to write and execute automated acceptance/unit tests.
It is cross-platform, open source and free.
Automate your test cases with minimal coding.

Framework Architecture
--------------
	Project-Name
		|
		|_src/main/java
		|	|_driverFactory
		|	|	|_DriverFactory.java
		|	|
		|	|_pages.hompPage
		|	|	|_flights
		|	|	|_visa
		|	|	|_HomePage.jav
		|	|_qaUtils
		|		|_ConfigReader.java
		|		|...
		|
		|_src/test/java
		|	|_myHooks
		|	|	|_ApplicationHooks.java
		|	|
		|	|_userStepDefinitions
		|	|	|_HomePage.java
		|	|	|_Visa.java
		|	|	|...
		|_src/test/resources
            |_configFiles
            |   |_config.properties
			|_featuresFiles
				|_Sellics Assessment.feature
				|...

* **src/test/resources/features** - all the cucumber features files (files .feature ext) goes here.
* **src/test/java/userStepDefinition** - you can define step defintion under this package for your feature steps.
* **src/test/resources/configFiles** - When you run your test on remote browser/platform you have to provide capabilities and platform information here.

Writing a test
--------------
The cucumber features goes in the `features` library and should have the ".feature" extension.

You can start out by looking at `features/my_first.feature`. You can extend this feature or make your own features using some of the predefined steps that comes with selenium-cucumber.

Predefined steps
-----------------
By using predefined steps you can automate your test cases more quickly, more efficiently and without much coding.