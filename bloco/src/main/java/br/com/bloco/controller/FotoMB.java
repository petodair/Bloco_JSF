package br.com.bloco.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bloco.model.FotoPerfil;
import br.com.bloco.service.FotoService;

@Named
@ViewScoped
public class FotoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FotoService service;
	
	@Inject
	private FotoPerfil fotoPerfil;
	
	private String fotoDefault = null;
	
	public String localFotoPerfil(int idconta) {
		String endereco;
		fotoPerfil = service.localFotoPerfil(idconta);
		if(fotoPerfil != null) {
			endereco = "/profile/" + fotoPerfil.getPasta() + "/" + fotoPerfil.getNome();
		} else {
			endereco = "/profile/default/gojo.png";
		}
		return endereco;
	}
	
	public String defaultSelect(String foto) {
		if (foto != null) {
			if(foto == "Foto1") {
				return "/profile/default/gojo.png";
			} else if(foto == "Foto2") {
				return "/profile/default/aluno.jpg";
			} else if(foto == "Foto3") {
				return "/profile/default/aluno2.jpg";
			} else if(foto == "Foto4") {
				return "/profile/default/deku.jpg";
			} else if(foto == "Foto5") {
				return "/profile/default/espetado.jpg";
			} else if(foto == "Foto6") {
				return "/profile/default/L.jpg";
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public void mudarFoto() {		
		System.out.println(fotoDefault + " = saida do radio");
		System.out.println("-------------------------");
		System.out.println(defaultSelect(fotoDefault) + " = aparecer no form");
		System.out.println("-------------------------");	
	}

	public FotoPerfil getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(FotoPerfil fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public String getFotoDefault() {
		return fotoDefault;
	}

	public void setFotoDefault(String fotoDefault) {
		this.fotoDefault = fotoDefault;
	}

}
