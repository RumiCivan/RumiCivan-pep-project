package DAO;

import Service.AccountService;
import Service.MessageService;
import DAO.AccountDAO;
import DAO.MessageDAO;
import Model.Account;
import Model.Message;
import Util.ConnectionUtil;
import io.javalin.http.Context;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {

    public Message create(Message message) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            String sql = "insert into message(posted_by, message_text, time_posted_epoch)values(?, ?, ?);";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, message.getPosted_by());
            preparedStatement.setString(2, message.getMessage_text());
            preparedStatement.setLong(3, message.getTime_posted_epoch());
            preparedStatement.executeUpdate();

            //

            String sql2 = "select * from message where posted_by = ? and message_text = ? and time_posted_epoch = ?;";
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
            preparedStatement2.setInt(1, message.getPosted_by());
            preparedStatement2.setString(2, message.getMessage_text());
            preparedStatement2.setLong(3, message.getTime_posted_epoch());
            ResultSet rs = preparedStatement2.executeQuery();

            while (rs.next()) {
                Message returnMessage = new Message(
                    rs.getInt(1), rs.getInt(2), 
                    rs.getString(3), rs.getLong(4));
                return returnMessage;
            }           
            
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        
        return null;
    }

    public List<Message> getAllMessages() {
        Connection connection = ConnectionUtil.getConnection();
        List<Message> messagesList = new ArrayList<>();

        try {

            String sql = "select * from Message";
            java.sql.Statement st = connection.createStatement();
            
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                Message message = new Message(
                    rs.getInt(1), 
                    rs.getInt(2), 
                    rs.getString(3), 
                    rs.getInt(4));

                messagesList.add(message);
            }

            return messagesList;


        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());

        }
        
        return null;
    }

    public Message getOneMessageGivenMessageId(int id) {
        Connection connection = ConnectionUtil.getConnection();

        try {
            String sql = "select * from Message where message_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);           

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Message message = new Message(
                    rs.getInt(1), 
                    rs.getInt(2), 
                    rs.getString(3), 
                    rs.getInt(4));

                return message;
            }         
            
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }        
        
        return null;
    }
    
}
