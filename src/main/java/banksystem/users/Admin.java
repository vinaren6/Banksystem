package banksystem.users;

import java.util.ArrayList;
import java.util.Scanner;

import banksystem.App;

public class Admin extends Account{
   private Scanner scanner = new Scanner(System.in);

   public String role;
   public String password;
   public String userName;
   public String email;
        
   //Constructor
   public Admin( String userName, String password, String email, String role){
      super(role, userName, password, email);
      this.role = role;
      this.userName = userName;
      this.password = password;
      this.email = email;
   }

   public String seeUser(){
      ArrayList<Account> list =  App.getList();
      for(int i = 0; i < list.size(); i++){
         if(list.get(i) instanceof User){
            User user = (User) list.get(i);
            System.out.println("First name: " + user.firstName + " - last name: " + user.lastName + " - email: " + user.email + " - username: " + user.userName + " - password: " + user.password + " - role: " + user.role + " - salary: " + user.salary + " - money: " + user.money);
         }
       }
      
      return "";
   }

   public String removeUser(String userName){
      ArrayList<Account> list =  App.getList();
      for(int i = 0; i < list.size(); i++){
         if(list.get(i) instanceof User){
            User user = (User) list.get(i);
            if(user.userName.equals(userName)){
               list.remove(i);
               break;
            }
         }
      }
      App.setList(list);
      return "";
   }

   public String seeUserRequestSalary(){
      ArrayList<Account> list =  App.getList();
     

      boolean exit = false;

      for(int i = 0; i < list.size(); i++){
         
         if(list.get(i) instanceof User){
            User user = (User) list.get(i);
            if(user.salary != user.salaryRequest){
               boolean exitWhile = false;

            System.out.println("Username: " + user.userName + " current salary: " + user.salary + " requested salary: " + user.salaryRequest);
            System.out.println("1. Accept  2. Decline  3. Exit");

            while(exitWhile == false){
               String decision = scanner.nextLine();
            switch(decision) 
            {   
                case "1": 
                User userWithNewsalary = (User) list.get(i);
                userWithNewsalary.salary = userWithNewsalary.salaryRequest;
                list.set(i, userWithNewsalary);
                exitWhile = true;
                break;
                case "2": 
                User userWithSamesalary = (User) list.get(i);
                userWithSamesalary.salaryRequest = userWithSamesalary.salary;
                list.set(i, userWithSamesalary);
                exitWhile = true;
                break;
                case "3":
                exit = true;
                exitWhile = true;
                break;
               }
         }
         if(exit){
            break;
         }
      }
      
      }
      App.setList(list);
      
   }
   return "";
}
   public String changeUserRole(){
      ArrayList<Account> list =  App.getList();
     

      boolean exit = false;

      for(int i = 0; i < list.size(); i++){
         
         if(list.get(i) instanceof User){
            User user = (User) list.get(i);
            if(!user.role.toLowerCase().equals(user.roleRequest.toLowerCase())){
               boolean exitWhile = false;

            System.out.println("Username: " + user.userName + " current role: " + user.role + " requested role: " + user.roleRequest);
            System.out.println("1. Accept  2. Decline  3. Exit");
           

            while(exitWhile == false){
               String decision = scanner.nextLine();
            switch(decision) 
            {   
                case "1": 
                User userWithNewRole = (User) list.get(i);
                userWithNewRole.role = userWithNewRole.roleRequest;
                list.set(i, userWithNewRole);
                exitWhile = true;
                break;
                case "2": 
                User userWithSameRole = (User) list.get(i);
                userWithSameRole.roleRequest = userWithSameRole.role;
                list.set(i, userWithSameRole);
                exitWhile = true;
                break;
                case "3":
                exit = true;
                exitWhile = true;
                break;
               }
         }
         if(exit){
            break;
         }
      }
      
      }
      
      
   }
      App.setList(list);
      return "";
   }
   public String changeUserSalary(User user){

      return "";
   }
   public String createUser(String firstName, String lastName, String role, String password, String userName, String email, int salary, long money){
      ArrayList<Account> list =  App.getList();
      User user = new User(firstName, lastName, role, password, userName, email, salary, money);
      list.add(user);
      App.setList(list);
      return "";
   }
   public void plannedSalary(){
      ArrayList<Account> list =  App.getList();
      ArrayList<Account> list2= new ArrayList<Account>();
      for(int i = 0; i < list.size(); i++){
         if(list.get(i) instanceof User){
            User user = (User) list.get(i);
            user.money = user.money + user.salary;
            list2.add(user);
         }
         else{
            list2.add(list.get(i));
         }
       }
      App.setList(list2);
   }

    // Getters and setters
  

//   public void setMyCalander(String[][] myCalander) {
//       this.myCalander = myCalander;
//   }
}