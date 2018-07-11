package com.ef.Parser;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Date;

import com.ef.Parser.service.LogFileService;
import com.ef.Parser.service.LogService;
import com.ef.Parser.utils.ParametersUtil;
import com.ef.Parser.validate.ValidateParameters;

/**
 * Main program class. This class is set in pom.xml.
 * @author ramonsantos
 *
 */
public class Main {

	public static void main(String[] args) throws UnsupportedEncodingException, ParseException {
		Date startDate = new Date();
		String duration = new String();
		String accessLogPath = new String();
		int threshold = 0;

		LogFileService logFileService = new LogFileService();
		LogService logService = new LogService();
//		 args = new String[4];
//		 args[0] = "--startDate=2017-01-01.13:00:00";
//		 args[1] = "--duration=hourly";
//		 args[2] = "--threshold=100";
//		 args[3] =
//		 "--accesslog=/home/ramonsantos/Documentos/Java_MySQL_Test/access.log";

		if (args.length > 0 && args.length < 5) {
			if (ValidateParameters.hasAnyValid(args)) {
				for (String parameter : args) {
					if (accessLogPath.isEmpty() && ValidateParameters.isValidAccessLogPath(parameter)) {
						accessLogPath = ParametersUtil.getAccessLogPath(parameter);
					}

					if (startDate != null && ValidateParameters.isValidStartDate(parameter)) {
						startDate = ParametersUtil.getStartDate(parameter);
					}

					if (duration.isEmpty() && ValidateParameters.isValidDuration(parameter)) {
						duration = ParametersUtil.getDuration(parameter);
					}

					if (threshold == 0 && ValidateParameters.isValidThreshould(parameter)) {
						threshold = ParametersUtil.getThreshold(parameter);
					}
				}
				System.out.println("*****************************************");
				System.out.println("Access Log Path: " + accessLogPath);
				System.out.println("Start Date: " + startDate);
				System.out.println("Duration: " + duration);
				System.out.println("Threshold: " + threshold);
				if (!accessLogPath.isEmpty()) {
					logFileService.setPathFile(accessLogPath);
					System.out.println("--------------------------------");
					System.out.println("Loading database with .log file");
					System.out.println("This may take a few minutes...");
					logFileService.populateLogTable();
					System.out.println("--------------------------------");
				} else {
					System.out.println("Please enter the path of the log file.");
					return;
				}
				logService.analyzeIpAddressByPeriod(startDate, duration, threshold);
				System.out.println("Finished!");
				System.out.println("*****************************************");
				return;
			}
		}
	}
}
