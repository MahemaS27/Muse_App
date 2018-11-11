package com.example.mahemasingh.playlistmaker;


//parse input from csv


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ParserLocation {

ArrayList<TouristLocation> parseLocations;
FileReader reader;


public ParserLocation(String fileName){

    this.parseLocations = new ArrayList<TouristLocation>();

    try {

        File file = new File(fileName);
        this.reader = new FileReader(file);
    } catch (FileNotFoundException e) {
        throw new IllegalArgumentException("could not find file.");
    }
}


public ArrayList<TouristLocation> parse() {
    Scanner scanner = new Scanner(reader);


    //skip the first line
    scanner.nextLine();


    while (scanner.hasNextLine()) {

        //start parsing data
        parseline(scanner.nextLine());

    }
    return parseLocations;

}

//parses line by line
    private void parseline(String s) {

    EnumIf enumIf = new EnumIf();
    Scanner scanner = new Scanner(s);
    scanner.useDelimiter(",");

    String name = scanner.next();
    double lat =  Double.parseDouble(scanner.next());
    double longit = Double.parseDouble(scanner.next());
    String tagName = scanner.next();


    ArrayList<Tag> tags =  new ArrayList<>();

    Tag tagtoAdd = enumIf.enumIf(tagName);

    tags.add(tagtoAdd);


    TouristLocation touristAdd = new TouristLocation(name, lat, longit, tags);

    parseLocations.add(touristAdd);

    }


}
