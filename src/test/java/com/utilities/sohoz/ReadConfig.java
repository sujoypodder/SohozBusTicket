package com.utilities.sohoz;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File("./configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getAppUrl() {
		String Url = pro.getProperty("baseUrl");
		return Url;
	}

	public String getFname() {
		String from = pro.getProperty("from");
		return from;
	}

	public String getDname() {
		String destination = pro.getProperty("destination");
		return destination;
	}

	public String getchromepath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getfirefoxpath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}

}
