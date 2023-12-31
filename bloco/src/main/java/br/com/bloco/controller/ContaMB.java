package br.com.bloco.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bloco.model.Conta;
import br.com.bloco.service.ContaService;

@Named
@ViewScoped
public class ContaMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Conta conta;
	
	@Inject
	private ContaService service;
	
	@Inject
	private FotoMB fotoMB;
	
	@Inject
	private LoginMB loginMB;
	
	private String pesquisa;
	
	private List<Conta> contas;
	
	private List<Conta> contasPesquisadas = null;
	
	@PostConstruct
	public void carregar() {
		contas = service.todasAsContas();
	}
	
	public void adicionar() {
		try {
			if(service.checaCredenciais(conta.getUser(), conta.getEmail()) == 1) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro","Já existe um usuario com este nome"));
			} else if(service.checaCredenciais(conta.getUser(), conta.getEmail()) == 2) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro","Já existe um usuario com este email"));
			} else {
			service.salvar(conta);
			conta = new Conta();
			carregar();
			}			
		} catch (Exception e) {
			System.out.println(e);
		}		
	}
	
	public void atualizar(Conta c,int id, String f) {
		fotoMB.mudarFoto(f, id);	
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("conta.xhtml");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void remover() {		
		try {
			service.remover(conta);
			carregar();
		} catch (Exception e) {
			
		}		
	}
	
	public void pesquisar() {
		try {
			contasPesquisadas = service.pesquisarConta(pesquisa);
		} catch (Exception e) {
			
		}
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public List<Conta> getContasPesquisadas() {
		return contasPesquisadas;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Conta> getContas() {
		return contas;
	}
	

}
