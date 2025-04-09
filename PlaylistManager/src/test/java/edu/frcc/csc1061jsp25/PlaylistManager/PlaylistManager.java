package edu.frcc.csc1061jsp25.PlaylistManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PlaylistManager {

	private static Scanner scanner = new Scanner(System.in);
	private static MyDoubleLinkedList<Song> playlist = new MyDoubleLinkedList<>();
	private static Random rand = new Random();

	public static void main(String[] args) {

		System.out.println(" *** Playlist Manager! ***");
		System.out.println("Commands:\nadd\nremove\ncount\nplay\nshuffle\nreverse\nsave\nload\nquit");

		while (true) {
			System.out.print(": ");
			String command = scanner.nextLine();

			switch (command) {
			case "add":
				addSong();
				break;
			case "remove":
				removeSong();
				break;
			case "count":
				System.out.println(playlist.size());
				break;
			case "play":
				playlist.printList();
				break;
			case "reverse":
				playlist.reverse();
				break;
			case "shuffle":
				shufflePlaylist();
				break;
			case "save":
				saveToFile();
				break;
			case "load":
				loadFromFile();
				break;
			case "quit":
				return;
			default:
				System.out.println("Unknown command. Try again.");
			}
		}
	}

	private static void addSong() {
		System.out.print("Enter artist: ");
		String artist = scanner.nextLine();
		System.out.print("Enter title: ");
		String title = scanner.nextLine();
		playlist.add(new Song(artist, title));
	}

	private static void removeSong() {
		System.out.print("Enter artist: ");
		String artist = scanner.nextLine();
		System.out.print("Enter title: ");
		String title = scanner.nextLine();
		boolean removed = playlist.remove(new Song(artist, title));
		if (!removed) {
			System.out.println("Song not found.");
		}
	}

	private static void shufflePlaylist() {
		List<Song> temp = new ArrayList<>();
		for (Object obj : playlist.toArray()) {
			temp.add((Song) obj);
		}

		Collections.shuffle(temp, rand);
		playlist.clear();
		for (Song s : temp) {
			playlist.add(s);
		}
	}

	private static void saveToFile() {
		System.out.print("Enter file: ");
		String filename = scanner.nextLine();

		try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
			for (Object obj : playlist.toArray()) {
				Song song = (Song) obj;
				writer.println(song.getArtist() + "|" + song.getTitle());
			}
			System.out.println("Playlist saved.");
		} catch (IOException e) {
			System.out.println("Error saving file.");
		}
	}

	private static void loadFromFile() {
		System.out.print("Enter file: ");
		String filename = scanner.nextLine();

		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			playlist.clear();
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split("\\|");
				if (parts.length == 2) {
					playlist.add(new Song(parts[0], parts[1]));
				}
			}
			System.out.println("Playlist loaded.");
		} catch (IOException e) {
			System.out.println("Error loading file.");
		}

	}
}