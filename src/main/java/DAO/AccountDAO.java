package DAO;

import Service.AccountService;
import Service.MessageService;
import DAO.AccountDAO;
import DAO.MessageDAO;
import Model.Account;
import Model.Message;
import Util.ConnectionUtil;
import io.javalin.http.Context;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

    public Account register(Account acc){
        Connection connection = ConnectionUtil.getConnection();

        try {
            String sql = "insert into account (username, password) values (?, ?);";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, acc.getUsername());
            preparedStatement.setString(2, acc.getPassword());
            preparedStatement.executeUpdate();
            return acc;
            
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }


        return null;

    }

    public Account login(Account acc){
        Connection connection = ConnectionUtil.getConnection();

        try {
            String sql = "";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.executeUpdate();
            return acc;
            
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        

        return null;
    }

    
}
