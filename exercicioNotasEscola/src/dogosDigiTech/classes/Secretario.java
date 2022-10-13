package dogosDigiTech.classes;

import dogosDigiTech.interfaces.PermitirAcesso;

public class Secretario extends Pessoa implements PermitirAcesso{
	
	private String registro;
	private String nivelCargo;
	private String experiencia;

	// ====================Interface sem par�metros========================
	private String login;
	private String senha;
	/*Interface com par�metros n�o precisa destes atributos*/
	//=====================fim Interface sem par�metros====================
	
	//=====================construtor com par�metro========================
	
	public Secretario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	//=====================construtor sem par�metro========================
	public Secretario() {
		
	}	
//	
//	public String getLogin() {
//		return login;
//	}
//	public void setLogin(String login) {
//		this.login = login;
//	}
//	public String getSenha() {
//		return senha;
//	}
//	public void setSenha(String senha) {
//		this.senha = senha;
//	}
//====================fim sem par�metro=========================

	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getNivelCargo() {
		return nivelCargo;
	}
	public void setNivelCargo(String nivelCargo) {
		this.nivelCargo = nivelCargo;
	}
	public String getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}
	
	
	

	
	@Override
	public String toString() {
		return "Secretario [nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + ", registroGeral="
				+  registroGeral + ", numeroCpf=" + numeroCpf + ", nomeMae=" + nomeMae + ", nomePai=" + nomePai + "registro=" + registro + ", nivelCargo=" + nivelCargo + ", experiencia=" + experiencia + "]";
	}
	
	//m�todo de contrato de autentica��o (valida��o de login e senha)
	
	//======================Interface com par�metro=======================
//	@Override
//	public boolean autenticar(String login, String senha) {
//		this.login = login;
//		this.senha = senha;
//		return login.equals("admin") && senha.equals("admin");; 
//	}
	
	
	//(valida��o de login e senha) retorna sim caso login e senha sejam igual admin
	@Override
	public boolean autenticar() {		
		return login.equals("admin") && senha.equals("admin"); 
	}
	
	//========para Interface com Par�metros e contrutor sem par�metro==========
	
//	@Override
//	public boolean autenticar(String login, String senha) {
//		return login.equals("admin") && senha.equals("admin");
//	}

	@Override
	public boolean camposPreenchidos() {
		return login.equals("") || senha.equals("");
	}
	
	
}
