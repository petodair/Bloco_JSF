package br.com.bloco.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.bloco.dao.DAOQuest;
import br.com.bloco.model.Quest;

public class QuestService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DAOQuest dao;
	
	public void salvar(Quest quest) {
		dao.inserirQuests(quest);
	}
	
	public List<Quest> quests(){
		return dao.listarQuests();
	}

}
