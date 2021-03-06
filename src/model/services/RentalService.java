package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	
	private Double pricePerDay;
	private Double pricePerHour;
	
	private TaxService taxService;

	public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {//alguns frameworks exigem construtor vazio (padr?o) na model.entities
		//inje??o de dependencia do construtor no rental service, uma das formas de inversao de controle, de tirar da classe a obriga??o de instanciar suas dependecias
		super();
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;//inversao de controle: tira da classe a obriga??o de instanciar suas dependencias
		//sem inje??o de dependencia e forte acoplamento:
		//this.taxService = new BrasilTaxService();
	}
	
	public void processInvoice(CarRental carRental) {
		//vai gerar a nota de pagamento
		long t1 = carRental.getStart().getTime();
		long t2 = carRental.getFinish().getTime();
		double hours = (double)(t2 - t1) / 1000 / 60 / 60;
		double basicPayment;
		if(hours <= 12.0) {
			basicPayment = Math.ceil(hours) * pricePerHour;
		}else {
			basicPayment = Math.ceil(hours / 24) * pricePerDay;
		}
		
		double tax = taxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
}
