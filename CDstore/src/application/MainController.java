package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainController {

	@FXML
	private TextField titleText;
	@FXML
	private TextField artistText;
	@FXML
	private TextField yearText;
	@FXML
	private TextField songText;

	@FXML
	private Button makeCD;
	@FXML
	private Button addSong;
	@FXML
	private Button saveCD;

	@FXML
	private ListView<String> currentCDList;

	@FXML
	private ListView<String> CDSAdded;

	ArrayList<CD> cdList = new ArrayList<>();

	public void makeCDClick(ActionEvent event){
		CD newCD = new CD(titleText.getText(), artistText.getText(), yearText.getText());
		cdList.add(newCD);
		currentCDList.getItems().add("Title: " + titleText.getText());
		currentCDList.getItems().add("Artist: " + artistText.getText());
		currentCDList.getItems().add("Year: " + yearText.getText());
	}

	public void addSongClick(ActionEvent event){
		cdList.get(cdList.size()-1).setSong(songText.getText());
		currentCDList.getItems().add("Added Song: " + songText.getText());
		songText.clear();
	}
	public void saveCDClickClick(ActionEvent event){
		printArray(cdList);
		addToSecondTab();
		currentCDList.getItems().clear();
	}

	public void addToSecondTab(){
		CDSAdded.getItems().add(cdList.get(cdList.size()-1).mainString());
	}

	public void printArray(ArrayList<CD> cdList){

		String fileName = "CDS.csv";
		File sourceFile = new File(fileName);

		titleText.clear();
		artistText.clear();
		yearText.clear();

		if(!sourceFile.exists()){
			try {
				PrintWriter writer = new PrintWriter(fileName);
				writer.println(cdList.get(cdList.size()-1).toString());
				writer.close();
			}

			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		else{
			try {
				PrintWriter writer = new PrintWriter("temporary.csv");
				Scanner input = new Scanner(sourceFile);
				while(input.hasNext()){
					String copyString = input.nextLine();
					writer.println(copyString);
				}
				writer.println(cdList.get(cdList.size()-1).toString());

				File newFile = new File("temporary.csv");
				sourceFile.delete();
				newFile.renameTo(new File(fileName));

				input.close();
				writer.close();
			}

			catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}

	}
}
