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
public class App {
    public static ArrayList<Account> list = new ArrayList<Account>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Admin admin = new Admin("admin1", "admin1234", "admin@admin.admin", "Admin");
        list.add(admin);
        admin.createUser("viktor", "abc123", "viktor@mail.com", "programmer", "viktor", "Rüdén", 1500, 15000);
        admin.createUser("joshua", "abc123", "josh@mail.com", "janitor", "joshua", "klein", 1000, 1000);
        startMenu();
        
    }
    
    public static void startMenu(){
        Login classLogin = new Login();
        boolean exit = false;

        while (exit == false) {

            System.out.println("1. Login  0. Logout");
            String menuChoise = scanner.nextLine();

            switch (menuChoise) {
            case "1":
                boolean login = false;
                while (login == false) {
                    System.out.println("Login");

                    System.out.println("Username");
                    String username = scanner.nextLine();
                    System.out.println("Password");
                    String password = scanner.nextLine();

                    int userPosition = classLogin.loginGetListPosition(username, password);
                    if (userPosition != -1) {
                        Account account = classLogin.loginGetAccountFromList(userPosition);
                        if (account instanceof User) {
                            User user2 = (User) account;
                            UserMenu userMenu = new UserMenu();
                            userMenu.menu(user2);
                            login = true;
                        } else {
                            Admin admin2 = (Admin) account;
                            AdminMenu adminMenu = new AdminMenu();
                            adminMenu.menu(admin2);
                            login = true;
                        }
                    }
                }

                break;
            case "0":
                System.out.println("Goodbye!");
                exit = true;
                break;

            }
        }
    }

    public static void setList(ArrayList<Account> setArrayList) {
        list = setArrayList;
    }

    public static ArrayList<Account> getList() {
        return list;
    }
}
