package controllers.logins.admin.gerenciar;

import extras.Util;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import models.Database;
import models.Professor;

public class GerenciarProfessoresController {
	public static void gerenciarProfessores(Scanner sc, Database db) {
		while (true) {
			/*
			 * Opção do Administrador para o gerenciamento dos professores 1 - Cadastro de um novo
			 * Professor = Linha 2 - Atualização de dados de um professor = Linha 3 - Exclusão de um
			 * professor = Linha 4 - Lista dos professores = Linha 5 - Voltar = Voltar
			 */
			int option = Util.optionPainel(sc,
					new String[] {"[1] - Cadastrar Professores", "[2] - Atualizar Professores",
							"[3] - Excluir Professor", "[4] - Ver Professores",
							"[5] - Voltar a página anterior"});
			switch (option) {
				case 1:
					GerenciarProfessoresController.cadastrarProfessor(sc, db);
					break;
				case 2:
					GerenciarProfessoresController.atualizarProfessor(sc, db);
					break;
				case 3:
					GerenciarProfessoresController.excluirProfessor(sc, db);
					break;
				case 4:
					GerenciarProfessoresController.verProfessor(sc, db);
				case 5:
					System.out.println("Voltando a página anterior!");
					return;
				default:
					System.out.println("\nDigite uma opção válida!\n");
					break;
			}
		}
	}

	private static void cadastrarProfessor(Scanner sc, Database db) {
		// Metodo de cadastro do professor
		String nome;
		String ra;
		String senha = "";
		String turno;
		String curso;
		String uc;
		System.out.print("Digite o nome do professor: ");
		nome = sc.nextLine();
		ra = UUID.randomUUID().toString();
		System.out.print("Escolha um turno para o professor: ");
		turno = sc.nextLine();
		System.out.print("Escolha um curso para o professor: ");
		curso = sc.nextLine();
		System.out.print("Escolha a UC do professor: ");
		uc = sc.nextLine();
		for (int i = 0; i < 1; i++) {
			System.out.print("Digite uma senha: ");
			senha = sc.nextLine();
			System.out.print("Digite a senha novamente: ");
			String senhaRepetida = sc.nextLine();
			if (!senha.equals(senhaRepetida)) {
				Util.limparTela();
				System.out.println("As senhas não coincidem");
				i--;
			}
		}
		Professor professor = new Professor(nome, ra, senha, turno, curso, uc);
		db.cadastrarProfessor(professor);
		System.out.println("Professor cadastrado com sucesso!");
	}

	private static void atualizarProfessor(Scanner sc, Database db) {
		// Metodo de atualização de professor
		System.out.print("Digite o professor que deseja modificar:\t");
		String nomeProfessor = sc.nextLine();
		Professor professor = db.getProfessor(nomeProfessor);
		System.out.println("O que deseja modificar?");
		int option = Util.optionPainel(sc, new String[] {"[1] - Turno", "[2] - Curso"});
		int acc = 0;
		while (acc < 1) {
			switch (option) {
				case 1:
					System.out.print("Digite o novo turno:\t");
					String turno = sc.nextLine();
					professor.setTurno(turno);
					db.atualizarProfessor(professor);
					break;
				case 2:
					System.out.print("Digite o novo curso:\t");
					String curso = sc.nextLine();
					professor.setCurso(curso);
					db.atualizarProfessor(professor);
					break;
				default:
					System.out.println("Essa opção não existe!");
					acc--;
					break;
			}
		}
	}

	private static void excluirProfessor(Scanner sc, Database db) {
		// Metodo de exclusão de professor
		System.out.println("Digite o nome do professor(a) que deseja excluir:\t");
		String nomeProfessor = sc.nextLine();
		Professor professor = db.getProfessor(nomeProfessor);
		db.excluirProfessor(professor);
		System.out.println("Professor(a) excluído com sucesso!");

	}

	private static void verProfessor(Scanner sc, Database db) {
		// Metodo de visualização de professor
		List<Professor> professores = db.getProfessores();
		for (Professor professor : professores) {
			System.out.printf("Professor: %s\t | Curso: %s\t | Turno: %s\t | \n",
					professor.getNome(), professor.getCurso(), professor.getTurno());
		}
		System.out.print("\nPressione enter para prosseguir...");
		sc.nextLine();
	}
}
