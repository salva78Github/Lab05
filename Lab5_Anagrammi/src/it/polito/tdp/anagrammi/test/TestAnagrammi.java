package it.polito.tdp.anagrammi.test;

import java.util.Set;

import it.polito.tdp.anagrammi.exception.AnagrammiException;
import it.polito.tdp.anagrammi.model.AnagrammiGenerator;

public class TestAnagrammi {

	public static void main(String[] args) {

		String word = "noce";

		AnagrammiGenerator ag = new AnagrammiGenerator();
		Set<String> solutions = ag.findAnagrammi(word);
		
		boolean isCorrect;
		for (String l : solutions) {
			System.out.println("<anagramma> " + l);
			try {
				isCorrect = ag.isCorrect(l);
				System.out.println("<anagramma corretto > " + (isCorrect?"SI'":"NO"));
			} catch (AnagrammiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
