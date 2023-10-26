package br.com.bloco.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.bloco.model.FotoPerfil;

public class DAOFoto implements Serializable{

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
	
	public FotoPerfil carregaFotoPerfil(int idconta) {
		FotoPerfil foto = new FotoPerfil();
		String read = "SELECT * FROM tbfotoperfil WHERE idconta = ?";
	    try {
	    	Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setInt(1, idconta);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				foto.setId(rs.getInt(1));
				foto.setIdConta(rs.getInt(2));
				foto.setPasta(rs.getString(3));
				foto.setNome(rs.getString(4));
				return foto;
			}else {
			return null;
			}
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
	}

}
