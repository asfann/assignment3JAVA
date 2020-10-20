package servlets;

import classes.Password;
import classes.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.websocket.Session;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Login extends HttpServlet {
    LinkedHashSet<User> UserList = new LinkedHashSet<User>();
    private void addUser(User user) {
        UserList.add(user);
    }
    private Password password;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String l = request.getParameter("email");
        String p = request.getParameter("pass");

        File file = new File("C:\\Users\\asfan\\IdeaProjects\\assignment3JAVA\\src\\main\\java\\db.txt");
        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNext())
        {
            int id = fileScanner.nextInt();
            String n = fileScanner.next();
            String s = fileScanner.next();
            String u = fileScanner.next();
            String pass = fileScanner.next();
            User user = new User(id, n, s, u, pass);
            addUser(user);
        }
        fileScanner.close();

        String msg = "";

        if(!checkEmail(l))
        {
            msg = "Username doesn't exist, try again";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        password = new Password(p);

        if(!password.checkPass(p, l, UserList))
        {
            msg = "Incorrect password, try again";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        for(User user : UserList)
        {
            if(user.getUsername().equals(l) && user.getPassword().equals(p))
            {
                Cookie lc = new Cookie("login", l);

                lc.setMaxAge(5 * 60 * 60);
                response.addCookie(lc);

                request.getRequestDispatcher("CookieSession").forward(request, response);
            }
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
}
