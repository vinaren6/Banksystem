package banksystem.users;

import java.util.ArrayList;
import java.util.Scanner;

import banksystem.App;

public class Admin extends Account {
   private Scanner scanner = new Scanner(System.in);

   public String role;
   public String password;
   public String userName;
   public String email;

   // Constructor
   public Admin(String userName, String password, String email, String role) {
      super(userName, password, email, role);
      this.role = role;
      this.userName = userName;
      this.password = password;
      this.email = email;
   }
   //Prints all users information excepts their request
   public void seeUser() {
      ArrayList<Account> list = App.getList();
      for (int i = 0; i < list.size(); i++) {
         if (list.get(i) instanceof User) {
            User user = (User) list.get(i);
            System.out.println("First name: " + user.firstName + " - last name: " + user.lastName + " - email: "
                  + user.email + " - username: " + user.userName + " - password: " + user.password + " - role: "
                  + user.role + " - salary: " + user.salary + " - money: " + user.money);
         }
      }

   }
   //Removes the user with the username and password you write
   public void removeUser(String userName, String password) {
      ArrayList<Account> list = App.getList();
      for (int i = 0; i < list.size(); i++) {
         if (list.get(i) instanceof User) {
            User user = (User) list.get(i);
            if (user.userName.equals(userName) && user.password.equals(password)) {
               list.remove(i);
               break;
            }
         }
      }
      App.setList(list);
   }
      //Loops throgh all user with a salaryRequest and you and accept or decline the request
   public void seeUserRequestSalary() {
      ArrayList<Account> list = App.getList();

      boolean exit = false;

      for (int i = 0; i < list.size(); i++) {

         if (list.get(i) instanceof User) {
            User user = (User) list.get(i);
            if (user.salary != user.salaryRequest) {
               boolean exitWhile = false;

               System.out.println("Username: " + user.userName + " current salary: " + user.salary
                     + " requested salary: " + user.salaryRequest);
               System.out.println("1. Accept  2. Decline  3. Exit");

               while (exitWhile == false) {
                  String decision = scanner.nextLine();
                  switch (decision) {
                  case "1":
                     User userWithNewsalary = (User) list.get(i);
                     userWithNewsalary.salary = userWithNewsalary.salaryRequest;
                     list.set(i, userWithNewsalary);
                     exitWhile = true;
                     break;
                  case "2":
                     User userWithSamesalary = (User) list.get(i);
                     userWithSamesalary.salaryRequest = userWithSamesalary.salary;
                     list.set(i, userWithSamesalary);
                     exitWhile = true;
                     break;
                  case "3":
                     exit = true;
                     exitWhile = true;
                     break;
                  }
               }
               if (exit) {
                  break;
               }
            }

         }
         App.setList(list);

      }
   }
   //Loops throgh all user with a roleRequest and you and accept or decline the request
   public void changeUserRole() {
      ArrayList<Account> list = App.getList();

      boolean exit = false;

      for (int i = 0; i < list.size(); i++) {

         if (list.get(i) instanceof User) {
            User user = (User) list.get(i);
            if (!user.role.toLowerCase().equals(user.roleRequest.toLowerCase())) {
               boolean exitWhile = false;

               System.out.println("Username: " + user.userName + " current role: " + user.role + " requested role: "
                     + user.roleRequest);
               System.out.println("1. Accept  2. Decline  3. Exit");

               while (exitWhile == false) {
                  String decision = scanner.nextLine();
                  switch (decision) {
                  case "1":
                     User userWithNewRole = (User) list.get(i);
                     userWithNewRole.role = userWithNewRole.roleRequest;
                     list.set(i, userWithNewRole);
                     exitWhile = true;
                     break;
                  case "2":
                     User userWithSameRole = (User) list.get(i);
                     userWithSameRole.roleRequest = userWithSameRole.role;
                     list.set(i, userWithSameRole);
                     exitWhile = true;
                     break;
                  case "3":
                     exit = true;
                     exitWhile = true;
                     break;
                  }
               }
               if (exit) {
                  break;
               }
            }

         }

      }
      App.setList(list);

   }
   //Creates a user and adds it ti the arraylist
   public void createUser(String userName, String password, String email, String role, String firstName,
         String lastName, int salary, int money) {
      ArrayList<Account> list = App.getList();
      User user = new User(userName, password, email, role, firstName, lastName, salary, money);
      list.add(user);
      App.setList(list);

   }
   //Sets all user adds the users salary to the users money
   public void plannedSalary() {
      ArrayList<Account> list = App.getList();
      for (int i = 0; i < list.size(); i++) {
         if (list.get(i) instanceof User) {
            User user = (User) list.get(i);
            user.money = user.money + user.salary;
            list.set(i, user);
         }
      }
      App.setList(list);
   }

}