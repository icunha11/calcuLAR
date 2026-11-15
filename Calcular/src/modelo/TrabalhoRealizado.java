package modelo;
import java.util.ArrayList;
import java.util.List;

public class TrabalhoRealizado {
	private String descricao;
	private TipoServico tipoServico;
	private double metragem;
	private List<String> caminhoFotos;
	private double notaCliente;
	

	public String getDescricao() {
		return descricao;
	}
	public TipoServico getTipoServico() {
		return tipoServico;
	}
	public double getMetragem() {
		return metragem;
	}
	public List<String> getCaminhoFotos() {
		return caminhoFotos;
	}
	public double getNotaCliente() {
		return notaCliente;
	}
	
	public TrabalhoRealizado(String descricao, TipoServico tipoServico, double metragem,List<String> caminhoFotos,double notaCliente) {
		if (metragem <= 0) {
			throw new IllegalArgumentException("A metragem deve ser maior que 0.");
		}
		if (notaCliente < 0 || notaCliente > 5) {
			throw new IllegalArgumentException("A nota deve estar entre 1 e 5.");
		}
		
		this.descricao = descricao;
		this.tipoServico = tipoServico;
		this.metragem = metragem;
		if (caminhoFotos != null) {
			this.caminhoFotos = new ArrayList<>(caminhoFotos);
		} else {
			this.caminhoFotos = new ArrayList<>();
		}
		this.notaCliente = notaCliente;
		
	}
	
	
	
}
