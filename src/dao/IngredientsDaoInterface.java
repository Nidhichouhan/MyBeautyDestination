package dao;

import model.Ingredients;

public interface IngredientsDaoInterface {
	void insertIngredients(Ingredients ingredients);
	void deleteIngredients(int ingredient_id);
	void updateIngredients(int ingredient_id);
}
