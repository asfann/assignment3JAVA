package servlets;

import classes.Password;
import classes.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Register extends HttpServlet {
    LinkedHashSet<User> UserList = new LinkedHashSet<User>();//List for users
    private void addUser(User user) {
        UserList.add(user);
    }
    private Password password;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("emailreg");
        String pass = request.getParameter("passreg");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");

        File file = new File("C:\\Users\\asfan\\IdeaProjects\\assignment3JAVA\\src\\main\\java\\db.txt");
        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNext())
        {
            int id = fileScanner.nextInt();
            String n = fileScanner.next();
            String s = fileScanner.next();
            String u = fileScanner.next();
            String p = fileScanner.next();
            User user = new User(id, n, s, u, p);
            addUser(user);
        }
        fileScanner.close();

        String msg = "";

        if(checkEmail(email))
        {
            msg = "Username is in use, enter another";
            request.setAttribute("msgreg", msg);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        password = new Password(pass);

        if (password.checkPassword() == "false")
        {
            msg = "Incorrect password format! Try again";
            request.setAttribute("msgreg", msg);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else if(password.checkPassword() != "false")
        {
            User user = new User(fname, lname, email, pass);
            addUser(user);

            Cookie lc = new Cookie("login", email);

            HttpSession sessions = request.getSession();
            sessions.setAttribute("users", UserList);

            saveUserList();

            lc.setMaxAge(5 * 60 * 60);
            response.addCookie(lc);
            UserList.clear();
            request.getRequestDispatcher("CookieSession").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    //check email if it is in use
    private boolean checkEmail(String u){
        for(User user : UserList)
        {
            if(user.getUsername().equals(u))
            {
                return true;
            }
        }

        return false;
    }

    //save user list to db.txt
    private void saveUserList() throws IOException {
        String content = "";
        for(User u : UserList){
            content += u.getId() + " " + u.getName() + " " + u.getSurname() + " " + u.getUsername() + " " + u.getPassword() + "\n";
        }
        Files.write(Paths.get("C:\\Users\\asfan\\IdeaProjects\\assignment3JAVA\\src\\main\\java\\db.txt"), content.getBytes());
        UserList.clear();
    }
}
