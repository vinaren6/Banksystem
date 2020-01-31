package banksystem.menu;

import java.util.Scanner;

import banksystem.users.User;



public class UserMenu {
    private Scanner scanner = new Scanner(System.in);

    public void menu(User user) {
        Boolean logout = false;
       
        while (logout == false) {
            System.out.println("1. Salary  2. Role  3. Request new salary  4. Request new role  5. Remove  6. Saldo  0. Logout");
			String menuChoise = stringLongerthenOne();

            switch(menuChoise) 
        {   
            case "1": 
                System.out.println(user.viewSalary()); 
                break; 
            case "2": 
                System.out.println(user.viewRole()); 
                break; 
            case "3": 
                System.out.println("Write your requested salary. your current salary are " + user.viewSalary());
                boolean parseInt = false;
                int intNewSalary = 0;
                while (!parseInt){
               try{
                String newSalary = scanner.nextLine();
                intNewSalary = Integer.parseInt(newSalary);
                parseInt = true;
               }catch(Exception e){
                System.out.println("You can only write numbers");
               }
            }
                if(user.viewSalary() != intNewSalary){
                user.createRequestSalary(intNewSalary); 
                }
                else{
                    System.out.println("you alredy have this salary");
                }
                break; 
            case "4": 
                System.out.println("Write your requested role. your current role are " + user.viewRole());
                String newRole = stringLongerthenOne();
                if(!user.viewRole().equals(newRole)){
                user.createRequestRole(newRole);
                }
                else{
                    System.out.println("you alredy have this role");
                }
                break; 
            case "5": 
                System.out.println("Usernmae");
                String removeUsername = stringLongerthenOne();
                System.out.println("Password");
                String removePassword = stringLongerthenOne();
                if(user.removeUser(user , removeUsername, removePassword)){ 
                logout = true;
                }
                else{
                    System.out.println("Wrong username or password");
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
    public String stringLongerthenOne(){
        boolean exit = false;
        String str = "";
        while(exit == false){
            str = scanner.nextLine();
            if(str.length() > 0){
                exit = true;
            }
        }
        return str;
    }
}