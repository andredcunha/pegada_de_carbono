package model;

//import java.time.LocalDate;

//import java.util.List;

public class Colaborador {

//	idColaborador ser� gerado automaticamente pelo banco de dados (Implementa��o futura)
	private int idColaborador;

	//	Vari�veis obrigat�rias para inst�ncia
	private String nome;
	private boolean habilitado;

//	Vari�vel opcional para inst�ncia
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
// M�todo set para o ID apenas prois�rio para valida��o (Ser� gerado pelo banco) 
	public void setIdColaborador(int idColaborador) {
		this.idColaborador = idColaborador;
	}
// To string para facilitar reotrno do teste
	public String toString() {
//		return "ID do Colaborador: " + idColaborador + "\nNome: " + nome + "\nHabilitado:" + habilitado + "\n";
		if (habilitado) {
			return nome;
		} else {
			return "Colaborador sem habilita��o" + "( ID do Colaborador: " + idColaborador + ")";	
		}
		
	}
//*******************************************************************************//
	
}
