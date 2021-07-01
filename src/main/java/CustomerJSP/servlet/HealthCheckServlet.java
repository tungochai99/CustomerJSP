package CustomerJSP.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CustomerJSP.dbconnection.JDBCConnection;

@WebServlet(name = "healthCheckServlet", urlPatterns = "/health")
public class HealthCheckServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection testConnection = JDBCConnection.getConnection();
		if(testConnection != null) {
			resp.getWriter().append("Database connection has been created successfully!");
		} else  {
			resp.getWriter().append("Database connection has been created unsuccessfully!");
		}
	}
}
