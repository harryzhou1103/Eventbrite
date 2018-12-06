package Servlets;

import DataAccessObject.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class VerifyUserServlet extends BaseServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(response.encodeRedirectURL("/login"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = (UserDAO) getServletConfig().getServletContext().getAttribute("userDAO");
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        String password = (String)session.getAttribute("password");
        try {
            if (userDAO.userValidate(username, password)) {
                response.sendRedirect(response.encodeRedirectURL("/home"));
            }
            else {
                response.sendRedirect(response.encodeRedirectURL("/register"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
