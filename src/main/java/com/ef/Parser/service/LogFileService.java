package com.ef.Parser.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.ef.Parser.dao.LogDAO;
import com.ef.Parser.domain.Log;
import com.ef.Parser.utils.DateUtil;

/**
 * Class of Service for loading log files (CSV)
 * Class responsible for managing business rules and performing interaction with the DAO layer
 * @author ramonsantos
 *
 */
public class LogFileService {

	private LogDAO logDao;

	private String pathFile;

	public LogFileService() {
		this.logDao = new LogDAO();
		this.pathFile = new String();
	}

	/**
	 * Method responsible for loading a file into the MySQL database
	 * @throws UnsupportedEncodingException
	 * @throws ParseException
	 */
	public void populateLogTable() throws UnsupportedEncodingException, ParseException {
		Scanner scanner = null;

		try {
			scanner = new Scanner(new InputStreamReader(new FileInputStream(pathFile), "UTF-8")).useDelimiter("\n");
			int lineCount = 0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String delimiter = "|";
				StringTokenizer st = new StringTokenizer(line, delimiter);

				String dateOfAccess = "";
				String ipAddress = "";
				Integer requestStatus = 0;
				String request = "";
				String userAgent = "";

				int i = 0;

				while (st.hasMoreElements() && i < 6) {
					switch (i) {
					case 1:
						dateOfAccess = (String) st.nextElement();
						break;
					case 2:
						ipAddress = (String) st.nextElement();
						break;
					case 3:
						request = (String) st.nextElement();
						break;
					case 4:
						requestStatus = Integer.getInteger((String) st.nextElement());
						break;
					case 5:
						userAgent = (String) st.nextElement();
						break;
					}
					i++;
				}
				Date date = DateUtil.formatStringToDate(dateOfAccess);
				Log log = new Log(date.getTime(), ipAddress, requestStatus, request, userAgent);
				logDao.saveOrUpdate(log);
				lineCount++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("ERRO: O arquivo não pôde ser lido!");
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}

	public String getPathFile() {
		return pathFile;
	}

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

}
