package entities;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(numeroCel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		return Objects.equals(numeroCel, other.numeroCel);
	}

	
	
}
