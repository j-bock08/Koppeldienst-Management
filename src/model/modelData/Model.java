package model.modelData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.objects.Rank;
import model.objects.User;
import model.systemFiles.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

public class Model implements ModelInterface {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static Connection connectionToDataBase = null;
    private final ArrayList<User> accountList = new ArrayList<>();
    public User currentUser = null;


    @Override
    public void initData() {
        connectionToDataBase = DatabaseConnector.getConnection();

        //insertUserAccountsToDataBase();
        initializeUserAccountsFromDataBase();
        //initializeUserAccountsFromDataBase();

    }

    @Override
    public void closeProgram() {
        DatabaseConnector.closeConnection();
    }

    private void initFirstUser(){
        accountList.add(new User(1, "admin", "1234", Rank.Admin));
        accountList.add(new User(2, "jona", "1212", Rank.User));
    }

    private void initializeUserAccountsFromDataBase() {
        String query = "SELECT * FROM accounts";

        try (PreparedStatement stat = connectionToDataBase.prepareStatement(query)) {
            ResultSet result = stat.executeQuery();

            while (result.next()) {
                int id = result.getInt("accountId");
                String username = result.getString("username");
                String password = result.getString("password");
                Rank rank = Rank.valueOf(result.getString("rank"));

                accountList.add(new User(id, username, password, rank));
            }

            System.out.println("All Users got initialized.");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void insertUserAccountsToDataBase() {
        String query = "INSERT INTO accounts (username, password, rank) VALUES(?, ?, ?)";

        try (PreparedStatement stat = connectionToDataBase.prepareStatement(query)) {

            for (User userAccount : accountList){

                stat.setString(1, userAccount.getUserName());
                stat.setString(2, userAccount.getPassword());
                stat.setString(3, userAccount.getRank().name());

                stat.addBatch();
            }

            stat.executeBatch();
            System.out.println("Accounts successfully inserted in database.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //region systemMethods
    @Override
    public User findUserByUserName(String inputUsername) {
        for (User entry : accountList) {
            if (entry.getUserName().equalsIgnoreCase(inputUsername)){
                return entry;
            }
        }
        return null;
    }
    //endregion

    //region getter & setter
    @Override
    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    //endregion
}