package banksystem;

import java.util.ArrayList;
import java.util.Scanner;

import banksystem.menu.AdminMenu;
import banksystem.menu.UserMenu;
import banksystem.users.Account;
import banksystem.users.Admin;
import banksystem.users.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static ArrayList<Account> list = new ArrayList<Account>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main( String[] args )
    {
        
        Admin admin = new Admin("admin1", "admin1234", "admin@admin.admin", "Admin");
        User user = new User("Viktor", "Ruden", "Programmer", "viktor", "123", "viktor@viktor.viktor", 100000, 1000000, "", "" ,"" ,"");
        User user1 = new User("Joshua", "Klein", "Janitor", "123", "Joshua", "joshua@joshua.joshua", 1000, 1000, "", "" ,"" ,"");

        list.add(admin);
        list.add(user);
        list.add(user1);

        System.out.println(list.get(0) instanceof User);
        list.get(1).checkUserName();

        Account account = login();

        if(account instanceof User){
            User user2 = (User) account;
            UserMenu userMenu = new UserMenu();
            userMenu.menu(user2);
        }
        else {
            Admin admin2 = (Admin) account;
            AdminMenu adminMenu = new AdminMenu();
            adminMenu.menu(admin2);
        }

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).checkUserName());
        }

        
    }
    
    public static Account login(){
        Boolean login = false;
        Account account = list.get(0);
        while (login == false) {
        
        System.out.println("Login");

        System.out.println("Username");
        String username = scanner.nextLine();
        System.out.println("Password");
        String password = scanner.nextLine();
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).checkUserName() + " " + username);
            System.out.println(list.get(i).checkPassword() + " " + password);

            if(list.get(i).checkUserName().equals(username) && list.get(i).checkPassword().equals(password)) {
                account = list.get(i);
                login = true;
            }
        }
        if(login == false){
            System.out.println("Username or password incorrect");
        }
        }
        return  account;
    }

    public static void setList(ArrayList<Account> setArrayList){
        list = setArrayList;
    }
    public static ArrayList<Account> getList(){
        return list;
    }
}



