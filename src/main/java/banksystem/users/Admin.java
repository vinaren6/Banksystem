package banksystem.users;

import java.util.ArrayList;

import banksystem.App;

public class Admin extends Account{
    
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

   public String seeUserRequest(){

      return "";
   }
   public String changeUserRole(User user){

      return "";
   }
   public String changeUserSalary(User user){

      return "";
   }
   public String createUser(String firstName, String lastName, String role, String password, String userName, String email, int salary, long money){
      ArrayList<Account> list =  App.getList();
      User user = new User(firstName, lastName, role, password, userName, email, salary, money, "", "" ,"" ,"");
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