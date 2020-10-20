package classes;

import interfaces.IPassword;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Password implements IPassword {
    private String passwordStr;

    public Password(String p){
        passwordStr = p;
    }

    public String checkPassword() {

        if (passwordStr.length() < 9){
            return "false";
        }
        else {
            int n = passwordStr.length();
            int u = 0;
            int l = 0;
            int d = 0;
            for (int i = 0; i < n; i++) {
                if(passwordStr.charAt(i) == ' ')
                {
                    return "false";
                }
                if(isDigit(passwordStr.charAt(i))){
                    d++;
                }
                if(hasLowerCase(passwordStr.charAt(i))){
                    l++;
                }
                if(hasUpperCase(passwordStr.charAt(i))){
                    u++;
                }
            }
            if(l > 0 && u > 0 && d > 0){
                return passwordStr;
            }
            else{
                return "false";
            }
        }
    }

    public boolean checkPass(String p, String u, LinkedHashSet<User> UserList) {
        for (User user : UserList) {
            if (user.getUsername().equals(u)) {
                if (user.getPassword().equals(p)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isDigit(char ch){
        for(char i = '0'; i <= '9'; i++)
        {
            if(ch == i)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasUpperCase(char ch){
        for(char i = 'A'; i <= 'Z'; i++)
        {
            if(ch == i)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasLowerCase(char ch){
        for(char i = 'a'; i <= 'z'; i++)
        {
            if(ch == i)
            {
                return true;
            }
        }
        return false;
    }
}
