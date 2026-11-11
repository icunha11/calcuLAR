package servico;

import java.util.ArrayList;
import java.util.List;

import modelo.Profissional;
import modelo.SolicitacaoVisita;
import modelo.StatusChamado;

public class PainelChamados {
	
	private List<SolicitacaoVisita>  listaSolicitacoes;
	
	public PainelChamados() {
		this.listaSolicitacoes = new ArrayList<>(0);
	}
	
	
	
	public List<SolicitacaoVisita> listarPendenteDS(Profissional profissional) {
	
		List<SolicitacaoVisita> pendentes = new ArrayList<>();
		for (SolicitacaoVisita s: this.listaSolicitacoes) {
			if (s.getProfissional().equals(profissional) && s.getStatus() == StatusChamado.PENDENTE) {
				pendentes.add(s);
			}
		}
		return pendentes;
	}
	
	public void confirmar(SolicitacaoVisita solicitacao) {
		if (solicitacao.getStatus() != StatusChamado.PENDENTE) {
			throw new IllegalStateException("Não é possível confirmar: a solicitação não está PENDENTE.");
		}
		solicitacao.setStatus(StatusChamado.CONFIRMADO);
	}
	
	public void recusar(SolicitacaoVisita solicitacao) {
		if (solicitacao.getStatus() != StatusChamado.PENDENTE) {
			throw new IllegalStateException("Não é possível recusar: a solicitação não está PENDENTE.");
		}
		solicitacao.setStatus(StatusChamado.RECUSADO);
	}
	
	public List<SolicitacaoVisita> agendaDoProfissional(Profissional profissional){
		List<SolicitacaoVisita> agenda = new ArrayList<SolicitacaoVisita>();
		for (SolicitacaoVisita s: this.listaSolicitacoes) {
			if (s.getProfissional().equals(profissional)) {
				agenda.add(s);
			}
		}
		return agenda;
	}
	
	
}
