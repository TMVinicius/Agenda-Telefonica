package entities;

public class Telefone {

	private int DDD;
	private String numeroCel;

	public Telefone() {

	}

	public Telefone(int DDD, String numeroCel) {
		this.DDD = DDD;
		this.numeroCel = numeroCel;
	}

	public void setDDD(int DDD) {
		this.DDD = DDD;
	}

	public String getNumeroCel() {
		return numeroCel;
	}

	public int getDDD() {
		return DDD;
	}

	public void setNumeroCel(String numeroCel) {
		this.numeroCel = numeroCel;
	}

}
