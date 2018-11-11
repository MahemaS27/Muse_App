package com.example.mahemasingh.playlistmaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class SearchableActivity extends AppCompatActivity {

   public  ArrayList<Song> playlist;
   public ArrayList<String> playlistStrings;

   @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        System.out.println("Created");

        String searchField = "";

        Bundle b = getIntent().getExtras();

        if (b != null) {
            searchField = b.getString("searchField");
        }


        setContentView(R.layout.search);


        System.out.println("search field: " + searchField);


            //String query = intent.getStringExtra(SearchManager.ACTION_KEY);
            doMySearch(searchField);
            System.out.println("playlist size " + this.playlist.size());

            makeString();

            System.out.println("strings size " + this.playlistStrings.size());

         Intent myintent = new Intent(SearchableActivity.this, PlaylistView.class);
         Bundle b2 = new Bundle();
         b2.putStringArrayList("playlist", playlistStrings);
             myintent.putExtras(b2);
            startActivity(myintent);


    }

    private void makeString() {
       ArrayList<String> stringarr = new ArrayList<>();

       for (Song s : this.playlist) {
           stringarr.add(s.toString());
       }

       this.playlistStrings = stringarr;
    }

    private void doMySearch(String query) {

        //use universe and locations
        System.out.println("starting " + query);
        String fix = query.trim();
        for (TouristLocation touristLocation : MainPage.locations ){
            System.out.println(touristLocation.name);
            if (touristLocation.name.equalsIgnoreCase(fix)){
                System.out.println("found it!");

               playlist = touristLocation.pickPlaylist(MainPage.universe, 10);
               return;
            }
        }

        if (playlist == null) {
            System.out.println("universe " + MainPage.universe.size());
        }

    }


}
