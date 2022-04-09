package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Colaborador;
import model.Veiculo;
import util.ConnectionUtil;

public class VeiculoDao {

	private static VeiculoDao instance;
	private List<Veiculo> listaVeiculos = new ArrayList<>();
	private Connection con = ConnectionUtil.getConnection();
	
	public static VeiculoDao getInstance() {
		if (instance == null) {
			instance = new VeiculoDao();
		}
		return instance;
	}
	
	public void salvar(Veiculo veiculo) {
		try {
			String sql = "insert into frota (placa, autonomia, disponibilidade) values ( ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, veiculo.getPlaca());
			pstmt.setDouble(2, veiculo.getAutonomia());
			pstmt.setBoolean(3, veiculo.isDisponibilidade());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Veiculo veiculo) {
		try {
			String sql = "update frota set placa = ?, autonomia = ?, disponibilidade = ? where id_veiculo = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, veiculo.getPlaca());
			pstmt.setDouble(2, veiculo.getAutonomia());
			pstmt.setBoolean(3, veiculo.isDisponibilidade());
			pstmt.setInt(4, veiculo.getIdVeiculo());
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
				listaVeiculos.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaVeiculos;
	}

}