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
    
   //Constructor
   public User(String firstName, String lastName, String role, String password, String userName, String email, int salary){
        super(role, password, userName, email);
        this.role = role;
        this.password = password;
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
   }

   public String createRequest(String request){

     return "";
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