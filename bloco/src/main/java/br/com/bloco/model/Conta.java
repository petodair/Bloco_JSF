package br.com.bloco.model;

import java.io.Serializable;
import java.util.Objects;

public class Conta implements Serializable, Base{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String user;
	private String email;
	private String senha;
	private String tipo;
	private int xp;
	private int lvl;
	
	public Conta() {
		super();
	}
	
	public Conta(int id, String user, String email, String senha, String tipo, int xp, int lvl) {
		super();
		this.id = id;
		this.user = user;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
		this.xp = xp;
		this.lvl = lvl;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
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
		Conta other = (Conta) obj;
		return Objects.equals(id, other.id);
	}

}
