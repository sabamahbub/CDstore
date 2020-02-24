# CDstore

A JavaFX application that allows you to store CDs in a csv file. 
Csv files separate records by commas, and can be read by spreadsheet programs. 

How it needs to work: 
A CD class with title, artist, a list of songs, and the publishing year.
A JavaFX program in which the UI has 4 text fields (one for title, one for artist, one for year, one for songs), 4 labels (one for each text field) and a three buttons (Make CD, Add Song, Save CD).
Event Handlers for the buttons (3pts for each handler): The first (Make CD), causes the program to create a new instance of CD, using information in the title, artist, and year text fields, and stores it in an ArrayList stored in the program's main class (not in the CD class). The second (Add Song), adds a song to the current CD and clears the song text field every time it is pressed. The third button (Save CD) is linked to a method (not in the CD class) that iterates through the ArrayList of CDs and prints on a new row the CD's information, then a line break. The method takes an ArrayList as a parameter and returns void. Create all needed additional methods/classes. 

It should print something like this:
Title, Artist, Year, Song 1, Song 2, . . .

Display the current CD's information in a List View in the main view as the CD is being entered. 
In a new tab in a List View, display of the CD's entered: show title, artist, and year (don't show the songs).
