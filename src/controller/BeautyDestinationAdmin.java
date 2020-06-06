package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.AdminDAO;
import dao.BeautyProductsDAO;
import dao.BeautyProductsDisplay;
import dao.IngredientDAODisplay;
import dao.IngredientsDAO;
import dao.UserDAO;
import model.Beauty_Products;
import model.Ingredients;

public class BeautyDestinationAdmin {
	//Beauty products Details
		void beauty() throws IOException {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int choice;
			do {
				System.out.println("1.Add Product items");
				System.out.println("2.Delete Product items");
				System.out.println("3.Update Product items");
				System.out.println("4.View all product items");
				System.out.println("5.Exit");
				System.out.println("\nWhich Action You want to Perform?(1-5)");
				System.out.println("*----------------------------------------*");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				
				//Creating object for beauty product class -for crud operations
				BeautyProductsDAO productdao = new BeautyProductsDAO();
				//Creating object for displaying beauty products table
				BeautyProductsDisplay productdisplay = new BeautyProductsDisplay();
				choice = Integer.parseInt(br.readLine());
				switch (choice) {
					case 1:
						System.out.println("*----------------------------------------*");
						System.out.println("            Enter Product Details            ");
						System.out.println("*----------------------------------------*");
						System.out.print("Enter Product ID : ");
						int product_id=Integer.parseInt(br.readLine());
						System.out.print("Enter Product Name : ");
						String product_name = br.readLine();
						System.out.print("Enter Product Description : ");
						String product_description = br.readLine();
						System.out.print("Enter Product Active Ingredient : ");
						String product_ingredient = br.readLine();
						System.out.print("Enter Ingredient Id : ");
						int ingredient_id = Integer.parseInt(br.readLine());
						System.out.print("Enter Product Price : ");
						int product_price = Integer.parseInt(br.readLine());
						System.out.print("Enter Product Expiry Date(DD-MM-YYYY) : ");
						String edate = br.readLine();
						LocalDate expiry_date = LocalDate.parse(edate, formatter);
						System.out.print("Enter Product Quantity : ");
						int product_quantity = Integer.parseInt(br.readLine());
		
						Beauty_Products product = new Beauty_Products(product_id,product_name,product_description,product_ingredient,ingredient_id,product_price,expiry_date,product_quantity);
						productdao.insertProducts(product);
						System.out.println("*----------------------------------------*");
						break;
					case 2:
						System.out.println("*----------------------------------------*");
						System.out.println("            Delete Product Details           ");
						System.out.println("*----------------------------------------*");
						System.out.print("Enter Product ID You Want to Delete : ");
						product_id = Integer.parseInt(br.readLine());
						productdao.deleteProducts(product_id);
						System.out.println("*----------------------------------------*");
						break;
					case 3:
						System.out.println("*----------------------------------------*");
						System.out.println("           Update Product Details            ");
						System.out.println("*----------------------------------------*");
						System.out.print("Enter Product ID You Want to Update : ");
						product_id = Integer.parseInt(br.readLine());
						productdao.updateProducts(product_id);
						System.out.println("*----------------------------------------*");
						break;
		
					case 4:
						System.out.println("*------------------------------------------------------------------------------------------------------------------------------------------------------------*");
						System.out.println("                                                                 View All the Product Details                                                               ");
						System.out.println("*------------------------------------------------------------------------------------------------------------------------------------------------------------*");
						System.out.printf("%10s %30s %40s %20s %40s %20s %20s %20s","Product_Id","Product_Name","Product_Description","Product_Price","Product_Expiry_Date","Product_Quantity","Ingredients_Id","Ingredients_Name");
						System.out.println("*------------------------------------------------------------------------------------------------------------------------------------------------------------*");
						productdisplay.viewAllProductDetailsAdmin();
						System.out.println("*--------------------------------------------------------------------------------------*");

						break;

					case 5:
						
						break;
					default:
						System.out.println("Wrong Choice");
						break;
					}
			}while(choice!=5);
		}
		void ingredient() throws IOException {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int choice;
			do {
				System.out.println("1.Add Ingredients List");
				System.out.println("2.Delete Ingredients List");
				System.out.println("3.Update Ingredients");
				System.out.println("4.View all the Ingredients");
				System.out.println("5.Exit");
				System.out.println("\nWhich Action You want to Perform?(1-5)");
				System.out.println("*----------------------------------------*");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				
				//Creating object for ingredient class -for crud operations
				IngredientsDAO ingredientdao = new IngredientsDAO();
				
				//Creating object for displaying ingredients table
				IngredientDAODisplay ingredientdisplay = new IngredientDAODisplay();
				
				choice = Integer.parseInt(br.readLine());
				switch (choice) {
					case 1:
						System.out.println("*----------------------------------------*");
						System.out.println("            Enter Ingredients Details            ");
						System.out.println("*----------------------------------------*");
						System.out.print("Enter Ingredient ID : ");
						int ingredient_id=Integer.parseInt(br.readLine());
						System.out.print("Enter Ingredient Name : ");
						String ingredient_name = br.readLine();
						System.out.print("Enter Ingredient Description : ");
						String ingredient_description = br.readLine();
						System.out.print("Enter the General Issues Targeted : ");
						String issues = br.readLine();
						System.out.print("Enter the Skin Type It Works For : ");
						String skinType = br.readLine();
						System.out.print("Enter the Skin Id : ");
						int SkinId = Integer.parseInt(br.readLine());
		
						Ingredients ingredient = new Ingredients(ingredient_id, ingredient_name,ingredient_description, issues,skinType,SkinId);
						ingredientdao.insertIngredients(ingredient);
						System.out.println("*----------------------------------------*");
						break;
					case 2:
						System.out.println("*----------------------------------------*");
						System.out.println("            Delete Ingredient             ");
						System.out.println("*----------------------------------------*");
						System.out.print("Enter Ingredient ID You Want to Delete : ");
						ingredient_id = Integer.parseInt(br.readLine());
						ingredientdao.deleteIngredients(ingredient_id);
						System.out.println("*----------------------------------------*");
						break;
					case 3:
						System.out.println("*----------------------------------------*");
						System.out.println("           Update Product Details            ");
						System.out.println("*----------------------------------------*");
						System.out.print("Enter Product ID You Want to Update : ");
						ingredient_id = Integer.parseInt(br.readLine());
						ingredientdao.updateIngredients(ingredient_id);
						System.out.println("*----------------------------------------*");
						break;
		
					case 4:
						System.out.println("*------------------------------------------------------------------------------------------------------------------------------------------------------------*");
						System.out.println("                                                                 View All the Ingredients List                                                               ");
						System.out.println("*------------------------------------------------------------------------------------------------------------------------------------------------------------*");
						System.out.printf("%10s %30s %40s %20s %40s %20s","Ingredients_Id","Ingredients_Name","Ingredients_Description","Issues_Targeted","Skin_Type","Skin_Id");
						System.out.println("*------------------------------------------------------------------------------------------------------------------------------------------------------------*");
						ingredientdisplay.viewAllIngredientDetails();
						System.out.println("*--------------------------------------------------------------------------------------*");
						break;

					case 5:
						
						break;
					default:
						System.out.println("Wrong Choice");
						break;
					}
			}while(choice!=5);
		}
		void admin() throws NumberFormatException, IOException {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			AdminDAO admindao = new AdminDAO();
			UserDAO userdao=new UserDAO();
			int choice;
			do {
				System.out.println("1.Product Items");
				System.out.println("2.Product Ingredients");
				System.out.println("3.View User Details");
				System.out.println("4.View User Feedbacks");
				System.out.println("5.Exit");
				System.out.println("\nWhich Action You want to Perform?(1-5)");
				System.out.println("*----------------------------------------*");
				choice = Integer.parseInt(br.readLine());
				switch (choice) {
					case 1:
						beauty();
						break;
					case 2:
						ingredient();
						break;
					case 3:
						System.out.println("*-------------------------------------------------------------*");
						System.out.println("                        View User Details                      ");
						System.out.println("*-------------------------------------------------------------*");
						System.out.println("User_Id\t\tUser_Name\t\tUser_Email\t\tUser_ContactDetails");
						System.out.println("*-------------------------------------------------------------*");
						userdao.viewUserDetails();
						System.out.println("*------------------------------------------------------------ *");
						break;
					case 4:
						break;
					default:
						System.out.println("Wrong Choice");
						break;
				}
			}while(choice!=5);
		}
		
