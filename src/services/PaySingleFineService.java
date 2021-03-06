package services;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import DAO.DBOperation;
import beans.ProductBean;
//import beans.Books;
//import beans.PostBean;
import beans.ProductsBean;
import beans.SearchBean;
//import beans.UserBean;

@Path("/paysinglefineservice")
public class PaySingleFineService {
	
	@Path("/view")
	@POST
	@Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
	public Response addNewUser(String data) 
	{
		
		boolean response = false;
		Gson gson = new Gson();
		//PostBean post = gson.fromJson(data, PostBean.class);
		//ProductsBean products = new ProductsBean();
        //SearchBean search=new SearchBean();
		ProductBean search = gson.fromJson(data, ProductBean.class);
		String cardId=search.getCardId();
		String loanId=search.getLoanId();
		String dateIn=search.getDateIn();
		String paid=search.getPaid();
		//ArrayList<ArrayList<String>> postResult = DBOperation.searchSumFines();
		boolean postResult=DBOperation.PaySingleFine(cardId,loanId,dateIn,paid);
		boolean postResult1 =DBOperation.checkUnreturnedBook(cardId);
		System.out.println("The search result is: " + postResult);
		//search.setValidation(postResult);
		//search.setCard(postResult==true?"true":"false");
		//System.out.println("index 0 is: " + searchResult.get(0).get(0));
		
		if(postResult != false){
			response = true;
			//post.setpostResult(postResult);
			//search.setValidation(response);
			
			//products.setValidationSearch(response);
			/*System.out.println("post result size " + postResult.size());
			
			for(int index=0;index < postResult.size();index++)
			{
				ProductBean product = new ProductBean();
				
				product.setCardId(postResult.get(index).get(0));
				product.setFine(postResult.get(index).get(1));
				//product.setPaid(postResult.get(index).get(2));
				//product.setCardId(postResult.get(index).get(3));
				//product.setDateIn(postResult.get(index).get(4));
				product.setFirstName(postResult.get(index).get(2));
				
				products.addProducts(product);
				
		
			}*/
			
			//books.getBooks();
		}
		else
		{
			response = false;
			//search.setValidation(true);
			
		}

		Gson searchResultJson = new Gson();
		String responseData = searchResultJson.toJson(search);
		//System.out.println("value of string is: " + responseData);
		return Response.ok().entity(responseData).build();
	}
	
	@Path("/availableusername/{username}")
	@GET
	public String availableUsername(@PathParam("username") String username) {
		//code here to see if userName exists		
		return username + "001";
	}

}
