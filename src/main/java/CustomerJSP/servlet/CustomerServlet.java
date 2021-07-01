package CustomerJSP.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CustomerJSP.model.Customer;
import CustomerJSP.model.CustomerService;
import CustomerJSP.utils.Pathutils;
import CustomerJSP.utils.UrlUtils;

@WebServlet(name = "customerServlet", urlPatterns = {
		UrlUtils.CUSTOMER_ADD,
		UrlUtils.CUSTOMER_DASHBOARD,
		UrlUtils.CUSTOMER_DELETE,
		UrlUtils.CUSTOMER_UPDATE
})
public class CustomerServlet extends HttpServlet{
	private CustomerService service;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		switch(path) {
		case UrlUtils.CUSTOMER_DASHBOARD:
			List<Customer> customers = service.findAllCustomer();
			req.setAttribute("customers", customers);
			
			req.getRequestDispatcher(Pathutils.CUSTOMER_DASHBOARD).forward(req, resp);
			break;
		case UrlUtils.CUSTOMER_ADD:
			req.getRequestDispatcher(Pathutils.CUSTOMER_ADD).forward(req, resp);
			break;
		case UrlUtils.CUSTOMER_UPDATE:
			int codeToUpdate = Integer.parseInt(req.getParameter("code"));
			
			Customer customerUpdate = service.findCustomerByCode(codeToUpdate);
			
			req.setAttribute("customer", customerUpdate);
			
			req.getRequestDispatcher(Pathutils.CUSTOMER_UPDATE).forward(req, resp);
			break;
		case UrlUtils.CUSTOMER_DELETE:
			int codeToBeDeleted = Integer.parseInt(req.getParameter("code"));
			service.deleteCustomerByCode(codeToBeDeleted);
			resp.sendRedirect(req.getContextPath() +UrlUtils.CUSTOMER_DASHBOARD);
			break;
		default:
				break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		switch(path) {
		case UrlUtils.CUSTOMER_ADD:
			Customer customer = new Customer();
			
			customer.setCode(Integer.parseInt(req.getParameter("code")));
			customer.setName(req.getParameter("name"));
			customer.setAddress(req.getParameter("address"));
			customer.setEmail(req.getParameter("email"));
			
			service.addNewCustomer(customer);
			resp.sendRedirect(req.getContextPath() + UrlUtils.CUSTOMER_DASHBOARD);
			break;
			
		case UrlUtils.CUSTOMER_UPDATE:
			int codeToUpdate = Integer.parseInt(req.getParameter("code"));
			
			Customer customerUpdate = 	service.findCustomerByCode(codeToUpdate);
			customerUpdate.setName(req.getParameter("name"));
			customerUpdate.setAddress(req.getParameter("address"));
			customerUpdate.setEmail(req.getParameter("email"));
			
			service.update(customerUpdate, codeToUpdate);
			resp.sendRedirect(req.getContextPath() + UrlUtils.CUSTOMER_DASHBOARD);
			break;
			
		default:
			break;
		}
	}
	@Override
	public void init() throws ServletException {
		super.init();
		service = new CustomerService();
	}
}
