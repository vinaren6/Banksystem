package banksystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import banksystem.users.Account;
import banksystem.users.Admin;
import banksystem.users.User;


public class SmokeTest {
    private Login classLogin = new Login();

    //Test for loggin in to a admin and a user
    @Test
    public void loginTest() {
        Admin admin = makeAdmin();
        admin.createUser("test", "abc123", "test", "test", "test", "test", 150, 1200);
        int listPositionAdmin = classLogin.loginGetListPosition("admin1", "admin1234");
        Account accountAdmin = classLogin.loginGetAccountFromList(listPositionAdmin);
        int listPositionUser = classLogin.loginGetListPosition("test", "abc123");
        Account accountUser = classLogin.loginGetAccountFromList(listPositionUser);
        assertTrue(accountAdmin instanceof Admin);
        assertTrue(accountUser instanceof User);
        clearList();
    }
    //Test for making a user
    @Test
    public void makeUser() {
        Admin admin = makeAdmin();
        admin.createUser("test", "abc123", "test", "test", "test", "test", 150, 1200);
        ArrayList<Account> list = App.getList();
        User user = (User) list.get(1);
        assertEquals(150, user.viewSalary());
        clearList();
    }
    //Makes a admin and adds it to the arraylist
    public Admin makeAdmin() {
        ArrayList<Account> list = new ArrayList<Account>();
        Admin admin = new Admin("admin1", "admin1234", "admin@admin.admin", "Admin");
        list.add(admin);
        App.setList(list);
        return admin;
    }
    //Clears the Arraylist
    public void clearList() {
        ArrayList<Account> list = new ArrayList<Account>();
        App.setList(list);
    }
}