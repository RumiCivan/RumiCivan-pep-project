package DAO;

import DAO.AccountDAO;
import Model.Account;
import Util.ConnectionUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {

    public Account register(Account account){
        Connection connection = ConnectionUtil.getConnection();

        try {
            String sql = "insert into account (username, password) values (?, ?);";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.executeUpdate();

            //
            String sql2 = "select * from Account where username = ? and password = ?;";

            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
            preparedStatement2.setString(1, account.getUsername());
            preparedStatement2.setString(2, account.getPassword());

            ResultSet rs = preparedStatement2.executeQuery();
            while(rs.next()){
                Account registeredAccount = new Account(rs.getInt("account_id"), 
                    rs.getString("username"), 
                    rs.getString("password"));

                return registeredAccount;            
            }  
            
            
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }


        return null;

    }

    public Account login(Account account){
        Connection connection = ConnectionUtil.getConnection();

        try {
            String sql = "select * from Account where username = ? and password = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                Account loginAccount = new Account(rs.getInt("account_id"), 
                    rs.getString("username"), 
                    rs.getString("password"));

                return loginAccount;            
            }            
            
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        
        return null;
    }

    public boolean getUserById(int id) {
        Connection connection = ConnectionUtil.getConnection();

        try {
            String sql = "select * from Account where account_id = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);    
            
            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()){
                return true;            
            }            
            
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        
        return false;
    }

    
}
