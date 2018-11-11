package com.example.mahemasingh.playlistmaker;

//for comparing songs via the diff of specific tag
public class SpecificSong implements Comparable<SpecificSong> {

    Song song;
    double diff;

    public SpecificSong (Song song, double[] averageVect){
        this.song = song;
        diff = song.findDifference(averageVect);
    }





    @Override
    public int compareTo(SpecificSong o) {

        if( this.diff > o.diff ){
            return 1;
        }

        if(this.diff < o.diff){
            return -1;
        }

        else {
            return 0;
        }

    }
}
