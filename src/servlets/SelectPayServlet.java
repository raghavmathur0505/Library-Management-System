package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import beans.SearchBean;
import beans.UserBean;
import beans.ProductBean;
import beans.ProductsBean;
import java.util.ArrayList;

/**
 * Servlet implementation class ViewPostsServlet
 */
@WebServlet("/SelectPayServlet")
public class SelectPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()54
	 */
	public SelectPayServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPOST(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// String user="";
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json");
		//ServletRequest session = null;
		// @SuppressWarnings("null")
		//HttpSession session = request.getSession();
		//UserBean userBean=(UserBean)session.getAttribute("USER");
		//String user=userBean.getName();
		//String cardId = request.getParameter("cardId");
		String cardId = request.getParameter("cardId");
		String loanId = request.getParameter("loanId");
		String fine = request.getParameter("fine");
		String Fname = request.getParameter("Fname");
		String dateIn = request.getParameter("dateIn");
		String paid = request.getParameter("paid");
		String isbn = request.getParameter("isbn");
		//String name = request.getParameter("name");
		//String cardId = userBean.getCardId();
		//System.out.println("session in servlet: "+user+" "+cardId);
		
		//cardId = "%" + cardId + "%";
		//isbn = "%" + isbn + "%";
		//name = "%" + name + "%";

		ProductBean products = new ProductBean();
		SearchBean search = new SearchBean();
		//System.out.println("searchtext:" + searchTitle);
		//search.setSearch(cardId);
		//search.setSearch2(isbn);
		//search.setSearch3(name);
		products.setCardId(cardId);
		products.setLoanId(loanId);
		products.setFirstName(Fname);
		products.setIsbn(isbn);
		products.setPaid(paid);
		products.setDateIn(dateIn);
		products.setFine(fine);

		Boolean status = false;
		try {

			//Client client = Client.create();
			//WebResource webResource = client
			//		.resource("http://localhost:9443/LibraryManagement/rest/viewfineservice/view");

			//Gson userJson = new Gson();
			//String data = userJson.toJson(search);

			// ClientResponse restResponse = webResource
			// .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
			// .post(ClientResponse.class, formData);
			//ClientResponse restResponse = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, data);

			//if (restResponse.getStatus() != 200) {
			//	throw new RuntimeException("Failed : HTTP error code : " + restResponse.getStatus());
			//}

			//Gson gson = new Gson();
			//ProductsBean searchResult = gson.fromJson(restResponse.getEntity(String.class), ProductsBean.class);

			System.out.println("servlet printing now: ");
			status=true;
			// searchResult.getBooks();

			//products = searchResult;

			// String statusString = restResponse.getEntity(String.class);
			// status = Boolean.parseBoolean(statusString);
			//status = products.isValidSearch();
			//System.out.println("servlet status: " + status);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (status) {
			//UserBean ub=new UserBean();
			//ub.setCardId(cardId);
			System.out.println("status is good!");
			HttpSession session = request.getSession();
			session.setAttribute("PRODUCTS1", products);
			//session1.setAttribute("USER", userBean);
			RequestDispatcher rd = request.getRequestDispatcher("PayFinePage.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("MainPage.jsp");
			rd.forward(request, response);
		}

		// now send request to service

	}

}
