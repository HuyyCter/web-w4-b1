<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>CD List</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

    <h2>CD list</h2>

    <table>
        <tr>
            <th>Description</th>
            <th>Price</th>
            <th></th>
        </tr>
        <tr>
            <td>86 (the band) - True Life Songs and Pictures</td>
            <td>$14.95</td>
            <td>
            	<form action="add-to-cart" method="post">
            		<input type="hidden" name="productId" value="1">
            		<button type="submit" class="btn">Add To Cart</button>
            	</form>
            </td>
        </tr>
        <tr>
            <td>Paddlefoot - The first CD</td>
            <td>$12.95</td>
            <td>
            	<form action="add-to-cart" method="post">
            		<input type="hidden" name="productId" value="2">
            		<button type="submit" class="btn">Add To Cart</button>
            	</form>
            </td>
        </tr>
        <tr>
            <td>Paddlefoot - The second CD</td>
            <td>$14.95</td>
            <td>
            	<form action="add-to-cart" method="post">
            		<input type="hidden" name="productId" value="3">
            		<button type="submit" class="btn">Add To Cart</button>
            	</form>
            </td>
        </tr>
        <tr>
            <td>Joe Rut - Genuine Wood Grained Finish</td>
            <td>$14.95</td>
            <td>
            	<form action="add-to-cart" method="post">
            		<input type="hidden" name="productId" value="4">
            		<button type="submit" class="btn">Add To Cart</button>
            	</form>
            </td>
        </tr>
    </table>

</body>
</html>