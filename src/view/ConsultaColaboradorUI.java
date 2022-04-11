package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.ColaboradorController;
import model.Colaborador;
import model.Veiculo;
import view.tables.ColaboradorTableModel;

import javax.swing.JScrollPane;

public class ConsultaColaboradorUI extends JInternalFrame {
	private JTable jtColaboradores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaColaboradorUI frame = new ConsultaColaboradorUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaColaboradorUI() {
		setClosable(true);
		setTitle("Consulta de Colaboradores");
		setBounds(100, 100, 634, 320);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Colaborador colaborador = new ColaboradorTableModel(new ColaboradorController().listar()).get(jtColaboradores.getSelectedRow());
				CadastroColaboradorUI cadColaboradorUI = new CadastroColaboradorUI();
				cadColaboradorUI.setColaboradorEdicao(colaborador);
				cadColaboradorUI.setVisible(true);
				getParent().add(cadColaboradorUI, 0);
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Colaborador colaborador = new ColaboradorTableModel(new ColaboradorController().listar()).get(jtColaboradores.getSelectedRow());
				try {
					new ColaboradorController().excluir(colaborador.getIdColaborador());
					JOptionPane.showMessageDialog(null, "Colaborador excluído com sucesso");
					jtColaboradores.setModel(new ColaboradorTableModel(new ColaboradorController().listar()));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir colaborador");
				}
			}
		});
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtColaboradores.setModel(new ColaboradorTableModel(new ColaboradorController().listar()));
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(256)
							.addComponent(btnAtualizar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExcluir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnFechar))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFechar)
						.addComponent(btnEditar)
						.addComponent(btnExcluir)
						.addComponent(btnAtualizar))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		
		jtColaboradores = new JTable();
		jtColaboradores.setModel(new ColaboradorTableModel(new ColaboradorController().listar()));
		scrollPane.setViewportView(jtColaboradores);
		getContentPane().setLayout(groupLayout);

	}

}
