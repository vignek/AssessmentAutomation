package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
	
	private String propertyValue;
	
	public String get(String propertyKey) {
		Properties prop = new Properties();
		InputStream input = null;
		
		try {
			input = new FileInputStream("src/parameters.properties");
			prop.load(input);
			propertyValue = prop.getProperty(propertyKey);
		} 
		catch(IOException e) {
			e.printStackTrace();
		}		
		return propertyValue;
	}
	
}