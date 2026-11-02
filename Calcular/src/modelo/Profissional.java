package modelo;
/**
 * Prestador de serviço autônomo, como pedreiro ou mestre de obras.
 * Além dos dados de {@link Usuario}, guarda a especialidade,
 * o preço praticado, a região de atendimento e a avaliação média.
 */
public class Profissional extends Usuario {
	
	  /**
     * Cria um profissional.
     *
     * @param id                identificador único do profissional
     * @param nome              nome completo
     * @param telefone          telefone de contato
     * @param email             e-mail de contato
     * @param especialidade     área de atuação (por exemplo, assentamento de piso)
     * @param precoPorM2        valor cobrado por metro quadrado, em reais
     * @param cidadeAtendimento cidade onde o profissional atende
     * @param avaliacaoMedia    nota média recebida dos clientes
     */
	
	private String especialidade;
	private double precoPorM2;
	private String cidadeAtendimento;
	private  double avaliacaoMedia=0;
	
	public Profissional(String id,String nome, String telefone,String email, String especialidade,double precoPorM2,String cidadeAtendimento) {
		super(id,nome,telefone,email);
		this.especialidade = especialidade;
		this.precoPorM2 = precoPorM2;
		this.cidadeAtendimento = cidadeAtendimento;
		
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public double getPrecoPorM2() {
		return precoPorM2;
	}

	public void setPrecoPorM2(double precoPorM2) {
		this.precoPorM2 = precoPorM2;
	}

	public String getCidadeAtendimento() {
		return cidadeAtendimento;
	}

	public void setCidadeAtendimento(String cidadeAtendimento) {
		this.cidadeAtendimento = cidadeAtendimento;
	}

	public double getAvaliacaoMedia() {
		return avaliacaoMedia;
	}

	public void setAvaliacaoMedia(double avaliacaoMedia) {
		this.avaliacaoMedia = avaliacaoMedia;
	}
	
	@Override
	public String toString() {
	    return super.toString() + " - " + especialidade + " - R$ " + precoPorM2 + "/m² - " + cidadeAtendimento;
	}
	
	
	
}
