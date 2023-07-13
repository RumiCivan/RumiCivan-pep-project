package Service;

import Service.AccountService;
import DAO.AccountDAO;
import Model.Account;



public class AccountService {
    private AccountDAO accountDAO;
    
    public AccountService(){
        accountDAO = new AccountDAO();
    }

    public AccountService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    public Account register(Account account){

        // check if acc exist already
        if(accountDAO.login(account) == null){
            return accountDAO.register(account);
        }
        

        return null;
    }

    public Account login(Account account) {       
        
        return accountDAO.login(account);

    }

    public boolean getUserById(int id){
        return accountDAO.getUserById(id);
    }




}
