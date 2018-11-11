package com.example.mahemasingh.playlistmaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class MainPage extends AppCompatActivity {

    static public ArrayList<TouristLocation> locations = new ArrayList<>();
    static public ArrayList<Song> universe = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


         readLocationData();
         readSongData();



        Button btn = (Button)findViewById(R.id.searchButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPage.this, LocationSearch.class));
            }
        });









    }

    //read the song data
    private void readSongData(){
        InputStream locationInput = getResources().openRawResource(R.raw.songs);
        BufferedReader songReader = new BufferedReader(new InputStreamReader(locationInput,Charset.forName("UTF-16") ));

        String line = "";

        try {

            //step over headers
            songReader.readLine();

            while ((line = songReader.readLine()) != null) {

                //Split by commas

                String[] tokens = line.split(",");

                //read the data
                Song songToAdd = new Song();
                double [] vector;

                songToAdd.setTitle(tokens[0]);
                songToAdd.setArtist(tokens[1]);
                songToAdd.setId("spotify:track:"+tokens[2]);

                //save all the values for the vector

                double dancebility = Double.parseDouble(tokens[3]);
                double energy = Double.parseDouble(tokens[4]);
                double speechiness = Double.parseDouble(tokens[5]);
                double acousticness = Double.parseDouble(tokens[6]);
                double instrumentalness = Double.parseDouble(tokens[7]);
                double liveness = Double.parseDouble(tokens[8]);
                double tempo = Double.parseDouble(tokens[9]);
                double valence = Double.parseDouble(tokens[10]);

                //make the vector
                songToAdd.setVector(dancebility, energy, speechiness, acousticness, instrumentalness, liveness, tempo, valence);

                //add the song to the universe
                universe.add(songToAdd);

            }
            for (Song s: universe){
                System.out.println(s.toString());
            }
        }
        catch(IOException e){
            throw new IllegalArgumentException("Error reading in data file.");

        }
    }




    //read the location data
    private void readLocationData() {
        InputStream locationInput = getResources().openRawResource(R.raw.locations);
        BufferedReader locationReader = new BufferedReader(new InputStreamReader(locationInput,Charset.forName("UTF-8") ));

        String line = "";

        try {

            //step over headers
            locationReader.readLine();

            while ((line = locationReader.readLine()) != null) {

                //Split by commas

                String[] tokens = line.split(",");

                //read the data
                TouristLocation locationToAdd = new TouristLocation();
                EnumIf enumIf = new EnumIf();
                ArrayList<Tag> tags = new ArrayList<>();

                locationToAdd.setName(tokens[0]);
                locationToAdd.setLatitude(Double.parseDouble(tokens[1]));
                locationToAdd.setLongitude(Double.parseDouble(tokens[2]));
                tags.add((enumIf.enumIf(tokens[3])));
                locationToAdd.setTags(tags);
                locationToAdd.setAverageVector();

                //add the made location to the list of available locations
                locations.add(locationToAdd);

            }
            for (TouristLocation t: locations){
                System.out.println(t.toString());
            }
        }
        catch(IOException e){
            throw new IllegalArgumentException("Error reading in data file.");

        }
    }


}
