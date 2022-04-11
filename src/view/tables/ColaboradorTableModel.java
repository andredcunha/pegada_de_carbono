package view.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Colaborador;

public class ColaboradorTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private static final int COL_NOME = 0;
	private static final int COL_HABILITADO = 1;

	private List<Colaborador> valores;       

	//Esse � um construtor, que recebe a nossa lista de clientes
	public ColaboradorTableModel(List<Colaborador> valores) {
		this.valores = new ArrayList<Colaborador>(valores);
	}

	public int getRowCount() {
		//Quantas linhas tem sua tabela? Uma para cada item da lista.
		return valores.size();
	}

	public int getColumnCount() {
		//Quantas colunas tem a tabela? Nesse exemplo, s� 2.
		return 2;
	}

	public String getColumnName(int column) {
		//Qual � o nome das nossas colunas?
		if (column == COL_NOME) return "Nome";
		if (column == COL_HABILITADO) return "� Habilitado?";
		return ""; //Nunca deve ocorrer
	}

	public Object getValueAt(int row, int column) {
		//Precisamos retornar o valor da coluna column e da linha row.
		Colaborador colaborador = valores.get(row);
		if (column == COL_NOME) 
			return colaborador.getNome();
		else 
			if (column == COL_HABILITADO) 
					return colaborador.isHabilitado();
		return ""; //Nunca deve ocorrer
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Colaborador colaborador = valores.get(rowIndex);
		//Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no par�metro.
		//Note que vc poderia alterar 2 campos ao inv�s de um s�.
		if (columnIndex == COL_NOME)
			colaborador.setNome(aValue.toString());
		else 
			if (columnIndex == COL_HABILITADO) 
				colaborador.setHabilitado(Boolean.parseBoolean((aValue.toString())));
	}

	public Class<?> getColumnClass(int columnIndex) {
		//Qual a classe das nossas colunas? Como estamos exibindo texto, � string.
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		//Indicamos se a c�lula da rowIndex e da columnIndex � edit�vel. Nossa tabela toda �.
		return true;
	}
	//J� que esse tableModel � de clientes, vamos fazer um get que retorne um objeto cliente inteiro.
	//Isso elimina a necessidade de chamar o getValueAt() nas telas. 
	public Colaborador get(int row) {
		return valores.get(row);
	}
	
}
