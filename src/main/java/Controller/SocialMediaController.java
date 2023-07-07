package Controller;

import io.javalin.Javalin;
import io.javalin.http.Context;

import Service.AccountService;
import Service.MessageService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.AccountDAO;
import DAO.MessageDAO;
import Model.Account;
import Model.Message;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller. The endpoints you will need can be
 * found in readme.md as well as the test cases. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
public class SocialMediaController {
    /**
     * In order for the test cases to work, you will need to write the endpoints in the startAPI() method, as the test
     * suite must receive a Javalin object from this method.
     * @return a Javalin app object which defines the behavior of the Javalin controller.
     */

    AccountService accountService;
    MessageService messageService;

    public SocialMediaController(){
        this.accountService = new AccountService();
        this.messageService = new MessageService();
    }

    
    public Javalin startAPI() {
        Javalin app = Javalin.create();

        // User Registration
        app.post("/register", this::registerHandler);
        // Login 
        app.post("/login", this::loginHandler);
        // Create New Message
        app.post("/messages", this::createMessageHandler);
        // Get All Messages
        app.get("/messages", this::getAllMessageHandler);
        // Get One Message Given Message Id
        app.get("messages/{message_id}", this::getOneMessageGivenMessageIdHandler);
        // Delete a Message Given Message Id
        app.delete("messages/{message_id}", this::deleteOneMessageGivenMessageIdHandler);
        // Update Message Given Message Id
        app.patch("messages/{message_id}", this::updateMessageGivenMessageIdHandler);
        // Get All Messages From User Given Account Id
        app.get("accounts/{account_id}/messages", this::getAllMessagesFromUserGivenAccountIdHandler);

        return app;
    }

    private void registerHandler(Context context) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        Account account = mapper.readValue(context.body(), Account.class);

        if(account.getUsername() == "" | account.getPassword().length() < 4){
            context.status(400);
        }
        else{
            Account addedAccount = accountService.register(account);
            if(addedAccount!=null){
                context.json(mapper.writeValueAsString(addedAccount));
                context.status(200);
            }else{
                context.status(400);
            }
        }

       

    }

    private void loginHandler(Context context) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        Account account = mapper.readValue(context.body(), Account.class);
        Account loginAccount = accountService.login(account);

        if(loginAccount!=null){
            context.json(mapper.writeValueAsString(loginAccount));
            context.status(200);
        }else{
            context.status(401);
        }
    }

    private void createMessageHandler(Context context){
        context.json(context, getClass());
    }

    private void getAllMessageHandler(Context context){
        context.json(context, getClass());
    }

    private void getOneMessageGivenMessageIdHandler(Context context){
        context.json(context, getClass());
    }

    private void deleteOneMessageGivenMessageIdHandler(Context context){
        context.json(context, getClass());
    }

    private void updateMessageGivenMessageIdHandler(Context context){
        context.json(context, getClass());
    }

    private void getAllMessagesFromUserGivenAccountIdHandler(Context context){
        context.json(context, getClass());
    }


}