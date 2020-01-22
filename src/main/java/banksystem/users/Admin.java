package banksystem.users;

public class Admin extends Account{
    
   public String role;
   public String password;
   public String userName;
   public String email;
        
   //Constructor
   public Admin(String role, String userName, String password, String email){
      super(role, userName, password, email);
      this.role = role;
      this.userName = userName;
      this.password = password;
      this.email = email;
   }

   public String seeUser(){
      
      return "";
   }

   public String removeUser(User user){

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
   public String createUser(String firstName, String lastName, String role, String password, String userName, String email, int salary){
      return "";
   }
   public void plannedSalary(){
      
   }

    // Getters and setters
  

//   public void setMyCalander(String[][] myCalander) {
//       this.myCalander = myCalander;
//   }
}