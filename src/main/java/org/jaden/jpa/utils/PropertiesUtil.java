package org.jaden.jpa.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 读取config.properties配置
 */
public final class PropertiesUtil {
	
	private PropertiesUtil() {
	}

	private static Properties properties = new Properties();

	private static final String UTF_8 = "UTF-8";

	static {
		InputStream in = PropertiesUtil.class.getResourceAsStream("/config.properties");
		try {
			properties.load(new InputStreamReader(in, UTF_8));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 如果没有找到key，就返回defauleValue默认值
	 * @return
	 */
	public static String get(String key, String defauleValue) {
		if (StringUtils.isNotBlank(key)) {
			String val = properties.getProperty(key.trim());
			if (StringUtils.isNotBlank(val)) {
				return val.trim();
			}
		}
		return defauleValue;
	}
	
}
