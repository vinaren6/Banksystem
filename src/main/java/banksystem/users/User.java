package banksystem.users;

import java.util.ArrayList;

import banksystem.App;


public class User extends Account{
    String role;
    String password;
    String userName;
    String email;
    String firstName;
    String lastName;
    int salary;
    long money;
    String roleRequest;
    int salaryRequest;
  
    
   //Constructor
   public User(String firstName, String lastName, String role, String userName, String password, String email, int salary, long money){
        super(role, userName, password, email);
        this.role = role;
        this.password = password;
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.money = money;
        this.roleRequest = "";
        this.salaryRequest = salary;
        
   }

   public int createRequestSalary(int request){
      salaryRequest = request;
     return salaryRequest;
   }
   public String createRequestRole(String request){
      roleRequest = request;
    return roleRequest;
  }
   public int viewSalary(){

     return salary;
   }
   public String viewRole(){

     return role;
   }
   public String removeUser(User user){
     ArrayList<Account> list =  App.getList();
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).equals(user)){
        list.remove(i);
        break;
      }
    }
    App.setList(list);
     return "123";
   }
   public int viewAccountBalance(User user) {

     return 0;
   }
}