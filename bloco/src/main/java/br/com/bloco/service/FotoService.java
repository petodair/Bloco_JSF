package br.com.bloco.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.bloco.dao.DAOFoto;
import br.com.bloco.model.FotoPerfil;

public class FotoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DAOFoto dao;
	
	public FotoPerfil localFotoPerfil(int idConta) {
		return dao.carregaFotoPerfil(idConta);
	}
	
	public void escolherFoto(FotoPerfil f) {
		dao = new DAOFoto();
		dao.insereFoto(f);
	}
}