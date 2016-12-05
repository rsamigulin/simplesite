package db;

public class Product {
	
	String name;
	String description;
	double price;
	String imageName;
	int quantity;
	
	public Product(String name, String description, double price, String imageName, int quantity) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.imageName = imageName;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
