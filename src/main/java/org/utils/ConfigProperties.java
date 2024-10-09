package org.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    private Properties properties;
    private String configFilePath;

    public ConfigProperties(String configFilePath) throws IOException {
        this.configFilePath = configFilePath;
        properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(configFilePath);
        properties.load(fileInputStream);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String setProperty (String key, String value){
        String str = (String) properties.setProperty(key,value);
        return str;
    }

}
