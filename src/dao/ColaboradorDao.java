package dao;

import java.util.ArrayList;
import java.util.List;

import model.Colaborador;

public class ColaboradorDao {

	private static ColaboradorDao instance;
	private List<Colaborador> listaColaboradores = new ArrayList<>();
	
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
		listaColaboradores.add(colaborador);
	}
	
	public void atualizar(Colaborador colaborador) {
		listaColaboradores.set(colaborador.getIdColaborador(), colaborador);
	}
	
	public void excluir(int idColaborador) {
		listaColaboradores.remove(idColaborador);
	}
	
	public List<Colaborador> listar(){
		return listaColaboradores;
	}
	

}
