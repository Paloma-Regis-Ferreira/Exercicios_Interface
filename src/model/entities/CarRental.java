package model.entities;

import java.util.Date;

public class CarRental {
	
	private Date start;
	private Date finish;
	
	private Veiculo veiculo;
	private Invoice invoice;
	
	public CarRental() {
	}

	public CarRental(Date start, Date finish, Veiculo veiculo) {
		this.start = start;
		this.finish = finish;
		this.veiculo = veiculo;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
}
