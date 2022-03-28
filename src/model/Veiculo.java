package model;

public class Veiculo {
	
//	idVeiculo será gerado automaticamente pelo banco de dados (Implementação futura)
	private int idVeiculo;
	
	//	Variáveis obrigatórias para instância
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
// Método set para o ID apenas proisório para validação (Será gerado pelo banco) 
	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
// To string para facilitar reotrno do teste
	public String toString() {
		return "ID: " + idVeiculo + "\nPlaca: " + placa + "\nDispoivel:" + disponibilidade + "\nAutonomia: " + autonomia + "\n";
	}
//*******************************************************************************//
}
