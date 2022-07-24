package reusableComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesOperation {

	public static String ReadProp(String Key) throws Exception {
		Properties prop = new Properties();
		String	ConfigPath=System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
		File F = new File(ConfigPath);
		FileInputStream Fis = new FileInputStream(F);
		prop.load(Fis);
		String value = prop.getProperty(Key);
		Fis.close();
		if (StringUtils.isEmpty(value)) {
			throw new Exception ("Value is not Specified for Key"+ Key + "in Properties File");
		}
		
		return value;
	}
}
