package com.sms;

import com.sms.dao.*;
import demo.com.grocery_management_system.entities.review;
import demo.com.grocery_management_system.entities.user;
import demo.com.grocery_management_system.entities.product;
import demo.com.grocery_management_system.entities.ordr;
import demo.com.grocery_management_system.entities.orderitem;
import demo.com.grocery_management_system.entities.cartitem;
import demo.com.grocery_management_system.entities.cart;
import demo.com.grocery_management_system.entities.category;


import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Hibernate;

public class serConsoleApp {
    private static UserDAO userDao = new UserDAOImpl();
    private static ReviewDAO reviewDao = new ReviewDAOImpl();
    private static ProductDAO productDao = new ProductDAOImpl();
    private static OrderDAO orderDao = new OrderDAOImpl();
    private static OrderItemDAO orderItemDao = new OrderItemDAOImpl();
    private static CartDAO cartDao = new CartDAOImpl();
    private static CartItemDAO cartItemDao = new CartItemDAOImpl();
    private static CategoryDAO categoryDao = new CategoryDAOImpl(); 
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Choose a Table ---");
            System.out.println("1. User");
            System.out.println("2. Review");
            System.out.println("3. Product");
            System.out.println("4. Order");
            System.out.println("5. Order Item");
            System.out.println("6. Category");
            System.out.println("7. Cart");
            System.out.println("8. Cart Item");
            System.out.println("9. Exit");

