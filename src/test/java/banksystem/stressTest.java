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
    public void loginStressTest()
    {
        Admin admin = makeAdmin();
        makeUser(admin);
     

    }

    private Admin makeAdmin(){
        ArrayList<Account> list = new ArrayList<Account>();
        Admin admin = new Admin("admin1", "admin1234", "admin@admin.admin", "Admin");
        list.add(admin);
        App.setList(list);
        return admin;
    }
    private void makeUser(Admin admin){
        for(int i = 0; i <= 1000000; i++){
            admin.createUser("firstName", "lastName", "role", "abc123", "user1" + i , "email", 100, 150);
        }
    }
    
}