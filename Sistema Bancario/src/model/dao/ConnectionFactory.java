package model.dao;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static Properties properties;
    private ConnectionFactory(){
    }
    public static Connection getConnection() throws 
            SQLException, IOException{
        readProperties();
        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String pwd = properties.getProperty("db.pwd");
        return DriverManager.getConnection(
                url,user,pwd);
    }
    private static void readProperties() throws IOException
    {
        if(properties==null){
            Properties props = new Properties();
            InputStream file = ConnectionFactory.class.getResourceAsStream("DataBase.properties");
            if (file == null) {
                file = Files.newInputStream(Paths.get("src", "model", "dao", "DataBase.properties"));
            }
            props.load(file);
            file.close();
            properties = props ;
        }
    }
}
