package model;

public class Veiculo {
	
//	idVeiculo ser� gerado automaticamente pelo banco de dados (Implementa��o futura)
	private int idVeiculo;
	
	//	Vari�veis obrigat�rias para inst�ncia
	private String placa;
	private boolean disponibilidade;
	private Double autonomia;
	private String modelo;
	
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Veiculo(String placa, Double autonomia) {
		this.placa = placa;
		this.autonomia = autonomia;
	}

	public Veiculo() {
		// TODO Auto-generated constructor stub
	}

	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public boolean isDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	public Double getAutonomia() {
		return autonomia;
	}
	public void setAutonomia(Double autonomia) {
		this.autonomia = autonomia;
	}

	public int getIdVeiculo() {
		return idVeiculo;
	}
//*******************************************************************************//
// M�todo set para o ID apenas prois�rio para valida��o (Ser� gerado pelo banco) 
	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
// To string para facilitar reotrno do teste
	public String toString() {
//		return "ID do ve�culo: " + idVeiculo + "\nPlaca: " + placa + "\nAutonomia: " + autonomia + "\n";
		if (disponibilidade) {
			return modelo + " (Placa: " + placa + ")";
		} else {
			return "Veiculo Indispon�vel" + " (ID do ve�culo: " + idVeiculo + ")";	
		}
	}
//*******************************************************************************//
}
