package dao;

import java.util.ArrayList;
import java.util.List;

import model.Veiculo;

public class VeiculoDao {

	private static VeiculoDao instance;
	private List<Veiculo> listaVeiculos = new ArrayList<>();
	
	public static VeiculoDao getInstance() {
		if (instance == null) {
			instance = new VeiculoDao();
		}
		return instance;
	}
	
	public void salvar(Veiculo veiculo) {
		listaVeiculos.add(veiculo);
	}
	
	public void atualizar(Veiculo veiculo) {
		listaVeiculos.set(veiculo.getIdVeiculo(), veiculo);
	}
	
	public void excluir(int idVeiculo) {
		listaVeiculos.remove(idVeiculo);
	}
	
	public List<Veiculo> listar(){
		return listaVeiculos;
	}

}
