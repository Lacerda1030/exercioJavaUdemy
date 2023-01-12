package br.com.aulasudemy.poo.aplication;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import br.com.aulasudemy.poo.entities.Employee;
import br.com.aulasudemy.poo.entities.People;
import br.com.aulasudemy.poo.entities.Product;
import br.com.aulasudemy.poo.entities.Triangle;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Employee e = null;
		
		int op;
		
		do {
			System.out.println();
			showMenu();
			op = sc.nextInt();
			switch(op) {
				case 1:{
					System.out.println("Simple vector");
					System.out.print("Enter vector size: ");
					int n = sc.nextInt();
					System.out.println("Enter with vector elements: ");
					double[] vect = new double[n];
					for(int i=0; i<n; i++) {
						vect[i] = sc.nextDouble();
					}
					
					double sum = 0;
					for(int i=0; i<n; i++) {
						sum += vect[i];
					}
					double avg = sum / n;
					
					System.out.printf("Avarage Heitgh: %.2f", avg);
					break;
					
					
				}
				case 2:{
					System.out.println("Class vector");
					
					System.out.print("Enter vector size: ");
					int n = sc.nextInt();
					Product[] vectProd = new Product[n];
					
					System.out.println("Enter with vector elements: ");
					
					for(int i=0; i<vectProd.length; i++) {
						sc.nextLine();
						System.out.print("Product"+"["+i+1+"]"+ " name: ");
						String name = sc.nextLine();
						System.out.print("Product"+"["+i+1+"]"+ " price: ");
						double price = sc.nextDouble();
					
						System.out.println();
						
						vectProd[i] = new Product(name,price);
					}
					
					double sum = 0;
					double higherPrice = -200.0;//SALVAR O MAIOR PREÇO
					double percent = 0.0;//SALVAR PORCENTAGEM DE PREÇO MAIOR QUE 500,00
					int count = 0;;
					for(int i=0; i<vectProd.length; i++) {
						sum += vectProd[i].getPrice();
						if(vectProd[i].getPrice() > higherPrice) {
							higherPrice = vectProd[i].getPrice();
						}
						if(vectProd[i].getPrice() > 500.00) {
							count++;
						}
					}
					double avg = sum / n;
					percent = (count *100)/n;
					System.out.printf("Average Price: $ %.2f%n", avg);
					
					System.out.printf("Higher Pirce : $ %.2f%n", higherPrice);
					
					System.out.printf("Average price greater than 500.00 : $ %.2f%%%n", percent);
					
					
					sc.next();
					break;
				}
				
				case 3:{
					System.out.println("Vector Fixing Exercise");
					
					System.out.print("How many rooms will be rented?: ");
					int n = sc.nextInt();
					People[] vectRooms = new People[9];
					
					System.out.println("Enter with vector elements: ");
					
					for(int i=0; i<n; i++) {
						sc.nextLine();
						System.out.println("Rent ["+(i+1)+"] ");
						System.out.print("Name: ");
						String name = sc.nextLine();
						System.out.print("E-mail: ");
						String email = sc.nextLine();
						System.out.print("Room: ");
						int room = sc.nextInt();
											
						System.out.println();
						
						vectRooms[room] = new People(name,email);
					}
					
					System.out.println("Busy Room: ");
					for(int i=0; i<vectRooms.length; i++) {
						if(vectRooms[i] != null) {
							System.out.println(i + ": " + vectRooms[i].getName() + "," + vectRooms[i].getEmail());
						}					
					}
				
					sc.next();
					break;
				}
				
				case 4:{
					Triangle x = new Triangle();
					Triangle y = new Triangle();
					
					Double areaX, areaY;
					
					System.out.println("Enter the measures of triangle X: ");
					x.a = sc.nextDouble();
					x.b = sc.nextDouble();
					x.c = sc.nextDouble();
					
					System.out.println("Enter the measures of triangle Y: ");
					y.a = sc.nextDouble();
					y.b = sc.nextDouble();
					y.c = sc.nextDouble();
					
					areaX = x.area();
					areaY = y.area();
					System.out.printf("Triangle X area: %.4f%n", areaX);
					
					System.out.printf("Triangle X area: %.4f%n", areaY);
					
					if(areaX > areaY) {
						System.out.println("Large area: X");
					}else {
						System.out.println("Large area: Y");
					}
					
					Product product = new Product();
					
					System.out.println("Enter produtc data: ");
					System.out.print("Name: ");
					product.name = sc.nextLine();
					System.out.print("Price: ");
					product.price = sc.nextDouble();
					System.out.print("Quantity: ");
					product.quantity = sc.nextInt();
					
					System.out.println("Product data: " + product);
					System.out.println();
					System.out.print("Enter the numbers of product to be added in stock: ");
					int quantity = sc.nextInt();
					product.AddProduct(quantity);
					
					System.out.println();
					System.out.println("Updated data: " + product);
					System.out.println();
					
					
					System.out.print("Enter the numbers of product to be removed from stock: ");
					quantity = sc.nextInt();
					product.removeProduct(quantity);
					
					System.out.println();
					System.out.println("Updated data: " + product);
					System.out.println();

					
				}
				case 5:{
					
					List<Employee> list = new ArrayList<>();
					int n, id;
					String name;
					Double rate = 0.0;
					Double salary = 0.0;
					
					System.out.println("How many employees will be registered? ");
					n = sc.nextInt();
					for(int i=0; i<n; i++) {
						System.out.println("Employee #"+(i+1));
						System.out.print("Id: ");
						id = sc.nextInt();
						while(checkId(list, id)) {
							System.out.println("Is already taken! Try again: ");
							id = sc.nextInt();
						}
											
						System.out.print("Name: ");
						sc.nextLine();
						name = sc.nextLine();
						System.out.print("Salary: ");
						salary = sc.nextDouble();
						e = new Employee(id, name, salary);
						list.add(e);
					}
					
					System.out.println("Enter the employee id that will have salary increase: ");
					id = sc.nextInt();
					Integer pos = position(list, id);
					if(pos == null) {
						System.out.println("His id does not exist!");
					}else {
						System.out.println("Enter the rate: ");
						rate = sc.nextDouble();
						list.get(pos).increaseSalary(rate);
					}
						
					System.out.println("List of Employees: ");
					for(Employee x : list)
					System.out.println(x);
					//Thread.sleep(1000);
					break;
				}
				
				case 6:{
					
					int element, posL = 0, posC = 0, down = 0, up = 0, right = 0, left = 0; 
					System.out.println();
					System.out.println("Matrix exercise:");
					System.out.println("Enter with the number of rows: ");
					int line = sc.nextInt();
					System.out.println("Enter with the number of columns");
					int column = sc.nextInt();
					int[][] matrix = new int[line][column];
					
					System.out.println();
					System.out.println("Fill matrix: ");
					for(int l=0; l<matrix.length; l++) {
						for(int c=0; c<matrix[l].length; c++) {
							System.out.print("Matrix["+l+"]["+c+"]: ");
							element = sc.nextInt();
							matrix[l][c] = element;
						}
					}
					System.out.println("---------------");
					for(int l=0; l<matrix.length; l++) {
						for(int c=0; c<matrix[l].length; c++) {
							System.out.print(matrix[l][c] + " ");
						}
						System.out.println();
					}
					System.out.print("Choose an matrix element: ");
					element = sc.nextInt();
					for(int l=0; l<matrix.length; l++) {
						for(int c=0; c<matrix[l].length; c++) {
							if(element == matrix[l][c]) {
								posL = l;
								posC = c;
								if(l<matrix.length-1) {
									down = matrix[l+1][c];
								}
								if(l>0) {
									up = matrix[l-1][c];
								}
								if(c>0) {
									left = matrix[l][c-1];
								}
								if(c<matrix[l].length-1) {
									right = matrix[l][c+1];
								}
								System.out.println("---------------");
								System.out.println("Position: "+posL+", "+posC);
								if(left !=0)
									System.out.println("Left: "+left);
								if(right !=0)
									System.out.println("Right: "+right);
								if(up !=0)
									System.out.println("Up: "+up);
								if(down !=0)
									System.out.println("Down: "+down);
								posL = 0;
								posC = 0;
								down = 0;
								up = 0; 
								right = 0;
								left = 0;
							}
						}
					}
						
						
					break;
				}
				case 7:{
					LocalDate d1 = LocalDate.now();
					LocalDateTime d2 = LocalDateTime.now();
					Instant d3 = Instant.now();
					LocalDate d4 = LocalDate.parse("2023-01-11");
					LocalDateTime d5 = LocalDateTime.parse("2023-01-11T01:30:26");
					Instant d6 = Instant.parse("2023-01-11T01:30:26Z"); 
					//PASSANDO DO FORMATO DA TIMEZONE BR PARA O TIMEZONE GMT(Z) +3H DIFERENÇAs
					Instant d7 = Instant.parse("2023-01-11T01:30:26-03:00"); 
					
					//https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/time/LocalDateTime.html
					//https://www.digitalocean.com/community/tutorials/java-simpledateformat-java-date-format
					
					//ESTABELECER UM FORMATO A PARTIR DE UM PADRÃO
					DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
					DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
					DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;
					
					LocalDate d8 = LocalDate.parse("11/01/2023", fmt1);
					LocalDateTime d9 = LocalDateTime.parse("11/01/2023 01:30", fmt2);
					LocalDate d10 = LocalDate.of(2023, 01, 11);
					LocalDateTime d11 = LocalDateTime.of(2023, 01, 11, 01,30);
					
					LocalDate pastWeek = d1.minusWeeks(1);
					Instant pastWeekInstant = d6.minus(7, ChronoUnit.DAYS);
					
					Duration t1 = Duration.between(pastWeekInstant, d6);
					//atStartOfDay() ESPECIFICA 0H0MM E PASSA O LOCADATE PARA LOCALDATETIME
					Duration t2 = Duration.between(pastWeek.atStartOfDay(), d1.atStartOfDay());
					System.out.println("d1 = " + d1);
					System.out.println("pastWeek = " + pastWeek);
					System.out.println("Duration days = " + t2.toDays());
					System.out.println("d2 = " + d2);
					System.out.println("d3 = " + d3);
					System.out.println("d4 = " + d4);
					System.out.println("d5 = " + d5);
					System.out.println("d5 = " + d5.format(fmt4));
					//PASSA DE UMA DATETIME GLOBAL PARA DATETIME LOCAL, OBSERVAR A MUDANCA DO FUSO HORARIO
					System.out.println("d6 = " + fmt3.format(d6));
					System.out.println("pastWeekInstant = " + pastWeekInstant);
					System.out.println("Duration days = " + t1.toDays());
					System.out.println("d7 = " + d7);
					System.out.println("d8 = " + d8);
					System.out.println("d9 = " + d9);
					System.out.println("d9 = " + d9.getDayOfMonth());
					System.out.println("d10 = " + fmt1.format(d10));
					System.out.println("d11 = " + d11.format(fmt2));
					
					
					break;
				}
				case 0:{
					System.out.println("Thanks!");
					break;
				}
			}
		
		}while(op != 0);
				
		
				
		sc.close();
		
		
	}

	
	private static Integer position(List<Employee> list, int id) {
	
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getId() == id) {
				return  i;
			}
		}
		return null;
		
	}
	
	
	private static Boolean checkId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null); 
		return emp != null;
	}


	private static void showMenu() {
		System.out.println("UDEMY JAVA CLASS");
		System.out.println("1 - Simple Vetor");
		System.out.println("2 - Class Vector");
		System.out.println("3 - Vector Fixing exercise");
		System.out.println("4 - Class exercise");
		System.out.println("5 - ArrayList Fixing exercise");
		System.out.println("6 - Matrix Fixing exercise");
		System.out.println("7 - Date Time exempla");
		System.out.println("0 - Exit");
		System.out.println("Choose an option: ");

	}

}
