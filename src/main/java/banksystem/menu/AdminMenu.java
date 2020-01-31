package banksystem.menu;

import java.util.Scanner;

import banksystem.users.Admin;

public class AdminMenu {
    private Scanner scanner = new Scanner(System.in);
    private UserMenu userMenu = new UserMenu();

    public void menu(Admin admin) {
        Boolean logout = false;
        //Start menu for the admin
        while (logout == false) {
            System.out.println("1. see users  2. Make user  3. Pay salary  4. Delete user  5. Salary request  6. Role request  0. Logout");
            String menuChoise = userMenu.stringLongerthenOne();

            switch (menuChoise) {
            case "1":
                admin.seeUser();
                break;
            case "2":
                menuCreateUser(admin);
                break;
            case "3":
                admin.plannedSalary();
                break;
            case "4":
                System.out.println("Which user do you want to delete");
                String removeUserName = userMenu.stringLongerthenOne();
                System.out.println("Password");
                String removePassword = userMenu.stringLongerthenOne();
                admin.removeUser(removeUserName, removePassword);
                break;
            case "5":
                admin.seeUserRequestSalary();
                break;
            case "6":
                admin.changeUserRole();
                break;
            case "0":
                logout = true;
                break;
            default:
                System.out.println("no match");
            }
        }
    }
    //Prints the menu for when you creates a user
    public void menuCreateUser(Admin admin) {
        System.out.println("first name");
        String firstName = userMenu.stringLongerthenOne();
        System.out.println("last name");
        String lastName = userMenu.stringLongerthenOne();
        System.out.println("role");
        String role = userMenu.stringLongerthenOne();
        System.out.println("username");
        String userName = userMenu.stringLongerthenOne();
        boolean passwordCheck = false;
        String password = "";
        while (!passwordCheck) {
            System.out.println("password");
            password = scanner.nextLine();
            if (password.matches(".*\\d.*") && password.matches(".*[a-zA-Z].*")) {
                passwordCheck = true;
            }
            if (!passwordCheck) {
                System.out.print("Needs to contain number and letters");
            }
        }
        System.out.println("email");
        String email = userMenu.stringLongerthenOne();
        System.out.println("salary");
        int salary = userMenu.scannerToInt();
        System.out.println("money");
        int money = userMenu.scannerToInt();
      
        
        admin.createUser(userName, password, email, role, firstName, lastName, salary, money);
    }
}
