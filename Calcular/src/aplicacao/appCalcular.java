package aplicacao;
/**
 * Classe de aplicação do Calcular
 */

import modelo.Profissional;
import modelo.Revestimento;
import modelo.Rodape;
import modelo.Servico;
import modelo.TipoServico;
import servico.CalculadoraOrcamento;

public class appCalcular {

	public static void main(String[] args) {
		
		CalculadoraOrcamento calc = new CalculadoraOrcamento();

		Servico piso = new Revestimento(80.0);
		Servico rodape = new Rodape(15.0);

		System.out.println(calc.calcularOrcamento(piso, 4, 5));   // 1600.0
		System.out.println(calc.calcularOrcamento(rodape, 4, 5)); // 270.0

		System.out.println("--- Tipos de serviço ---");
		for (TipoServico tipo : TipoServico.values() ) {
			      System.out.println(tipo + " -> " + tipo.getNomeAmigavel());
		}
        System.out.println("--- Tabela de preços ---");
		Profissional joao = new Profissional("1", "João", "71999990000", "joao@email.com", "Pedreiro", "Salvador");
		joao.definirPreco(TipoServico.ALVENARIA, 50.0);
		joao.definirPreco(TipoServico.REVESTIMENTO, 80.0);
		
		System.out.println(joao);
		System.out.println("Faz alvenaria?" + joao.ofereceServico(TipoServico.ALVENARIA));
		System.out.println("Faz pintura? " + joao.ofereceServico(TipoServico.PINTURA));
		System.out.println("Preço do revestimento: "+ joao.getPreco(TipoServico.REVESTIMENTO));

		try {
		        
		        joao.definirPreco(TipoServico.PINTURA, -10.0);
		} catch (IllegalArgumentException e) {		
                 System.out.println("Erro esperado: " + e.getMessage());

				}
		
	}

}
	
