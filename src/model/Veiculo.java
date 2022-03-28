package model;

public class Veiculo {
	
//	idVeiculo ser� gerado automaticamente pelo banco de dados (Implementa��o futura)
	private int idVeiculo;
	
	//	Vari�veis obrigat�rias para inst�ncia
	private String placa;
	private boolean disponibilidade;
	private Double autonomia;
	
	
	public Veiculo(String placa, boolean disponibilidade, Double autonomia) {
		this.placa = placa;
		this.disponibilidade = disponibilidade;
		this.autonomia = autonomia;
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
		return "ID: " + idVeiculo + "\nPlaca: " + placa + "\nDispoivel:" + disponibilidade + "\nAutonomia: " + autonomia + "\n";
	}
//*******************************************************************************//
}
