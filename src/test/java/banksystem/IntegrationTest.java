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
public class IntegrationTest
{
    @Test
    public void main(){
        makeAdmin();
        Admin admin = (Admin) loginTest("admin1", "admin1234");
        admin.createUser("test", "abc123", "test", "test", "test", "test", 150, 1200);
        System.out.println("hello");


        User user = (User) loginTest("test", "abc123");
        assertEquals(150, user.viewSalary());
    }



    private Admin makeAdmin(){
        ArrayList<Account> list = App.getList();
        Admin admin = new Admin("admin1", "admin1234", "admin@admin.admin", "Admin");
        list.add(admin);
        App.setList(list);
        return admin;
    }
    private Account loginTest(String username, String password){

        int position = App.loginGetListPosition(username, password);
        Account account = App.loginGetAccountFromList(position);
        return account;
    }

}