package com.orangehrm.utils;

import org.apache.commons.collections4.functors.ExceptionPredicate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class PropertyReader {
    PropertyReader(){

    }

    static FileInputStream fileInputStream = null;
    static Properties properties =null;
    static Map<String, String> PROP_KEYS = new HashMap<>();

    static {
        try {
            fileInputStream = new FileInputStream(new File(System.getProperty("user.dir")+ "/src/main/resources/config.properties"));
            properties = new Properties();
            properties.load(fileInputStream);
            for(Object key : properties.keySet()){
                PROP_KEYS.put(String.valueOf(key), properties.getProperty(String.valueOf(key)));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(Objects.nonNull(fileInputStream)){
                try{
                    fileInputStream.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static String readKey(String key) throws Exception{
        if(key == null && properties.getProperty(key)== null){
            throw new Exception(properties.getProperty(key) + " not found.");
        }
        else{
            return PROP_KEYS.get(key);
        }
    }
}
