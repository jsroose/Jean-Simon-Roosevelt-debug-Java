package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	ISymptomReader reader;
	ISymptomWriter writer;

	/**
	 * 
	 * @param reader objet contenant une instance de la classe ReadSymptomDataFromFile
	 * 
	 * @param writer objet contenant une instance de la classe WriteSymptomDataToFile
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer)
	{
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * 
	 * récupère une liste de symptomes à partir d'un fichier
	 * 
	 * @return une liste de tous les symptomes obtenus à partir d'un fichier
	 */
	public List<String> getSymptoms() throws Exception {

		List<String> result = new ArrayList<String>();
		result = reader.getSymptoms();

		return result;
	}

	/**
	 *
	 * compte le nombre d'occurence de chaque symptomes à partir  d'une liste de symptomes
	 * passée en parmètre
	 * 
	 * @param symptoms liste de symptomes
	 * 
	 * @return un dictionnaire contenant une liste de symptomes
	 *         avec le nombre d'occurence de chaque symptomes
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomsCount = new HashMap<String, Integer>();

		symptoms.forEach((e) -> {
			if (!symptomsCount.containsKey(e)) {
				symptomsCount.put(e, 0);
			}
		});

		for (String i : symptomsCount.keySet()) {

			symptoms.forEach((e) -> {
				if (e.equals(i)) {
					symptomsCount.replace(e, symptomsCount.get(e)+1);
				}
			});
		}

		return symptomsCount;
	}

	/**
	 *
	 * trie les symptomes fournis via un dictionnaire
	 * 
	 * @param symptoms dictionnaire contenant une liste de symptomes et leur nombre d'occurence
	 * 
	 * @return un dictionnaire contnant une liste de symptomes triés par ordre alphabétique
	 *         avec le nombre d'occurence de chaque symptomes
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

		TreeMap<String, Integer> symptomsSorted = new TreeMap<String, Integer>(symptoms);

		return symptomsSorted;
	}

	/**
	 *
	 * sauvegarde la liste de symptomes ordonnés ainsi que leur nombre d'ocurrence dans un fichier
	 * 
	 * @param symptoms dictionnaire contenant une liste de symptomes triés par ordre alphabétique
	 *        et leur nombre d'occurence
	 *        
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

}
