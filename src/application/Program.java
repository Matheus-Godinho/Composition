package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf;
		String name, email;
		Date birthDate;
		Client client;
		
		sdf = new SimpleDateFormat("dd/MM/yyyy");		
		System.out.printf("Enter client data:%n");
		System.out.printf("Name: ");
		name = sc.nextLine();
		System.out.printf("Email: ");
		email = sc.nextLine();
		System.out.printf("Birth date (DD/MM/YYYY): ");
		birthDate = sdf.parse(sc.next());
		client = new Client(name, email, birthDate);
		
		
		OrderStatus status;
		Order order;
		int n, quantity;
		double price;
		Product product;
		OrderItem item;
		
		System.out.printf("Enter order data:%n");
		System.out.printf("Status: ");
		status = OrderStatus.valueOf(sc.next());
		order = new Order(new Date(), status, client);
		System.out.printf("How many items to this order? ");
		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.printf("Enter #%d item data:%n", i);
			System.out.printf("Product name: ");
			sc.nextLine();
			name = sc.nextLine();
			System.out.printf("Product price: ");
			price = sc.nextDouble();
			System.out.printf("Quantity: ");
			quantity = sc.nextInt();
			product = new Product(name, price);
			item = new OrderItem(quantity, price, product);
			order.addItem(item);
		}
		
		System.out.printf("%nORDER SUMMARY:%n");
		System.out.printf("%s%n", order.toString());
		
		sc.close();

	}

}
