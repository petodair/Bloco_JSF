package br.com.bloco.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bloco.model.Quest;
import br.com.bloco.service.QuestService;

@Named
@ViewScoped
public class QuestMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Quest quest;
	
	@Inject
	private QuestService service;
	
	private List<Quest> quests;
	
	@PostConstruct
	public void carregar() {
		quests = service.quests();
	}

	public Quest getQuest() {
		return quest;
	}

	public void setQuest(Quest quest) {
		this.quest = quest;
	}

	public QuestService getService() {
		return service;
	}

	public void setService(QuestService service) {
		this.service = service;
	}

	public List<Quest> getQuests() {
		return quests;
	}
	
}
