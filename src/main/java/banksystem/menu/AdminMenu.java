package banksystem.menu;

import java.util.Scanner;

import banksystem.users.Admin;


public class AdminMenu { 
    private Scanner scanner = new Scanner(System.in);

    public void menu(Admin admin) {
        Boolean logout = false;
              
        while (logout == false) {
            System.out.println("1. see users  2. Make user  3. Pay salary  4. Delete user  5. Salary request  6. Role request  0. Logout");
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
            boolean passwordLetter = false;
            boolean passwordNumber = false;
            String password = "";
            while (!passwordLetter && !passwordNumber){
            System.out.println("password");
            password = scanner.nextLine();
            if(password.matches(".*\\d.*")){
                passwordLetter = true;
            }
            if(password.matches(".*[a-zA-Z].*")){
                passwordNumber = true;
            }
            if(!passwordLetter || !passwordNumber){
                System.out.print("Needs to contain number and letters");
                passwordNumber = false;
                passwordLetter = false;
            }

            }

            System.out.println("username");
            String userName = scanner.nextLine();
            System.out.println("email");
            String email = scanner.nextLine();
            boolean parseIntSalary = false;
            int salary = 0;
            while (!parseIntSalary){
                try{
            System.out.println("salary");
            String strSalary = scanner.nextLine();
            salary = Integer.parseInt(strSalary);
            parseIntSalary = true;
                }
                catch(Exception e){}
            }
            boolean parseIntMoney = false;
            int money = 0;
                while (!parseIntMoney){
                    try{
            System.out.println("money");
            String strMoney = scanner.nextLine();
            money = Integer.parseInt(strMoney);
            parseIntMoney = true;
                    }
                    catch(Exception e){}
                }

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
    }
