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

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer)
	{
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() throws Exception {

		List<String> result = new ArrayList<String>();
		result = reader.GetSymptoms();

		return result;
	}

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

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

	    TreeMap<String, Integer> symptomsSorted = new TreeMap<String, Integer>(symptoms);

		return symptomsSorted;
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

}
