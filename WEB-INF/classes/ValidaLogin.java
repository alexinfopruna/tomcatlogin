import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Import Database Connection Class file


// Servlet Name
@WebServlet("/ValidaLogin")
public class ValidaLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        try {

            // Initialize the database

            String dbDriver = "com.mysql.jdbc.Driver";
            String dbURL = "jdbc:mysql:// localhost:3306/";
            // Database name to access
            String dbName = "servletlogin";
            String dbUsername = "webap";
            String dbPassword = "Alkaline:15";

            Class.forName(dbDriver);
            Connection con = DriverManager.getConnection(dbURL + dbName,
                    dbUsername,
                    dbPassword);


            // Create a SQL query to insert data into demo table
            // demo table consists of two columns, so two '?' is used
            PreparedStatement st = con
                    .prepareStatement("select * from user");


            // Close all the connections
            st.close();
            con.close();

            // Get a writer pointer
            PrintWriter out = response.getWriter();
            out.println("<html><body><b>Successfully Inserted"
                    + "</b></body></html>");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

