package aplicacao;

import java.util.Arrays;
import java.util.List;

import modelo.Profissional;
import modelo.Revestimento;
import modelo.Rodape;
import modelo.Servico;
import modelo.TipoServico;
import modelo.TrabalhoRealizado;
import servico.CalculadoraOrcamento;

/**
 * Classe de aplicação do Calcular
 */
public class appCalcular {

	public static void main(String[] args) {

		CalculadoraOrcamento calc = new CalculadoraOrcamento();

		Servico piso = new Revestimento(80.0);
		Servico rodape = new Rodape(15.0);

		System.out.println(calc.calcularOrcamento(piso, 4, 5));   // 1600.0
		System.out.println(calc.calcularOrcamento(rodape, 4, 5)); // 270.0

		System.out.println("--- Tipos de serviço ---");
		for (TipoServico tipo : TipoServico.values()) {
			System.out.println(tipo + " -> " + tipo.getNomeAmigavel());
		}

		System.out.println("--- Tabela de preços ---");
		Profissional joao = new Profissional("1", "João", "71999990000", "joao@email.com", "Pedreiro", "Salvador");
		joao.definirPreco(TipoServico.ALVENARIA, 50.0);
		joao.definirPreco(TipoServico.REVESTIMENTO, 80.0);

		System.out.println(joao);
		System.out.println("Faz alvenaria? " + joao.ofereceServico(TipoServico.ALVENARIA));
		System.out.println("Faz pintura? " + joao.ofereceServico(TipoServico.PINTURA));
		System.out.println("Preço do revestimento: " + joao.getPreco(TipoServico.REVESTIMENTO));

		try {
			joao.definirPreco(TipoServico.PINTURA, -10.0);
		} catch (IllegalArgumentException e) {
			System.out.println("Erro esperado: " + e.getMessage());
		}

		System.out.println("--- Portfólio e Avaliação Média ---");
		
		System.out.println("Média inicial (sem trabalhos): " + joao.getAvaliacaoMedia()); 

		
		List<String> fotosSala = Arrays.asList("/fotos/sala_antes.jpg", "/fotos/sala_depois.jpg");
		TrabalhoRealizado t1 = new TrabalhoRealizado("Assentamento de porcelanato na sala", TipoServico.REVESTIMENTO, 25.0, fotosSala, 5.0);
		TrabalhoRealizado t2 = new TrabalhoRealizado("Levantamento de muro externo", TipoServico.ALVENARIA, 40.0, null, 4.0);

		joao.adicionarTrabalho(t1);
		joao.adicionarTrabalho(t2);

		System.out.println("Trabalhos no portfólio: " + joao.getTrabalhosRealizados().size()); 
		System.out.println("Média após 2 trabalhos (5.0 e 4.0): " + joao.getAvaliacaoMedia()); 

		
		TrabalhoRealizado t3 = new TrabalhoRealizado("Revestimento de cozinha", TipoServico.REVESTIMENTO, 18.0, Arrays.asList("/fotos/cozinha.jpg"), 3.0);
		joao.adicionarTrabalho(t3);
		System.out.println("Média após 3 trabalhos (5.0, 4.0 e 3.0): " + joao.getAvaliacaoMedia()); 

		
		try {
			TrabalhoRealizado tInvalido = new TrabalhoRealizado("Serviço teste", TipoServico.PINTURA, 10.0, null, 6.5);
			joao.adicionarTrabalho(tInvalido);
		} catch (IllegalArgumentException e) {
			System.out.println("Erro esperado (nota inválida): " + e.getMessage());
		}
	}
}