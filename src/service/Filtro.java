package service;

import java.util.Scanner;
import java.util.function.Predicate;

import entities.Agenda;

public class Filtro implements Predicate <Agenda> {

	public String letra() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Qual letra deseja filtrar: ");
		String l = sc.next();
		sc.close();
		return l;
		
	}
	
	
	@Override
	public boolean test(Agenda a) {

		return a.getPessoa().getNome().toUpperCase().charAt(0) != letra().toUpperCase().charAt(0);
	}

}
