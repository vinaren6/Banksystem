package banksystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import banksystem.users.Account;

import org.junit.Test;

import banksystem.users.Admin;
import banksystem.users.User;
import junit.framework.Assert;


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
        Admin admin = new Admin("admin1", "admin1234", "admin@admin.admin", "Admin");
        assertEquals("admin1", admin.userName);
    }
     @Test
     public void createUser()
     {
        Admin admin = new Admin("admin1", "admin1234", "admin@admin.admin", "Admin");
        admin.createUser("test", "abc123", "test", "test", "test", "test", 150, 1200);
     }
    @Test
    public void checkUserSalary()
    {
        User user = new User("test", "abc123", "test", "test", "test", "test", 150, 1200);
        int salary = user.viewSalary();
        assertEquals(150, salary);
    }

    @Test
    public void checkUserRole()
    {
        User user = new User("test", "abc123", "test", "test", "test", "test", 150, 1200);
        String role = user.viewRole();
        assertEquals("Test", role);
    }


@Test
public void testRemoveUser()
{   clearList();
    ArrayList<Account> list = App.getList();
    User user = new User("test", "abc123", "test", "test", "test", "test", 150, 1200);
    list.add(user);
    App.setList(list);
    assertTrue(user.removeUser(user, "test", "abc123"));
    list = App.getList();
    assertEquals(0, list.size());
}
@Test
    public void testMakeSalaryRequest()
    {
        User user = new User("test", "abc123", "test", "test", "test", "test", 150, 1200);
        user.createRequestSalary(100);
        
    }



@Test
    public void testMakeRoleRequest()
    {
        User user = new User("test", "abc123", "test", "test", "test", "test", 150, 1200);
        user.createRequestRole("Janitor");
        
    }

    @Test
    public void testAdminRemoveUser()
    {
        Admin admin = new Admin("admin1", "admin1234", "admin@admin.admin", "Admin");
        clearList();
        ArrayList<Account> list = App.getList();
        User user = new User("test", "abc123", "test", "test", "test", "test", 150, 1200);
        list.add(user);
        App.setList(list);
        list = App.getList();
        assertEquals(1, list.size());
        admin.removeUser("test", "abc123");
        list = App.getList();
        assertEquals(0, list.size());
    }
    @Test
    public void testAdminSeeUsers(){
        Admin admin = new Admin("admin1", "admin1234", "admin@admin.admin", "Admin");
        admin.seeUser();
    }

    @Test
    public void testAdminPlannedSalary(){
        Admin admin = new Admin("admin1", "admin1234", "admin@admin.admin", "Admin");
        admin.createUser("test", "abc123", "test", "test", "test", "test", 150, 1200);
        admin.createUser("test1", "abc123", "test1", "test1", "test1", "test1", 150, 1200);
        admin.plannedSalary();
    }

    public void clearList(){
        ArrayList<Account> list = new ArrayList<Account>();
        App.setList(list);
    }
}











