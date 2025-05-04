package edu.frcc.csc1061jsp25.GettingToPhilosophy;

import java.io.IOException;

public class WikiTest {

	public static void main(String[] args) {
		// Start from Java Wikipedia page
		String start = "https://en.wikipedia.org/wiki/Java_(programming_language)";
		String goal = "https://en.wikipedia.org/wiki/Philosophy";

		try {
			// Clear the visited list to start fresh
			WikiPhilosophy.visited.clear();

			// Run the main logic with a limit of 15 steps
			WikiPhilosophy.testConjecture(goal, start, 15);

			// Print out the path that was followed
			System.out.println("\nPages Visited");
			for (String page : WikiPhilosophy.visited) {
				System.out.println(page);
			}

			// Final result check
			if (WikiPhilosophy.visited.contains(goal)) {
				System.out.println("\nIt worked");
			} else {
				System.out.println("\nDid not work");
			}

		} catch (IOException e) {
			System.out.println("Can't connect to Wikipedia.");
			e.printStackTrace();
		}

		System.out.println("End of Test");
	}

}
