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
   public User(String userName, String password, String email, String role, String firstName, String lastName, int salary, long money){
        super(userName, password, email, role);
        this.role = role.substring(0, 1).toUpperCase() + role.substring(1).toLowerCase();
        this.password = password;
        this.userName = userName;
        this.email = email;
        this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
        this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
        this.salary = salary;
        this.money = money;
        this.roleRequest = role.substring(0, 1).toUpperCase() + role.substring(1).toLowerCase();
        this.salaryRequest = salary;
   }

   public int createRequestSalary(int request){
      salaryRequest = request;
     return salaryRequest;
   }
   public String createRequestRole(String request){
      roleRequest = request.substring(0, 1).toUpperCase() + request.substring(1).toLowerCase();;
    return roleRequest;
  }
   public int viewSalary(){

     return salary;
   }
   public String viewRole(){

     return role;
   }
   public boolean removeUser(User user, String username, String password){
     if(user.checkUserName().equals(username) && user.checkPassword().equals(password)){
     ArrayList<Account> list =  App.getList();
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).equals(user)){
        list.remove(i);
        break;
      }
    }
    App.setList(list);
     return true;
  }
  return false;
   }
   public long viewAccountBalance() {

     return money;
   }
}