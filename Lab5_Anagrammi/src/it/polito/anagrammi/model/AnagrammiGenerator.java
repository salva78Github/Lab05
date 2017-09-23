package it.polito.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

public class AnagrammiGenerator {

	Set<String> solutions = new HashSet<String>();

	public Set<String> findAnagrammi(String word) {

		int level = 0;
		Lettera[] soluzioneParziale = new Lettera[word.length()];
		recursive(word, level, soluzioneParziale);

		return solutions;
	}

	private void recursive(String word, int level, Lettera[] soluzioneParziale) {

		if (level == word.length()) {

			String solution = toString(soluzioneParziale);
			solutions.add(solution);
			return;
		}

		for (int i = 0; i < word.length(); i++) {
			Lettera l = new Lettera(word.charAt(i), i);
			if (!contains(soluzioneParziale, l)) {
				soluzioneParziale[level] = l;
				// System.out.println("<recursive> soluzioneParziale: " +
				// soluzioneParziale);

				recursive(word, level + 1, soluzioneParziale);

				soluzioneParziale[level] = null;

			}

		}

	}

	private String toString(Lettera[] soluzioneParziale) {
		StringBuffer anagramma = new StringBuffer();
		for (int i = 0; i < soluzioneParziale.length; i++) {
			anagramma.append(soluzioneParziale[i].getValore());
		}
		return anagramma.toString();
	}

	private boolean contains(Lettera[] soluzioneParziale, Lettera lettera) {
		// TODO Auto-generated method stub

		for (int j = 0; soluzioneParziale[j] != null && j < soluzioneParziale.length; j++) {
			if (soluzioneParziale[j].equals(lettera)) {
				return true;
			}
		}

		return false;

	}

}
