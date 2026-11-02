package modelo;

/**
 * Representa uma pessoa que usa o sistema, seja cliente ou profissional.
 * Guarda os dados de identificação e contato comuns aos dois perfis.
 * <p>
 * Esta classe é abstrata: só existem objetos de {@link Cliente}
 * ou {@link Profissional}.
 */
public abstract class Usuario {
	
	 /**
     * Cria um usuário com os dados básicos.
     *
     * @param id       identificador único do usuário
     * @param nome     nome completo
     * @param telefone telefone de contato, usado para combinar a visita
     * @param email    e-mail de contato
     */
	
	private String id;
	private String nome;
	private String telefone;
	private String email;
	
	public Usuario(String id,String nome, String telefone,String email) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	public String getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return  "[" + id + "] " + nome + " - " + telefone + " - " + email;
	}
	
	
	
	
	
	
}
