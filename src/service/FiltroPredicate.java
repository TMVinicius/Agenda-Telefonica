package service;

import java.util.function.Predicate;

import entities.Agenda;

public class FiltroPredicate implements Predicate<Agenda> {

	private String letra;
	
	public FiltroPredicate(String letra) {
		this.letra = letra.toUpperCase();
	}
	
	
	
	@Override
	public boolean test(Agenda a) {
		return a.getPessoa().getNome().toUpperCase().charAt(0) != letra.charAt(0);
	}
	

	
}