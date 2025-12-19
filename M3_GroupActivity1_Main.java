package M3_GroupActivity1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class M3_GroupActivity1_Main {

	// Create a Queue of Products using LinkedList	
	private static final Queue<Product> productQueue = new LinkedList<>();
	static double totalBill = 0.0;
	
	public static void main(String[] args) {

		computerProducts();
		
		Scanner scanner = new Scanner(System.in);

			while (true) {
				displayMenu();
				System.out.print("> ");
				String inputChoice = scanner.nextLine().trim();
				char choice;
	            	
			
	            	if ((inputChoice == null) || (inputChoice.length() != 1) ) {
	            		choice = "0".charAt(0);
	            	} else {
	            		choice = inputChoice.charAt(0);
	            	} 
	            	
	                switch (choice) {
	                	case '1':
	                        addProduct(scanner);
	                        break;
	                	case '2':
	                		processNextProducts();
	                    case '3':
	                    	checkNumberOfProducts();
	                        break;
	                    case '4':
	                    	viewTotalBill();
	                        break;
	                    case '5':
	                    	viewFinalTotal();
	                        scanner.close();
	                        return;
	                        
	                    default:
	                        System.out.println("Invalid option. Please select 1-5.\n");
	                }
	            }
	        }
	    
	
	// Start the program with 5 initial products	
	private static void computerProducts() {
		productQueue.add(new Product("Laptop", 1200.0));
		productQueue.add(new Product("Smartphone", 800.0));
		productQueue.add(new Product("Headphones", 150.0));
		productQueue.add(new Product("Mic", 150.0));
		productQueue.add(new Product("Tablet", 15000.0));
    }
	
	// Display Menu
	private static void displayMenu() {
        System.out.println("Select an option:");
        System.out.println("1. Add a product");
        System.out.println("2. Process next product");
        System.out.println("3. Check number of products");
        System.out.println("4. View total bill so far");
        System.out.println("5. Exit");
    }

	// Add a Product
    private static void addProduct(Scanner scanner) {
        System.out.print("Enter product name to add: ");
        String name = scanner.nextLine().trim();
        

        while (name.isEmpty()) {
            System.out.println("Product name is invalid.");
            System.out.print("Enter product name to add: ");
            name = scanner.nextLine().trim();
        }

        
        Double priceOfProduct = null;        
        while (priceOfProduct == null) {
            System.out.print("Enter price of Product: ");
            String priceOfProductStr = scanner.nextLine().trim();
            if (isNumeric(priceOfProductStr)) {
            	if (isMultiplePeriod(priceOfProductStr)) {
            		priceOfProduct = Double.parseDouble(String.valueOf(priceOfProductStr));
            		if (priceOfProduct < 0) {
            			System.out.println("Price of Product is invalid.");
            			priceOfProduct = null;
            			}
            		} else {
            			System.out.println("Price of Product is invalid.");
            			}
            	} else {
            		System.out.println("Price of Product is invalid.");
            		}
            }

        productQueue.add(new Product(name, priceOfProduct));
        System.out.println("Product added: " + name + " to checkout line! \n");
    }
    
    // Process next product
    private static void processNextProducts() {
    	if (productQueue.isEmpty()) {
            System.out.println("No products to process.");
        } else {
            Product productPrice = productQueue.poll();
            totalBill += productPrice.price;
            System.out.println("Processed: " + productPrice);
            System.out.println("Total bill so far: ₱" + totalBill + "\n");
        }
	}
    
    // Check number of products
    private static void checkNumberOfProducts() {
    	System.out.println("Products in line: " + productQueue.size() + "\n");
	}
    
    // View total bill so far
    private static void viewTotalBill() {
    	System.out.println("Total bill so far: ₱" + totalBill + "\n");
	}
	
    // Exit
    private static void viewFinalTotal() {
    	System.out.println("Closing cashier line...");
        System.out.println("Final total bill: ₱" + totalBill);
    }
    
    private final static boolean isNumeric(String string){
        if (string == null) return false;
        string = string.trim();
        if (string.isEmpty()) return false;
        return string.matches("^\\d+(\\.\\d+)?$");
    }

    
    private final static boolean isMultiplePeriod(String string){
    	int periodCount = 0;
    	boolean result = true;
    	
		char[] chars = string.toCharArray();
    	for (int i = 0; i < chars.length; i++){
    		char c = chars[i];
    		if (c == '.') {
    			periodCount++;
    		}
        	if(periodCount > 1){
        		result = false;
        	}
    		if(!result){
    			return false;
    		}
    	}
    	return true;
    }
}
