package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Agenda;
import service.FiltroPredicate;

public class Aplicacao {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Agenda menu = new Agenda();
		List<Agenda> agenda = new ArrayList<>();

		System.out.println(menu.menu());

		int op = sc.nextInt();

		while (op != 6) {

			if (op == 1) {
				if (agenda.size() == 0) {
					System.out.println("Não há telefones cadastrados!");
					System.out.println(menu.menu());
					op = sc.nextInt();

				} else {

					agenda.sort((p1, p2) -> p1.getPessoa().getNome().toUpperCase()
							.compareTo(p2.getPessoa().getNome().toUpperCase()));
					agenda.forEach(System.out::println);

					System.out.println(menu.menu());
					op = sc.nextInt();
				}
			}

			if (op == 2) {
				agenda.add(menu.agendar());

				System.out.println(menu.menu());
				op = sc.nextInt();

			}

			if (op == 3) {

				List<Agenda> agendaFiltrada = new ArrayList<>();
				for (Agenda a : agenda) {
					agendaFiltrada.add(a);
				}
				
				System.out.println("Qual letra deseja filtrar: ");
				String letra = sc.next();
				
				agendaFiltrada.removeIf(new FiltroPredicate(letra));
				
				agendaFiltrada.forEach(System.out::println);

				System.out.println(menu.menu());
				op = sc.nextInt();
			}

		}
		System.out.print("Operação encerrada pelo operador!");

		sc.close();
	}

}
