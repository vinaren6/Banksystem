package banksystem;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.ArrayList;

import banksystem.users.Account;
import banksystem.users.Admin;
import banksystem.users.User;

/**
 * Unit test for simple App.
 */
public class IntegrationTest {
    private Login classLogin = new Login();
    //Test for admin to login and make an user and the login to the user and view the users salary
    @Test
    public void main() {
        makeAdmin();
        Admin admin = (Admin) loginTest("admin1", "admin1234");
        admin.createUser("test", "abc123", "test", "test", "test", "test", 150, 1200);

        User user = (User) loginTest("test", "abc123");
        assertEquals(150, user.viewSalary());
    }
    //Makes a admin and adds it to the arraylist
    private Admin makeAdmin() {
        ArrayList<Account> list = App.getList();
        Admin admin = new Admin("admin1", "admin1234", "admin@admin.admin", "Admin");
        list.add(admin);
        App.setList(list);
        return admin;
    }
    //Logs in to the user
    private Account loginTest(String username, String password) {

        int position = classLogin.loginGetListPosition(username, password);
        Account account = classLogin.loginGetAccountFromList(position);
        return account;
    }

}