package view;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class PrincipalUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalUI frame = new PrincipalUI();
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
	public PrincipalUI() {
		setTitle("Pegada de Carbono");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 354);
		
		JMenuBar jmMenuPrincipal = new JMenuBar();
		setJMenuBar(jmMenuPrincipal);
		
		JMenu jmCadastros = new JMenu("Cadastros");
		jmMenuPrincipal.add(jmCadastros);
		
		JMenuItem jmiColaboradores = new JMenuItem("Colaboradores");
		jmiColaboradores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroColaboradorUI cadColaboradorUI = new CadastroColaboradorUI();
				cadColaboradorUI.setVisible(true);
				contentPane.add(cadColaboradorUI, 0);
			}
		});
		jmCadastros.add(jmiColaboradores);
		
		JMenuItem jmiVeiculos = new JMenuItem("Ve\u00EDculos");
		jmiVeiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroVeiculoUI cadVeiculoUI = new CadastroVeiculoUI();
				cadVeiculoUI.setVisible(true);
				contentPane.add(cadVeiculoUI, 0);
			}
		});
		jmCadastros.add(jmiVeiculos);
		
		JMenu jmConsultas = new JMenu("Consultas");
		jmMenuPrincipal.add(jmConsultas);
		
		JMenuItem jmiConsultaColaboradores = new JMenuItem("Colaboradores");
		jmiConsultaColaboradores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaColaboradorUI consultaColabUI = new ConsultaColaboradorUI();
				consultaColabUI.setVisible(true);
				contentPane.add(consultaColabUI, 0);
			}
		});
		jmConsultas.add(jmiConsultaColaboradores);
		
		JMenuItem jmiConsultaVeiculos = new JMenuItem("Ve\u00EDculos");
		jmiConsultaVeiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaVeiculoUI consultaVeiculoUI = new ConsultaVeiculoUI();
				consultaVeiculoUI.setVisible(true);
				contentPane.add(consultaVeiculoUI, 0);
			}
		});
		jmConsultas.add(jmiConsultaVeiculos);
		
		JMenu jmChamados = new JMenu("Chamados");
		jmMenuPrincipal.add(jmChamados);
		
		JMenuItem jmiRegistrarChamado = new JMenuItem("Registrar Chamado");
		jmiRegistrarChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarChamadoUI regChamadoUI = new RegistrarChamadoUI();
				regChamadoUI.setVisible(true);
				contentPane.add(regChamadoUI, 0);
			}
		});
		jmChamados.add(jmiRegistrarChamado);
		
		JMenuItem jmiConsultarChamado = new JMenuItem("Consultar Chamado");
		jmiConsultarChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaChamadosUI consultaChamadoUI = new ConsultaChamadosUI();
				consultaChamadoUI.setVisible(true);
				contentPane.add(consultaChamadoUI, 0);
			}
		});
		jmChamados.add(jmiConsultarChamado);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 623, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 283, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

}
