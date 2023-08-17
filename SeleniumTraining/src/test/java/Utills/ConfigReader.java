package Utills;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import Log.Log;

public class ConfigReader {

	public Properties properties = new Properties();

	public String getProperties(String key) {
		String value = null;
		try {
			// Load the properties file
			InputStream inputStream = ConfigReader.class.getResourceAsStream("/config.properties");
			properties.load(inputStream);
			inputStream.close();
			value = properties.getProperty(key);
			System.out.println("Fetched property value:" + value + " And Key is:" + key);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return value;
	}

	public static ConfigReader getInstance() {
		ConfigReader envProperties = new ConfigReader();
		return envProperties;
	}
}
