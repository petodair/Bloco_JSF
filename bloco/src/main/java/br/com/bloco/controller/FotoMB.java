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
	
	private String fotoDefault;
	
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
		
			if(foto.equals("Foto1")) {
				return "profile/default/gojo.png";
			} else if(foto.equals("Foto2")) {
				return "profile/default/aluno.jpg";
			} else if(foto.equals("Foto3")) {
				return "profile/default/aluno2.jpg";
			} else if(foto.equals("Foto4")) {
				return "profile/default/deku.jpg";
			} else if(foto.equals("Foto5")) {
				return "profile/default/espetado.jpg";
			} else if(foto.equals("Foto6")) {
				return "profile/default/L.jpg";
			} else {
				return null;
			}
		} 
	
	
	public void mudarFoto(String f, int id) {
		
		fotoPerfil = new FotoPerfil();
		service = new FotoService();
		  fotoPerfil.setIdConta(id);
		if(f.equals("Foto1")) {
			fotoPerfil.setPasta("default");
			fotoPerfil.setNome("gojo.png");
		} else if(f.equals("Foto2")) {
			fotoPerfil.setPasta("default");
			fotoPerfil.setNome("aluno.jpg");
		} else if(f.equals("Foto3")) {
			fotoPerfil.setPasta("default");
			fotoPerfil.setNome("aluno2.jpg");
		} else if(f.equals("Foto4")) {
			fotoPerfil.setPasta("default");
			fotoPerfil.setNome("deku.jpg");
		} else if(f.equals("Foto5")) {
			fotoPerfil.setPasta("default");
			fotoPerfil.setNome("espetado.jpg");
		} else if(f.equals("Foto6")) {
			fotoPerfil.setPasta("default");
			fotoPerfil.setNome("L.jpg");
		} else if(f.equals(null)) {
			fotoPerfil.setPasta("default");
			fotoPerfil.setNome("gojo.png");
		}
		
		service.escolherFoto(fotoPerfil);
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
