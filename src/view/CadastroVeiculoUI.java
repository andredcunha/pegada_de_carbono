package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.VeiculoController;
import model.Veiculo;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class CadastroVeiculoUI extends JInternalFrame {
	private JTextField txtModelo;
	private JTextField txtPlaca;
	private JTextField txtAutonomia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroVeiculoUI frame = new CadastroVeiculoUI();
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
	public CadastroVeiculoUI() {
		setClosable(true);
		setTitle("Cadastro de Ve\u00EDculos");
		setBounds(100, 100, 494, 221);
		
		JLabel jlModelo = new JLabel("Modelo:");
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		
		JLabel jlPlaca = new JLabel("Placa:");
		
		txtPlaca = new JTextField();
		txtPlaca.setColumns(10);
		
		JLabel jlAutonomia = new JLabel("Autonomia:");
		
		txtAutonomia = new JTextField();
		txtAutonomia.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Veiculo veiculo = new Veiculo();
				veiculo.setModelo(txtModelo.getText());
				veiculo.setPlaca(txtPlaca.getText());
				veiculo.setAutonomia(Double.parseDouble(txtAutonomia.getText()));
//				colaborador.setHabilitado(cboxHabilitado.get())
				new VeiculoController().salvar(veiculo);
				JOptionPane.showMessageDialog(null, "Veiculo salvo com sucesso");
				dispose();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Erro ao salvar Veiculo");
			}
		}
		});
		
		JCheckBox chbxDisponibilidade = new JCheckBox("Dispon\u00EDvel");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jlAutonomia)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(jlPlaca)
							.addComponent(jlModelo)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
						.addComponent(chbxDisponibilidade)
						.addComponent(txtAutonomia, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
					.addGap(74))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(329, Short.MAX_VALUE)
					.addComponent(btnSalvar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancelar)
					.addGap(68))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlModelo)
						.addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlPlaca)
						.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlAutonomia)
						.addComponent(txtAutonomia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(chbxDisponibilidade)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnCancelar))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

}
