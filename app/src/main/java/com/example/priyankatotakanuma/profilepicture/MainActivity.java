package com.example.priyankatotakanuma.profilepicture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView list = null;
    private ArrayList<String> names;
    private ArrayList<Integer> imageUrls;
    private ProfilePicAdapter profilePicAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView) findViewById(R.id.list);
        names = new ArrayList<>();
        imageUrls = new ArrayList<>();

       // imageUrls.add(R.drawable.industry_offerings_symbol);
        imageUrls.add(R.drawable.news_symbol);
        imageUrls.add(R.drawable.pdf_symbol);
        imageUrls.add(R.drawable.ic_launcher);

     //   names.add("Monarch");
        names.add("Bat Bar");
        names.add("Knockout");
        names.add("BetaTeta");

        profilePicAdapter = new ProfilePicAdapter(MainActivity.this, names, imageUrls);
        list.setAdapter(profilePicAdapter);
    }

}
