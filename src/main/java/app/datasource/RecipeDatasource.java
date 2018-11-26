package app.datasource;

import java.util.List;

import app.recipe.Recipe;


public interface RecipeDatasource  {

	List<Recipe> findAll();
    void saveOrUpdate(Recipe recipe);
    void delete(Recipe recipe);
    List<Recipe> queryCountIngredients();
	
}
