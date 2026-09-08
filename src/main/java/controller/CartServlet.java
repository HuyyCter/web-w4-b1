package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.Product;
import service.ProductService;

import java.io.IOException;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductService productService = new ProductService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		if (action == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing action parameter");
            return;
        }
		
		switch (action) {
			case "add":
				addCartItem(request, response);
				break;
			case "update":
				updateCartItem(request, response);
				break;
			case "remove":
				removeCartItem(request, response);
				break;
			default:
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
		}
				
	}
	
	private void addCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("productId");
		Product product = productService.getProductById(productId);
		
		HttpSession session = request.getSession(true);
		Cart cart = (Cart) session.getAttribute("cart");
		
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		
		cart.addCartItem(product);
		
		String url = "cart.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	private void updateCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("productId");
		String quantity = request.getParameter("quantity");
		
		HttpSession session = request.getSession(false);
		Cart cart = (session != null) ? (Cart) session.getAttribute("cart") : null;
		
		if (cart != null) {
			if (quantity.trim().isEmpty() || quantity.matches("^[a-zA-Z]+$")) {
				throw new IllegalArgumentException("Quantity must be number.");
			}
			int newQuantity = Integer.parseInt(quantity);
			cart.updateCartItem(productId, newQuantity);
		}
		
		String url = "cart.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	private void removeCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("productId");
		
		HttpSession session = request.getSession(false);
        Cart cart = (session != null) ? (Cart) session.getAttribute("cart") : null;
        
        if (cart != null) {
        	cart.removeCartItem(productId);
        }
        
        String url = "cart.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
}