            int tableChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (tableChoice) {
                case 1:
                    userOperationsMenu();
                    break;
                case 2:
                    reviewOperationsMenu();
                    break;
                case 3:
                    productOperationsMenu();
                    break;
                case 4:
                    orderOperationsMenu();
                    break;
                case 5:
                    orderItemOperationsMenu(); // Add OrderItem menu
                    break;
                case 6:
                	categoryOperationsMenu();  // Add Category menu
                	break;
                case 7:
                    cartOperationsMenu(); // Add Cart menu
                    break;
                case 8:
                    cartItemOperationsMenu(); // Add CartItem menu
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid table.");
            }
        }
    }

    // --- Menu for User Operations ---
    private static void userOperationsMenu() {
        while (true) {
            System.out.println("\n--- User Operations ---");
            System.out.println("1. Insert User");
            System.out.println("2. Update User");
            System.out.println("3. Delete User");
            System.out.println("4. Show All Users");
            System.out.println("5. Back to Table Selection");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    insertUser();
                    break;
                case 2:
                    updateUser();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 4:
                    showAllUsers();
                    break;
                case 5:
                    return; // Go back to table selection
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // --- Menu for Review Operations ---
    private static void reviewOperationsMenu() {
        while (true) {
            System.out.println("\n--- Review Operations ---");
            System.out.println("1. Insert Review");
            System.out.println("2. Update Review");
            System.out.println("3. Delete Review");
            System.out.println("4. Show All Reviews");
            System.out.println("5. Back to Table Selection");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    insertReview();
                    break;
                case 2:
                    updateReview();
                    break;
                case 3:
                    deleteReview();
                    break;
                case 4:
                    showAllReviews();
                    break;
                case 5:
                    return; // Go back to table selection
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    //product menu
    private static void productOperationsMenu() {
        while (true) {
            System.out.println("\n--- Product Operations ---");
            System.out.println("1. Insert Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Show All Products");
            System.out.println("5. Back to Table Selection");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    insertProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    showAllProducts();
                    break;
                case 5:
                    return; // Go back to table selection
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //order menu
    private static void orderOperationsMenu() {
        while (true) {
            System.out.println("--- Order Operations ---");
            System.out.println("1. Insert Order");
            System.out.println("2. Update Order");
            System.out.println("3. Delete Order");
            System.out.println("4. Show All Orders");
            System.out.println("5. Back to Table Selection");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    insertOrder();
                    break;
                case 2:
                    updateOrder();
                    break;
                case 3:
                    deleteOrder();
                    break;
                case 4:
                    showAllOrders();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    // --- Menu for OrderItem Operations ---
    private static void orderItemOperationsMenu() {
        while (true) {
            System.out.println("\n--- OrderItem Operations ---");
            System.out.println("1. Insert OrderItem");
            System.out.println("2. Update OrderItem");
            System.out.println("3. Delete OrderItem");
            System.out.println("4. Show All OrderItems");
            System.out.println("5. Back to Table Selection");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    insertOrderItem();
                    break;
                case 2:
                    updateOrderItem();
                    break;
                case 3:
                    deleteOrderItem();
                    break;
                case 4:
                    showAllOrderItems();
                    break;
                case 5:
                    return; // Go back to table selection
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
    }
    
      // --- Menu for Category Operations ---
    private static void categoryOperationsMenu() {
        while (true) {
            System.out.println("\n--- Category Operations ---");
            System.out.println("1. Insert Category");
            System.out.println("2. Update Category");
            System.out.println("3. Delete Category");
            System.out.println("4. Show All Categories");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    insertCategory();
                    break;
                case 2:
                    updateCategory();
                    break;
                case 3:
                    deleteCategory();
                    break;
                case 4:
                    showAllCategories();
                    break;
                case 5:
                    return; // Go back to table selection
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    // --- Cart Operations Menu ---
    private static void cartOperationsMenu() {
        while (true) {
            System.out.println("\n--- Cart Operations ---");
            System.out.println("1. Insert Cart");
            System.out.println("2. Update Cart");
            System.out.println("3. Delete Cart");
            System.out.println("4. Show All Carts");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    insertCart();
                    break;
                case 2:
                    updateCart();
                    break;
                case 3:
                    deleteCart();
                    break;
                case 4:
                    showAllCarts();
                    break;
                case 5:
                    return; // Go back to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
 // --- CartItem Operations Menu ---
    private static void cartItemOperationsMenu() {
        while (true) {
            System.out.println("\n--- CartItem Operations ---");
            System.out.println("1. Insert CartItem");
            System.out.println("2. Update CartItem");
            System.out.println("3. Delete CartItem");
            System.out.println("4. Show All CartItems");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    insertCartItem();
                    break;
                case 2:
                    updateCartItem();
                    break;
                case 3:
                    deleteCartItem();
                    break;
                case 4:
                    showAllCartItems();
                    break;
                case 5:
                    return; // Go back to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

 

    // --- User Management Methods ---
    private static void insertUser() {
        System.out.println("\n--- Insert User ---");
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
        LocalDate dob = LocalDate.parse(scanner.nextLine());
        LocalDate dateJoined = LocalDate.now(); // Automatically set to current date

        user newUser = new user(userId, username, password, email, firstName, lastName, address, phoneNumber, dob, dateJoined);
        userDao.insert(newUser);
        System.out.println("User inserted successfully.");
    }

    private static void updateUser() {
        System.out.println("\n--- Update User ---");
        System.out.print("Enter User ID to update: ");
        String userId = scanner.nextLine();
        user existingUser = userDao.findById(userId);
        if (existingUser == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("\n--- Enter New Details for the User ---");
        System.out.print("Enter Username: ");
        existingUser.setUsername(scanner.nextLine());
        System.out.print("Enter Password: ");
        existingUser.setPassword(scanner.nextLine());
        System.out.print("Enter Email: ");
        existingUser.setEmail(scanner.nextLine());
        System.out.print("Enter First Name: ");
        existingUser.setFirstname(scanner.nextLine());
        System.out.print("Enter Last Name: ");
        existingUser.setLastname(scanner.nextLine());
        System.out.print("Enter Address: ");
        existingUser.setAddress(scanner.nextLine());
        System.out.print("Enter Phone Number: ");
        existingUser.setPhonenumber(scanner.nextLine());

        userDao.update(existingUser);
        System.out.println("User updated successfully.");
    }

    private static void deleteUser() {
        System.out.println("\n--- Delete User ---");
        System.out.print("Enter User ID to delete: ");
        String userId = scanner.nextLine();
        userDao.delete(userId);
        System.out.println("User deleted successfully.");
    }

    private static void showAllUsers() {
        System.out.println("\n--- User List ---");
        List<user> users = userDao.findAll();
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            for (user u : users) {
                System.out.println(u);
            }
        }
    }

    // --- Review Management Methods ---
    private static void insertReview() {
        System.out.println("\n--- Insert Review ---");
        System.out.print("Enter Review ID: ");
        int reviewId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Rating (1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Comment: ");
        String comment = scanner.nextLine();

        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        user reviewUser = userDao.findById(userId);
        product reviewProduct = productDao.findById(productId); // Fetch product by ID

        if (reviewUser != null && reviewProduct != null) {
            review newReview = new review(reviewId, rating, comment, reviewProduct, reviewUser);
            reviewDao.insert(newReview);
            System.out.println("Review inserted successfully.");
        } else {
            System.out.println("Invalid user or product ID. Review not inserted.");
        }
    }

    private static void updateReview() {
        // Update review code similar to updateUser, adjust accordingly
    	System.out.println("\n--- Update Review ---");

        System.out.print("Enter Review ID to update: ");
        int reviewId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        review existingReview = reviewDao.findById(reviewId);

        if (existingReview == null) {
            System.out.println("Review not found.");
            return;
        }

        System.out.println("\n--- Enter New Details for the Review ---");

        System.out.print("Enter Rating (1-5): ");
        existingReview.setRating(scanner.nextInt());
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Comment: ");
        existingReview.setComment(scanner.nextLine());

        reviewDao.update(existingReview);
        System.out.println("Review updated successfully.");
    	
    }

    private static void deleteReview() {
        // Delete review code
    	 System.out.println("\n--- Delete Review ---");

         System.out.print("Enter Review ID to delete: ");
         int reviewId = scanner.nextInt();
         scanner.nextLine(); // Consume newline

         reviewDao.delete(reviewId);
         System.out.println("Review deleted successfully.");
    }

    private static void showAllReviews() {
        System.out.println("\n--- Review List ---");
        List<review> reviews = reviewDao.findAll();
        if (reviews.isEmpty()) {
            System.out.println("No reviews found.");
        } else {
            for (review r : reviews) {
                System.out.println(r);
            }
        }
    }

    // --- Product Management Methods ---
    private static void insertProduct() {
        // Insert product code
    	System.out.println("\n--- Insert Product ---");

        product p = new product();
        System.out.print("Enter Product ID: ");
        p.setProductId(scanner.nextInt());
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Product Name: ");
        p.setName(scanner.nextLine());

        System.out.print("Enter Product Description: ");
        p.setDescription(scanner.nextLine());

        System.out.print("Enter Product Price (without currency symbol): ");
        // Make sure to read the price as a double, without the currency symbol
        while (true) {
            try {
                p.setPrice(scanner.nextDouble());
                break; // Exit loop if input is valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid price (numeric value only): ");
                scanner.next(); // Clear invalid input
            }
        }
        
        System.out.print("Enter Product Stock: ");
        while (true) {
            try {
                p.setStock(scanner.nextInt());
                break; // Exit loop if input is valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid stock number (integer only): ");
                scanner.next(); // Clear invalid input
            }
        }
        scanner.nextLine(); // Consume newline

        // Set the category here as per your application logic
        // Example: p.setCategory(categoryDao.findById(categoryId));

        productDao.insert(p);
        System.out.println("Product inserted successfully!");
    }

    private static void updateProduct() {
        // Update product code
    	System.out.println("\n--- Update Product ---");

        System.out.print("Enter Product ID to update: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        product existingProduct = productDao.findById(productId);
        if (existingProduct == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.println("\n--- Enter New Details for the Product ---");

        System.out.print("Enter Product Name (leave blank for no change): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            existingProduct.setName(name);
        }

        System.out.print("Enter Product Description (leave blank for no change): ");
        String description = scanner.nextLine();
        if (!description.isEmpty()) {
            existingProduct.setDescription(description);
        }

        System.out.print("Enter Product Price (leave blank for no change): ");
        double price = scanner.nextDouble();
        if (price > 0) {
            existingProduct.setPrice(price);
        }

        System.out.print("Enter Product Stock (leave blank for no change): ");
        int stock = scanner.nextInt();
        if (stock >= 0) {
            existingProduct.setStock(stock);
        }

        productDao.update(existingProduct);
        System.out.println("Product updated successfully!");

    }

    private static void deleteProduct() {
        // Delete product code
    	System.out.println("\n--- Delete Product ---");

        System.out.print("Enter Product ID to delete: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        productDao.delete(productId);
        System.out.println("Product deleted successfully!");
    }

    private static void showAllProducts() {
        System.out.println("\n--- Product List ---");
        List<product> products = productDao.findAll();
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (product p : products) {
                System.out.println(p);
            }
        }
    }
    // --- Order Management Methods ---
    private static void insertOrder() {
        ordr newOrder = new ordr();
        
        System.out.print("Enter Order ID: ");
        newOrder.setOrdrId(scanner.nextInt());
        scanner.nextLine(); // consume the newline

        System.out.print("Enter Order Date (YYYY-MM-DD): ");
        newOrder.setOrdrDate(LocalDate.parse(scanner.nextLine()));

        System.out.print("Enter Total Amount: ");
        newOrder.setTotalAmount(scanner.nextDouble());
        scanner.nextLine(); // consume the newline

        System.out.print("Enter Shipping Address: ");
        newOrder.setShippingAddress(scanner.nextLine());

        System.out.print("Enter Order Status: ");
        newOrder.setOrdrStatus(scanner.nextLine());

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine(); // Use String to match user table ID type
        user existingUser = userDao.findById(userId); // Fetch user by ID
        if (existingUser != null) {
            newOrder.setUser(existingUser); // Set user if found
            orderDao.insert(newOrder);
            System.out.println("Order inserted successfully!");
        } else {
            System.out.println("User not found. Order not inserted.");
        }
    }

    private static void updateOrder() {
        System.out.print("Enter Order ID to update: ");
        int orderId = scanner.nextInt();
        ordr order = orderDao.findById(orderId);

        if (order != null) {
            System.out.print("Enter New Order Date (YYYY-MM-DD): ");
            order.setOrdrDate(LocalDate.parse(scanner.next()));

            System.out.print("Enter New Total Amount: ");
            order.setTotalAmount(scanner.nextDouble());

            scanner.nextLine(); // consume the newline
            System.out.print("Enter New Shipping Address: ");
            order.setShippingAddress(scanner.nextLine());

            System.out.print("Enter New Order Status: ");
            order.setOrdrStatus(scanner.nextLine());

            System.out.print("Enter New User ID: ");
            String userId = scanner.nextLine(); // Use String to match user table ID type
            user existingUser = userDao.findById(userId); // Fetch user by ID
            if (existingUser != null) {
                order.setUser(existingUser); // Set new user if found
                orderDao.update(order);
                System.out.println("Order updated successfully!");
            } else {
                System.out.println("User not found. Order not updated.");
            }
        } else {
            System.out.println("Order not found.");
        }
    }

    private static void deleteOrder() {
        System.out.print("Enter Order ID to delete: ");
        int orderId = scanner.nextInt();
        orderDao.delete(orderId);
        System.out.println("Order deleted successfully.");
    }

    private static void showAllOrders() {
        System.out.println("\n--- Order List ---");
        List<ordr> orders = orderDao.findAll();
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            for (ordr o : orders) {
                System.out.println(o);
            }
        }
    }

 // --- OrderItem Management Methods ---
    private static void insertOrderItem() {
        System.out.println("\n--- Insert Order Item ---");

        // Fetch OrderItem details
        System.out.print("Enter OrderItem ID: ");
        int orderItemId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Unit Price: ");
        double unitPrice = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        // Fetch associated Product
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        product existingProduct = productDao.findById(productId);

        // Fetch associated Order (ordr)
        System.out.print("Enter Order (ordr) ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        ordr existingOrder = orderDao.findById(orderId);  // Make sure ordr is fetched using its correct DAO

        if (existingProduct != null && existingOrder != null) {
            // Correct constructor call with appropriate entities (product, ordr, unitPrice)
            orderitem newOrderItem = new orderitem(orderItemId, quantity, unitPrice, existingOrder, existingProduct);
            orderItemDao.insert(newOrderItem);  // Assuming orderItemDao is properly implemented
            System.out.println("Order Item inserted successfully!");
        } else {
            System.out.println("Invalid Product or Order ID. Order Item not inserted.");
        }
    }

    private static void updateOrderItem() {
        System.out.println("\n--- Update OrderItem ---");

        System.out.print("Enter OrderItem ID to update: ");
        int orderItemId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        orderitem existingOrderItem = orderItemDao.findById(orderItemId);

        if (existingOrderItem != null) {
            System.out.print("Enter New Quantity: ");
            existingOrderItem.setQuantity(scanner.nextInt());
            scanner.nextLine(); // Consume newline

            System.out.print("Enter New Unit Price: ");
            existingOrderItem.setUnitPrice(scanner.nextDouble());
            scanner.nextLine(); // Consume newline

            System.out.print("Enter New Product ID: ");
            int productId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            product existingProduct = productDao.findById(productId);

            System.out.print("Enter New Order ID: ");
            int orderId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            ordr existingOrder = orderDao.findById(orderId);

            if (existingProduct != null && existingOrder != null) {
                existingOrderItem.setProduct(existingProduct);
                existingOrderItem.setOrder(existingOrder);
                orderItemDao.update(existingOrderItem);
                System.out.println("OrderItem updated successfully.");
            } else {
                System.out.println("Invalid Product or Order ID. OrderItem not updated.");
            }
        } else {
            System.out.println("OrderItem not found.");
        }
    }
    private static void deleteOrderItem() {
        System.out.println("\n--- Delete OrderItem ---");

        System.out.print("Enter OrderItem ID to delete: ");
        int orderItemId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        orderItemDao.delete(orderItemId);
        System.out.println("OrderItem deleted successfully.");
    }

    private static void showAllOrderItems() {
        System.out.println("\n--- OrderItem List ---");
        List<orderitem> orderItems = orderItemDao.findAll();
        if (orderItems.isEmpty()) {
            System.out.println("No OrderItems found.");
        } else {
            for (orderitem oi : orderItems) {
                System.out.println(oi);
            }
        }
      }
    //--- Category Management Methods ---
    private static void insertCategory() {
        System.out.println("\n--- Insert Category ---");

        System.out.print("Enter Category ID: ");
        String categoryId = scanner.next();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Category Name: ");
        String categoryName = scanner.nextLine();

        System.out.print("Enter Description: ");
        String description = scanner.nextLine();

        category newCategory = new category(categoryId, categoryName, description);
        categoryDao.insert(newCategory);
        System.out.println("Category inserted successfully!");
    }

    private static void updateCategory() {
        System.out.println("\n--- Update Category ---");

        System.out.print("Enter Category ID to update: ");
        String categoryId = scanner.next();

        category existingCategory = categoryDao.findById(categoryId);
        if (existingCategory != null) {
            System.out.print("Enter New Category Name: ");
            existingCategory.setCategoryName(scanner.next());

            System.out.print("Enter New Description: ");
            existingCategory.setDescription(scanner.next());

            categoryDao.update(existingCategory);
            System.out.println("Category updated successfully.");
        } else {
            System.out.println("Category not found.");
        }
    }

    private static void deleteCategory() {
        System.out.println("\n--- Delete Category ---");

        System.out.print("Enter Category ID to delete: ");
        String categoryId = scanner.next();

        categoryDao.delete(categoryId);
        System.out.println("Category deleted successfully.");
    }

    private static void showAllCategories() {
        System.out.println("\n--- Category List ---");
        List<category> categories = categoryDao.findAll();
        if (categories.isEmpty()) {
            System.out.println("No categories found.");
        } else {
            for (category cat : categories) {
                System.out.println(cat);
            }
        }
      }

 // --- Cart Management Methods ---
    private static void insertCart() {
        System.out.println("\n--- Insert Cart ---");

        System.out.print("Enter Cart ID: ");
        int cartId = scanner.nextInt();

        System.out.print("Enter Creation Date (yyyy-mm-dd): ");
        String creationDateStr = scanner.next();
        LocalDate creationDate = LocalDate.parse(creationDateStr);

        System.out.print("Enter User ID (String): ");
        String userId = scanner.next(); // Expecting a String now

        user user = userDao.findById(userId); // findById expects a String

        if (user != null) {
            cart newCart = new cart(cartId, creationDate, user);
            cartDao.insert(newCart);
            System.out.println("Cart inserted successfully!");
        } else {
            System.out.println("User not found.");
        }
    }

    private static void updateCart() {
        System.out.println("\n--- Update Cart ---");

        System.out.print("Enter Cart ID to update: ");
        int cartId = scanner.nextInt();

        cart existingCart = cartDao.findById(cartId);
        if (existingCart != null) {
            System.out.print("Enter New Creation Date (yyyy-mm-dd): ");
            String creationDateStr = scanner.next();
            LocalDate creationDate = LocalDate.parse(creationDateStr);
            existingCart.setCreationDate(creationDate);

            cartDao.update(existingCart);
            System.out.println("Cart updated successfully.");
        } else {
            System.out.println("Cart not found.");
        }
    }
    private static void deleteCart() {
        System.out.println("\n--- Delete Cart ---");

        System.out.print("Enter Cart ID to delete: ");
        int cartId = scanner.nextInt();

        cartDao.delete(cartId);
        System.out.println("Cart deleted successfully.");
    }
    private static void showAllCarts() {
        System.out.println("\n--- Cart List ---");
        List<cart> carts = cartDao.findAll();
        if (carts.isEmpty()) {
            System.out.println("No carts found.");
        } else {
            for (cart cart : carts) {
                System.out.println(cart);
            }
        }
    }

// --- CartItem Management Methods ---
private static void insertCartItem() {
    System.out.println("\n--- Insert CartItem ---");

    System.out.print("Enter CartItem ID: ");
    int cartItemId = scanner.nextInt();

    System.out.print("Enter Quantity: ");
    int quantity = scanner.nextInt();

    System.out.print("Enter Cart ID: ");
    int cartId = scanner.nextInt();
    cart cart = cartDao.findById(cartId);

    System.out.print("Enter Product ID: ");
    int productId = scanner.nextInt();
    product product = productDao.findById(productId);

    if (cart != null && product != null) {
        cartitem newCartItem = new cartitem(cartItemId, quantity, cart, product);
        cartItemDao.insert(newCartItem);
        System.out.println("CartItem inserted successfully!");
    } else {
        System.out.println("Invalid Cart or Product ID.");
    }
}

private static void updateCartItem() {
    System.out.println("\n--- Update CartItem ---");
  
    System.out.print("Enter CartItem ID to update: ");
    int cartItemId = scanner.nextInt();

    cartitem existingCartItem = cartItemDao.findById(cartItemId);
    if (existingCartItem != null) {
        System.out.print("Enter New Quantity: ");
        existingCartItem.setQuantity(scanner.nextInt());

        cartItemDao.update(existingCartItem);
        System.out.println("CartItem updated successfully.");
    } else {
        System.out.println("CartItem not found.");
    }
}

private static void deleteCartItem() {
    System.out.println("\n--- Delete CartItem ---");

    System.out.print("Enter CartItem ID to delete: ");
    int cartItemId = scanner.nextInt();

    cartItemDao.delete(cartItemId);
    System.out.println("CartItem deleted successfully.");
}

private static void showAllCartItems() {
    System.out.println("\n--- CartItem List ---");
    List<cartitem> cartItems = cartItemDao.findAll();
    if (cartItems.isEmpty()) {
        System.out.println("No cart items found.");
    } else {
        for (cartitem cartItem : cartItems) {
            System.out.println(cartItem);
        }
    }
  }
}
