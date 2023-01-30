package nobel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class Feladatok {

	public void KikeresDijazottat(List<NobelDijak> dijLista) {

		int index = 0;

		while (index < dijLista.size() && !(dijLista.get(index).getKersztNev().toLowerCase().equals("arthur b."))
				&& !dijLista.get(index).getVezetekNev().toLowerCase().equals("mcdonald")) {
			index++;
		}

		if (index < dijLista.size()) {
			JOptionPane.showMessageDialog(null, dijLista.get(index).getDijTipus(), "3. feladat",
					JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Nincsen ilyen", "3. feladat", JOptionPane.PLAIN_MESSAGE);
		}

	}

	public void KikeresDijazottNevet(List<NobelDijak> dijLista) {

		int index = 0;

		for (int i = 0; i < dijLista.size(); i++) {
			if (dijLista.get(i).getEv() == 2017 && dijLista.get(i).getDijTipus().equals("irodalmi")) {
				index = i;
			}

		}

		JOptionPane.showMessageDialog(null,
				dijLista.get(index).getKersztNev() + " " + dijLista.get(index).getVezetekNev(), "4. feladat",
				JOptionPane.PLAIN_MESSAGE);

	}

	public void KilistazSzervezeteket(List<NobelDijak> dijLista) {

		StringBuilder lista = new StringBuilder();

		for (NobelDijak dijak : dijLista) {
			if (dijak.getEv() > 1990 && dijak.getVezetekNev().toLowerCase().equals("szervezet")) {
				lista.append(dijak.toString() + "\n");
			}
		}

		ListazoAblak ujAblak = new ListazoAblak(lista);
		ujAblak.setVisible(true);

	}

	public void KilistazCsaladTagokat(List<NobelDijak> dijLista) {

		StringBuilder lista = new StringBuilder();

		for (NobelDijak dijak : dijLista) {
			if (dijak.getVezetekNev().toLowerCase().contains("curie")) {
				lista.append(dijak.getEv() + ": " + dijak.getKersztNev() + " " + dijak.getVezetekNev() + " ("
						+ dijak.getDijTipus() + ")\n");
			}
		}

		ListazoAblak ujAblak = new ListazoAblak(lista);
		ujAblak.setTitle("6. feladat");
		ujAblak.setVisible(true);

	}

	public void DijTipustSzamol(List<NobelDijak> dijLista) {

		Map<String, Integer> dijTipusok = new HashMap<String, Integer>();

		for (NobelDijak dijak : dijLista) {
			dijTipusok.put(dijak.getDijTipus(), 0);
		}

		for (NobelDijak dijak : dijLista) {
			for (Map.Entry<String, Integer> dijTipus : dijTipusok.entrySet()) {

				if (dijak.getDijTipus().equals(dijTipus.getKey())) {
					dijTipus.setValue((dijTipus.getValue() + 1));
				}
			}
		}

		StringBuilder lista = new StringBuilder();

		dijTipusok.entrySet().stream().forEach(k -> lista.append(k.getKey() + " " + k.getValue() + " db\n"));

		ListazoAblak ujAblak = new ListazoAblak(lista);
		ujAblak.setTitle("7. feladat");
		ujAblak.setVisible(true);

	}

}
