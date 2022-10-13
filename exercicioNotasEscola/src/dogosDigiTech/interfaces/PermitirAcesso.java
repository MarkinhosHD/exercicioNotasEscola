package dogosDigiTech.interfaces;

//essa interface será nosso contrato de autenticação
public interface PermitirAcesso {
	
	//"Interface com Parâmetro" - apenas declaração do método com parâmetro
	//public boolean autenticar(String login, String senha); 

	public boolean autenticar();//sem parâmetro
	
	
	public boolean camposPreenchidos();
}


