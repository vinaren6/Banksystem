package banksystem.users;

public class Account {
    String role;
    String password;
    String userName; 
    String email;   
   //Constructor
   Account(String role, String password, String userName, String email){
      this.role = role;
      this.password = password;
      this.userName = userName;
      this.email = email;
      
   }
}