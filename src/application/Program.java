package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf;
		String name, email;
		Date birthDate;
		Client client;
		
		sdf = new SimpleDateFormat();		
		System.out.printf("Enter client data:%n");
		System.out.printf("Name: ");
		name = sc.nextLine();
		System.out.printf("Email: ");
		email = sc.nextLine();
		System.out.printf("Birth date (DD/MM/YYYY): ");
		birthDate = sdf.parse(sc.next());
		client = new Client(name, email, birthDate);
		
		sc.close();

	}

}
