package TestRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features/Gap.feature"}, //this is the location of feature file
        monochrome = true, // this is used to set the console output is much readable
        glue ={"stepdef"} , // this is the location of step definition files
        //format = {"pretty", "json:target/json-report.json", "junit:target/junit-report.xml", "html:target/html"}, // this is a format in different types of formats for the output reports
        tags ={"@Function"}    // this is like priority of test cases. suppose we have 5 scenarios in our feature.
        // we wanna execute only 3 scenarios priority based.so, we need to mention tags above every scenario.
        // @smoke ..... @login.... @Sanity ...naming conventions are not standards
)
public class GmailRunner extends AbstractTestNGCucumberTests {
	/*@BeforeClass
	public static void setup() {
		System.setProperty("cucumberReportPath", "target/extentreport/TestExecution-" + GmailElements.GetDateTimeInYYYYMMDDHHMMSS() + ".html");
		
	}
	
	@AfterClass
	public void teardown(){
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", GmailElements.OS);
        Reporter.setTestRunnerOutput("Sample test runner output message");
	}
	*/


}

