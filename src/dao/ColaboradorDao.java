package dao;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Colaborador;
import util.ConnectionUtil;



public class ColaboradorDao {

	private static ColaboradorDao instance;
	private List<Colaborador> listaColaboradores = new ArrayList<>();
	private Connection con = ConnectionUtil.getConnection();
	
	/*
	 * Singleton
	 */
	public static ColaboradorDao getInstance() {
		if (instance == null) {
			instance = new ColaboradorDao();
		}
		return instance;
	}
	
	public void salvar(Colaborador colaborador) {
		try {
			String sql = "insert into colaborador (nome, data_nasc, habilitado) values ( ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, colaborador.getNome());
			pstmt.setDate(2, java.sql.Date.valueOf(colaborador.getDataNascimento()));
			pstmt.setBoolean(3, colaborador.isHabilitado());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Colaborador colaborador) {
		try {
			String sql = "update colaborador set nome = ?, data_nasc = ?, habilitado = ? where id_colaborador = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, colaborador.getNome());
			pstmt.setDate(2, java.sql.Date.valueOf(colaborador.getDataNascimento()));
			pstmt.setBoolean(3, colaborador.isHabilitado());
			pstmt.setInt(4, colaborador.getIdColaborador());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int idColaborador) {
		try {
			String sql = "delete from colaborador where id_colaborador = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idColaborador);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Colaborador> listar(){
		List<Colaborador> listaColaboradores = new ArrayList<>();
		try {
			String sql = "select * from colaborador";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Colaborador c = new Colaborador();
				c.setIdColaborador(rs.getInt("id_colaborador"));
				c.setNome(rs.getString("nome"));
//				c.setDataNascimento(rs.getDate("data_nasc"));
				c.setHabilitado(rs.getBoolean("habilitado"));
				listaColaboradores.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaColaboradores;
	}
	
}
