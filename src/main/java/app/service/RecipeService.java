package app.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import app.recipe.Recipe;

import org.springframework.stereotype.Component;


@Path("recipe")
@Component
@Consumes("application/json")
@Produces("application/json")
public interface RecipeService {
	
	@GET
	@Path("/all")
	public RecipesResponse getRecipes();
	
	@GET
	@Path("/getIngredients")	
	 public RecipesResponse queryCountIngredients();
	
	@PUT
	@Path("/save")
	public void  saveOrUpdate(Recipe recipe); 
	
	
	@DELETE
	@Path("/delete")
	public void  delete(Recipe recipe); 
	
	
	
	


}
