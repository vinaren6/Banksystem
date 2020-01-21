package banksystem.users;

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

     return "";
   }
   public int viewAccountBalance(User user) {

     return 0;
   }
}