package Controller;

import io.javalin.Javalin;
import io.javalin.http.Context;

import Service.AccountService;
import Service.MessageService;
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

    private void registerHandler(Context context){
        context.json(context, getClass());
    }

    private void loginHandler(Context context){
        context.json(context, getClass());
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