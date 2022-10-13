package dogosDigiTech.classes;


import java.text.DecimalFormat;
import java.util.ArrayList;

import java.util.List;

import dogosDigiTech.constantes.StatusAluno;

public class Aluno extends Pessoa {

	
	private String dataMatricula;
	private String nomeEscola;
	private String serieMatriculado;

	// ---------------------------------------------------------------------------------

	
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	

	// ---------------------------------------------------------------------------------

	public Aluno() {

	}

	// ---------------------------------------------------------------------------------

	

	public String getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public String getNomeEscola() {
		return nomeEscola;
	}

	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}

	public String getSerieMatriculado() {
		return serieMatriculado;
	}

	public void setSerieMatriculado(String serieMatriculado) {
		this.serieMatriculado = serieMatriculado;
	}

	// ---------------------------------------------------------------------------------

	
	int cont;

	public double mediaDoAluno() {
		double somaNotas = 0.0;
		for (Disciplina disciplina : disciplinas) {

			somaNotas += disciplina.getMediaNotas();

		}
		double mediaAluno = (somaNotas / disciplinas.size());
		return mediaAluno;

	}
	
	
	public String getMediaAluno() {
		DecimalFormat decimalFormat = new DecimalFormat("0.00"); 
		String mediaFinalAluno = decimalFormat.format(mediaDoAluno());
		return mediaFinalAluno;
	}
	

	public String getAlunoSituacao() {
		double media = (this.mediaDoAluno() );

		if (media >= 6) {
			return StatusAluno.APROVADO; // usando classes e atributos estáticos
		} else if (media < 6 && media >= 4) {
			return StatusAluno.RECUPERACAO;
		} else {
			return StatusAluno.REPROVADO;
		}

	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + ", registroGeral="
				+ registroGeral + ", numeroCpf=" + numeroCpf + ", nomeMae=" + nomeMae + ", nomePai=" + nomePai
				+ ", dataMatricula=" + dataMatricula + ", nomeEscola=" + nomeEscola + ", serieMatriculado="
				+ serieMatriculado + "]";
	}

	// ---------------------------------------------------------------------------------

}
