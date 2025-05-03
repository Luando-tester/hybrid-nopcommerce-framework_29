package data;

import commons.GlobalContants;

import java.io.*;
import java.util.Properties;

public class UserProperties {
    public static void main(String[] args) {

        try (InputStream input = new FileInputStream(GlobalContants.DATA_TEST_PATH + "user.properties")) {

            Properties prop = new Properties();
            prop.load(input);
            System.out.println(prop.getProperty("firstname"));
            System.out.println(prop.getProperty("lastname"));
            System.out.println(prop.getProperty("company"));
            System.out.println(prop.getProperty("email"));
            System.out.println(prop.getProperty("password"));

        } catch (IOException io) {
            io.printStackTrace();
        }

    }
}
