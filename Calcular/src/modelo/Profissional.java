package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Prestador de serviço autônomo, como pedreiro ou mestre de obras.
 * Além dos dados de {@link Usuario}, guarda a especialidade,
 * os preços praticados, a região de atendimento e o histórico de trabalhos realizados.
 */
public class Profissional extends Usuario {

	private String especialidade;
	private Map<TipoServico, Double> precos = new HashMap<>();
	private String cidadeAtendimento;
	private List<TrabalhoRealizado> trabalhosRealizados = new ArrayList<>();

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
	public Profissional(String id, String nome, String telefone, String email, String especialidade, String cidadeAtendimento) {
		super(id, nome, telefone, email);
		this.especialidade = especialidade;
		this.cidadeAtendimento = cidadeAtendimento;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	/**
	 * Cadastra ou atualiza o preço que o profissional cobra por um serviço.
	 *
	 * @param tipo  tipo de serviço
	 * @param valor preço por metro quadrado, em reais
	 * @throws IllegalArgumentException se o valor for zero ou negativo
	 */
	public void definirPreco(TipoServico tipo, double valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException("O preço deve ser maior que zero.");
		}
		precos.put(tipo, valor);
	}

	/**
	 * Informa se o profissional oferece um tipo de serviço.
	 *
	 * @param tipo tipo de serviço
	 * @return true se há preço cadastrado para esse serviço
	 */
	public boolean ofereceServico(TipoServico tipo) {
		return precos.containsKey(tipo);
	}

	/**
	 * Devolve o preço por metro quadrado de um serviço.
	 *
	 * @param tipo tipo de serviço
	 * @return preço por metro quadrado, em reais
	 * @throws IllegalArgumentException se o profissional não oferece o serviço
	 */
	public double getPreco(TipoServico tipo) {
		if (!ofereceServico(tipo)) {
			throw new IllegalArgumentException("O profissional não oferece " + tipo.getNomeAmigavel() + ".");
		}
		return precos.get(tipo);
	}

	public String getCidadeAtendimento() {
		return cidadeAtendimento;
	}

	public void setCidadeAtendimento(String cidadeAtendimento) {
		this.cidadeAtendimento = cidadeAtendimento;
	}

	/**
	 * Adiciona um trabalho concluído ao portfólio do profissional.
	 *
	 * @param trabalho registro do trabalho realizado
	 * @throws IllegalArgumentException se o trabalho for nulo
	 */
	public void adicionarTrabalho(TrabalhoRealizado trabalho) {
		if (trabalho == null) {
			throw new IllegalArgumentException("O trabalho realizado não pode ser nulo.");
		}
		trabalhosRealizados.add(trabalho);
	}

	/**
	 * Devolve uma cópia da lista de trabalhos realizados pelo profissional.
	 *
	 * @return lista de trabalhos no portfólio
	 */
	public List<TrabalhoRealizado> getTrabalhosRealizados() {
		return new ArrayList<>(trabalhosRealizados);
	}

	/**
	 * Calcula dinamicamente a avaliação média com base nas notas dos trabalhos realizados.
	 *
	 * @return média das notas dos clientes, ou 0.0 caso ainda não haja trabalhos avaliados
	 */
	public double getAvaliacaoMedia() {
		if (trabalhosRealizados.isEmpty()) {
			return 0.0;
		}
		double somaNotas = 0.0;
		for (TrabalhoRealizado trabalho : trabalhosRealizados) {
			somaNotas += trabalho.getNotaCliente();
		}
		return somaNotas / trabalhosRealizados.size();
	}

	@Override
	public String toString() {
		return super.toString() + " - " + especialidade + " - " + cidadeAtendimento;
	}
}