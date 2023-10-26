package br.com.bloco.model;

import java.io.Serializable;
import java.util.Objects;

public class Amizade implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int idConta;
	private int idAmigo;
	private boolean bloqueado;
	
	public Amizade() {
		super();
	}
	
	public Amizade(int idConta, int idAmigo, boolean bloqueado) {
		super();
		this.idConta = idConta;
		this.idAmigo = idAmigo;
		this.bloqueado = bloqueado;
	}

	public int getIdConta() {
		return idConta;
	}
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	public int getIdAmigo() {
		return idAmigo;
	}
	public void setIdAmigo(int idAmigo) {
		this.idAmigo = idAmigo;
	}
	public boolean isBloqueado() {
		return bloqueado;
	}
	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idConta);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Amizade other = (Amizade) obj;
		return idConta == other.idConta;
	}

}
