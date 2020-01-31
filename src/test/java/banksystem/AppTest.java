package banksystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import banksystem.users.Account;

import org.junit.Test;

import banksystem.users.Admin;
import banksystem.users.User;
import junit.framework.Assert;

//Junit test
public class AppTest {

    //Check if you can create a admin
    @Test
    public void createAdmin() {
        Admin admin = new Admin("admin1", "admin1234", "admin@admin.admin", "Admin");
        assertEquals("admin1", admin.userName);
    }
    //Check if a admin can create a user
    @Test
    public void createUser() {
        Admin admin = new Admin("admin1", "admin1234", "admin@admin.admin", "Admin");
        admin.createUser("test", "abc123", "test", "test", "test", "test", 150, 1200);
    }
    //Check if a user can see their own role
    @Test
    public void checkUserSalary() {
        User user = new User("test", "abc123", "test", "test", "test", "test", 150, 1200);
        int salary = user.viewSalary();
        assertEquals(150, salary);
    }
    //Check if a user can see their own role
    @Test
    public void checkUserRole() {
        User user = new User("test", "abc123", "test", "test", "test", "test", 150, 1200);
        String role = user.viewRole();
        assertEquals("Test", role);
    }
    //Test if a user can remove itself from the arraylist
    @Test
    public void testRemoveUser() {
        clearList();
        ArrayList<Account> list = App.getList();
        User user = new User("test", "abc123", "test", "test", "test", "test", 150, 1200);
        list.add(user);
        App.setList(list);
        assertTrue(user.removeUser(user, "test", "abc123"));
        list = App.getList();
        assertEquals(0, list.size());
    }
    //Test if a user can make a setRequestSalary
    @Test
    public void testMakeSalaryRequest() {
        User user = new User("test", "abc123", "test", "test", "test", "test", 150, 1200);
        user.setRequestSalary(100);

    }
    //Test if a user can make a setRequestRole
    @Test
    public void testMakeRoleRequest() {
        User user = new User("test", "abc123", "test", "test", "test", "test", 150, 1200);
        user.setRequestRole("Janitor");

    }
    //Test so the admin can remove a user
    @Test
    public void testAdminRemoveUser() {
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
    //Test seeUser
    @Test
    public void testAdminSeeUsers() {
        Admin admin = new Admin("admin1", "admin1234", "admin@admin.admin", "Admin");
        admin.seeUser();
    }
    //Test the plannedsalary method on two users
    @Test
    public void testAdminPlannedSalary() {
        clearList();
        Admin admin = new Admin("admin1", "admin1234", "admin@admin.admin", "Admin");
        admin.createUser("test", "abc123", "test", "test", "test", "test", 150, 1200);
        admin.createUser("test1", "abc123", "test1", "test1", "test1", "test1", 150, 1200);
        admin.plannedSalary();
        ArrayList<Account> list = App.getList();
        User user1 = (User) list.get(0);
        User user2 = (User) list.get(1);
        assertEquals(1350, user1.viewAccountBalance());
        assertEquals(1350, user2.viewAccountBalance());
    }
    //Clears the arraylist
    public void clearList() {
        ArrayList<Account> list = new ArrayList<Account>();
        App.setList(list);
    }
}
