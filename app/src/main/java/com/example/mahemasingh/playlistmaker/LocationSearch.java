package com.example.mahemasingh.playlistmaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

public class LocationSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final SearchView view = findViewById(R.id.searchView);


        Button btn = (Button)findViewById(R.id.button4);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LocationSearch.this, SearchableActivity.class);
                Bundle b = new Bundle();
                b.putString("searchField", view.getQuery().toString());
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }

}
