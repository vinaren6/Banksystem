package banksystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import banksystem.users.Account;
import banksystem.users.Admin;
import banksystem.users.User;


/**
 * Unit test for simple App.
 */
public class SmokeTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void loginTest()
    {
        Admin admin = makeAdmin();
        admin.createUser("test", "abc123", "test", "test", "test", "test", 150, 1200);
        int listPositionAdmin = App.loginGetListPosition("admin1", "admin1234");
        Account accountAdmin = App.loginGetAccountFromList(listPositionAdmin);
        int listPositionUser = App.loginGetListPosition("test", "abc123");
        Account accountUser = App.loginGetAccountFromList(listPositionUser);
        assertTrue( accountAdmin instanceof Admin);
        assertTrue( accountUser instanceof User);
        clearList();
    }
    @Test
    public void makeUser(){
       Admin admin = makeAdmin();
       admin.createUser("test", "abc123", "test", "test", "test", "test", 150, 1200);
       ArrayList<Account> list = App.getList();
       User user = (User) list.get(1);
       assertEquals(150, user.viewSalary());
       clearList();
    }







    public Admin makeAdmin(){
        ArrayList<Account> list = new ArrayList<Account>();
        Admin admin = new Admin("admin1", "admin1234", "admin@admin.admin", "Admin");
        list.add(admin);
        App.setList(list);
        return admin;
    }
    public void clearList(){
        ArrayList<Account> list = new ArrayList<Account>();
        App.setList(list);
    }
}