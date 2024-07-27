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
	 * @param filepath a full or partial path to file with symptom strings in it, one per line

	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
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
