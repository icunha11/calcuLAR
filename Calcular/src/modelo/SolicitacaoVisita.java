package modelo;
// implemnetar logica do id da solicitacao
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class SolicitacaoVisita {
	private Cliente cliente;
	private Profissional profissional;
	private Servico tipoDeServico;
	
	private double area;
	private double valorEstimado;
	private LocalDate dataVisita;
	private Turno turno;
	private StatusChamado status;
	
	public SolicitacaoVisita(Cliente cliente,Servico tipoDeServico,double area,
			double valorEstimado, LocalDate dataVisita, Turno turno) {
		
		this.cliente = cliente;
		this.tipoDeServico = tipoDeServico;
		this.area = area;
		this.valorEstimado = valorEstimado;
		this.dataVisita = dataVisita;
		this.turno = turno;
		this.status = StatusChamado.PENDENTE;
		
		
		
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public Servico getTipoDeServico() {
		return tipoDeServico;
	}

	public void setTipoDeServico(Servico tipoDeServico) {
		this.tipoDeServico = tipoDeServico;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getValorEstimado() {
		return valorEstimado;
	}

	public void setValorEstimado(double valorEstimado) {
		this.valorEstimado = valorEstimado;
	}

	public LocalDate getDataVisita() {
		return dataVisita;
	}

	public void setDataVisita(LocalDate dataVisita) {
		this.dataVisita = dataVisita;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public StatusChamado getStatus() {
		return status;
	}

	public void setStatus(StatusChamado status) {
		this.status = status;
	}
	
	
	public String gerarRelatorio() {
		
		String valorFormatado,dataFormatada,diaSemana,areaFormatada;
		Locale ptBr =  Locale.of("pt", "Br");
		
		NumberFormat fmtMoeda = NumberFormat.getCurrencyInstance(ptBr);
		valorFormatado = fmtMoeda.format(this.valorEstimado);
		
		DateTimeFormatter  fmtData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		dataFormatada = this.dataVisita.format(fmtData);
		
		DateTimeFormatter fmtDiaSemana = DateTimeFormatter.ofPattern("EEEE",ptBr);
		diaSemana = this.dataVisita.format(fmtDiaSemana);
		
		String textoTurno = "";
		if (this.turno == Turno.MANHA) {
			textoTurno = "pela manhã";
		} else if (this.turno == Turno.TARDE) {
			textoTurno = "pela tarde";
		} else if (this.turno == Turno.NOITE) {
			textoTurno = "pela noite";
		}
		
		areaFormatada = String.format(ptBr, "%.2f" ,this.area);
		
		return String.format("Novo agendamento solicitado: %s, área de %s metros quadrados, estimativa de %s, para %s (%s) $s.",
				this.tipoDeServico.getNome(),
				areaFormatada,
				valorFormatado,
				diaSemana,
				dataFormatada,
				textoTurno);
		
		
	}
	
}
