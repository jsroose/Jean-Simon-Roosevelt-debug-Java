package com.hemebiotech.analytics;
 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.util.Map;
import java.util.HashMap;

/**
 * Simple brute force implementation
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
	
	/**
	 * 
	 * sauvegarde la liste de symptomes ordonnés ainsi que leur nombre d'ocurrence dans un fichier
	 * 
	 * @param symptoms est un dictionnaire contnant la liste des symptomes d'un fichier triés par
	 *        ordre alphabétique avec le nombre d'occurence dans le fichier
	 */

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {

		try {
			FileWriter writer = new FileWriter ("result.out");
			
			for (String i : symptoms.keySet()) {
				writer.write( i + ": " + symptoms.get(i) + "\n");
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
