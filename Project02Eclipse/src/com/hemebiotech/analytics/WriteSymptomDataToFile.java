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

		// next generate output
		// FileWriter writer = new FileWriter ("result.out");
		// writer.write("headache: " + "" + "\n");
		// writer.write("rash: " + "" + "\n");
		// writer.write("dialated pupils: " + "" + "\n");
		// writer.close();
	}

}
