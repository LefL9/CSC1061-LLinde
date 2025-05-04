package edu.frcc.csc1061jsp25.SentimentAnalysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SentimentAnalysis {
	public static void main(String[] args) {
		MyHashMap<String, Integer> sentimentMap = new MyHashMap<>();

		// Load from file
		try (Scanner fileScanner = new Scanner(new File("sentiments.txt"))) {
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] parts = line.split(",");
				if (parts.length == 2) {
					String phrase = parts[0].trim().toLowerCase();
					int score = Integer.parseInt(parts[1].trim());
					sentimentMap.put(phrase, score);

				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Sentiment file not found.");
			return;
		}

		// Read input from user
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Enter text:");
		StringBuilder userInput = new StringBuilder();
		while (true) {
		    String line = inputScanner.nextLine().trim();
		    if (line.equalsIgnoreCase("end")) break;  // check before adding
		    if (userInput.length() > 0) {
		        userInput.append(" ");
		    }
		    userInput.append(line);
		}

		// Clean the input
		String[] words = userInput.toString().replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

		int totalWords = 0;
		int totalSentiment = 0;
		String prevWord = "";

		for (String word : words) {
			totalWords++;

			// Check for two-word phrase
			String phrase = prevWord + " " + word;
			if (!prevWord.isEmpty() && sentimentMap.containsKey(phrase)) {
				totalSentiment += sentimentMap.get(phrase);
			} else if (sentimentMap.containsKey(word)) {
				totalSentiment += sentimentMap.get(word);
			}

			prevWord = word;
		}

		// Calculate average sentiment
		double avgSentiment = (totalWords > 0) ? (double) totalSentiment / totalWords : 0.0;

		// Print results
		System.out.println("\nWords: " + totalWords);
		System.out.println("Sentiment: " + totalSentiment);
		System.out.printf("Overall: %.2f\n", avgSentiment);
	}
}