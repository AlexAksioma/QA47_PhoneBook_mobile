package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

public class PropertiesXML {

    static Properties properties = new Properties();

    public static void main(String[] args) {
        setProperty("platformName", "Android",false, "pixel3");
        setProperty("deviceName", "Pixel_3",false, "pixel3");
        setProperty("platformVersion", "8.0",false, "pixel3");
        setProperty("appPackage", "com.sheygam.contactapp",false, "pixel3");
        setProperty("appActivity", ".SplashActivity",false, "pixel3");
        System.out.println(getProperties("deviceName", "pixel3"));
    }

    public static void setProperty(String key, String value, boolean clearFile, String device) {
        if (!clearFile) {
            try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/devices" +
                    File.separator + device.toLowerCase() + ".xml")){
                properties.loadFromXML(fileInputStream);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        properties.setProperty(key, value);
        try(FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/devices" +
                File.separator + device.toLowerCase() + ".xml")){
            properties.storeToXML(fileOutputStream, null);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getProperties(String key, String device){
        try(FileInputStream fileInputStream = new FileInputStream("src/main/resources/devices" +
                File.separator + device.toLowerCase() + ".xml")){
            properties.loadFromXML(fileInputStream);
            return properties.getProperty(key);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
