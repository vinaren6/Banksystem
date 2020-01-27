package banksystem.users;

public class Account {
    String role;
    String password;
    String userName; 
    String email;   
   //Constructor
   Account(String role, String userName, String password, String email){
      this.role = role;
      this.password = password;
      this.userName = userName;
      this.email = email;
      
   }
   public String checkUserName(){
      return userName;
   }
   public String checkPassword(){
      return password;
   }

}