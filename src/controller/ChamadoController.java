package controller;

import java.util.List;

import dao.ChamadoDao;
import model.Chamado;

public class ChamadoController {

	public void registrarChamado(Chamado chamado) throws Exception {
		if (chamado.getDataChamdo() == null) {
			throw new Exception("Data Inválida");
		}
		if (chamado.getIdColaborador() == null) {
			throw new Exception("Não há motorista alocado para o chamado");
		}
		if (chamado.getIdVeiculo() == null) {
			throw new Exception("Não há um veiculo alocado para o chamado");
		}
		ChamadoDao.getInstance().registrarChamado(chamado);
	}
	public void atualizarChamado(Chamado chamado) throws Exception {
		if (chamado.getKmPercorrido() == null) {
			throw new Exception("Não há KM registrado pra o chamado");
		}
		ChamadoDao.getInstance().registrarChamado(chamado);
	}
	public List<Chamado> listar(){
		return ChamadoDao.getInstance().listar();
	}
}
