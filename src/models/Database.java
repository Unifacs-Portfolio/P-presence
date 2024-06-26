package models;

import java.util.ArrayList;
import java.util.List;

// Classe para armazenar e modificar os dados
public class Database {
	// Listas de alunos e professores que ficam na memória
	private final List<Aluno> alunos;
	private final List<Professor> professores;

	// Constutor que inicializa as listas
	public Database() {
		this.alunos = new ArrayList<>();
		this.professores = new ArrayList<>();
	}

	// Métodos para manipular os alunos
	public Aluno getAluno(String registro_aluno) {
		for (Aluno a : this.alunos) {
			if (a.getRa().equals(registro_aluno)) {
				return a;
			}
		}
		return null;
	}

	// Método que retorna a lista de alunos
	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	// Método que retorna lista de alunos com base no nome
	public List<Aluno> getAlunosNome(String nome) {
		List<Aluno> alunos_local = new ArrayList<>();
		for (Aluno a : this.alunos) {
			if (a.getNome().contains(nome)) {
				alunos_local.add(a);
			}
		}
		return alunos_local;
	}

	// Método que retorna a lista de alunos com base no curso
	public List<Aluno> getAlunosCurso(String curso) {
		List<Aluno> alunos_local = new ArrayList<>();
		for (Aluno a : this.alunos) {
			if (a.getCurso().contains(curso)) {
				alunos_local.add(a);
			}
		}
		return alunos_local;
	}

	// Método que retorna a lista de alunos com base no RA
	public List<Aluno> getAlunosRA(String ra) {
		List<Aluno> alunos_local = new ArrayList<>();
		for (Aluno a : this.alunos) {
			if (a.getRa().contains(ra)) {
				alunos_local.add(a);
			}
		}
		return alunos_local;
	}

	// Método que retorna a lista de alunos com base no turno
	public List<Aluno> getAlunosTurno(String turno) {
		List<Aluno> alunos_local = new ArrayList<>();
		for (Aluno a : this.alunos) {
			if (a.getTurno().contains(turno)) {
				alunos_local.add(a);
			}
		}
		return alunos_local;
	}

	// Método que retorna a lista de alunos com base no gênero
	public List<Aluno> getAlunosGenero(String genero) {
		List<Aluno> alunos_local = new ArrayList<>();
		for (Aluno a : this.alunos) {
			if (a.getGenero().contains(genero)) {
				alunos_local.add(a);
			}
		}
		return alunos_local;
	}

	// Método que retorna a lista de alunos com base na sala
	public void cadastrarAluno(Aluno aluno) {
		alunos.add(aluno);
	}

	// Método para atualizar as informações dos alunos
	public void atualizarAluno(Aluno aluno) {
		for (Aluno a : this.alunos) {
			if (a.getRa().equals(aluno.getRa())) {
				this.alunos.set(this.alunos.indexOf(a), aluno);
				break;
			}
		}
	}

	// Método que exclui um aluno
	public void excluirAluno(Aluno aluno) {
		alunos.remove(aluno);
	}

	// Métodos para manipular os professores
	public Professor getProfessor(String registro_professor) {
		for (Professor p : this.professores) {
			if (p.getRp().equals(registro_professor)) {
				return p;
			}
		}
		return null;
	}

	// Método que retorna a lista de professores
	public List<Professor> getProfessores() {
		return this.professores;
	}

	// Método que retorna lista de professores com base no nome
	public List<Professor> getProfessores(String name) {
		List<Professor> profs = new ArrayList<>();
		for (Professor p : this.professores) {
			if (p.getNome().contains(name)) {
				profs.add(p);
			}
		}
		return profs;
	}

	// Método que retorna a lista de professores com base no RP
	public void cadastrarProfessor(Professor professor) {

		professores.add(professor);
	}

	// Método que atualiza um professor
	public void atualizarProfessor(Professor professor) {
		for (Professor p : this.professores) {
			if (p.getRp().equals(professor.getRp())) {
				this.professores.set(this.professores.indexOf(p), professor);
				break;
			}
		}
	}

	// Método que exclui um professor
	public void excluirProfessor(Professor professor) {
		professores.remove(professor);
	}

}
