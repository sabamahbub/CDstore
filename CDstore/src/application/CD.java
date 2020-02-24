package application;

import java.util.ArrayList;

public class CD {

	private String title;
	private String artist;
	private String year;
	private ArrayList<String> listOfSongs = new ArrayList<>();

	public CD(String title, String artist, String year){
		this.title = title;
		this.artist = artist;
		this.year = year;
	}

	public void setSong(String song){
		listOfSongs.add(song);
	}

	public String mainString(){
		return String.format("%s, %s, %s", title, artist, year);
	}

	public String toString(){
		if(listOfSongs.isEmpty()){
			return mainString();
		}
		else{
			String songs = "";
			for(int i = 0; i < listOfSongs.size(); i++){
				songs += listOfSongs.get(i) + ", ";
			}
			String addedString = songs.substring(0, songs.length() - 1);
			return String.format("%s, %s", mainString(), addedString);
		}
	}
}
