package model.systemFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    private static Connection connection;

    private static final String connectionUrl = SystemProperties.dataBaseConnectionUrl;
    private static final String connectionUser = SystemProperties.dataBaseConnectionUser;
    private static final String connectionPassword = SystemProperties.dataBaseConnectionPassword;

    public static Connection getConnection(){
        try{

            connection = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword );
            System.out.println("Connection build successfully.");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    public static void closeConnection(){
        try {

            connection.close();
            System.out.println("Connection successfully closed.");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
