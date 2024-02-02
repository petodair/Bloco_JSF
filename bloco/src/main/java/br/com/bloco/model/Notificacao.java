package br.com.bloco.model;

import java.io.Serializable;
import java.util.Objects;

public class Notificacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int idConta;
	private int idRemetente;
	private int idQuest;
	private int idPost;
	private int idComentario;
	private int registroLike;
	private String tipo;
	private boolean visto;
	
	public Notificacao(int id, int idconta, int idRemetente, int idQuest, String tipo, boolean visto) {
		super();
		this.id = id;
		this.idConta = idconta;
		this.idRemetente = idRemetente;
		this.idQuest = idQuest;
		this.tipo = tipo;
		this.visto = visto;
	}
	
	
	public Notificacao(int id, int idConta, int idRemetente, int idQuest, int idPost, int idComentario,
			int registroLike, String tipo, boolean visto) {
		super();
		this.id = id;
		this.idConta = idConta;
		this.idRemetente = idRemetente;
		this.idQuest = idQuest;
		this.idPost = idPost;
		this.idComentario = idComentario;
		this.registroLike = registroLike;
		this.tipo = tipo;
		this.visto = visto;
	}


	public int getIdPost() {
		return idPost;
	}


	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}


	public int getIdComentario() {
		return idComentario;
	}


	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}


	public int getRegistroLike() {
		return registroLike;
	}


	public void setRegistroLike(int registroLike) {
		this.registroLike = registroLike;
	}


	public Notificacao() {
		super();
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
	public void setIdConta(int idconta) {
		this.idConta = idconta;
	}
	public int getIdRemetente() {
		return idRemetente;
	}
	public void setIdRemetente(int idRemetente) {
		this.idRemetente = idRemetente;
	}
	public int getIdQuest() {
		return idQuest;
	}
	public void setIdQuest(int idQuest) {
		this.idQuest = idQuest;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isVisto() {
		return visto;
	}
	public void setVisto(boolean visto) {
		this.visto = visto;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notificacao other = (Notificacao) obj;
		return id == other.id;
	}
	
	
	

}
