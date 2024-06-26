import controllers.logins.admin.AdministradorController;
import controllers.logins.aluno.AlunoController;
import controllers.logins.professor.ProfessorController;
import extras.Util;
import java.util.Scanner;
import models.Aluno;
import models.Database;
import models.Professor;

// Classe programa principal
public class Programa {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Database banco_de_dados = new Database();
		// Informações referente aos dados dos alunos
		banco_de_dados.cadastrarAluno(new Aluno("Marcilio", "123", "Masculino", "Matutino",
				"Ciencia da Computacao", "1º semestre"));
		banco_de_dados.cadastrarAluno(new Aluno("Erick ", "abc", "Masculino", "Matutino",
				"Ciencia da Computacao", "1º semestre"));
		banco_de_dados.cadastrarAluno(new Aluno("Rodson", "teste", "Masculino", "Matutino",
				"Ciencia da Computacao", "1º semestre"));
		banco_de_dados.cadastrarAluno(new Aluno("Arthur", "789", "Masculino", "Matutino",
				"Ciencia da Computacao", "1º semestre"));
		banco_de_dados.cadastrarAluno(new Aluno("Marcus", "senha", "Masculino", "Matutino",
				"Ciencia da Computacao", "1º semestre"));
		banco_de_dados.cadastrarAluno(new Aluno("Marcela", "password", "Feminino", "Matutino",
				"Ciencia da Computacao", "1º semestre"));
		banco_de_dados.cadastrarProfessor(new Professor("Eliane", "profeliane", "Matutino",
				"Ciencia da Computacao", "Programas e solucoes computacionais", "Doutora", "Tecnologia da Informacao"));
		// Login e senha do administrador:
		String administrador = "admin";
		String senha_administrador = "admin";
		while (true) {
			Util.limparTela();
			// Apresenta as opções na tela e retorna a opção escolhida
			int opcao = Util.optionPainel(scanner,
					new String[] { " 1  Fazer login como aluno", " 2  Fazer login como professor",
							" 3  Fazer login como administrador", " 4  Sair do programa" });
			// Abre um novo painel com base na opção escolhida
			switch (opcao) {
				case 1:
					/*
					 * Método responsável por logar o aluno
					 */
					AlunoController.loginAluno(scanner, banco_de_dados);
					break;
				case 2:
					/*
					 * Método responsável por logar o professor
					 */
					ProfessorController.loginProfessor(scanner, banco_de_dados);
					break;
				case 3:
					/*
					 * Método responsável por logar o administrador
					 */
					AdministradorController.loginAdmin(scanner, banco_de_dados, administrador, senha_administrador);
					break;
				case 4:
					/*
					 * Uma pequena mensagem para simbolizar que finalizou o programa
					 */
					System.out.println("Volte sempre!");
					scanner.close();
					return;
				default:
					/*
					 * Método caso o usuário utilize outro valor
					 */
					System.out.println("\nDigite uma opção válida!\n");
					break;
			}
		}
	}
}
