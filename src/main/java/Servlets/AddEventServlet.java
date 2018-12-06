package Servlets;

import DataAccessObject.EventDAO;
import DataAccessObject.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AddEventServlet extends BaseServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =  request.getSession();
        if (session.getAttribute("username") != null) {
            response.sendRedirect(response.encodeRedirectURL("/login"));
        }
        else {
            PrintWriter out = prepareResponse(response);
            out.println(header("Add one event now!", (String)session.getAttribute("username")));
            out.println("<form action=\"/createEvent\" method=\"post\" >\r\n" +
                    "Event Name: <input type=\"text\" name=\"name\" ><br>\r\n" +
                    "Event Tickets: <input type=\"number\" name=\"tickets\"><br>\r\n" +
                    "Event Description: <input type=\"text\" name=\"description\"><br>\r\n" +
                    "<input type=\"submit\" value=\"Submit\">\r\n" +
                    "</form>");
            out.println(footer());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventDAO eventDAO = (EventDAO) getServletConfig().getServletContext().getAttribute("eventDAO");
        eventDAO.addNewEvent(request.getParameter("name"),
                Integer.valueOf(request.getParameter("tickets")),
                request.getParameter("description"));
    }


}
