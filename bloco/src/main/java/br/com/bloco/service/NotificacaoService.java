package br.com.bloco.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.bloco.dao.DAONotificacao;
import br.com.bloco.model.Notificacao;

public class NotificacaoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	DAONotificacao dao;
	
	public void inserirQuest(Notificacao notificacao) {
		dao.inserirNotificaçãoQuest(notificacao);
	}
	
	public void inserirLike(Notificacao notificacao) {
		dao.inserirNotificaçãoLike(notificacao);
	}
	
	public List<Notificacao> listarNotificacoes(int id){
		return dao.notificacoes(id);
	}
	
}
