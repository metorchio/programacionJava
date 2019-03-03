package ar.com.maxo.servlet;
// Import required java libraries

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Extend HttpServlet class
public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = -7016272265494965171L;
	final static Logger logger = Logger.getLogger(HelloWorldServlet.class);
    private String message;

    public void init() throws ServletException {
        // Do required initialization
        logger.info("===============[ INIT ]==================");
        message = "Hello World Servlet";
        Boolean debug = getInitParameter("debug").equals("true");
        logger.info(">>>> Input Param 'debug':  " +  debug);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("Clase: HelloWorldServlet - Método: doGet");
        logger.info(">>>> Request Query String: " + request.getQueryString() );

        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
        out.println("<br/> revisar el log...");
        logger.info(">>>> Termine.");
    }

    public void destroy() {
        // do nothing.
        logger.info("===============[ DESTROY ]==================");
        message = null;
        logger.info("Variable 'message': " + message);

    }
}