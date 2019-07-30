package ar.com.maxo.servlet;
// Import required java libraries

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Extend HttpServlet class
public class ButtonServlet extends HttpServlet {

    private String message;

    public void init() throws ServletException {
        // Do required initialization
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println( this.createButtonHtml() );

    }

    private String createButtonHtml(){
        String buttonHTML = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <style>\n" +
                "        .btn {\n" +
                "            border: none;\n" +
                "            color: white;\n" +
                "            padding: 14px 28px;\n" +
                "            font-size: 16px;\n" +
                "            cursor: pointer;\n" +
                "        }\n" +
                "\n" +
                "        .success {background-color: #4CAF50;} /* Green */\n" +
                "        .success:hover {background-color: #46a049;}\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h1>Alert Buttons</h1>\n" +
                "\n" +
                "<button class=\"btn success\" onclick=\"myFunction()\">Success</button>\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "<script>\n" +
                "function myFunction() {\n" +
                "   alert(\"I am an alert box!\");\n" +
                "}\n" +
                "</script>" +
                "</html>";

        return buttonHTML;
    }

    public void destroy() {
        // do nothing.
    }
}

