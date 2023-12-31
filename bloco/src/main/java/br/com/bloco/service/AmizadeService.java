package br.com.bloco.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.bloco.dao.DAOAmizade;
import br.com.bloco.model.Amizade;
import br.com.bloco.model.Solicitacao;

public class AmizadeService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DAOAmizade dao;
	
	public void salvar(int idconta,int idremetente) {
		dao.adicionarSolicitacao(idconta, idremetente);
	}
	
	public void remover(int id) {
		dao.excluirSolicitacao(id);
	}
	
	public void remover(int idconta, int idremetente) {
		dao.excluirSolicitacao(idconta, idremetente);
	}
	
	public List<Amizade> listarAmizades(int idconta){
		return dao.listarAmizades(idconta);
	}
	
	public List<Solicitacao> listarSolicitacoes(int idconta) {
		return dao.listarSolicitacoes(idconta);	
	}
	
	public boolean checaSolicitacao(int idconta, int idremetente) {
		return dao.checaSolicitacao(idconta, idremetente);
	}
	
	public boolean checaAmizade(int idconta, int idamigo) {
		return dao.checaAmizade(idconta, idamigo);
	}
	
	public void aceitarSolicitacao(Solicitacao s) {
		dao.aceitarSolicitacao(s);
	}

}