		public static void user() throws Exception {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			BeautyProductsDisplay productdisplay = new BeautyProductsDisplay();
			IngredientDAODisplay ingredientdisplay = new IngredientDAODisplay();
			int choice;
			do {
				System.out.println("1.View All Products Items");
				System.out.println("2.View Skin Care Products");
				System.out.println("3.View Hair Care Products");
				System.out.println("4.Search By Skin Type");
				System.out.println("5.Search By Your Particular Skin Issues");
				System.out.println("6.Search By Hair Type");
				System.out.println("7.Search By Your Particular Hair Issues");
				System.out.println("8.Ordering Products");
				System.out.println("\nWhich Action You want to Perform?(1-8)");
				System.out.println("*----------------------------------------*");
				choice = Integer.parseInt(br.readLine());
				switch( choice ) {
				case 1:
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					System.out.println("                                                                                            View All Product Details                                                                                                     ");
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					System.out.printf("%-20s  %60s  %43s  %35s  %40s %38s","Product_Name","Product_Description","Product_Ingredients","Price","Expiry_Date","Quantity\n");
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					productdisplay.viewAllProductDetailsUser();
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					break;
				case 2:
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					System.out.println("                                                                                            ALL THE SKIN CARE PRODUCTS                                                                                                   ");
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					System.out.printf("%-20s  %60s  %43s  %35s  %40s  %38s","Product_Name","Product_Description","Product_Ingredients","Price","Expiry_Date", "Quantity\n");
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
	         		productdisplay.viewAllSkinCareProducts();
	         		System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					break;
				case 3:
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					System.out.println("                                                                                            ALL THE HAIR CARE PRODUCTS                                                                                                   ");
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					System.out.printf("%-20s  %60s  %43s  %35s  %40s %38s","Product_Name","Product_Description","Product_Ingredients","Price","Expiry_Date", "Idle Hair Type\n");
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
	         		productdisplay.viewAllHairCareProducts();
	         		System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					
					break;
				case 4:
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					System.out.println("                                                                                                                                                              ");
					System.out.println("                                                                                           ENTER THE GIVEN SKIN TYPES :                                       ");
					System.out.println("                                                                                                                                                              ");
					System.out.print("                                                           DRY SKIN TYPE                          NORMAL SKIN TYPE                     COMBINATION SKIN TYPE\n"  );
					System.out.println("                                                                                                                                                              ");
					System.out.print("                                                       OILY TO NORMAL SKIN TYPE             OILY TO COMBINATION SKIN TYPE              OILY TO DRY SKIN TYPE\n"  );
					System.out.println("                                                                                                                                                              ");
					System.out.print("                                                       NORMAL TO OILY SKIN TYPE            NORMAL TO COMBINATION SKIN TYPE            NORMAL TO DRY SKIN TYPE\n" );
					System.out.println("                                                                                                                                                              ");
					System.out.print("                                                                              ALL SKIN TYPE                               OILY SKIN TYPE                     \n "   );
					System.out.println("                                                                                                                                                              ");
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					System.out.print("Enter Your Skin Type : ");
					String skin_type = br.readLine();
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					System.out.println("                                                                                            View "+skin_type+" Products                                                                                                ");
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					System.out.printf("%-20s  %60s  %43s  %35s  %40s %38s","Product_Name","Product_Description","Skin_Type","Price","Product_Ingredients","Expiry_Date\n");
					System.out.println("*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					productdisplay.searchbySkinType(skin_type);
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					break;
				case 5:
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					System.out.println("                                                                                                                                                              ");
					System.out.println("                                                                                          ENTER THE GIVEN SKIN ISSUES :                                           ");
					System.out.println("                                                                                                                                                                  ");
					System.out.print("                                                                 ACNE                               UNEVEN SKIN                          DULLNESS\n"                 );
					System.out.println("                                                                                                                                                                  ");
					System.out.print("                                                              DAMAGED SKIN                           DARK SPOTS                       SKIN IMPURITIES\n"             );
					System.out.println("                                                                                                                                                                  ");
					System.out.print("                                                              CLOGGED PORES                        SIGNS OF AGING                     DEAD SKIN CELLS\n"             );
					System.out.println("                                                                                                                                                                  ");
					System.out.print("                                                               FINE LINES                             WRINKLES                           ROUGHNESS \n "              );
					System.out.println("                                                                                                                                                              ");
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					System.out.print("Enter Your Skin Issue : ");
					String skin_issue = br.readLine();
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					System.out.println("                                                                                            View "+skin_issue+" Products                             ");
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					System.out.printf("%-20s  %60s  %43s  %35s  %40s","Product_Name","Product_Description","Product_Ingredients","Price","Expiry_Date\n");
					System.out.println("*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					productdisplay.searchbySkinIssue(skin_issue);
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");

					break;
				case 6:
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					System.out.println("                                                                                              ENTER THE GIVEN HAIR TYPES :                                      ");
					System.out.println("                                                                                                                                                              ");
					System.out.print("                                                               CURLY HAIRS                           NORMAL HAIRS                     WAVY HAIRS\n");
					System.out.println("                                                                                                                                                              ");
					
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					System.out.print("Enter Your Hair Type : ");
					String hair_type = br.readLine();
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					System.out.println("                                                                                               View "+hair_type+" Products                             ");
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					System.out.printf("%-20s  %60s  %43s  %35s  %40s","Product_Name","Product_Description","Product_Ingredients","Price","Expiry_Date\n");
					System.out.println("*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					productdisplay.searchbyHairType(hair_type);
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					break;
				case 7:
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					System.out.println("                                                                                                                                                              ");
					System.out.println("                                                                                            ENTER THE GIVEN HAIR ISSUES :                                                                                            ");
					System.out.println("                                                                                                                                                                                                                         ");
					System.out.print("                                                                FRIZZY HAIRS                          SPLIT ENDS                      GREY HAIRS\n                                                                         ");
					System.out.println("                                                                                                                                                                                                                         ");
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					System.out.print("Enter Your Hair Issue : ");
					String hair_issue = br.readLine();
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					System.out.println("                                                                                             View "+hair_issue+" Products                             ");
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					System.out.printf("%-20s  %60s  %43s  %35s  %40s","Product_Name","Product_Description","Product_Ingredients","Price","Expiry_Date\n");
					System.out.println("*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
					productdisplay.searchbyHairIssue(hair_issue);
					System.out.println("*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
				case 8:
					System.out.println("PROCEED FOR SHOPPING!");
					System.out.println("*----------------------------------------*");
					break;
		
				default:
					System.out.println("Wrong Choice");
					break;
		}
		}while(choice!=8);
			
		}
		
	}


