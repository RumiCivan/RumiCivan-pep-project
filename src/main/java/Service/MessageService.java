package Service;

import Service.AccountService;
import Service.MessageService;
import java.util.List;
import DAO.AccountDAO;
import DAO.MessageDAO;
import Model.Account;
import Model.Message;

public class MessageService {

    private MessageDAO messageDAO;

    public MessageService(){
        messageDAO = new MessageDAO();
    }

    public MessageService(MessageDAO messageDAO){
        this.messageDAO = messageDAO;
    }

    public Message create(Message message) {

        return messageDAO.create(message);
    }

    public List<Message> getAllMessages() {
        
        return messageDAO.getAllMessages();
    }

    public Message getOneMessageGivenMessageId(int id) {
        
        return messageDAO.getOneMessageGivenMessageId(id);
    }
    
}
