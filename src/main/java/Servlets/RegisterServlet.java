package Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends BaseServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = prepareResponse(response);
        out.println("<html><head><title>" + "Register Page" + "</title></head><body>");
        out.println("<h1> Please register ! <h1>");
        out.println("<form action=\"/register\" method=\"post\"> \r\n" +
                "UserName: <input type=\"text\" name=\"user\" ><br>\r\n" +
                "PassWord: <input type=\"password\" name=\"password\"><br>\r\n" +
                "<input type=\"submit\" value=\"Register\">\r\n" +
                "</form>");
        out.println(footer());
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");

//        if (pwd.exists(user)) {
//            response.sendRedirect(response.encodeRedirectURL("/login"));
//        }
//        else {
//            pwd.addUser(user, password);
//            response.sendRedirect(response.encodeRedirectURL("/login"));
//        }

    }
}
