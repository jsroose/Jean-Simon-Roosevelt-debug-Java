package com.hemebiotech.analytics;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) throws Exception {
		Map<String, Integer> symptoms;
		Map<String, Integer> symptomsSorted;
		List<String> result = new ArrayList<String>();
		ISymptomReader reader = new ReadSymptomDataFromFile("com/hemebiotech/symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile();
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

		result = analyticsCounter.getSymptoms();
		symptoms = analyticsCounter.countSymptoms(result);
		symptomsSorted = analyticsCounter.sortSymptoms(symptoms);
		analyticsCounter.writeSymptoms(symptomsSorted);
	}
}
