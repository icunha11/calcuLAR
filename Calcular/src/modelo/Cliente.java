package modelo;

/**
 * Pessoa que solicita o orçamento e agenda a visita técnica.
 * Além dos dados de {@link Usuario}, guarda o endereço do imóvel.
 */

public class Cliente extends Usuario{

	/**
     * Cria um cliente.
     *
     * @param id       identificador único do cliente
     * @param nome     nome completo
     * @param telefone telefone de contato
     * @param email    e-mail de contato
     * @param endereco endereço onde o serviço será realizado
     */

	private String endereco;
		
	public Cliente(String id, String nome, String telefone, String email, String endereco) {
		super(id,nome,telefone,email);
		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	@Override
	public String toString() {
		 return super.toString() + " - " + endereco;
	}
	
		
		
	

}
