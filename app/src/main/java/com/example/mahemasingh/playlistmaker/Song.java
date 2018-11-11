package com.example.mahemasingh.playlistmaker;

//a song object
public class Song {

    String title;
    String artist;
    String id;
    double [] vector;



  protected Song (String title, String artist, String id, double danceability, double energy,  double speechiness,
          double acousticness, double instrumental, double liveness, double tempo, double valence) {




        this.title = title;
        this.artist = artist;
        this.id = "spotify:track:" + id;

        this.vector = new double[]{danceability,  energy,   speechiness,  acousticness,
                instrumental,  liveness, tempo, valence, 1,1, 1, 1, 1,1, 1, 1};
    }


    @Override
    public String toString() {
        return title + ", by" +
                ", " + artist + "\n" ;
    }

    //constucotr for the main class
    public Song(){
        this.title = "none";
        this.artist = "none";
        this.id = "spotify:track:";

        this.vector = null;

    }

    //Setter methods from the main

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVector(double danceability, double energy,  double speechiness,
                          double acousticness, double instrumental, double liveness, double tempo, double valence) {
        this.vector = new double[]{danceability,  energy,   speechiness,  acousticness,
                instrumental,  liveness, tempo, valence, 1,1, 1, 1, 1,1, 1, 1};
    }




    //determine the difference value that we will use to pick playlists
   public double findDifference(double [] other){

      double ave = 0;

      for(int i = 0; i<8 ; i+=1){


          ave += ((Math.abs(other[i]-this.vector[i])) * other[i+8]);

          System.out.println("Song name: " + this.title+ " Difference: " + (Math.abs(other[i]-this.vector[i]))+ "  times weight " + other[i+8]);



          //System.out.println ("difference: " + (Math.abs(other[i]-this.vector[i])) + " times weight : " + other[i+1]);

          //System.out.println (title + " ave : " + (Math.abs(other[i]-this.vector[i])) * other[i+1]);


      }

      ave = ave/8;
      return ave;
    }


}
