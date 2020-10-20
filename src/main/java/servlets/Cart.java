package servlets;

import classes.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Application;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/cart")
public class Cart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            doGet_DisplayCart(request, response);
        } else {
            if (action.equalsIgnoreCase("buy")) {
                doGet_Buy(request, response);
            } else if (action.equalsIgnoreCase("remove")) {
                doGet_Remove(request, response);
            }
        }
    }
    protected void doGet_DisplayCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("jsp/Sneakers.jsp").forward(request, response);
    }

    protected void doGet_Remove(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        int index = isExisting(Integer.parseInt(request.getParameter("id")), cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        response.sendRedirect("jsp/Cart.jsp");

    }

    protected void doGet_Buy(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") != null) {
            LinkedList<Product> cart = (LinkedList<Product>) session.getAttribute("cart");

            LinkedList<Product> sneaker = (LinkedList<Product>) session.getAttribute("sneaker");
            for(Product p : sneaker)
            {
                if(p.getId() == Integer.parseInt(request.getParameter("id")))
                {
                    cart.add(p);
                }
            }
            LinkedList<Product> cloth = (LinkedList<Product>) session.getAttribute("cloth");
            for(Product p : cloth)
            {
                if(p.getId() == Integer.parseInt(request.getParameter("id")))
                {
                    cart.add(p);
                }
            }
            LinkedList<Product> ball = (LinkedList<Product>) session.getAttribute("ball");
            for(Product p : ball)
            {
                if(p.getId() == Integer.parseInt(request.getParameter("id")))
                {
                    cart.add(p);
                }
            }

            session.setAttribute("cart", cart);
        }

        response.sendRedirect("cart");
    }

    private int isExisting(int id, List<Product> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
