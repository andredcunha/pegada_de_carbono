package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarChamadoUI extends JInternalFrame {
	private JTextField txtDataChamado;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarChamadoUI frame = new RegistrarChamadoUI();
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
	public RegistrarChamadoUI() {
		setClosable(true);
		setTitle("Registrar Chamado");
		setBounds(100, 100, 495, 277);
		
		JComboBox cbColaborador = new JComboBox();
		
		JLabel jlColaborador = new JLabel("Colaborador:");
		
		JLabel jlVeiculo = new JLabel("Ve\u00EDculo:");
		
		JComboBox cbVeiculo = new JComboBox();
		
		JLabel jlDataChamado = new JLabel("Data Chamado:");
		
		txtDataChamado = new JTextField();
		txtDataChamado.setColumns(10);
		
		JLabel jlDistancia = new JLabel("Dist\u00E2ncia:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel jlStatus = new JLabel("Status:");
		
		JComboBox cbStatus = new JComboBox();
		cbStatus.setModel(new DefaultComboBoxModel(new String[] {"EM ABERTO", "EM ANDAMENTO", "CONCLU\u00CDDO"}));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO - Ação do botão salvar
			}
		});
		
		JLabel jlResultado = new JLabel("Resultado CO2:");
		
		JLabel jlResultadoCO2 = new JLabel("XY,XY");
		jlResultadoCO2.setFont(new Font("Tahoma", Font.BOLD, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(jlDataChamado)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtDataChamado, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(jlStatus)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbStatus, 0, 169, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(jlColaborador)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbColaborador, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(jlVeiculo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbVeiculo, 0, 366, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(jlDistancia)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
							.addComponent(jlResultado)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(jlResultadoCO2)
							.addGap(41))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSalvar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar)))
					.addGap(62))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlDataChamado)
						.addComponent(txtDataChamado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jlStatus)
						.addComponent(cbStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlColaborador)
						.addComponent(cbColaborador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlVeiculo)
						.addComponent(cbVeiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlDistancia)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jlResultado)
						.addComponent(jlResultadoCO2))
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvar))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

}
