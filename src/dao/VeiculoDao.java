package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Veiculo;
import util.ConnectionUtil;

public class VeiculoDao {

	private static VeiculoDao instance;
	private Connection con = ConnectionUtil.getConnection();
	
	public static VeiculoDao getInstance() {
		if (instance == null) {
			instance = new VeiculoDao();
		}
		return instance;
	}
	
	public void salvar(Veiculo veiculo) {
		try {
			String sql = "insert into frota (placa, autonomia, disponibilidade, modelo) values ( ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, veiculo.getPlaca());
			pstmt.setDouble(2, veiculo.getAutonomia());
			pstmt.setBoolean(3, veiculo.isDisponibilidade());
			pstmt.setString(4, veiculo.getModelo());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void localizar(int idVeiculo) {
		try {
			String sql = "select autonomia from veiculo where id_veiculo = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
				Veiculo v = new Veiculo();
				v.setIdVeiculo(rs.getInt("id_veiculo"));
				v.setAutonomia(rs.getDouble("autonomia"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void atualizar(Veiculo veiculo) {
		try {
			String sql = "update frota set placa = ?, autonomia = ?, disponibilidade = ?, modelo = ? where id_veiculo = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, veiculo.getPlaca());
			pstmt.setDouble(2, veiculo.getAutonomia());
			pstmt.setBoolean(3, veiculo.isDisponibilidade());
			pstmt.setString(4, veiculo.getModelo());
			pstmt.setInt(5, veiculo.getIdVeiculo());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int idVeiculo) {
		try {
			String sql = "delete from frota where id_veiculo = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idVeiculo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Veiculo> listar(){
		List<Veiculo> listaVeiculos = new ArrayList<>();
		try {
			String sql = "select * from frota";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Veiculo v = new Veiculo();
				v.setIdVeiculo(rs.getInt("id_veiculo"));
				v.setPlaca(rs.getString("placa"));
				v.setAutonomia(rs.getDouble("autonomia"));
				v.setDisponibilidade(rs.getBoolean("disponibilidade"));
				v.setModelo(rs.getString("modelo"));
				listaVeiculos.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaVeiculos;
	}

}