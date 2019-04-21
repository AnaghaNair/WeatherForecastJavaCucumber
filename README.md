# Read Me
-------------------------------------------------------

Environment
-----------------------
Java Version : 1.8
Maven Version: 3.3.9
O S          : Windows 10 Home



Pre Conditions
-----------------------

1. Build and run the application to be tested locally - Refer https://github.com/buildit/acceptance-testing for more information.

2. Java and Maven should be installed properly in the machine.

Running the test cases
-----------------------
1. Download the project and extract it
2. Import the project into an IDE like Eclipse
3. Run the 'RunTest.java' file as a Junit Test [WeatherForecast\WeatherForecast\src\test\java\runner\RunTest.java]
4. Now the project build will start and will execute the test cases

OR

1. Download the project and extract it
2. Open command prompt and navigate to the project root folder [WeatherForecast] where POM.xml file is present
3. Now execute the following command

	mvn clean test
	
4. Now the project build will start and will execute the test cases

Note: All th tests will be executed in the ssame browser session unless there are failed test where the browser closes and opens a fresh session for next test

Test Types
-----------------------
There are 3 types of tests available in this framework. 
1. @HealthCheck --> This will run a test to check whether the application is up and running fine.  [Use tags= "@HealthCheck" in "RunTest.java"]
2. @Smoke --> This will test the basic functionality of the application for a minimum set of data. [Use tags= "@Smoke" in "RunTest.java"]
3. @Regression --> This will run all the tests. [Use tags= "@Regression" in "RunTest.java"]

Running the failed Test cases
-----------------------------
After the test execution the failed test scenarios will be captured into the rerun.txt file under target/HTML-Report folder. These failed test cases can be executed again by running the ReRunFailedTests.java class.


Test Report
-----------------------
The Cucumber Test report will be present in the following location
	[ WeatherForecast]\target\HTML-Report\index.html ]
	
	
Other Features which can be added to this framework.
----------------------------------------------------
1. Scenarios names,result etc can be captured in an excel sheet using Apache poi, and this can be used to send an automated mail with test reports using SMTP server.
2. Cross Browser testing can be implemented.
3. Environment variables such as Browser,Region can be passed from the Jenkins Job.
4. Test execution can be scheduled using Jenkins or by local setup.
	
