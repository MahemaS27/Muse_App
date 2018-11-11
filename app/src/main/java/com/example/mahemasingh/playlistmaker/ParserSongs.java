package com.example.mahemasingh.playlistmaker;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

//parses the songs
public class ParserSongs {

    ArrayList<Song> universe;
    FileReader reader;


    public ParserSongs(String fileName){

        this.universe = new ArrayList<Song>();

        try {
            this.reader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("could not find file.");
        }
    }


    public ArrayList<Song> parse() {
        Scanner scanner = new Scanner(reader);


        //skip the first line
        scanner.nextLine();


        while (scanner.hasNextLine()) {

            //start parsing data
            parseline(scanner.nextLine());

        }
        return universe;

    }

    //parses line by line
    private void parseline(String s) {

        Scanner scanner = new Scanner(s);
        scanner.useDelimiter(",");

        String name = scanner.next();
        String artist = scanner.next();
        String id = scanner.next();
        Double danceability = Double.parseDouble(scanner.next());
        Double energy = Double.parseDouble(scanner.next());
        Double speechiness = Double.parseDouble(scanner.next());
        Double acousticness = Double.parseDouble(scanner.next());
        Double instrumentalness = Double.parseDouble(scanner.next());
        Double liveness = Double.parseDouble(scanner.next());
        Double tempo = Double.parseDouble(scanner.next());
        Double valence = Double.parseDouble(scanner.next());


        ArrayList<Song> tags = new ArrayList<>();

        Song songtoAdd = new Song(name, artist, id, danceability, energy, speechiness, acousticness, instrumentalness, liveness, tempo, valence);

        universe.add(songtoAdd);


    }

    }
