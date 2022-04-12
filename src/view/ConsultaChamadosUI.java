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

import controller.ChamadoController;
import controller.VeiculoController;
import model.Chamado;
import model.Veiculo;
import view.tables.ChamadoTableModel;
import view.tables.VeiculoTableModel;

import javax.swing.JScrollPane;

public class ConsultaChamadosUI extends JInternalFrame {
	private JTable jtChamados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaChamadosUI frame = new ConsultaChamadosUI();
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
	public ConsultaChamadosUI() {
		setClosable(true);
		setTitle("Consulta de Chamados");
		setBounds(100, 100, 743, 399);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chamado chamado = new ChamadoTableModel(new ChamadoController().listar()).get(jtChamados.getSelectedRow());
				RegistrarChamadoUI cadChamadoUI = new RegistrarChamadoUI();
				cadChamadoUI.setChamadoEdicao(chamado);
				cadChamadoUI.setVisible(true);
				getParent().add(cadChamadoUI, 0);
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chamado chamado = new ChamadoTableModel(new ChamadoController().listar()).get(jtChamados.getSelectedRow());
				try {
					new ChamadoController().excluir(chamado.getIdChamado());
					JOptionPane.showMessageDialog(null, "Chamado excluído com sucesso");
					jtChamados.setModel(new ChamadoTableModel(new ChamadoController().listar()));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir chamado");
				}				
			}
		});
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtChamados.setModel(new ChamadoTableModel(new ChamadoController().listar()));
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(386, Short.MAX_VALUE)
					.addComponent(btnAtualizar)
					.addGap(18)
					.addComponent(btnExcluir)
					.addGap(18)
					.addComponent(btnEditar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnFechar)
					.addGap(59))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 694, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(51, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditar)
						.addComponent(btnFechar)
						.addComponent(btnExcluir)
						.addComponent(btnAtualizar))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		
		jtChamados = new JTable();
		jtChamados.setModel(new ChamadoTableModel(new ChamadoController().listar()));
		scrollPane.setViewportView(jtChamados);
		getContentPane().setLayout(groupLayout);

	}

}
