package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Chamado;

import util.ConnectionUtil;

public class ChamadoDao {

	private static ChamadoDao instance;
	private Connection con = ConnectionUtil.getConnection();
	
	public static ChamadoDao getInstance() {
		if (instance == null) {
			instance = new ChamadoDao();
		}
		return instance;
	}
	
	public void registrarChamado(Chamado chamado) {
		try {
			String sql = "insert into chamado (data_chamado, status_chamado, colaborador_id_colaborador, frota_id_veiculo, km_percorrido ) values (?, ?, ?, ?, ?)"; 
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setDate(1, java.sql.Date.valueOf(chamado.getDataChamdo()));
			pstmt.setBoolean(2, chamado.getStatusChamado());
			pstmt.setInt(3, chamado.getIdColaborador().getIdColaborador());
			pstmt.setInt(4, chamado.getIdVeiculo().getIdVeiculo());
			pstmt.setDouble(5, chamado.getKmPercorrido());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void atualizarChamado(Chamado chamado) {
		try {
			String sql = "update chamado set status_chamado = ?, km_percorrido = ? where id_chamado = ?";
		
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setBoolean(1, chamado.getStatusChamado());
			System.out.println("Status Chamado:" + chamado.getStatusChamado());
			pstmt.setDouble(2, chamado.getKmPercorrido());
			System.out.println("KM percorrdito:" + chamado.getKmPercorrido());
			pstmt.setInt(3, chamado.getIdChamado());
			System.out.println("ID Chamado:" + chamado.getIdChamado());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int idChamado) {
		try {
			String sql = "delete from chamado where id_chamado = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idChamado);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Chamado> listar(){
		List<Chamado> listaChamados = new ArrayList<>();
		try {
			String sql = "select * from chamado";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Chamado ch = new Chamado();
				ch.setIdChamado(rs.getInt("id_chamado"));
				ch.setDataChamdo(rs.getDate("data_chamado").toLocalDate());
				ch.setStatusChamado(rs.getBoolean("status_chamado"));
//				ch.setIdColaborador(rs.getInt("colaborador_id_colaborador"));
//				ch.setIdVeiculo(rs.getInt("frota_id_veiculo "));

				ch.setKmPercorrido(rs.getDouble("km_percorrido"));
				
				listaChamados.add(ch);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaChamados;
	}
}
