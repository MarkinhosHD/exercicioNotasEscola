package dogosDigiTech.executavel;

import javax.swing.JOptionPane;

import dogosDigiTech.classes.Aluno;
import dogosDigiTech.classes.Disciplina;

public class ArrayVetor {

	public static void main(String[] args) {
		
//		String posicoes = JOptionPane.showInputDialog("Quantas posi��es o Array deve ter?");
//		
//		//declarando Array e convertendo uma String em Int
//		double[] notas = new double[Integer.parseInt(posicoes)];
//		
//		//inserindo valores nas posi��es do Array
//		for (int pos = 0; pos < notas.length; pos++) {
//			String valor = JOptionPane.showInputDialog("Qual o valor da posi��o " + (pos +1)); //recebendo valores
//			notas[pos] = Double.valueOf(valor); //convertendo uma String em Double e atribuindo os valores em cada uma das posi��es
//		}
//		
//		//exibindo conte�do da array
//		for (int pos = 0; pos < notas.length; pos++) {
//			System.out.println("Nota " + (pos + 1) + " � = " + notas[pos]);
//		}	
		
		//cria��o do Aluno
		Aluno aluno = new Aluno();
		aluno.setNome("Marcos");
		aluno.setNomeEscola("Teste");
		
		//cria��o da Disciplina
		Disciplina disciplina = new Disciplina();
		disciplina.setDisciplina("Java");
		double[] notas = {8.9,9.7,7.6,6.8};
		disciplina.setNota(notas);
		
		aluno.getDisciplinas().add(disciplina);
		
		Disciplina disciplina2 = new Disciplina();
		disciplina2.setDisciplina("Banco de Dados");
		double[] notasBD = {9.9,9.6,8.7,8};
		disciplina2.setNota(notasBD);
		
		aluno.getDisciplinas().add(disciplina2);

		
		System.out.println("Nome do Aluno: " + aluno.getNome() + " inscrito na escola: " + aluno.getNomeEscola());
		System.out.println("-----------------Disciplinas do Aluno----------------");
		for (Disciplina d : aluno.getDisciplinas()) {
			System.out.println("Disciplina: " + d.getDisciplina());
			System.out.println("As notas da disciplina s�o:");
			
			for (int pos = 0; pos < d.getNota().length; pos++) {
				System.out.println("Nota " + (pos + 1) + " �: " + d.getNota()[pos]);
			}
			
		 System.out.println("---------------------------------------------------------------------");
		}
		
		
	}

}
