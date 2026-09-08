package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<CartItem> listCartItems = new ArrayList<>();
	
	public Cart() {
		
	}
	
	public List<CartItem> getListCartItems() {
		return listCartItems;
	}
	
	public void addCartItem(Product product) {
		// Input: 1 object Product
		// Output: The object Product is added to listCartItem
		
		// Validate:
		// + Not null
		product = Objects.requireNonNull(product, "Product cannot be null.");
		
		// Business: 
		// + The product exists
		for (CartItem item : listCartItems) {
			if (item.getProduct().getId().equals(product.getId())) {
				item.setQuantity(item.getQuantity() + 1);
				return;
			}
		}
		
		// + The product does not exist
		listCartItems.add(new CartItem(product, 1));
	}
	
	public void updateCartItem(String productId, int quantity) {
		// Input: product id
		// Output: update amount, quantity
		
		// Validate:
		// + Not null
		productId = Objects.requireNonNull(productId, "Product Id cannot be null.");
		quantity = Objects.requireNonNull(quantity, "Quantity cannot be null.");
		
		// Business:
		for (CartItem item : listCartItems) {
			if (item.getProduct().getId().equals(productId)) {
				if (quantity <= 0) {
					listCartItems.remove(item);
				} else {
					item.setQuantity(quantity);
				}
				return;
			}
		}
	}
	
	public void removeCartItem(String productId) {
		productId = Objects.requireNonNull(productId, "Product Id cannot be null.");
		
		for (CartItem item : listCartItems) {
			if (item.getProduct().getId().equals(productId)) {
				listCartItems.remove(item);
				return;
			}
		}
	}
}