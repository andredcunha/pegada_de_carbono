package teste;

import controller.ColaboradorController;
import controller.ChamadoController;
import controller.VeiculoController;
import model.Chamado;
import model.Colaborador;
import model.Veiculo;

public class Principal {
	
	public static void main(String[] args) {


// Colaborador
		Colaborador colaborador1 = new Colaborador("Andre", true);
		colaborador1.setIdColaborador(1);
		colaborador1.setDataNascimento(null);
		
		Colaborador colaborador2 = new Colaborador("Fabiano", true);
		colaborador2.setIdColaborador(2);
		colaborador2.setDataNascimento(null);
		
		Colaborador colaborador3 = new Colaborador("Leonardo", true);
		colaborador3.setIdColaborador(3);
		colaborador3.setDataNascimento(null);
		
		ColaboradorController controller = new ColaboradorController();
		try {
		controller.salvar(colaborador1);
		controller.salvar(colaborador2);
		controller.salvar(colaborador3);
		} catch (Exception er) {
			System.out.println(er.getMessage());
		}
		System.out.println ("**************** Dados dos colaboradores ****************");
		for (Colaborador c : controller.listar()) {
			System.out.println(c.toString());
		}
		
// Veiculo

		Veiculo veiculo1 = new Veiculo("QHR3051", true, 30.5);
		veiculo1.setIdVeiculo(1);
		
		Veiculo veiculo2 = new Veiculo("IOC2347", true, 15.3);
		veiculo2.setIdVeiculo(2);
		
		Veiculo veiculo3 = new Veiculo("ABC3342", true, 15.2);
		veiculo3.setIdVeiculo(3);

		VeiculoController controller2 = new VeiculoController();
		
		try {
		controller2.salvar(veiculo1);
		controller2.salvar(veiculo2);
		controller2.salvar(veiculo3);
		} catch (Exception er) {
			System.out.println(er.getMessage());
		}
		System.out.println ("**************** Dados dos Veículos ****************");
		for (Veiculo v : controller2.listar()) {
			System.out.println(v.toString());
		}		

// Chamado abertura
		Chamado chamado1 = new Chamado();
		chamado1.setIdChamado(1);
		chamado1.setIdColaborador(colaborador1);
		chamado1.setIdVeiculo(veiculo1);

		Chamado chamado2 = new Chamado();
		chamado2.setIdChamado(2);
		chamado2.setIdColaborador(colaborador2);
		chamado2.setIdVeiculo(veiculo2);

		Chamado chamado3 = new Chamado();
		chamado3.setIdChamado(3);
		chamado3.setIdColaborador(colaborador3);
		chamado3.setIdVeiculo(veiculo3);

		ChamadoController controller3 = new ChamadoController();

		try {
		controller3.registrarChamado(chamado1);
		controller3.registrarChamado(chamado2);
		controller3.registrarChamado(chamado3);
		} catch (Exception er) {
			System.out.println(er.getMessage());
		}
		System.out.println ("**************** Dados abertura chamados ****************");
		for (Chamado ch : controller3.listar()) {
			System.out.println(ch.toString_abertura());
		}	
// Chamado fechamento
	chamado1.encerraChamado(1, 29.2 );
	chamado2.encerraChamado(2, 40.5);
	chamado3.encerraChamado(3, 13);
	
	try {
//	controller3.registrarChamado(chamado1);
	controller3.atualizarChamado(chamado1);
	controller3.atualizarChamado(chamado2);
	controller3.atualizarChamado(chamado3);
	} catch (Exception er) {
		System.out.println(er.getMessage());
	}
	System.out.println ("**************** Dados chamados encerrados ****************");
	for (Chamado chfinished : controller3.listar()) {
		System.out.println(chfinished.toString_encerrado());
	}
	
	}
}

