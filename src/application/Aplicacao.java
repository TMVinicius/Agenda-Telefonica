package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Agenda;
import entities.Pessoa;
import entities.Telefone;

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
				System.out.println("Adicionar novo Contato: ");
				System.out.print("Nome: ");
				String nome = sc.next();
				nome = nome.toUpperCase().charAt(0) + nome.substring(1);
				System.out.print("Idade: ");
				int idade = sc.nextInt();
				System.out.print("DDD: ");
				int DDD = sc.nextInt();
				System.out.print("Numero Tel: ");
				String numeroTel = sc.next();

				Pessoa p = new Pessoa(nome, idade);
				Telefone t = new Telefone(DDD, numeroTel);

				Agenda ag = new Agenda(p, t);
				agenda.add(ag);

				System.out.println("Contato cadastrado com sucesso!");
				System.out.println(menu.menu());
				op = sc.nextInt();
			}

			if (op == 3) {
				System.out.println("Qual letra deseja filtrar: ");
				String letra = sc.next();

				List<Agenda> agendaFiltrada = new ArrayList<>();

				for (Agenda a : agenda) {
					agendaFiltrada.add(a);
				}

				agendaFiltrada.removeIf(p -> p.getPessoa().getNome().toUpperCase().charAt(0) != letra.toUpperCase().charAt(0));
				agendaFiltrada.sort((p1, p2) -> p1.getPessoa().getNome().toUpperCase()
						.compareTo(p2.getPessoa().getNome().toUpperCase()));
				agendaFiltrada.forEach(System.out::println);

				System.out.println(menu.menu());
				op = sc.nextInt();
			}

		}

		sc.close();
	}

}
