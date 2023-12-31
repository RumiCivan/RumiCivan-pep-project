package Service;

import Service.MessageService;
import java.util.List;
import DAO.MessageDAO;
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

    public Message deleteOneMessageGivenMessageId(int id) {
        return messageDAO.deleteOneMessageGivenMessageId(id);
    }

    public Message updateMessageGivenMessageId(int id, String text) {
        return messageDAO.updateMessageGivenMessageId(id, text);
    }

    public List<Message> getAllMessagesFromUserGivenAccountId(int accountId) {
        return messageDAO.getAllMessagesFromUserGivenAccountId(accountId);
    }
    
}
