import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import DataAccessObject.EventDAO;
import DataAccessObject.TicketDAO;
import DataAccessObject.UserDAO;
import Servlets.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import java.sql.SQLException;

public class EventbriteDriver {


    public static void main(String[] args) throws Exception {
    Server server = new Server(8050);
    ServletContextHandler servhandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(servhandler);


        servhandler.addEventListener(new ServletContextListener() {

        public void contextDestroyed(ServletContextEvent sce) {

        }

        public void contextInitialized(ServletContextEvent sce){
//            try {
//                EventDAO eventDAO = new EventDAO();
//                TicketDAO ticketDAO = new TicketDAO();
//                UserDAO userDAO = new UserDAO();
//                sce.getServletContext().setAttribute("eventDAO", eventDAO);
//                sce.getServletContext().setAttribute("ticketDAO", ticketDAO);
//                sce.getServletContext().setAttribute("userDAO", userDAO);
//            }
//            catch (SQLException e) {
//                e.printStackTrace();
//            }

//            sce.getServletContext().setAttribute("library", library);
//            sce.getServletContext().setAttribute("userinfo", userinfo);
//            sce.getServletContext().setAttribute("password", password);
//            sce.getServletContext().setAttribute("admin", admin);
//            sce.getServletContext().setAttribute("lib", artLib);
        }
    });


        servhandler.addServlet(LoginServlet.class, "/login");
        servhandler.addServlet(LogoutServlet.class, "/logout");
        servhandler.addServlet(VerifyUserServlet.class, "/verify");
        servhandler.addServlet(RegisterServlet.class, "/register");
        servhandler.addServlet(HomeServlet.class, "/home");
        servhandler.addServlet(InfoServlet.class, "/info");
        servhandler.addServlet(AddEventServlet.class, "/createEvent");
        servhandler.addServlet(AllEventsPageServlet.class, "allevents");

        server.setHandler(servhandler);

    //start the server
        server.start();
        server.join();
}



}
