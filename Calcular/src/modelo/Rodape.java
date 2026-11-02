package modelo;

/**
 * Serviço de Rodapé,cobrado por metro linear.
 * a quantidade é o perímetrp.
 */

public class Rodape extends Servico{

	
	public Rodape(double precoPorM2) {
		super("Rodapé",precoPorM2);
	}
	
	/**
	 * Calcula o preço do rodapé a partir do perímetro
	 * @param largura     largura do ambiente, em metros
     * @param comprimento comprimento do ambiente, em metros
     * @return preço total em reais
     */
	 
	
	@Override
	public double calcularPreco(double largura,double comprimento) {
		double perimetro = 2 * (largura + comprimento);
        return perimetro * getPrecoPorM2();
	}
	
}
