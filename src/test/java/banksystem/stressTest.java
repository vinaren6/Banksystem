package banksystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.lang.annotation.Repeatable;
import java.util.ArrayList;

import org.junit.Test;

import banksystem.users.Account;
import banksystem.users.Admin;
import banksystem.users.User;

public class stressTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void createUserStressTest()
    {
        Admin admin = makeAdmin();
        makeUser(admin);
        loginStressTest();

    }

    
    public void loginStressTest(){
        for(int i = 0; i <= 50000; i++){
        int listPosition = App.loginGetListPosition("user1" + i, "abc123");
        Account account = App.loginGetAccountFromList(listPosition);
        System.out.println(i);
        }
    }

    private Admin makeAdmin(){
        ArrayList<Account> list = new ArrayList<Account>();
        Admin admin = new Admin("admin1", "admin1234", "admin@admin.admin", "Admin");
        list.add(admin);
        App.setList(list);
        return admin;
    }
    private void makeUser(Admin admin){
        for(int i = 0; i <= 50000; i++){
            admin.createUser("user1" + i , "abc123", "email", "role", "firstName", "lastName", 100, 150);
        }
    }
    
}