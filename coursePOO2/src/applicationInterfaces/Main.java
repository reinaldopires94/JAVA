package applicationInterfaces;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Enter com os dados do aluguel");
		System.out.print("Modelo do carro: ");
		String carModel = sc.nextLine();
		System.out.println("Retirada (dd/MM/yyyy hh:mm): ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.println("Rotorno (dd/MM/yyyy hh:mm): ");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
		
		CarRental carRental = new CarRental(start,finish, new Vehicle(carModel));
		
		System.out.println("Enter com o preço por hora:");
		double pricePerHour = sc.nextDouble();
		System.out.println("Entre com o preço por dia:");
		double pricePerDay = sc.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		
		rentalService.processInvoice(carRental);
		
		System.out.println("Fatura:");
		System.out.println("Pagamento básico: " + carRental.getInvoice().getBasicPayment());
		System.out.println("Imposto: " + carRental.getInvoice().getTax());
		System.out.println("Total: " + carRental.getInvoice().getTotalPayment());
		
		sc.close();
	}
}
