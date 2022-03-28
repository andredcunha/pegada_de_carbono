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
		for (Veiculo v : controller2.listar()) {
			System.out.println(v.toString());
		}		

	}
}

