package m3_groupactivity1;

public class Product {

	final String name;
	final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() { 
    	return name; 
    }
    public double getPrice() { 
    	return price; 
    }

    @Override
    public String toString() {
        return name + " (" + price + ")";
    }

}
