package com.webautomation.reports;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentManager {

public static ExtentReports extent;
public static String screenshotfolderpath;

public static ExtentReports getInstance(String reportpath) {
	
	if(extent == null) {
		String filename = "Report.html";
		Date d = new Date();
		String foldername = d.toString().replace(":", "_");
		String freportpath=System.getProperty("user.dir")+reportpath;
		new File(freportpath+foldername+"//screenshots").mkdirs();
		freportpath=freportpath+foldername+"//";
		screenshotfolderpath = freportpath+"screenshots//";
//		System.out.println(reportpath+filename);
		createInstance(freportpath+filename);
		
	}
	
	return extent;
	
}

private static ExtentReports createInstance(String filename) {
	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filename);
	htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
    htmlReporter.config().setChartVisibilityOnOpen(true);
    htmlReporter.config().setTheme(Theme.STANDARD);
    htmlReporter.config().setDocumentTitle("Reports");
    htmlReporter.config().setEncoding("utf-8");
    htmlReporter.config().setReportName("Reports - Automation Testing for Online Shopping Portal");
    
    
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
    
    return extent;
	
}

}

