package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Agenda;
import entities.Pessoa;
import entities.Telefone;
import service.FiltroComparator;
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

					agenda.sort(new FiltroComparator());
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

				if (agenda.size() != 0) {
					for (Agenda a : agenda) {
						if (numeroTel.equals(a.getTelefone().getNumeroCel())) {
							System.out.println("Telefone já cadastrado na base de dados!");
						}
					}
				} else {
					agenda.add(new Agenda(p, t));
					System.out.println("Contato cadastrado com sucesso!");
				}

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
				agendaFiltrada.sort(new FiltroComparator());
				agendaFiltrada.forEach(System.out::println);

				System.out.println(menu.menu());
				op = sc.nextInt();
			}

		}
		System.out.print("Operação encerrada pelo operador!");

		sc.close();
	}

}
