package dogosDigiTech.interfaces;

//essa interface ser� nosso contrato de autentica��o
public interface PermitirAcesso {
	
	//"Interface com Par�metro" - apenas declara��o do m�todo com par�metro
	//public boolean autenticar(String login, String senha); 

	public boolean autenticar();//sem par�metro
	
	
	public boolean camposPreenchidos();
}


