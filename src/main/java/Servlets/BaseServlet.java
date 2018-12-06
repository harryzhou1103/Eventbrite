package Servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BaseServlet extends HttpServlet {

    public static final String LIBRARY = "library";
    public static final String SEARCH = "search";
    public static final String TYPE = "type";
    private HttpServletResponse response;


    protected PrintWriter prepareResponse(HttpServletResponse response) throws IOException {
        this.response = response;
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        return response.getWriter();
    }
    //header of the page
    protected String header(String title, String username) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><title>" + title + "</title></head><body>");
        if (username == null) username = "Anonymous";
        sb.append(username + "'s Events and Tickets Page");
        return sb.toString();

    }
    //foot of the page
    protected String footer() {
        return "</body></html>";
    }
}
