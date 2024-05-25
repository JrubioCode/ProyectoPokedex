package aplicacion;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.bson.Document;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JList;

public class Interfaz extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Document pokemonInfo = null;
	private JLabel lblNombre;
	private JLabel lblNivel;
	private JLabel lblTipo;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
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
	public Interfaz() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1066, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

// ----------------------------------------------- INICIO DE BOTONES PARA VER POKEMONS -----------------------------------------------
		JButton btnBulbasaur = new JButton("Bulbasaur");
		btnBulbasaur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConectorMongo conector = new ConectorMongo();
				pokemonInfo = conector.mostrarInfo("Bulbasaur");
				if (pokemonInfo != null) {
					updateLabels();
				} else {
					lblNombre.setText("Información no encontrada");
					lblNivel.setText("");
					lblTipo.setText("");
				}
			}
		});

		// BOTON DE IVYSAUR
		JButton btnIvysaur = new JButton("Ivysaur");
		btnIvysaur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConectorMongo conector = new ConectorMongo();
				pokemonInfo = conector.mostrarInfo("Ivysaur");
				if (pokemonInfo != null) {
					updateLabels();
				} else {
					lblNombre.setText("Información no encontrada");
					lblNivel.setText("");
					lblTipo.setText("");
				}
			}
		});

		JButton btnVenasaur = new JButton("Venasaur");
		btnVenasaur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConectorMongo conector = new ConectorMongo();
				pokemonInfo = conector.mostrarInfo("Venasaur");
				if (pokemonInfo != null) {
					updateLabels();
				} else {
					lblNombre.setText("Información no encontrada");
					lblNivel.setText("");
					lblTipo.setText("");
				}
			}
		});
// ----------------------------------------------- FIN DE BOTONES PARA VER POKEMONS -----------------------------------------------

// ----------------------------------------------- INICIO DE AÑADIR BOTONES AL CONTENT PANE -----------------------------------------------
		btnBulbasaur.setBounds(10, 11, 200, 23);
		contentPane.add(btnBulbasaur);

		btnIvysaur.setBounds(10, 45, 200, 23);
		contentPane.add(btnIvysaur);

		btnVenasaur.setBounds(10, 85, 200, 23);
		contentPane.add(btnVenasaur);
// ----------------------------------------------- FIN DE AÑADIR BOTONES AL CONTENT PANE -----------------------------------------------

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(540, 25, 300, 23);
		contentPane.add(lblNombre);

		lblNivel = new JLabel("Nivel:");
		lblNivel.setBounds(540, 54, 300, 23);
		contentPane.add(lblNivel);

		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(540, 85, 300, 23);
		contentPane.add(lblTipo);

		// BOTON DE COMPRAR
		JButton btnNewButton = new JButton("COMPRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 322, 110, 38);
		contentPane.add(btnNewButton);

		// BOTON DE VENDER
		JButton btnNewButton_1 = new JButton("VENDER");
		btnNewButton_1.setBounds(178, 322, 95, 38);
		contentPane.add(btnNewButton_1);

	}

	private void updateLabels() {
        lblNombre.setText("Nombre: " + pokemonInfo.getString("nombre"));
        lblNivel.setText("Nivel: " + pokemonInfo.getString("nivel"));
        lblTipo.setText("Tipo: " + pokemonInfo.getString("tipo"));
    }
}