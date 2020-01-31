package banksystem;

import java.util.ArrayList;

import banksystem.users.Account;

public class Login {
    //Retruns the user with the position in the arraylist
    public Account loginGetAccountFromList(int position) {
        ArrayList<Account> list = App.getList();

        Account account = list.get(position);
        return account;
    }
    //Returns the user or admin postition in the arraylist -1 if username and password are incorrect
    public int loginGetListPosition(String username, String password) {
        int userPosition = -1;
        ArrayList<Account> list = App.getList();

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).checkUserName().equals(username) && list.get(i).checkPassword().equals(password)) {
                userPosition = i;
                break;
            }
        }
        if (userPosition == -1) {
            System.out.println("Username or password incorrect");
        }

        return userPosition;
    }
}