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
	private List<Chamado> listaChamados = new ArrayList<>();
	private Connection con = ConnectionUtil.getConnection();
	
	public static ChamadoDao getInstance() {
		if (instance == null) {
			instance = new ChamadoDao();
		}
		return instance;
	}
	
	public void registrarChamado(Chamado chamado) {
		try {
			
//			String sql = "insert into chamado (data_chamado, status_chamdo, colaborador_id_motorista, frota_id_veiculo) values (?, ?, ?, ?)"; 
			String sql = "insert into chamado(status_chamado, colaborador_id_motorista, frota_id_veiculo) values ( ?, ?, ?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
//			pstmt.setDate(1, java.sql.Date.valueOf(chamado.getDataChamdo()));
//			pstmt.setBoolean(2, false);
//			pstmt.setInt(3, chamado.getIdColaborador().getIdColaborador());
//			pstmt.setInt(4, chamado.getIdVeiculo().getIdVeiculo());

			pstmt.setInt(1, 0);
			pstmt.setInt(2, 127);
			pstmt.setInt(3, 10);

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void atualizarChamado(Chamado chamado) {
		listaChamados.set(chamado.getIdChamado(), chamado);
	}
	
	public void excluir(int idChamado) {
		listaChamados.remove(idChamado);
	}
	public List<Chamado> listar(){
		return listaChamados;
	}
}
