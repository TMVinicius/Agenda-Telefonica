package entities;

import java.util.Objects;
import java.util.Scanner;

public class Agenda {

	private Telefone telefone;
	private Pessoa pessoa;

	Scanner sc = new Scanner(System.in);

	public Agenda() {

	}

	public Agenda(Pessoa pessoa, Telefone telefone) {
		this.pessoa = pessoa;
		this.telefone = telefone;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public String menu() {
		return "\nMenu: " + "\n1-lista de numeros." + "\n2-adicionar novo contato."
				+ "\n3-filtro por letra inicial do nome." + "\n6-sair.\n";
	}

	@Override
	public String toString() {
		return "Cadastro: " + pessoa.getNome() + " de telefone (+0" + telefone.getDDD() + ")"
				+ telefone.getNumeroCel().charAt(0) + " " + telefone.getNumeroCel().substring(1, 5) + "-"
				+ telefone.getNumeroCel().substring(5);
	}

	@Override
	public int hashCode() {
		return Objects.hash(telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		return Objects.equals(telefone, other.telefone);
	}
	
	

}
