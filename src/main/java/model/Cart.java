package model;

import java.util.ArrayList;
import java.util.List;


public class Cart {
	private List<CartItem> items = new ArrayList<>();

    public void addProduct(Product product) {
    	for (CartItem item : items) {
    		if (item.getProduct().getId().equals(product.getId())) {
    			item.setQuantity(item.getQuantity() + 1);
    			return;
    		}
    	}
    	items.add(new CartItem(product, 1));
    }
    
    public void updateQuantity(String productId, int newQuantity) {
    	for (CartItem item : items) {
    		if (item.getProduct().getId().equals(productId)) {
    			if (newQuantity <= 0) {
    				items.remove(item);
    			} else {
    				item.setQuantity(newQuantity);    				
    			}
    			return;
    		}
    	}
    }
    
    public void removeProduct(String productId) {
    	for (CartItem item : items) {
    		if (item.getProduct().getId().equals(productId)) {
    			items.remove(item);
    			return;
    		}
    	}
    }

    public List<CartItem> getItems() {
        return items;
    } 
}