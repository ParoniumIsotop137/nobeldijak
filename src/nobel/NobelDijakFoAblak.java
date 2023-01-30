package nobel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NobelDijakFoAblak {

	private JFrame frmNobelDijak;
	private JTable tblDijTabla;
	private DefaultTableModel tModel;
	private List<NobelDijak> dijLista;

	private FajlKezeles fajl = new FajlKezeles();
	private Feladatok megoldas = new Feladatok();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					NobelDijakFoAblak window = new NobelDijakFoAblak();
					window.frmNobelDijak.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NobelDijakFoAblak() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNobelDijak = new JFrame();
		frmNobelDijak.getContentPane().setBackground(new Color(255, 255, 224));
		frmNobelDijak.setTitle("Nobel-díjak");
		frmNobelDijak.setBounds(100, 100, 600, 500);
		frmNobelDijak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNobelDijak.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 585, 360);
		frmNobelDijak.getContentPane().add(scrollPane);

		tblDijTabla = new JTable();
		tblDijTabla.setForeground(new Color(46, 139, 87));
		tblDijTabla.setFont(new Font("Segoe UI Symbol", Font.ITALIC, 12));
		tblDijTabla.setBackground(new Color(255, 239, 213));
		scrollPane.setViewportView(tblDijTabla);

		String[] oszlopok = new String[] { "Évszám", "Díj típusa", "Keresztnév", "Vezetéknév" };

		tModel = new DefaultTableModel(null, oszlopok);
		tblDijTabla.setModel(tModel);

		JButton btnNyolcadik = new JButton("8. feladat");
		btnNyolcadik.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				FajlbaIras();

			}
		});
		btnNyolcadik.setForeground(new Color(160, 82, 45));
		btnNyolcadik.setBackground(new Color(184, 134, 11));
		btnNyolcadik.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 12));
		btnNyolcadik.setBounds(50, 390, 100, 25);
		frmNobelDijak.getContentPane().add(btnNyolcadik);

		dijLista = new ArrayList<NobelDijak>();

		dijLista = fajl.ListaBeolvasas("F:\\Kurs\\Feladatok\\Nobel-dijak\\nobel.csv", ";");

		TablaFeltoltes();

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(250, 235, 215));
		frmNobelDijak.setJMenuBar(menuBar);

		JMenu mnFeladatok = new JMenu("Feladatok");
		mnFeladatok.setForeground(new Color(128, 0, 0));
		mnFeladatok.setFont(new Font("Open Sans", Font.BOLD, 13));
		menuBar.add(mnFeladatok);

		JMenuItem mntHarmadik = new JMenuItem("3. feladat");
		mntHarmadik.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				KikeresAdottNevet();

			}
		});
		mntHarmadik.setForeground(new Color(205, 133, 63));
		mntHarmadik.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 13));
		mntHarmadik.setBackground(new Color(245, 222, 179));
		mnFeladatok.add(mntHarmadik);

		JMenuItem mntNegyedik = new JMenuItem("4. feladat");
		mntNegyedik.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				KikeresDijazottat();

			}
		});
		mntNegyedik.setForeground(new Color(205, 133, 63));
		mntNegyedik.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 13));
		mntNegyedik.setBackground(new Color(245, 222, 179));
		mnFeladatok.add(mntNegyedik);

		JMenuItem mntOtodik = new JMenuItem("5. feladat");
		mntOtodik.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				KikeresSzervezeteket();

			}
		});
		mntOtodik.setForeground(new Color(205, 133, 63));
		mntOtodik.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 13));
		mntOtodik.setBackground(new Color(245, 222, 179));
		mnFeladatok.add(mntOtodik);

		JMenuItem mntHatodik = new JMenuItem("6. feladat");
		mntHatodik.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				KikeresCsaladTagokat();

			}
		});
		mntHatodik.setForeground(new Color(205, 133, 63));
		mntHatodik.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 13));
		mntHatodik.setBackground(new Color(245, 222, 179));
		mnFeladatok.add(mntHatodik);

		JMenuItem mntHetedik = new JMenuItem("7. feladat");
		mntHetedik.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				DijTipusokListazasa();

			}
		});
		mntHetedik.setForeground(new Color(205, 133, 63));
		mntHetedik.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 13));
		mntHetedik.setBackground(new Color(245, 222, 179));
		mnFeladatok.add(mntHetedik);
	}

	private void FajlbaIras() {

		fajl.FajlbaIrOrvosiDijakat(dijLista, "F:\\Kurs\\Feladatok\\Nobel-dijak\\orvosi.txt", ";");

	}

	private void DijTipusokListazasa() {

		megoldas.DijTipustSzamol(dijLista);

	}

	private void KikeresCsaladTagokat() {

		megoldas.KilistazCsaladTagokat(dijLista);

	}

	private void KikeresSzervezeteket() {

		megoldas.KilistazSzervezeteket(dijLista);

	}

	private void KikeresDijazottat() {

		megoldas.KikeresDijazottNevet(dijLista);

	}

	private void KikeresAdottNevet() {

		megoldas.KikeresDijazottat(dijLista);

	}

	private void TablaFeltoltes() {

		for (NobelDijak dijak : dijLista) {

			Object[] adatok = new Object[] { dijak.getEv(), dijak.getDijTipus(), dijak.getKersztNev(),
					dijak.getVezetekNev() };

			tModel.addRow(adatok);

		}

	}
}
