package com.example.mahemasingh.playlistmaker;

import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.Collections;

public class TouristLocation {

    //whenever we add a location construct one of these
    String name;
    double latitude;
    double longitude;
    ArrayList<Tag> tags;
    double[] averageVector;


    public TouristLocation(String name, double latitude, double longitude, ArrayList<Tag> tags) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tags = tags;
        this.averageVector = getAverage();
    }


    @Override
    public String toString() {
        return "TouristLocation{" +
                "name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    //constructor for main method purposes
    public TouristLocation(){
        this.name = "default";
        this.latitude = 0;
        this.longitude = 0;
        this.tags = new ArrayList<Tag>();
        this.averageVector = null;
    }


    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public void setAverageVector() {
        this.averageVector = getAverage();
    }


    public void setName(String name) {
        this.name = name;
    }

    // gets the average of value for the tags that we have
    //still in vector form
    public double[] getAverage() {
        double[] result = new double[18];


        for (int i = 0; i < 16; i+=2) {


            double ave = 0;
            for (Tag t : tags) {
                ave += t.getValue()[i];


            }

            ave = ave / (tags.size());

            result[i] = ave;
            result[i+1] = tags.get(0).getValue()[i+1];

        }
        return result;
    }

    //pick a playlist
    public ArrayList<Song> pickPlaylist(ArrayList<Song> universe, int length){

        System.out.println("HELLOO");
        ArrayList<Song> result = new ArrayList<>();

        for (int i = 0; i<length; i++){
            try{
                Song song = pickSong(universe, result);
                result.add(song);
                //System.out.println("new song: "+ song.toString());
                //System.out.println(result.get(result.size()-1).title +" " +  result.get(result.size()-1).findDifference(this.averageVector));
            }
            catch(Exception e ){
                //if null return what we have so far
                System.out.println("FAILED");
                return result;
            }
        }
        return result;

    }


    //find the median of the universe to calculate the tolerance
    private double findTolerance (ArrayList<Song> universe){

       ArrayList<SpecificSong> specificSongs = new ArrayList<>();

       for (Song s : universe){
           specificSongs.add(new SpecificSong(s, this.averageVector));
       }

       //sorts th list
       Collections.sort(specificSongs);

       return specificSongs.get(specificSongs.size()/2).diff;

    }




    //picks a song
    public Song pickSong(ArrayList<Song> universe, ArrayList<Song> dontPick) {

        double minifference = 100;
        double tolerance = this.findTolerance(universe);

        //place holder
        Song song1 = null;

        for (Song s : universe) {
            //if less than min and not already picked
            double dif = s.findDifference(this.averageVector);
            if ((dif < minifference ) && (!dontPick.contains(s)) && (dif <= tolerance))  {
                minifference = dif;
                song1 = s;


            }
            System.out.println("current min song : "+ dif);

        }
        if (song1 == null){
            throw new IllegalArgumentException("song cant be null");
        }
        return song1;
    }


}


