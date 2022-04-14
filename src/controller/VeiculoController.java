package controller;

import java.util.List;

import dao.VeiculoDao;
import model.Veiculo;

public class VeiculoController {

	public void salvar(Veiculo veiculo) throws Exception {
		if (veiculo.getPlaca() == null || veiculo.getPlaca().trim().equals("")) {
			throw new Exception("Placa de veiculo inválida");
		}
		VeiculoDao.getInstance().salvar(veiculo);
	}
	
	public void atualizar(Veiculo veiculo) throws Exception {
		if (veiculo.getPlaca() == null || veiculo.getPlaca().trim().equals("")) {
			throw new Exception("Placa de veiculo inválida");
		}
		VeiculoDao.getInstance().atualizar(veiculo);
	}
	
	public void excluir(int idVeiculo) throws Exception {
		if (idVeiculo == 0) {
			throw new Exception("Nenhum veiculo selecionado");
		}
		VeiculoDao.getInstance().excluir(idVeiculo);
	}
	public void localizarVeiculo(int idVeiculo) throws Exception {
		if (idVeiculo == 0) {
			throw new Exception("Nenhum veiculo selecionado");
		}
		VeiculoDao.getInstance().localizar(idVeiculo);
	}
	public List<Veiculo> listar(){
		return VeiculoDao.getInstance().listar();
	}


}
