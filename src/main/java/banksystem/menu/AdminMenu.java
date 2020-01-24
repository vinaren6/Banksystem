package banksystem.menu;

import java.util.Scanner;

import banksystem.users.Admin;


public class AdminMenu { 
    private Scanner scanner = new Scanner(System.in);

    public void menu(Admin admin) {
        Boolean logout = false;
              
        while (logout == false) {
            System.out.println("1. Salary  2. Role  3. Remove  0. Logout");
			String menuChoise = scanner.nextLine();

            switch(menuChoise) 
        {   
            case "1": 
                System.out.println(admin); 
                break; 
            case "2": 
                System.out.println(admin); 
                break; 
            case "3": 
                System.out.println(admin); 
                logout = true;
                break; 
            case "0":
                logout = true;
                break;
            default: 
                System.out.println("no match"); 
        } 
        }

        }
    }
