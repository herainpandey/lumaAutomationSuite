package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class Helper {

    public static String generateRandomAccount(){
        Random rand = new Random();
        int num = rand.nextInt(90000) + 10000;
        return String.valueOf(num);
    }


    public static String generateRandomTransactionAmount(){
        Random rand = new Random();
        int num = rand.nextInt(900) + 100;
        return String.valueOf(num);

    }

    public static String generateRandomSSNNumber(){
        Random rand = new Random();
        int num = rand.nextInt(900000000) + 100000000;
        return String.valueOf(num);

    }


    public static String getProperties(String data) throws IOException {
        String value ="";
         try{
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\testData.properties");
            Properties prop = new Properties();
            prop.load(fis);
            value =  prop.getProperty(data);
        }catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }
}
