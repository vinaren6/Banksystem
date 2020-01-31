package banksystem.users;

import java.util.ArrayList;

import banksystem.App;

public class User extends Account {
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

  // Constructor
  public User(String userName, String password, String email, String role, String firstName, String lastName, int salary, long money) {
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
  //Sets the users requestSalary
  public int setRequestSalary(int request) {
    salaryRequest = request;
    return salaryRequest;
  }
  //Sets the users requestRole
  public String setRequestRole(String request) {
    roleRequest = request.substring(0, 1).toUpperCase() + request.substring(1).toLowerCase();
    return roleRequest;
  }
  //Returns salary
  public int viewSalary() {

    return salary;
  }
    //Returns role
  public String viewRole() {

    return role;
  }
  //Removes the user you are logged in to if you writes the correct username and password to the user
  public boolean removeUser(User user, String username, String password) {
    if (user.checkUserName().equals(username) && user.checkPassword().equals(password)) {
      ArrayList<Account> list = App.getList();
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).equals(user)) {
          list.remove(i);
          break;
        }
      }
      App.setList(list);
      return true;
    }
    return false;
  }
    //Returns money
  public long viewAccountBalance() {

    return money;
  }
}