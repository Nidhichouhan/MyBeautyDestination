package model;

import java.time.LocalDate;

public class Beauty_Products {
	private int productId;
	private String productName;
	private String productDescription;
	private String productIngredients;
	private int ingredientsId;
	private int price;
	private LocalDate expiryDate;
	private int quantity;
 
	public Beauty_Products(int productId, String productName, String productDescription, String productIngredients,int ingredientsId, int price, LocalDate expiryDate, int quantity) {
		this.productId=productId;
		this.productName=productName;
		this.productDescription=productDescription;
		this.productIngredients=productIngredients;
		this.ingredientsId=ingredientsId;
		this.price=price;
		this.expiryDate=expiryDate;
		this.quantity=quantity;
	}
	
	public Beauty_Products() {
	 
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductIngredients() {
		return productIngredients;
	}

	public void setProductIngredients(String productIngredients) {
		this.productIngredients = productIngredients;
	}

	public int getIngredientsId() {
		return ingredientsId;
	}

	public void setIngredientsId(int ingredientsId) {
		this.ingredientsId = ingredientsId;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	
 
}
