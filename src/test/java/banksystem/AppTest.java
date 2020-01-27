package banksystem;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import banksystem.users.Admin;
import banksystem.users.User;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void createAdmin()
    {
        Admin admin = new Admin("Admin", "admin1", "admin1234", "admin@admin.admin");
        assertEquals("admin1", admin.userName);
    }
    // @Test
    // public void createUser()
    // {
    //     User user = new User("Joshua", "Klein", "Worker", "12345","YEEET", "user@user.user", 200000000);
    //     assertEquals("Klein" );
    // }
    @Test
    public void checkUserSalary()
    {
        User user = new User("Joshua", "Klein", "Worker", "12345","YEEET", "user@user.user", 20000, 1000, "", "" ,"" ,"");
        int salary = user.viewSalary();
        assertEquals(20000, salary);
    }

    @Test
    public void checkUserRole()
    {
        User user = new User("Joshua", "Klein", "Worker", "12345","YEEET", "user@user.user", 20000, 1000, "", "" ,"" ,"");
        String role = user.viewRole();
        assertEquals("Worker", role);
    }
}
