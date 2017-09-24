package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.dao.AnagrammaDAO;
import it.polito.tdp.anagrammi.exception.AnagrammiException;

public class AnagrammiGenerator {

	private Set<String> solutions = new HashSet<String>();
	private AnagrammaDAO adao;
	
	public AnagrammiGenerator(){
		adao = new AnagrammaDAO();
	}
	
	public Set<String> findAnagrammi(String word) {

		int level = 0;
		solutions.clear();
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

	
	public boolean isCorrect(String anagramma) throws AnagrammiException {
		return adao.isCorrect(anagramma);
	}

	
}
