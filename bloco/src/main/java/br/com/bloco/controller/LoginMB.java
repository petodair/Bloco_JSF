package br.com.bloco.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bloco.model.Conta;
import br.com.bloco.service.LoginService;

@Named
@SessionScoped
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private String user;
	private String senha;

	private Conta conta;
	@Inject
	private LoginService service;

	public String logar() {

		conta = new Conta();

		conta.setUser(user);
		conta.setSenha(senha);

		if (service.checaLogin(conta) == true) {
			return "/home.xhtml";
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Usuario ou senha incorretos"));
		return null;
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml";
	}

	public String levelAtual() {

		if (conta != null) {
			if (conta.getLvl() == 1) {
				return "Level 1: Iniciante";
			} else if (conta.getLvl() == 2) {
				return "Level 2: Fuçando";
			} else if (conta.getLvl() == 3) {
				return "level 3: Aprendendo";
			} else {
				return "Tem algo de errado com o nível";
			}
		} else {
			return "Tem algo de errado com o nível";
		}
	}

	public int xpMaximo() {
		if (conta != null) {
			if (conta.getLvl() == 1) {
				return 100;
			} else if (conta.getLvl() == 2) {
				return 300;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	public int xpBarra() {

		int xpMax;
		int xpAtual;
		int total;

		if (conta != null) {
			if (conta.getLvl() == 1) {
				xpMax = 100;
				xpAtual = conta.getXp();
			} else if (conta.getLvl() == 2) {
				xpMax = 200;
				xpAtual = conta.getXp() - 100;
			} else {
				return 0;
			}

			total = 100 * xpAtual / xpMax;

			return total;

		} else {
			return 0;
		}

	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

}
