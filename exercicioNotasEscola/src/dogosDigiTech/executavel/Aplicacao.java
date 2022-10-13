package dogosDigiTech.executavel;


import dogosDigiTech.excecao.LoginSenhaException;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import dogosDigiTech.classes.Aluno;
import dogosDigiTech.classes.Disciplina;

import dogosDigiTech.classes.Secretario;
import dogosDigiTech.constantes.StatusAluno;


import dogosDigiTech.interfaces.PermitirAcesso;

public class Aplicacao {

	public static void main(String[] args) throws Exception {
		try {

			String login = JOptionPane.showInputDialog("Informe login");
			String senha = JOptionPane.showInputDialog("Informe a senha");			
			
			
					// ===================construtor com parâmetro========================
					PermitirAcesso permitirAcesso = new Secretario(login, senha);
					
					if (permitirAcesso.camposPreenchidos()) {
						throw new LoginSenhaException("Erro com campo de login ou senha vazio!");
						
					} else {					

					
					if (permitirAcesso.autenticar()) { // se TRUE acessa,se FALSE não acessa

						List<Aluno> alunos = new ArrayList<Aluno>();

						// é uma lista que dentro dela tem uma chave que identifica uma sequência de
						// valores também
						HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

						

						for (int qtd = 1; qtd <= 2; qtd++) {

							String nome = JOptionPane.showInputDialog("Digite o nome do Aluno " + qtd);
//		String idade = JOptionPane.showInputDialog("Digite a idade do aluno");
//		String dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento do Aluno");
//		String rg = JOptionPane.showInputDialog("Digite o RG do Aluno");
//		String cpf = JOptionPane.showInputDialog("Digite o CPF do Aluno");
//		String mae = JOptionPane.showInputDialog("Digite o nome da mãe do Aluno");
//		String pai = JOptionPane.showInputDialog("Digite o nome do pai do Aluno");
//		String dataMatricula = JOptionPane.showInputDialog("Digite a data da matrícula do Aluno");
//		String serie = JOptionPane.showInputDialog("Digite a série do Aluno");
//		String escola = JOptionPane.showInputDialog("Digite o nome da Escola");

							/*
							 * =============================================================================
							 */

							Aluno aluno1 = new Aluno();

							aluno1.setNome(nome);
//		aluno1.setIdade(Integer.valueOf(idade)); //"Integer.valueOf(String s)" => comando que converte String em Integer 
//		aluno1.setDataNascimento(dataNascimento);
//		aluno1.setRegistroGeral(rg);
//		aluno1.setNumeroCpf(cpf);
//		aluno1.setNomeMae(mae);
//		aluno1.setNomePai(pai);
//		aluno1.setDataMatricula(dataMatricula);
//		aluno1.setSerieMatriculado(serie);
//		aluno1.setNomeEscola(escola);

							for (int posicao = 1; posicao <= 3; posicao++) {
								
								Disciplina disciplina = new Disciplina();
								
								String nomeDisciplina = JOptionPane.showInputDialog("Nome da Disciplina " + posicao);
								
								
								
								for (int pos = 0; pos < disciplina.getNota().length; pos++) {
									String notaDisciplina = JOptionPane.showInputDialog("Nota " + (pos + 1) + " da Disciplina " + posicao);
									disciplina.getNota()[pos] = Double.valueOf(notaDisciplina); //atribuindo valores às posições da array
									
								}

								
								
								disciplina.setDisciplina(nomeDisciplina);


								aluno1.getDisciplinas().add(disciplina);
							}

							int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");

							if (escolha == 0) {

								int continuaRemover = 0;
								int posicao = 1;

								while (continuaRemover == 0) {
									String disciplinaRemover = JOptionPane
											.showInputDialog("Qual a disciplina? 1,2,3 ou 4?");
									aluno1.getDisciplinas()
											.remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
									posicao++;
									continuaRemover = JOptionPane.showConfirmDialog(null,
											"Continuar a Remover disciplinas?");
								}
							}

							alunos.add(aluno1);
						}
						
//-----------------------------------------------------------------------------------------------------------------------------
						
						System.out.println("---------- Dados dos Alunos ----------");
						
						for (Aluno aluno : alunos) {
							System.out.println("***** Nome: " + aluno.getNome() + " *****");
							
							for(Disciplina materia : aluno.getDisciplinas()) {
								System.out.println("*** Matéria: " + materia.getDisciplina());
								
								//double media = 0;
								for (int pos = 0; pos < materia.getNota().length; pos++) {
									System.out.println("Nota " + (pos + 1) + " : " + materia.getNota()[pos]);
									//media += materia.getNota()[pos] / 2;
									
								}
								
								System.out.println("média: " + materia.getMediaNotas());
							}
						
						System.out.println("-----------------------------------------------------------------------------------------");
							
						}

//-----------------------------------------------------------------------------------------------------------------------------
						

						// Usando HASHMAP

						maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
						maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
						maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());

						for (Aluno aluno : alunos) {

							if (aluno.getAlunoSituacao().equalsIgnoreCase(StatusAluno.APROVADO)) {
								maps.get(StatusAluno.APROVADO).add(aluno);

							} else if (aluno.getAlunoSituacao().equalsIgnoreCase(StatusAluno.REPROVADO)) {
								maps.get(StatusAluno.REPROVADO).add(aluno);

							} else {
								maps.get(StatusAluno.RECUPERACAO).add(aluno);
							}

						}

						System.out.println("------------------------- APROVADOS ----------------------------");
						for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
							
							System.out.println("Nome: " + aluno.getNome() + " com média " + aluno.getMediaAluno());
						}

						System.out.println("------------------------- REPROVADOS ----------------------------");
						for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
							
							System.out.println("Nome: " + aluno.getNome() + " com média " + aluno.getMediaAluno());
						}

						System.out.println("------------------------- RECUPERAÇÃO ----------------------------");
						for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
							
							System.out.println("Nome: " + aluno.getNome() + " com média " + aluno.getMediaAluno());
						}

						
					} else {

						JOptionPane.showMessageDialog(null, "Login e/ou Senha incorretos");

					}

				
					
				}
			} catch (LoginSenhaException o) {
				o.printStackTrace();
				JOptionPane.showMessageDialog(null, "Campo de login ou senha em branco!");
			}



	}

}
