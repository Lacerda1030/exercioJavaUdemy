package br.com.aulasudemy.poo.entities;

public class Product {
	
	public String name;
	public int quantity;
	public Double price;
	
	public Product() {
		
	}
	
	public Product(String name, Double price) {
		this.name = name;
		
		this.price = price;
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double totalValueInStock() {
		return price * quantity;
		
	}
	
	public void AddProduct(int quantity) {
		this.quantity += quantity;
	}
	
	public void removeProduct(int quantity) {
		this.quantity -= quantity;
	}

	public String toString() {
		return name
				+", $ "
				+ String.format("%.2f", price)
				+ ", "
				+ quantity
				+ " units, Total: $ "
				+ String.format("%.2f", totalValueInStock());
	}
}
