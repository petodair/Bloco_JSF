package br.com.bloco.model;

import java.io.Serializable;

public class FotoPerfil implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int idConta;
	private String pasta;
	private String nome;
	
	public FotoPerfil() {
		super();
	}
	
	public FotoPerfil(int id, int idConta, String pasta, String nome) {
		super();
		this.id = id;
		this.idConta = idConta;
		this.pasta = pasta;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdConta() {
		return idConta;
	}
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	public String getPasta() {
		return pasta;
	}
	public void setPasta(String pasta) {
		this.pasta = pasta;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
