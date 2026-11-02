package aplicacao;
/**
 * Classe de aplicação do Calcular
 */

import modelo.Revestimento;
import modelo.Rodape;
import modelo.Servico;
import servico.CalculadoraOrcamento;

public class appCalcular {

	public static void main(String[] args) {
		
		CalculadoraOrcamento calc = new CalculadoraOrcamento();

		Servico piso = new Revestimento(80.0);
		Servico rodape = new Rodape(15.0);

		System.out.println(calc.calcularOrcamento(piso, 4, 5));   // 1600.0
		System.out.println(calc.calcularOrcamento(rodape, 4, 5)); // 270.0
		
	}

}
	
