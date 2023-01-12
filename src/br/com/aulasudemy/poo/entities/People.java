package br.com.aulasudemy.poo.entities;

public class People {
	
	private String name;
	private int age;
	private double height;
	private String email;
	
	public People() {
		
	}
	
	public People(String name, int age, double height) {
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	public People(String name, String email) {
		this.name = name;
		
		this.email = email;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	

}
