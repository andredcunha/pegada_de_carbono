package model;

//import java.time.LocalDate;

//import java.util.List;

public class Colaborador {

//	idColaborador será gerado automaticamente pelo banco de dados (Implementação futura)
	private int idColaborador;

	//	Variáveis obrigatórias para instância
	private String nome;
	private boolean habilitado;

//	Variável opcional para instância
//	private LocalDate dataNascimento;

//	private List<Colaborador> Colaboradores;
	
//	public LocalDate getDataNascimento() {
//		return dataNascimento;
//	}

//	public void setDataNascimento(LocalDate dataNascimento) {
//		this.dataNascimento = dataNascimento;
//	}

	public Colaborador(String nome, boolean habilitado) {
	this.nome = nome;
	this.habilitado = habilitado;
	}
	
	public Colaborador() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public int getIdColaborador() {
		return idColaborador;
	}
//*******************************************************************************//
// Método set para o ID apenas proisório para validação (Será gerado pelo banco) 
	public void setIdColaborador(int idColaborador) {
		this.idColaborador = idColaborador;
	}
// To string para facilitar reotrno do teste
	public String toString() {
//		return "ID do Colaborador: " + idColaborador + "\nNome: " + nome + "\nHabilitado:" + habilitado + "\n";
		if (habilitado) {
			return nome;
		} else {
			return "Colaborador sem habilitação" + "( ID do Colaborador: " + idColaborador + ")";	
		}
		
	}
//*******************************************************************************//
	
}
