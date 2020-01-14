package com.cognizant.truyum.Dao;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import com.cognizant.truyum.model1.Cart;
import com.cognizant.truyum.model1.MenuItem;

public class CartDaoSqlImplTest {

	public static void testaddCartItems() throws IOException {
	    new CartDaoSqlImpl().addCartItems(2, 1);
	}
	 
    public static void testremoveCartItems() throws IOException {
	    new CartDaoSqlImpl().removeCartItem(2, 3);
	}
	
    public static void testgetAllCartItems() throws CartEmptyException {
        long userId=1;
        Cart cart=new CartDaoSqlImpl().getAllCartItems(userId);
        List<MenuItem> menuItemList=cart.getMenuItemList();
        double total=cart.getTotal();
        DecimalFormat df = new DecimalFormat("#.00");
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
            //ArrayList<MenuItem> list = new ArrayList<>();    
            //new CartDaoSqlImpl().getAllCartItems(1);
            System.out.format("%-15s%-15s%-15s%-20s%-15s%-15s\n", "NAME","PRICE","ACTIVE","DATE_OF_LAUNCH","CATEGORY","FREEDELIVERY");    
            String FreeDelivery;
            for (MenuItem menuItem : menuItemList) {         
                if(menuItem.getFreeDelivery()== true) {
                    FreeDelivery="Yes";
                }else { 
                    FreeDelivery="No";
                }
                System.out.format("%-15s%-15s%-15s%-20s%-15s%-15s\n", menuItem.getName(),df.format(menuItem.getPrice()),menuItem.getActive(),sdf.format(menuItem.getDateOfLaunch()),menuItem.getCategory(),FreeDelivery);  
            } 
    System.out.println("Total="+total);
    }

	public static void main(String[] args) throws IOException, CartEmptyException {
		testaddCartItems();
		testremoveCartItems();
		testgetAllCartItems();   	    
	}
}
