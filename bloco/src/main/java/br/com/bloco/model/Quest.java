package br.com.bloco.model;

import java.io.Serializable;
import java.util.Objects;

public class Quest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private String detalhes;
	private int lvl;
	private int xp;
	private boolean ativa;
	
	public Quest(int id, String nome, String detalhes, int lvl, int xp, boolean ativa) {
		super();
		this.id = id;
		this.nome = nome;
		this.detalhes = detalhes;
		this.lvl = lvl;
		this.xp = xp;
		this.ativa = ativa;
	}
	public Quest() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}
	public boolean isAtiva() {
		return ativa;
	}
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
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
		Quest other = (Quest) obj;
		return id == other.id;
	}
	
	

}
