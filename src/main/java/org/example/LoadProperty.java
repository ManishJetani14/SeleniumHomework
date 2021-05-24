package org.example;

import java.io.FileInputStream;
import java.util.Properties;

public class LoadProperty
{   //object created for class
    static Properties prop;
    static FileInputStream input;
    static String fileName = "config.properties";
    static String fileLocation = "src/test/resources/TestData/config.properties";

    public String getProperty(String keyName)
    {
        prop = new Properties();
        //try and catch block
        try {
            input = new FileInputStream(fileLocation);
            prop.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //getting keyName
        return prop.getProperty(keyName);
    }
}
