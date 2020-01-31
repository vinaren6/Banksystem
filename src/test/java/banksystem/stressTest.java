package banksystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.lang.annotation.Repeatable;
import java.util.ArrayList;

import org.junit.Test;

import banksystem.users.Account;
import banksystem.users.Admin;
import banksystem.users.User;

public class stressTest {
    private Login classLogin = new Login();

    //Test for making 50000 users and logging in to each of them
    @Test
    public void createUserStressTest() {
        Admin admin = makeAdmin();
        makeUser(admin);
        loginStressTest();

    }
    //Login to all the 50000 new users
    public void loginStressTest() {
        for (int i = 0; i <= 50000; i++) {
            int listPosition = classLogin.loginGetListPosition("user1" + i, "abc123");
            classLogin.loginGetAccountFromList(listPosition);
            System.out.println(i);
        }
    }
    //Makes a admin and adds it to the arraylist
    private Admin makeAdmin() {
        ArrayList<Account> list = new ArrayList<Account>();
        Admin admin = new Admin("admin1", "admin1234", "admin@admin.admin", "Admin");
        list.add(admin);
        App.setList(list);
        return admin;
    }
    //Runs createuser method 50000 times
    private void makeUser(Admin admin) {
        for (int i = 0; i <= 50000; i++) {
            admin.createUser("user1" + i, "abc123", "email", "role", "firstName", "lastName", 100, 150);
        }
    }

}