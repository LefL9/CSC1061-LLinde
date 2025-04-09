package edu.frcc.csc1061jsp25.PlaylistManager;

public class Song {
	private String artist;
	private String title;

	public Song(String artist, String title) {
		this.artist = artist;
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Song other = (Song) obj;
	    return artist.equalsIgnoreCase(other.artist) && title.equalsIgnoreCase(other.title);
	}
	
	@Override
	public String toString() {
		return artist + " - " + title;
	}
}
