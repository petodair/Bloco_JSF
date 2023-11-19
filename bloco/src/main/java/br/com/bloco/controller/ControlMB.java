package br.com.bloco.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bloco.model.Conta;
import br.com.bloco.model.Post;
import br.com.bloco.service.ContaService;
import br.com.bloco.service.PostService;

@Named("bean")
@SessionScoped
public class ControlMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Post post;

	@Inject
	private Conta conta;

	@Inject
	private LoginMB login;

	@Inject
	private PostService service;

	@Inject
	private ContaService contaService;
	
	private String fotoDefault = null;

	private String valor;

	@PostConstruct
	public void init() {

		valor = post.getAssunto();

	}
	
	public String defaultSelect() {
		if (fotoDefault != null) {
			if(fotoDefault == "Foto1") {
				return "/profile/default/gojo.png";
			} else if(fotoDefault == "Foto2") {
				return "/profile/default/aluno.jpg";
			} else if(fotoDefault == "Foto3") {
				return "/profile/default/aluno2.jpg";
			} else if(fotoDefault == "Foto4") {
				return "/profile/default/deku.jpg";
			} else if(fotoDefault == "Foto5") {
				return "/profile/default/espetado.jpg";
			} else if(fotoDefault == "Foto6") {
				return "/profile/default/L.jpg";
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public int xpAtual() {
		if(conta != null) {
			if(conta.getLvl() == 1) {
				return conta.getXp();
			} else if(conta.getLvl() == 2) {
				return conta.getXp() - 100;
			} else {
				return 0;
			} } else {
				return 0;
			}
		}
	
	public void mudarFoto() {
	System.out.println(fotoDefault + " = saida do radio");
	System.out.println("-------------------------");
	System.out.println(defaultSelect() + " = aparecer no form");
	System.out.println("-------------------------");	
	}

	public void pagPost(int id) {
		post = new Post();
		post = service.selecionaPost(id);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("paginaPost.xhtml");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void pagPostSub(int id) {
		post = new Post();
		post = service.selecionaPost(id);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("../paginaPost.xhtml");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void editPost(int id) {
		post = new Post();
		post = service.selecionaPost(id);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("../restricted/editarPost.xhtml");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void editPerfil(int id) {
		conta = new Conta();
		conta = contaService.selecionaConta(id);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("../restricted/editarPerfil.xhtml");
		} catch (Exception e) {
			
		}
	}

	public void pagConta(int id) {
		conta = new Conta();
		conta = contaService.selecionaConta(id);
		try {
			if (login.getConta() != null) {
				if (login.getConta().getId() == id) {
					FacesContext.getCurrentInstance().getExternalContext().redirect("restricted/conta.xhtml");
				} else {
					FacesContext.getCurrentInstance().getExternalContext().redirect("perfil.xhtml");
				}
				} else {
					FacesContext.getCurrentInstance().getExternalContext().redirect("perfil.xhtml");
				}			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void pagContaSub(int id) {
		conta = new Conta();
		conta = contaService.selecionaConta(id);
		try {
			if (login.getConta() != null) {
				if (login.getConta().getId() == id) {
					FacesContext.getCurrentInstance().getExternalContext().redirect("restricted/conta.xhtml");
				} else {
					FacesContext.getCurrentInstance().getExternalContext().redirect("../perfil.xhtml");
				}
				} else {
					FacesContext.getCurrentInstance().getExternalContext().redirect("../perfil.xhtml");
				}			
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getFotoDefault() {
		return fotoDefault;
	}

	public void setFotoDefault(String fotoDefault) {
		this.fotoDefault = fotoDefault;
	}
	
	

}
