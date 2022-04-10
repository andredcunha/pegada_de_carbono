package controller;

import java.util.List;

import dao.ChamadoDao;
import dao.ColaboradorDao;
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
		ChamadoDao.getInstance().atualizarChamado(chamado);
	}
	public void excluir(int idChamado) throws Exception {
		if (idChamado == 0) {
			throw new Exception("Nenhum colaborador selecionado");
		}
		ChamadoDao.getInstance().excluir(idChamado);
	}
	public List<Chamado> listar(){
		return ChamadoDao.getInstance().listar();
	}
}
