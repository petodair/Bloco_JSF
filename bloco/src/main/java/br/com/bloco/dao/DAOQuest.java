package br.com.bloco.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.bloco.model.Conta;
import br.com.bloco.model.Quest;

public class DAOQuest implements Serializable {

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
	
	public void inserirConta(Quest quest) {

		String novaQuest = "INSERT INTO tbquests(nome, detalhes, lvl, xp, ativa) values(?,?,?,?,?)";
		try {

			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(novaQuest);

			pst.setString(1, quest.getNome());
			pst.setString(2, quest.getDetalhes());
			pst.setInt(3, quest.getLvl());
			pst.setInt(4, quest.getXp());
			pst.setBoolean(5, quest.isAtiva());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println("Erro ao inserir: " + e);
		}
	}
	
	public ArrayList<Quest> listarQuests() {
		ArrayList<Quest> quests = new ArrayList<>();
		String read = "SELECT id, nome, detalhes, lvl, xp, ativa FROM tbquests";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String detalhes = rs.getString(3);
				int lvl = rs.getInt(4);
				int xp = rs.getInt(5);
				boolean ativa = rs.getBoolean(6);

				quests.add(new Quest(id, nome, detalhes, lvl, xp, ativa));
			}
			con.close();
			return quests;
		} catch (Exception e) {
			System.out.println("Erro ao listar: " + e);
			return null;
		}
	}


}
