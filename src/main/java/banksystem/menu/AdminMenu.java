package banksystem.menu;

import java.util.Scanner;

import banksystem.users.Admin;


public class AdminMenu { 
    private Scanner scanner = new Scanner(System.in);

    public void menu(Admin admin) {
        Boolean logout = false;
              
        while (logout == false) {
            System.out.println("1. see users  2. Make user  3. Give salary  0. Logout");
			String menuChoise = scanner.nextLine();

            switch(menuChoise) 
        {   
            case "1": 
                admin.seeUser();
                break; 
            case "2": 
            System.out.println("first name");
            String firstName = scanner.nextLine();
            System.out.println("last name");
            String lastName = scanner.nextLine();           
            System.out.println("role");
            String role = scanner.nextLine();
            System.out.println("password");
            String password = scanner.nextLine();
            System.out.println("username");
            String userName = scanner.nextLine();
            System.out.println("email");
            String email = scanner.nextLine();
            System.out.println("salary");
            String strSalary = scanner.nextLine();
            int salary = Integer.parseInt(strSalary);
            System.out.println("money");
            String strMoney = scanner.nextLine();
            int money = Integer.parseInt(strMoney);

            admin.createUser(firstName, lastName, role, password, userName, email, salary, money);

                ; 
                break; 
            case "3": 
                admin.plannedSalary();
                break; 

            case "4":
                System.out.println("Which user do you want to delete");
                String removeUserName = scanner.nextLine();
                admin.removeUser(removeUserName);
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
