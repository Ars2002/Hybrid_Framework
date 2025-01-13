package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {
	private static ExtentReports extentReports;

	public static ExtentReports getReportInstance() {
		if (extentReports == null) {
			String reportPathString = "reports/extent-report.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(reportPathString);
			reporter.config().setReportName("Automation Test Result");
			reporter.config().setDocumentTitle("Test Report");

			extentReports = new ExtentReports();
			extentReports.attachReporter(reporter);
		}

		return extentReports;
	}
}
