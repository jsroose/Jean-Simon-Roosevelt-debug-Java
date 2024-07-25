package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.HashMap;


import java.util.ArrayList;
import java.util.List;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("com/hemebiotech/symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0;	// counts headaches
		Map<String, Integer> lineMap = new HashMap<String, Integer>();
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}

		Map<String, Integer> symptoms = new HashMap<String, Integer>();

		WriteSymptomDataToFile writeSymptomDataToFile = new WriteSymptomDataToFile();
		
		writeSymptomDataToFile.writeSymptoms(symptoms);
	}
}
