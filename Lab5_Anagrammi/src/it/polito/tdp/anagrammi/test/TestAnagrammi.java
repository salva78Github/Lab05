package it.polito.tdp.anagrammi.test;

import java.util.Set;

import it.polito.tdp.anagrammi.model.AnagrammiGenerator;

public class TestAnagrammi {

	public static void main(String[] args) {

		String word = "dipace";

		AnagrammiGenerator ag = new AnagrammiGenerator();
		Set<String> solutions = ag.findAnagrammi(word);

		for (String l : solutions) {
			System.out.println("<anagramma> " + l);
		}
	}

}
