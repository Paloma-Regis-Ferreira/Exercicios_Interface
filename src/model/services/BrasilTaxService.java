package model.services;

public class BrasilTaxService {
	
	public double tax(double amount) {//vai retornar double, entao não tem problema não ser Warpper class
		if(amount <= 100.0) {
			return amount * 0.2;
		}else {
			return amount * 0.15;
		}
	}
}
