package com.example.mahemasingh.playlistmaker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaylistView extends AppCompatActivity {

    ArrayList<String> strings;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        System.out.print("playlist list view created");
        setContentView(R.layout.content_playlist_view);


        Bundle b = getIntent().getExtras();
        ArrayList<String> stringarr = new ArrayList<>();
        stringarr.add("test");

        System.out.println("string arr " + stringarr);

        if (b != null) {
            stringarr = b.getStringArrayList("playlist");
        }

        strings = stringarr;


        /*
        ListAdapter mAdapter;

        Bundle b = getIntent().getExtras();
        ArrayList<String> stringarr = new ArrayList<>();
        stringarr.add("test");

        System.out.println("string arr " + stringarr);

        if (b != null) {
            stringarr = b.getStringArrayList("playlist");
        }

        //progress bar

        // Create a progress bar to display while the list loads
        ProgressBar progressBar = new ProgressBar(this);
        progressBar.setLayoutParams(new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT,
                Toolbar.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
        progressBar.setIndeterminate(true);
        getListView().setEmptyView(progressBar);

        // Must add the progress bar to the root of the layout
        ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
        root.addView(progressBar);

        System.out.println("What is this: " + stringarr);

        mAdapter = new ArrayAdapter<String>(this, R.layout.content_playlist_view,
                stringarr);

        this.setListAdapter(mAdapter);


*/


    }

    @Override
    public void onStart() {
        super.onStart();

        LinearLayout lView = new LinearLayout(this);
        TextView myText= new TextView(this);
        lView.addView(myText);
        for (int i=0; i<strings.size();i++){
            myText.append(strings.get(i));
            myText.append("\n");
        }
        setContentView(lView);

    }

}
