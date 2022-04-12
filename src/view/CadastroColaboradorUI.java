package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.ColaboradorController;

import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import model.Colaborador;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;

public class CadastroColaboradorUI extends JInternalFrame {
	private JTextField txtNome;
	private boolean is_habilitado;
	private Colaborador colaborador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroColaboradorUI frame = new CadastroColaboradorUI();
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
	public CadastroColaboradorUI() {
		
		setClosable(true);
		setTitle("Cadastro de Colaboradores");
		setBounds(100, 100, 598, 165);
		
		JLabel jlNome = new JLabel("Nome:");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
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
					if (colaborador != null && colaborador.getIdColaborador() > 0) {
						colaborador.setNome(txtNome.getText());
						colaborador.setHabilitado(is_habilitado);
//						Verificar como pegar booleano
						new ColaboradorController().atualizar((colaborador));
						JOptionPane.showMessageDialog(null, "Colaborador atualizado com sucesso");
					} else {
						Colaborador colaborador = new Colaborador();
						colaborador.setNome(txtNome.getText());
					    colaborador.setHabilitado(is_habilitado);
						new ColaboradorController().salvar(colaborador);
						JOptionPane.showMessageDialog(null, "Colaborador salvo com sucesso");
					}
					dispose();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar Colaborador");
				}
			}
		});
		
		JCheckBox cboxHabilitado = new JCheckBox("Colaborador Habilitado");
		cboxHabilitado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setIsHabilitado (cboxHabilitado.isSelected());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Seleção não está funcionando");
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSalvar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(jlNome)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(cboxHabilitado)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE))))
					.addGap(0))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlNome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(cboxHabilitado)
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvar))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}
	public void setColaboradorEdicao(Colaborador colaborador) {
		this.colaborador = colaborador;
		preeencheFormulario();
	}

	public void setIsHabilitado(Boolean is_habilitado) {
		this.is_habilitado = is_habilitado;
		System.out.println("Status do Check box:" + is_habilitado);
	}
	
	private void preeencheFormulario() {
		if(colaborador != null) {
			txtNome.setText(colaborador.getNome());
//			Falta metodo para pegar booleano de habilitado
		}
		
	}
}
