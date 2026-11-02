package modelo;

/**
 * Serviço de assentamento de revestimento de piso, cobrado por metro quadrado.
 * A quantidade cobrada é a área do ambiente (largura x comprimento).
 */

public class Revestimento extends Servico{
	
	public Revestimento(double precoPorM2) {
		super("Revestimento",precoPorM2);
	}
	
    /**
     * Calcula o preço do assentamento pela área do piso.
     *
     * @param largura     largura do ambiente, em metros
     * @param comprimento comprimento do ambiente, em metros
     * @return área multiplicada pelo preço por metro quadrado, em reais
     */
	
	@Override
	public double calcularPreco(double largura, double comprimento) {
        double area = largura * comprimento;
        return area * getPrecoPorM2();
    }
}
