package Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends BaseServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = prepareResponse(response);
        out.println("<img src=\"https://i.pinimg.com/564x/c0/5c/5b/c05c5b943b73be8f5ab057d6a62465ac.jpg\">");
        out.println("<h3>Welcome to EventHub</h3>\r\n "+
                "<h4>We believe in every event will bring your life much fun!</h4>");
        out.println("<html><head><title>" + "LogIn Page" + "</title></head><body>");
        out.println("<form action=\"/verify\" method=\"post\" >\r\n" +
                "UserName: <input type=\"text\" name=\"user\" ><br>\r\n" +
                "PassWord: <input type=\"password\" name=\"password\"><br>\r\n" +
                "<input type=\"submit\" value=\"Submit\">\r\n" +
                "</form>");
        out.println("<form action=\"forget\" method=\"post\">" +
                "<button type=\"submit\" name=\"number\" value=\"of searches\" class=\"btn-link\">Forget your password??</button>" +
                "</form>");
        out.println(footer());
    }

}
