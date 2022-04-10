package model;

import java.time.LocalDate;

public class Chamado {

//	idChamado será gerado automaticamente pelo banco de dados (Implementação futura)
	private int idChamado;
	
	//	Variáveis obrigatórias para instância
	private LocalDate dataChamdo;
	private Colaborador idColaborador;
	private Veiculo idVeiculo;
	private Boolean statusChamado; // Atribuído através dos métodos de abertura e fechamento

	private String endereco;

//	Variável obrigatória para fechamento do chamado
	private Double kmPercorrido;
	
//	Variável com cálculo do Co2 emitido no chamado
	private Double co2Emitido;

//	public Chamado(Colaborador idColaborador, Veiculo idVeiculo) {
	public Chamado() {
		//Data do chamado é gerada automaticamente na abertura 
		this.dataChamdo = LocalDate.now();

		//Na criação do chamado seu status é false, pois ainda não foi atendido
		this.statusChamado = false;
	}
	
	public void encerraChamado(int idChamado, double kmPercorrido) {
		// idChamdo será usado em implementação futura para mudar o status do chamado correspondente no banco de dados
		this.statusChamado = true;
		this.kmPercorrido = kmPercorrido;
		calculaCo2Emitido();
	}
	
	public void calculaCo2Emitido() {
	Double cg = kmPercorrido / idVeiculo.getAutonomia();
	this.co2Emitido = (cg * 0.82 * 0.75 * 3.7);
	}
	
	public int getIdChamado() {
		return idChamado;
	}

//*******************************************************************************//
// Método set para o ID apenas proisório para validação (Será gerado pelo banco) 
	public void setIdChamado(int idChamado) {
		this.idChamado = idChamado;
	}
// To string para facilitar reotrno do teste
	public String toString_abertura() {
		return "ID do Chamado: " + idChamado + "\nColaborador atribuido: " + idColaborador.getNome() + "\nVeículo atribuído:" + idVeiculo.getPlaca() + "\nStatusChamado: " + statusChamado + "\n";
	}
// To string para facilitar reotrno do teste
	public String toString_encerrado() {
		return "ID do Chamado: " + idChamado + "\nStatusChamado: " + statusChamado + "\nKM Percorrido: " + getKmPercorrido() + "\nCo2 Emitido: " + getCo2Emitido() +"\n";
	}
//*******************************************************************************//
	public LocalDate getDataChamdo() {
		return dataChamdo;
	}
	public void setDataChamdo(LocalDate dataChamdo) {
		this.dataChamdo = dataChamdo;
	}
	public Colaborador getIdColaborador() {
		return idColaborador;
	}
	public void setIdColaborador(Colaborador idColaborador) {
		this.idColaborador = idColaborador;
	}
	public Veiculo getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(Veiculo idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public Boolean getStatusChamado() {
		return statusChamado;
	}
	public void setStatusChamado(Boolean statusChamado) {
		this.statusChamado = statusChamado;
	}
	public Double getKmPercorrido() {
		return kmPercorrido;
	}
	public void setKmPercorrido(Double kmPercorrido) {
		this.kmPercorrido = kmPercorrido;
	}
	public Double getCo2Emitido() {
		return co2Emitido;
	}
	public void setCo2Emitido(Double co2Emitido) {
		this.co2Emitido = co2Emitido;
	}
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}