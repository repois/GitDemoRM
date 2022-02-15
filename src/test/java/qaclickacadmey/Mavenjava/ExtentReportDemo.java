package qaclickacadmey.Mavenjava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {

	ExtentReports extent;

	@BeforeTest
	public void config() {
		// to give project dynamically no matter which system one is working.
		String path = System.getProperty("user.dir") + "\\ExtentReportDemo.java\\index.html";
		// create object of ESReporter class
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		// create object of EReports class
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Nidhi Mathur");

	}

	@Test
	public void intialDemo() {

		//extent.createTest("intialDemo");
		//forcefully failing the test
		ExtentTest test = extent.createTest("intialDemo");
		System.setProperty("webdriver.edge.driver", "C:\\Users\\rachi\\Documents\\UDEMY SELENIUM\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		
		driver.close();
		test.fail("result did not match");
		
		extent.flush();

	}
	/*extentsparkreporter responsible where your report should be created. In ESReporter
	 * we have to send exact path of report where we want t0 create report. The ESR
	 * creates a html file and do some configuration in that file. To set path of 
	 * file use (system.getProperty()). In (user.dir)->means get the path
	 * until the  main folder in which we want to create-> from that point write 
	 * (user.dir"\\reports\\index.html")->in main folder(in this case ExtentReports)
	 * main folder->create another folder naming->reports->then create index.html
	 * file. Store the whole file path in a String variable-> 'path'. Pass this
	 * 'path'->in extentSparkReporter() as an argument->extentSparkReporter(path).
	 * By using reporter object-> ExtentSparkReporter reporter = new ExtentSReporter()
	 *  we can do some config like, set the name of file,set the document title.
	 *  Anything we need to config-> (reporter.config().whatever we want to do(choose
	 *  method).ExtentSReporter after doing config reports to its main class->k\a
	 *  ExtentReports. Its a helper method to its main class-> ExtentReports
	 *   Extent(object of ExtentReports)->drive all tests and consolidate all tests.
	 * Now we've to attach reporter object to ExtentReports(reporter).
	 * Next step->to connect ExtentReports(in which we have all the config attached)
	 * to our test case, so that any pass or fail test can be generated in the form
	 * of html report. Make the object(extent)global and do
	 * (extent.create test(test name)). Now extent will monitoring test's pass/fail
	 * status. 
	 * (extent.create test(test name))->MANDATORY to write in every test case 
	 * method. When we create test a'UNIQUE'object is created by 'ExtentReports'.
	 * ExtentReport extent = extent.create test(test name)-> take object(extent)
	 * for further tweaking like screenshot,fail(result do not match). In this
	 * explicitly failing the test case.
	 * Next, when naturally/implicitly test case fail-> attach TestNGListeners to
	 * ExtentReports ans Listeners will report failure to ExtentReports.
	 */

}
