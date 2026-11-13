package modelo;
import java.util.HashMap;
import java.util.Map;

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
     * @param cidadeAtendimento cidade onde o profissional atende
     */
	
	private String especialidade;
	private Map<TipoServico, Double> precos = new HashMap<>();
	private String cidadeAtendimento;
	private  double avaliacaoMedia=0;
	
	public Profissional(String id,String nome, String telefone,String email, String especialidade,String cidadeAtendimento) {
		super(id,nome,telefone,email);
		this.especialidade = especialidade;
		this.cidadeAtendimento = cidadeAtendimento;
		
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
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
	    return super.toString() + " - " + especialidade + " - "  + cidadeAtendimento;
	}
	
	
	
}
