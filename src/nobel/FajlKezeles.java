package nobel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JOptionPane;

public class FajlKezeles {

	public List<NobelDijak> ListaBeolvasas(String fajlnev, String elvalaszto) {

		List<NobelDijak> dijazottak = new ArrayList<NobelDijak>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlnev), "UTF-8"))) {

			br.readLine();

			while (br.ready()) {

				String[] sor = br.readLine().split(elvalaszto);

				String szoveg;

				if (sor.length == 3) {
					szoveg = "Szervezet";
				} else {
					szoveg = sor[3];
				}

				dijazottak.add(new NobelDijak(Integer.parseInt(sor[0]), sor[1], sor[2], szoveg));

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hiba lépett fel az adatok beolvasásakor: " + e.getMessage(), "Hiba!",
					JOptionPane.ERROR_MESSAGE);
		}
		return dijazottak;

	}

	public void FajlbaIrOrvosiDijakat(List<NobelDijak> dijLista, String fajlnev, String elvalaszto) {

		StringBuilder lista = new StringBuilder();

		try (OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fajlnev, false), "UTF-8")) {

			dijLista.sort((Comparator.comparingInt(n -> n.getEv())));

			dijLista.stream().filter(s -> s.getDijTipus().equals("irodalmi")).forEach(
					s -> lista.append(s.getEv() + elvalaszto + s.getKersztNev() + " " + s.getVezetekNev() + "\n"));

			out.write((lista.toString() + "\n"));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hiba lépett fel az adatok kiírásakor: " + e.getMessage(), "Hiba!",
					JOptionPane.ERROR_MESSAGE);
		}

		JOptionPane.showMessageDialog(null, "Az adatok fájlba írása sikeresen megtörtént (orvosi.txt).", "8. feladat",
				JOptionPane.PLAIN_MESSAGE);

	}

}
