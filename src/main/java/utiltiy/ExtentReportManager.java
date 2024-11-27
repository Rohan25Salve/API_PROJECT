package utiltiy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class  ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;

    // Thread-safe ExtentTest instance for parallel tests
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentReports setupExtentReport() {
        String reportPath = System.getProperty("user.dir") +"/test-output/ExtentReport.html";
        sparkReporter = new ExtentSparkReporter(reportPath);

        // Customizations for the report
        sparkReporter.config().setReportName("Test API Report");
        sparkReporter.config().setDocumentTitle("API Report");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester", "Your Name");
        extent.setSystemInfo("Browser", "Chrome");
        return extent;
    }

    public static ExtentTest createTest(String testName) {
        ExtentTest test = extent.createTest(testName);
        extentTest.set(test);
        return test;
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
