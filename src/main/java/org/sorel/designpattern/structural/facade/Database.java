package org.sorel.designpattern.structural.facade;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Database {
    private Database() {

    }

    public static Properties getProperties(String dbName) {
        String fileName = dbName + ".txt";
        Properties properties = new Properties();
        try (InputStream inputStream = Database.class.getClassLoader().getResourceAsStream(fileName)) {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("Warning: " + fileName + " is not found.");
        }
        return properties;
    }
}
