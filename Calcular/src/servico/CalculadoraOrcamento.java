package servico;

import modelo.Servico;

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
	
}
