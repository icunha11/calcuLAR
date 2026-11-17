package servico;

import java.util.ArrayList;
import java.util.List;
import modelo.Profissional;
import modelo.Servico;
import modelo.TipoServico;

/**
 * Responsável por gerar o orçamento de um serviço a partir das
 * medidas do ambiente.
 * <p>
 * Funciona como ponto único de entrada para o cálculo: quem chama
 * não precisa saber qual serviço está sendo orçado, porque cada
 * {@link Servico} define a sua própria regra de cobrança.
 */

public class CalculadoraOrcamento {
	
	public double calcularOrcamento(Servico servico, double largura, double comprimento) {
		return servico.calcularPreco(largura, comprimento);
	}
/**
	 * Calcula a área do ambiente em metros quadrados.
	 *
	 * @param largura     largura do ambiente, em metros
	 * @param comprimento comprimento do ambiente, em metros
	 * @return área em m²
	 * @throws IllegalArgumentException se alguma medida for zero ou negativa
	 */
	
	public double calcularArea(double largura, double comprimento) {
		     if (largura <= 0 || comprimento <= 0) {
				      throw new IllegalArgumentException("Largura e comprimento devem ser maiores que zero.");
			 }
		     return largura * comprimento;

}
	/**
	 * Calcula a estimativa de mão de obra usando o preço do profissional escolhido.
	 *
	 * @param profissional profissional que fará o serviço
	 * @param tipo         tipo de serviço
	 * @param largura      largura do ambiente, em metros
	 * @param comprimento  comprimento do ambiente, em metros
	 * @return área multiplicada pelo preço por m² do profissional, em reais
	 * @throws IllegalArgumentException se uma medida for inválida ou o profissional não oferecer o serviço
	 */


public double calcularOrcamento(Profissional profissional, TipoServico tipo, double largura, double comprimento) {
	     double area = calcularArea(largura, comprimento);
		 return area * profissional.getPreco(tipo);
}
	/**
	 * Filtra os profissionais que oferecem um tipo de serviço.
	 *
	 * @param profissionais lista de profissionais disponíveis
	 * @param tipo          tipo de serviço procurado
	 * @return nova lista só com quem oferece o serviço
	 */


public List<Profissional> listarProfissionais(List<Profissional> profissionais, TipoServico tipo) {
	     List<Profissional> resultado = new ArrayList<>();
		 for (Profissional p : profissionais) {
			        if (p.ofereceServico(tipo)) {
						        resultado.add(p);
					}

		 }
		 return resultado;

		}
	}