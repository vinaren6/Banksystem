package banksystem.menu;

import java.util.Scanner;

import banksystem.users.User;

public class UserMenu {
    private Scanner scanner = new Scanner(System.in);

    public void menu(User user) {
        Boolean logout = false;
        //Prints the start menu for a user
        while (logout == false) {
            System.out.println(
                    "1. Salary  2. Role  3. Request new salary  4. Request new role  5. Remove  6. Saldo  0. Logout");
            String menuChoise = stringLongerthenOne();
            switch (menuChoise) {
            case "1":
                System.out.println(user.viewSalary());
                break;
            case "2":
                System.out.println(user.viewRole());
                break;
            case "3":
                menuRequestSalary(user);
                break;
            case "4":
                menuRequestRole(user);
                break;
            case "5":
                if (menuRemoveUser(user)) {
                    logout = true;
                }
                break;
            case "6":
                System.out.println(user.viewAccountBalance());
                break;
            case "0":
                logout = true;
                break;
            default:
                System.out.println("no match");
            }
        }
    }
    //Makes you write a string until the string is 1 or more long
    public String stringLongerthenOne() {
        boolean exit = false;
        String str = "";
        while (exit == false) {
            str = scanner.nextLine();
            if (str.length() > 0) {
                exit = true;
            }
        }
        return str;
    }
    //Makes you write a string until the string only has nummber in it
    public int scannerToInt(){
        boolean parseIntSalary = false;
        int number = 0;
        while (!parseIntSalary) {
            try {
                String strSalary = scanner.nextLine();
                number = Integer.parseInt(strSalary);
                parseIntSalary = true;
            } catch (Exception e) {
            }
        }
        return number;
    }
    //Prints the menu for the user.setRequestSalary method
    public void menuRequestSalary(User user) {
        System.out.println("Write your requested salary. your current salary are " + user.viewSalary());
        int intNewSalary = scannerToInt();
        
        if (user.viewSalary() != intNewSalary) {
            user.setRequestSalary(intNewSalary);
        } else {
            System.out.println("you alredy have this salary");
        }
    }
    //Prints the menu for the user.setRequestRole method
    public void menuRequestRole(User user) {
        System.out.println("Write your requested role. your current role are " + user.viewRole());
        String newRole = stringLongerthenOne();
        if (!user.viewRole().equals(newRole)) {
            user.setRequestRole(newRole);
        } else {
            System.out.println("you alredy have this role");
        }
    }
    //Prints the menu for the user.removeUser method
    public boolean menuRemoveUser(User user) {
        System.out.println("Usernmae");
        String removeUsername = stringLongerthenOne();
        System.out.println("Password");
        String removePassword = stringLongerthenOne();
        if (user.removeUser(user, removeUsername, removePassword)) {
            return true;
        }

        System.out.println("Wrong username or password");
        return false;

    }
}