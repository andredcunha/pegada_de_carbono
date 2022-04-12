package view.tables;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Chamado;

public class ChamadoTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private static final int COL_DATA = 0;
	private static final int COL_KM = 1;
	private static final int COL_STATUS = 2;
	private static final int COL_COLABORADOR = 3;
	private static final int COL_VEICULO = 4;

	private List<Chamado> valores;       

	//Esse é um construtor, que recebe a nossa lista de clientes
	public ChamadoTableModel(List<Chamado> valores) {
		this.valores = new ArrayList<Chamado>(valores);
	}

	public int getRowCount() {
		//Quantas linhas tem sua tabela? Uma para cada item da lista.
		return valores.size();
	}

	public int getColumnCount() {
		//Quantas colunas tem a tabela? Nesse exemplo, sï¿½ 2.
		return 5;
	}

	public String getColumnName(int column) {
		//Qual é o nome das nossas colunas?
		if (column == COL_DATA) return "Data";
		if (column == COL_KM) return "Distância";
		if (column == COL_STATUS) return "Status";
		if (column == COL_COLABORADOR) return "Colaborador";
		if (column == COL_VEICULO) return "Veiculo";
		return ""; //Nunca deve ocorrer
	}

	public Object getValueAt(int row, int column) {
		//Precisamos retornar o valor da coluna column e da linha row.
		Chamado chamado = valores.get(row);
		if (column == COL_DATA)
			return chamado.getDataChamdo();
		else 
			if (column == COL_KM) 
					return chamado.getKmPercorrido();
		else 
			if (column == COL_STATUS) 
					return chamado.getStatusChamado();
		else 
			if (column == COL_COLABORADOR) 
					return chamado.getIdColaborador();
		else 
			if (column == COL_VEICULO)
					return chamado.getIdVeiculo();
		return ""; //Nunca deve ocorrer
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Chamado chamado = valores.get(rowIndex);
		//Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parï¿½metro.
		//Note que vc poderia alterar 2 campos ao invï¿½s de um sï¿½.
		if (columnIndex == COL_DATA)
			chamado.setDataChamdo(LocalDate.parse(aValue.toString()));
		else 
			if (columnIndex == COL_KM) 
				chamado.setKmPercorrido(Double.parseDouble(aValue.toString()));
		else 
			if (columnIndex == COL_STATUS) 
				chamado.setStatusChamado(Boolean.parseBoolean((aValue.toString())));
//		else 
//			if (columnIndex == COL_COLABORADOR) 
//				chamado.setIdColaborador(Integer.parseInt(aValue.toString()));
//		else 
//			if (columnIndex == COL_VEICULO) 
//				chamado.setIdVeiculo(Integer.parseInt(aValue.toString()));
	}

	public Class<?> getColumnClass(int columnIndex) {
		//Qual a classe das nossas colunas? Como estamos exibindo texto, ï¿½ string.
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		//Indicamos se a célula da rowIndex e da columnIndex é editável. Nossa tabela toda ï¿½.
		return true;
	}
	//Já que esse tableModel é de clientes, vamos fazer um get que retorne um objeto cliente inteiro.
	//Isso elimina a necessidade de chamar o getValueAt() nas telas. 
	public Chamado get(int row) {
		return valores.get(row);
	}
	
}