package br.com.bloco.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.bloco.model.Amizade;
import br.com.bloco.model.Solicitacao;

public class DAOAmizade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1/dbbloco?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "892240";

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;

		}
	}
	
	public void adicionarSolicitacao(int idconta, int idremetente) {
		String read = "INSERT INTO tbsolicitacao(idconta,idremetente) VALUES(?,?)";
		try {
			
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(read);
			
			pst.setInt(1, idconta);
			pst.setInt(2, idremetente);
			
			pst.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			System.out.println("Erro ao adicionar solicitacao " + e);
		}
	}
	
	public ArrayList<Solicitacao> listarSolicitacoes(int id) {
		ArrayList<Solicitacao> solicitacoes = new ArrayList<>();
		String read = "SELECT * FROM tbsolicitacao WHERE idconta = ? ORDER BY id DESC";
		try {
			
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(read);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int idsolicitacao = rs.getInt(1);
				int idconta = rs.getInt(2);
				int idremetente = rs.getInt(3);
				
				solicitacoes.add(new Solicitacao(idsolicitacao, idconta, idremetente));
			}
			
			con.close();
			
			return solicitacoes;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void excluirSolicitacao(int id) {
		String read = "DELETE FROM tbsolicitacao WHERE id = ?";
		try {
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(read);
			
			pst.setInt(1, id);
			
			pst.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void excluirSolicitacao(int idconta, int idremetente) {
		String read = "DELETE FROM tbsolicitacao WHERE idconta = ? AND idremetente = ?";
		try {
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(read);
			
			pst.setInt(1, idconta);
			pst.setInt(2, idremetente);
			
			pst.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public boolean checaSolicitacao(int idConta, int idRemetente) {
		boolean resposta = false;
		String read = "SELECT * FROM tbsolicitacao WHERE idconta = ? AND idremetente = ?";
		try {
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(read);
			
			pst.setInt(1, idConta);
			pst.setInt(2, idRemetente);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				resposta = true;
			}
			
			con.close();
			
			return resposta;
		} catch (Exception e) {
			System.out.println(e);
			return resposta;
		}
	}
	
	public boolean checaAmizade(int idConta, int idamigo) {
		boolean resposta = false;
		String read = "SELECT * FROM tbamizade WHERE idconta = ? AND idamigo = ?";
		try {
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(read);
			
			pst.setInt(1, idConta);
			pst.setInt(2, idamigo);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				resposta = true;
			}
			
			con.close();
			
			return resposta;
		} catch (Exception e) {
			System.out.println(e);
			return resposta;
		}
	}
	
	public void aceitarSolicitacao(Solicitacao s) {
		String read = "INSERT INTO tbamizade(idconta,idamigo,bloqueado) VALUES(?,?,?),(?,?,?)";
		try {
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(read);	
			
			pst.setInt(1, s.getIdConta());
			pst.setInt(2, s.getIdRemetente());
			pst.setBoolean(3, false);
			pst.setInt(4, s.getIdRemetente());
			pst.setInt(5, s.getIdConta());
			pst.setBoolean(6, false);
			pst.executeUpdate();
			
			con.close();
			
			excluirSolicitacao(s.getIdConta(), s.getIdRemetente());
			excluirSolicitacao(s.getIdRemetente(), s.getIdConta());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<Amizade> listarAmizades(int id) {
		ArrayList<Amizade> amizades = new ArrayList<>();
		String read = "SELECT * FROM tbamizade WHERE idconta = ? ORDER BY idconta DESC";
		try {
			
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(read);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int idconta= rs.getInt(1);
				int idamigo = rs.getInt(2);
				boolean bloqueado = rs.getBoolean(3);
				
				amizades.add(new Amizade(idconta, idamigo, bloqueado));
			}
			
			con.close();
			
			return amizades;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
