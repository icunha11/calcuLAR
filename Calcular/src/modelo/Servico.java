package modelo;

/**
 * Serviço de obra que pode ser orçado, como revestimento ou rodapé.
 * <p>
 * Esta classe é abstrata: cada serviço concreto define a sua própria
 * forma de calcular o preço a partir das medidas do ambiente.
 */
public abstract class Servico {
	
    /**
     * Calcula o preço do serviço para o ambiente informado.
     * Cada serviço concreto define como as medidas viram quantidade cobrada.
     *
     * @param largura     largura do ambiente, em metros
     * @param comprimento comprimento do ambiente, em metros
     * @return preço total da mão de obra, em reais
     */
	
	private String nome;
	private double precoPorM2;
	
	public Servico(String nome, double precoPorM2) {
		this.nome = nome;
		this.precoPorM2 = precoPorM2;
	}
	
	public abstract double calcularPreco(double largura, double comprimento);

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrecoPorM2() {
		return precoPorM2;
	}

	public void setPrecoPorM2(double precoPorM2) {
		this.precoPorM2 = precoPorM2;
	}
	
	
	
}
