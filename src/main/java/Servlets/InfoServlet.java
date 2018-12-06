package Servlets;

import DataAccessObject.EventDAO;
import DataAccessObject.TicketDAO;
import DataAccessObject.UserDAO;
import Objects.Ticket;
import org.eclipse.jetty.util.DateCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class InfoServlet extends BaseServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("username");
        if (name != null) {
            response.sendRedirect(response.encodeRedirectURL("/login"));
        }
        else {
            TicketDAO ticketDAO = (TicketDAO) getServletConfig().getServletContext().getAttribute("ticketDAO");
            UserDAO userDAO = (UserDAO) getServletConfig().getServletContext().getAttribute("userDAO");
            List<Ticket> tickets = ticketDAO.getTicketsByUserId(userDAO.getUserIdByUserName(name));
//            List<Ticket>tickets = new ArrayList<Ticket>();
            PrintWriter writer = prepareResponse(response);
//            Ticket t1 = new Ticket(1, 1, 1, "Concert");
            writer.println(header("All the tickets are here", null));
            writer.println("<table style=\"width:100%\">");
            writer.println("<tr>");
            writer.println("<th>All tickets</th>");
            writer.println("</tr>");
            for (Ticket t : tickets) {
                writer.println("<tr>");
                writer.println("<td><a href=\"event?event=" + URLEncoder.encode(t.getEventName(), "UTF-8") +
                        "\">" + t.getEventName()+ "</a></td>");
                writer.println("</tr>");
            }

            writer.println("</table>");

        }
    }


}
