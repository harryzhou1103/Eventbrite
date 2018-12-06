package Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class HomeServlet extends BaseServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =  request.getSession();
        if (session.getAttribute("username") != null) {
            response.sendRedirect(response.encodeRedirectURL("/login"));
        }
        else {
            PrintWriter out = prepareResponse(response);
            out.println(header("Home page!", (String)session.getAttribute("username")));
            out.println("<form action=\"info\" method=\"get\">" +
                    "<button type=\"submit\" name=\"number\" value=\"of searches\" class=\"btn-link\">See all the events</button>" +
                    "</form>");
            out.println("<form action=\"my\" method=\"get\">" +
                    "<button type=\"submit\" name=\"number\" value=\"of searches\" class=\"btn-link\">See all my tickets</button>" +
                    "</form>");
            out.println("<form action=\"createEvent\" method=\"get\">" +
                    "<button type=\"submit\" name=\"number\" value=\"of searches\" class=\"btn-link\">Add an event</button>" +
                    "</form>");
            out.println(footer());
        }

    }
}
