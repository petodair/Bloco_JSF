package br.com.bloco.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.bloco.model.Notificacao;

public class DAONotificacao implements Serializable {

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
	
	public void inserirNotificaçãoQuest(Notificacao notificacao) {
		String adicionar = "INSERT INTO tbnotificacoes(idconta, idquest, tipo, visto) VALUES(?,?,?,?)";
		try {

			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(adicionar);
			
			pst.setInt(1, notificacao.getIdConta());
			pst.setInt(2, notificacao.getIdQuest());
			pst.setString(3, "QUEST");
			pst.setBoolean(4, notificacao.isVisto());
			
			pst.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void inserirNotificaçãoLike(Notificacao notificacao) {
		String adicionar = "INSERT INTO tbnotificacoes(idconta, idcomentario, registrolike, tipo, visto) VALUES(?,?,?,?,?)";
		try {

			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(adicionar);
			
			pst.setInt(1, notificacao.getIdConta());
			pst.setInt(2, notificacao.getRegistroLike());
			pst.setString(3, "LIKE");
			pst.setBoolean(4, notificacao.isVisto());
			
			pst.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void inserirNotificaçãoLike(int idconta, int idremetente, int idcomentario) {
		String adicionar = "INSERT INTO tbnotificacoes(idconta,idremetente, idcomentario, tipo, visto) VALUES(?,?,?,?,?)";
		try {

			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(adicionar);
			
			pst.setInt(1, idconta);
			pst.setInt(2, idremetente);
			pst.setInt(3, idcomentario);
			pst.setString(4, "LIKE");
			pst.setBoolean(5, false);
			
			pst.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public List<Notificacao> notificacoes(int idread){
		ArrayList<Notificacao> notificacoes = new ArrayList<>();
		String read = "SELECT * FROM tbnotificacoes WHERE idconta = ?";
		try {
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(read);
			
			pst.setInt(1, idread);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				int idconta = rs.getInt(2);
				int idremetente = rs.getInt(3);
				int idquest = rs.getInt(4);
				int idpost = rs.getInt(5);
				int idcomentario = rs.getInt(6);
				int registrolike = rs.getInt(7);
				String tipo = rs.getString(8);
				boolean visto = rs.getBoolean(9);
				
				notificacoes.add(new Notificacao(id, idconta, idremetente, idquest, idpost, idcomentario, registrolike, tipo, visto));			
			}
			
			con.close();
			
			return notificacoes;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public int getIdByComentario(int idcomentario) {
		String read="SELECT idconta FROM tbcomentarios WHERE id=?";
		int id = 0;
		try {
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(read);
			
			pst.setInt(1, idcomentario);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
			   id = rs.getInt(1);
			}
			return id;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}

}
