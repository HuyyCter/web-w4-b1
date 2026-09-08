<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Your Cart</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

    <h2>Your cart</h2>

    <table>
        <tr>
            <th>Quantity</th>
            <th>Description</th>
            <th>Price</th>
            <th>Amount</th>
            <th></th>
        </tr>
        <c:forEach var="item" items="${sessionScope.cart.items}">
        	<tr>
            	<td>
            		<form action="update-cart" method="post">
	            		<input type="hidden" name="productId" value="${item.product.id}">
	             	    <input type="text" name="quantity" class="qty-input" value="${item.quantity}">
	             	    <button type="submit" class="btn">Update</button>
            		</form>
            	</td>
            	<td>${item.product.description}</td>
           		<td>$${item.product.price}</td>
            	<td>$${item.amount}</td>
            	<td>
            		<form action="remove-product" method="post" style="display:inline;">
                		<input type="hidden" name="productId" value="${item.product.id}">
                		<button type="submit" class="btn">Remove Item</button>
            		</form>
        		</td>
        	</tr>
        </c:forEach>
    </table>

    <p><strong>To change the quantity</strong>, enter the new quantity and click on the Update button.</p>

    <div class="action-buttons">
        <a href="product-list.jsp" class="btn">Continue Shopping</a>
        <form action="checkout" method="post" style="display:inline;">
        	<button type="submit" class="btn">Checkout</button>
    	</form>	
    </div>

</body>
</html>