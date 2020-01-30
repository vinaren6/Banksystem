package banksystem.users;

public class Account {
    String role;
    String password;
    String userName; 
    String email;   
   //Constructor
   Account(String userName, String password, String email, String role){
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