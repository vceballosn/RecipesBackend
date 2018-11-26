package app.service;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.datasource.RecipeDatasource;
import app.recipe.Recipe;


@Service
public class RecipeServiceImpl implements RecipeService {

	private static final Logger logger = LoggerFactory.getLogger(RecipeServiceImpl.class);
	
	@Autowired
	private RecipeDatasource datasource;
	
	@Override
	public RecipesResponse getRecipes() {
		
		RecipesResponse response = new RecipesResponse();
		response.setCode(200);
		response.setDescription("ok");
		
		try{
			response.getRecipes().addAll(datasource.findAll());
		} catch (Exception e) {
			logger.error("Error al obtener las recetas de la base de datos.");
			response.setCode(500);
			response.setDescription("Ha ocurrido un error al consultar las recetas");
		}
		
		return response;
	}
    
	
	@Override
	public RecipesResponse queryCountIngredients() {
		
		RecipesResponse response = new RecipesResponse();
		response.setCode(200);
		response.setDescription("ok");
		
		try{
			response.getRecipes().addAll(datasource.queryCountIngredients());
		} catch (Exception e) {
			logger.error("Error al obtener las recetas de la base de datos.");
			response.setCode(500);
			response.setDescription("Ha ocurrido un error al consultar las recetas");
		}
		
		return response;
	}
    
	
	@Override
	public void saveOrUpdate(Recipe recipe){
		try{			
		 this.datasource.saveOrUpdate(recipe);
		}catch(Exception e){
			logger.error("Error al Incluir las recetas de la base de datos.");			
		}
	}
	
	@Override
	public void delete(Recipe recipe){
	
		try{
		 this.datasource.delete(recipe);
		}catch(Exception e){
			logger.error("Error al Eliminar las recetas de la base de datos.");
		}
	}
	


}
