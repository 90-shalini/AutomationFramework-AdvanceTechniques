package com.tranings.advanceselenium.waytoautomation.library;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.NumberFormat;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.TestListenerAdapter;
import org.testng.xml.XmlSuite;

import com.tranings.advanceselenium.waytoautomation.tests.TestScriptSimpleElements;

public class CustomizedTestNGReports extends TestListenerAdapter implements IReporter {

	private static PrintWriter  f_out;
	private static final String OUT_FOLDER = "custom-test-report";
	private final static Logger logger = Logger.getLogger(CustomizedTestNGReports.class);
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
			String outputDirectory) {
		//	    //Iterating over each suite included in the test
		//	    for (ISuite suite : suites) {
		//	      //Following code gets the suite name
		//	      String suiteName = suite.getName();
		//	      //Getting the results for the said suite
		//	      Map<String, ISuiteResult> suiteResults = suite.getResults();
		//	      for (ISuiteResult sr : suiteResults.values()) {
		//	        ITestContext tc = sr.getTestContext();
		//	       
		//	        System.out.println("Report output diorectory:" +tc.getOutputDirectory());
		//	        System.out.println("Passed tests for suite '"+suiteName+"' is:"+tc.getPassedTests().getAllResults().size());
		//	        System.out.println("Failed tests for suite '"+suiteName+"' is:"+tc.getFailedTests().getAllResults().size());
		//	        System.out.println("Skipped tests for suite '"+suiteName+"' is:"+tc.getSkippedTests().getAllResults().size());
		//	      }
		//	}


		try
		{
			/**createWriter method will simply create the output directory and the index html file.**/
			f_out = createWriter(OUT_FOLDER);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		/**startHtmlPage(f_out) method will start the html stream, 
 		creating a basic html skeleton like creating HEAD and BODY part of html report page.**/
		startHtmlPage(f_out);

		//Code to populate the HTML table. This table will show the module details, test execution status, browser details… etc
		/**This method is responsible for getting all test results, fetching 
		 * data from TestNG.xml file and populating the HTML 
		 * tables with these data. You can design it the way you want**/
		generateTestExecutionStatus(suites);

		/**Similarly endHtmlPage(f_out); method will close the html stream
		 * @return **/
		endHtmlPage(f_out);

		f_out.flush();
		f_out.close();

	}


	/** Starts HTML Stream */
	public void startHtmlPage(PrintWriter out)
	{
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">");
		out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		out.println("<head>");
		out.println("<title> My Custom Report </title>" );

		/* Include Java Script and JQuery */
		//out.println("<script type=\text/javascript\ src=\stylesheets/jquery-latest.js\></script");
		/* Include Style Sheets */
		out.println("<link rel=\"stylesheet\" href=\"stylesheets/sexybuttons.css\" type=\"text/css\" />");
		out.println("<link rel=\"stylesheet\" href=\"stylesheets/custom-report-stylesheet.css\" type=\"text/css\" />");

		out.println("</head>");
		out.println("<body><br/>");

		Calendar cal = Calendar.getInstance();
		out.println("<br/><div align=\"right\">Report generated on: " + cal.getTime() + "</div><br/><br/>");

		out.flush();
	}

	/** Finishes HTML Stream */
	public void endHtmlPage(PrintWriter out)
	{
		out.println("</div></div></div></div>");
		out.println("<div class=\"footer\"> &copy; <a href=\"https://seleniumexperience.wordpress.com\">2013 WordPress.com</a></div>");
		out.println("</body></html>");
	}

	private void generateTestExecutionStatus(List<ISuite> suites)
	{
		String testName = "";

		int totalPassedMethods = 0;
		int totalFailedMethods = 0;
		int totalSkippedMethods = 0;
		int totalSkippedConfigurationMethods = 0;
		int totalFailedConfigurationMethods = 0;
		int totalMethods = 0;

		int suite_totalPassedMethods = 0;
		int suite_totalFailedMethods = 0;
		int suite_totalSkippedMethods = 0;

		String suite_passPercentage = "";
		String suiteName = "";

		ITestContext overview = null;
		HashMap<String, String> dashboardReportMap = new HashMap<String, String>();

		for (ISuite suite : suites)
		{
			suiteName = suite.getName();
			logger.info(">> " + suiteName + " <<");
			Map<String, ISuiteResult> tests = suite.getResults();

			for (ISuiteResult r : tests.values())
			{
				overview = r.getTestContext();
				testName = overview.getName();

				totalPassedMethods = overview.getPassedTests().getAllMethods().size();
				totalFailedMethods = overview.getFailedTests().getAllMethods().size();
				totalSkippedMethods = overview.getSkippedTests().getAllMethods().size();

				totalMethods = overview.getAllTestMethods().length;

				NumberFormat nf = NumberFormat.getInstance();
				nf.setMaximumFractionDigits(2);
				nf.setGroupingUsed(true);

				String includedModule ="";
				String includedGroup = "";

				ITestNGMethod[] allTestMethods = overview.getAllTestMethods();
				for (ITestNGMethod testngMethod : allTestMethods)
				{
					String[] modules = testngMethod.getGroups();
					for (String module : modules)
					{
						for (String moduleName : modules)
						{

							// Code to store and process testng groups …

							String browser = overview.getCurrentXmlTest().getParameter("browser");
							String browser_version = overview.getCurrentXmlTest().getParameter("browser_version");
							String platform = overview.getCurrentXmlTest().getParameter("platform");

							f_out.println("<p><b>Overall Execution Summary</b></p>");


						}
					}
				}
			}
		}
	}
	
	private PrintWriter createWriter(String outdir) throws IOException
	{
	new File(outdir).mkdirs();
	return new PrintWriter(new BufferedWriter(new FileWriter(
	new File(".\\test-output", "customized-test-run-report.html"))));
	}
}
