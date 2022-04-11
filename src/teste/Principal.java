package teste;

import controller.ColaboradorController;

import java.time.LocalDate;

import controller.ChamadoController;
import controller.VeiculoController;
import model.Chamado;
import model.Colaborador;
import model.Veiculo;

public class Principal {

	public static void main(String[] args) {

//		cadastraColaborador();
//		alteraColaborador();
//		excluiColaborador();

//		cadastraVeiculo();
//		alteraVeiculo();
//		excluiVeiculo();

//		cadastraChamado();
//		alteraChamado();
//		excluiChamado();
//		listarChamados();
		
	}

// Colaborador
	public static void cadastraColaborador() {
		Colaborador colaborador1 = new Colaborador("Andre", true);
//		colaborador1.setDataNascimento(LocalDate.of(1986, 05, 18));
		
		Colaborador colaborador2 = new Colaborador("Fabiano", true);
//		colaborador2.setDataNascimento(LocalDate.of(1980, 05, 18));
		
		Colaborador colaborador3 = new Colaborador("Leonardo", true);
//		colaborador3.setDataNascimento(LocalDate.of(1985, 05, 18));
		
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
	}

	public static void alteraColaborador() {
		Colaborador colaborador1 = new Colaborador("Andre", false);
		colaborador1.setIdColaborador(1);		
		
		ColaboradorController controller = new ColaboradorController();
		
		try {
		controller.atualizar(colaborador1);
		} catch (Exception er) {
			System.out.println(er.getMessage());
		}
		System.out.println ("**************** Dados dos colaboradores ****************");
		for (Colaborador c : controller.listar()) {
			System.out.println(c.toString());
		}
	}

	public static void excluiColaborador() {
		Colaborador colaborador1 = new Colaborador("Andre", false);
		colaborador1.setIdColaborador(1);		
		
		ColaboradorController controller = new ColaboradorController();

		try {
			for (Colaborador c : controller.listar()) {
				System.out.println(c.toString());
				controller.excluir(colaborador1.getIdColaborador());				
			}
		} catch (Exception er) {
		System.out.println(er.getMessage());
		}
	}



// Veiculo
//
	
	public static void	cadastraVeiculo() {
		Veiculo veiculo1 = new Veiculo("QHR3051", 30.5);
		Veiculo veiculo2 = new Veiculo("IOC2347", 15.3);
		Veiculo veiculo3 = new Veiculo("ABC3342", 15.2);
		veiculo1.setDisponibilidade(true);
		veiculo1.setModelo("GOL");
		veiculo2.setDisponibilidade(true);
		veiculo2.setModelo("PRISMA");
		veiculo3.setDisponibilidade(true);
		veiculo3.setModelo("UNO");
		VeiculoController controller = new VeiculoController();
		
		try {
		controller.salvar(veiculo1);
		controller.salvar(veiculo2);
		controller.salvar(veiculo3);
		} catch (Exception er) {
			System.out.println(er.getMessage());
		}
		System.out.println ("**************** Dados dos Veículos ****************");
		for (Veiculo v : controller.listar()) {
			System.out.println(v.toString());
		}
	}
	public static void	alteraVeiculo() {
		Veiculo veiculo1 = new Veiculo("QHR3051", 22.5);
		veiculo1.setIdVeiculo(1);
		veiculo1.setDisponibilidade(true);
		
		VeiculoController controller = new VeiculoController();
		
		try {
		controller.atualizar(veiculo1);
		} catch (Exception er) {
			System.out.println(er.getMessage());
		}
	
		System.out.println ("**************** Dados dos Veículos ****************");
		for (Veiculo v : controller.listar()) {
			System.out.println(v.toString());
		}
	}
	public static void	excluiVeiculo() {
		Veiculo veiculo1 = new Veiculo("QHR3051", 30.5);
		veiculo1.setIdVeiculo(1);

		VeiculoController controller = new VeiculoController();
		
		try {
		controller.excluir(veiculo1.getIdVeiculo());
		} catch (Exception er) {
			System.out.println(er.getMessage());
		}
		System.out.println ("**************** Dados dos Veículos ****************");
		for (Veiculo v : controller.listar()) {
			System.out.println(v.toString());
		}
	}

//// Chamado abertura

	public static void	cadastraChamado() {
		Chamado chamado1 = new Chamado();
		Colaborador colaborador1 = new Colaborador("Andre", true);
		Veiculo veiculo1 = new Veiculo("QHR3051", 30.1);
		colaborador1.setIdColaborador(7);
		veiculo1.setIdVeiculo(5);
		
		chamado1.setDataChamdo(LocalDate.now());
		chamado1.setIdColaborador(colaborador1);
		chamado1.setIdVeiculo(veiculo1);
		chamado1.setKmPercorrido(20.9);

		ChamadoController controller = new ChamadoController();

		try {
		controller.salvar(chamado1);
		} catch (Exception er) {
			System.out.println(er.getMessage());
		}
		System.out.println ("**************** Dados abertura chamados ****************");
		for (Chamado ch : controller.listar()) {
			System.out.println(ch.toString_abertura());
		}
	}

	public static void	alteraChamado() {
		Chamado chamado1 = new Chamado();
		chamado1.setIdChamado(2);
		chamado1.setStatusChamado(true);
		chamado1.setKmPercorrido(45.0);
		
		ChamadoController controller = new ChamadoController();

		try {
		controller.salvar(chamado1);
		} catch (Exception er) {
			System.out.println(er.getMessage());
		}
		System.out.println ("**************** Dados fechamento chamado ****************");
		for (Chamado ch : controller.listar()) {
			System.out.println(ch.toString_encerrado());
		}
	}

	public static void	excluirChamado() {
		Chamado chamado1 = new Chamado();
		chamado1.setIdChamado(1);
		
		
		ChamadoController controller = new ChamadoController();

		try {
		controller.excluir(chamado1.getIdChamado());
		} catch (Exception er) {
			System.out.println(er.getMessage());
		}
		System.out.println ("**************** Dados abertura chamados ****************");
		for (Chamado ch : controller.listar()) {
			System.out.println(ch.toString_abertura());
		}
	}
	public static void listarChamados() {
		ChamadoController controller = new ChamadoController();
		for (Chamado ch : controller.listar()) {
			System.out.println(ch.toString_sem_fk());
		}
	}
//// Chamado fechamento

//	chamado1.encerraChamado(1, 29.2 );
//	chamado2.encerraChamado(2, 40.5);
//	chamado3.encerraChamado(3, 13);
//	
//	try {
////	controller3.registrarChamado(chamado1);
//	controller3.atualizarChamado(chamado1);
//	controller3.atualizarChamado(chamado2);
//	controller3.atualizarChamado(chamado3);
//	} catch (Exception er) {
//		System.out.println(er.getMessage());
//	}
//	System.out.println ("**************** Dados chamados encerrados ****************");
//	for (Chamado chfinished : controller3.listar()) {
//		System.out.println(chfinished.toString_encerrado());
//	}
//	
//	}
//}
	}
