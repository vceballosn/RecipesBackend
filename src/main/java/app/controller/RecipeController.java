package app.controller;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.recipe.Recipe;
import app.service.AbstractResponse;
import app.service.QueryResult;
import app.service.RecipeServiceImpl;
import app.service.RecipesResponse;


@RestController
public class RecipeController {
	
	@Autowired
	protected RecipeServiceImpl recipeService;
	protected ObjectMapper mapper;
	
	@RequestMapping (value ="/saveOrUpdate",method = RequestMethod.POST )
	public AbstractResponse saveUpdate(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException{
		
		 
		this.mapper = new ObjectMapper();
		
		Recipe recipe = mapper.readValue(userJson, Recipe.class);
		
		if(!this.validarRecipe(recipe)){
			
			return new AbstractResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Los Campos son Requeridos");
			
		}
		this.recipeService.saveOrUpdate(recipe);
		return new AbstractResponse(0001, "Opercion Exitosa");
	}
	
	@RequestMapping (value ="/getRecipes",method = RequestMethod.GET )
	public RecipesResponse getRecipes(){
		return this.recipeService.getRecipes();
		
	}
	
	@RequestMapping (value ="/queryCountIngredients",method = RequestMethod.GET )
	public RecipesResponse queryCountIngredients(){
		return this.recipeService.queryCountIngredients();
		
	}
	
	@RequestMapping (value ="/deleteRecipe",method = RequestMethod.POST )
	public AbstractResponse deleteRecipe(@RequestBody String userJson) throws Exception{
		
		 
		this.mapper = new ObjectMapper();
		
		Recipe recipe = mapper.readValue(userJson, Recipe.class);
		
		if (recipe.getId() ==null){
			throw new Exception(" El recipe no Existe");
		}else
		
		this.recipeService.delete(recipe);
		return new AbstractResponse(0002, "Opercion Exitosa");
	}
	
	
	private boolean validarRecipe(Recipe recipe){
		boolean isValide = true;
		
		if(recipe.getName() == null || recipe.getName().equalsIgnoreCase("")){
          isValide =false;			
		}
		if(recipe.getDescription() == null || recipe.getDescription().equalsIgnoreCase("")){
	          isValide =false;			
			}
		
		return isValide;
	}

}

