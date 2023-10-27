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
				con.close();
				return foto;
			}else {
			con.close();
			return null;
			}
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
	}
	
	public void insereFoto(FotoPerfil f) {
		if(carregaFotoPerfil(f.getIdConta()) == null) {
			String read = "INSERT INTO tbfotoperfil(idconta, pasta, nome) VALUES(?,?,?)";
			try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(read);
				
				pst.setInt(1, f.getIdConta());
				pst.setString(2, f.getPasta());
				pst.setString(3, f.getNome());
				
				pst.executeUpdate();
				
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			String read = "UPDATE tbfotoperfil SET pasta = ?, nome = ? WHERE idconta = ?";
			try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(read);	
				
				pst.setString(1, f.getPasta());
				pst.setString(2, f.getNome());
				pst.setInt(3, f.getIdConta());
				
				pst.executeUpdate();
				
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
