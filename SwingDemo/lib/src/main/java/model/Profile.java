package model;

import java.util.Properties;

public class Profile {
	
	public static Properties getProperties(String name) {
		
		Properties props = new Properties();

		String env = System.getProperty("env");

		if (env == null) {
			env = "dev";
		}

		String propertiesFile = String.format("/config/%s.%s.properties", name, env);
		System.out.println(propertiesFile);
		

		try {
			props.load(Profile.class.getResourceAsStream(propertiesFile));
		} catch (Exception e) {
			throw new RuntimeException("Cannot load properties file" + propertiesFile);
		}
		
		return props;
	}
}
