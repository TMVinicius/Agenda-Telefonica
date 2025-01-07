package service;

import java.util.Comparator;

import entities.Agenda;

public class FiltroComparator implements Comparator<Agenda>{

	@Override
	public int compare(Agenda p1, Agenda p2) {

		return p1.getPessoa().getNome().toUpperCase().compareTo(p2.getPessoa().getNome().toUpperCase());
	}


}
