package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Veiculo;
import model.services.BrasilTaxService;
import model.services.RentalService;

public class Main {
	
	//projeto criado para exercicio de interface e programação em camadas

	public static void main(String[] args) throws ParseException{
		
		Locale.setDefault(Locale.US);
		Scanner sc =new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		//entrando com as informações do aluguel
		System.out.println("Entre com as informações do aluguel");
		System.out.print("Modelo do carro: ");
		String modelo = sc.nextLine();
		System.out.print("Data e hora de inicio (dd/MM/yyyy): ");
		Date dataInicio = sdf.parse(sc.nextLine());
		System.out.print("Data e hora de retorno (dd/MM/yyyy): ");
		Date dataFinal = sdf.parse(sc.nextLine());
		
		//instanciando o aluguel do carro
		CarRental cr = new CarRental(dataInicio, dataFinal, new Veiculo(modelo));
		
		//passando valores para o faturamento do aluguel
		System.out.print("Entre com o preço por hora: ");
		double precoPorHora = sc.nextDouble();
		System.out.print("Entre com o preço por dia: ");
		double precoPorDia = sc.nextDouble();
		
		//instanciando o serviço do aluguel
		RentalService rentalService = new RentalService(precoPorDia, precoPorHora, new BrasilTaxService());//a taxa passa a ser implementada só aqui
		
		//processando o faturamento do aluguel
		rentalService.processInvoice(cr);
		
		System.out.println("Invoice: ");
		System.out.println("Basic payment: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
		System.out.println("Tax: " + String.format("%.2f", cr.getInvoice().getTax()));
		System.out.println("Total payment: " + String.format("%.2f", cr.getInvoice().getTotalPayment()));
		
		sc.close();
	}

}
