package servlets;

import classes.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Logout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cc = request.getCookies();
        HttpSession sessions = request.getSession();

        //remove the cookies
        for(int i = 0; i < cc.length; i++)
        {
            cc[i].setMaxAge(0);
            cc[i].setValue("");
            response.addCookie(cc[i]);
        }

        //remove the sessions
        sessions.removeAttribute("users");
        sessions.removeAttribute("categories");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
