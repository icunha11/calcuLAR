package servico;

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

	public double calcularArea(double largura, double comprimento) {
		     if (largura <= 0 || comprimento <= 0) {
				      throw new IllegalArgumentException("Largura e comprimento devem ser maiores que zero.");
			 }
		     return largura * comprimento;

}

public double calcularOrcamento(Profissional profissional, TipoServico tipo, double largura, double comprimento) {
	     double area = calcularArea(largura, comprimento);
		 return area * profissional.getPreco(tipo);

}
}
