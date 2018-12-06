package Servlets;

import DataAccessObject.EventDAO;
import DataAccessObject.TicketDAO;
import Objects.Event;
import Objects.Ticket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

public class AllEventsPageServlet extends BaseServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventDAO eventDAO = (EventDAO) getServletConfig().getServletContext().getAttribute("eventDAO");
        List<Event> events = eventDAO.getAllEvents();
        PrintWriter writer = prepareResponse(response);
        writer.println(header("All the tickets are here", null));
        writer.println("<table style=\"width:100%\">");
        writer.println("<tr>");
        writer.println("<th>All tickets</th>");
        writer.println("</tr>");
        for (Event e : events) {
            writer.println("<tr>");
            writer.println("<td><a href=\"event?event=" + URLEncoder.encode(e.getEventName(), "UTF-8") +
                    "\">" + e.getEventName()+ "</a></td>");
            writer.println("</tr>");
        }

        writer.println("</table>");
    }
}
