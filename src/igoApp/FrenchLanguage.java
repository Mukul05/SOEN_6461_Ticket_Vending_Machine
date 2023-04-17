package igoApp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class FrenchLanguage extends Language {
	private HashMap<String, String> map = new HashMap<>();
	private static FrenchLanguage instance;

	private FrenchLanguage() {
		try (InputStream input = FrenchLanguage.class.getClassLoader()
				.getResourceAsStream("resources/strings_fr.properties")) {

			Properties prop = new Properties();

			if (input == null) {
				System.out.println("Sorry, unable to find strings_fr.properties");
				return;
			}

			prop.load(input);

			Enumeration<?> e = prop.propertyNames();

			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				map.put(key, prop.getProperty(key));
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static FrenchLanguage getInstance() {

		if (instance == null) {
			instance = new FrenchLanguage();
		}
		return instance;
	}

	public String getTextString(String property) {
		if (map.containsKey(property)) {
			return map.get(property);
		}

		return null;
	}
}
