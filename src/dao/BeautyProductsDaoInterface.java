package dao;

import model.Beauty_Products;

public interface BeautyProductsDaoInterface {

		void insertProducts(Beauty_Products beauty);
		void deleteProducts(int product_id);
		void updateProducts(int product_id);
	
}
