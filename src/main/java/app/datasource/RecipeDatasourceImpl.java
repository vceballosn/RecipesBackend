package app.datasource;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.recipe.Recipe;

@Repository
@Transactional
public class RecipeDatasourceImpl  implements RecipeDatasource,Serializable {
    
	@Autowired
	private SessionFactory sessionFactory;

	@Override
    public List<Recipe> findAll() {
		List<Recipe> listaRecipes =null;
		try{
		
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Recipe.class);
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			listaRecipes = (List<Recipe>)criteria.list();			
		}catch(Exception e){
			System.out.println(" findAll " + e);
		}
		return listaRecipes;
    }
	
	
	
	@Override
    public List<Recipe> queryCountIngredients() {
		List<Recipe> listaRecipes =null;
		try{
		
		Query query =	sessionFactory.getCurrentSession().createQuery("select count(i.recipeId) AS total, re.name as name from Ingredient i , Recipe re where  re.id = i.recipeId group by i.recipeId ");
			listaRecipes  = query.list();			
		}catch(Exception e){
			System.out.println(" findAll " + e);
		}
		return listaRecipes;
    }
	
	@Override
	public void saveOrUpdate(Recipe recipe){
		try{
			sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().saveOrUpdate(recipe);
			sessionFactory.getCurrentSession().getTransaction().commit();
			
		}catch(Exception e){
			System.out.println(" Error saveOrUpdate RecipeDatasourceImpl "+e);
			
		}
		
		//sessionFactory.getCurrentSession().close();
	}
	
	@Override
    
	public void delete(Recipe recipe){
		
		try{
			
        	Session	session = sessionFactory.getCurrentSession();
//			session.getSessionFactory().openSession().getTransaction();
			session.load(Recipe.class, recipe.getId());
				session.delete(recipe);
				session.flush();
				
		}
		catch(Exception e){
			System.out.println(" Error Delete RecipeDatasourceImpl "+ e);
		}finally{
			System.out.println(" recipe ID:"+ recipe.getId());
			
		}
		
		/*sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().delete(recipe);
		sessionFactory.getCurrentSession().getTransaction().commit();
		sessionFactory.getCurrentSession().close();*/

		
	}
    	
}
