package applicationInterfacesContrato;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entitiesInterfaces.Contract;
import entitiesInterfaces.Installment;
import servicesInterContrato.ContractService;
import servicesInterContrato.PaypalService;

public class Main {

	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Entre os dados do contrato:");
		System.out.println("Número: ");
		int number = sc.nextInt();
		System.out.println("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.println("Valor do contrato: ");
		double totalValue = sc.nextDouble();
		
		Contract obj = new Contract(number, date, totalValue);
		
		System.out.println("Entre com número de parcelas:");
		int installment = sc.nextInt();
		
		ContractService  contractService = new ContractService(new PaypalService());
		contractService.processContract(obj, installment);
		
		System.out.println("Parcelas:");
		for(Installment i : obj.getInstallments()) {
			System.out.println(i);
		}
		sc.close();
	}
}
