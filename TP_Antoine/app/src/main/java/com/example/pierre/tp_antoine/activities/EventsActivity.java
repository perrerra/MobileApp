package com.example.pierre.tp_antoine.activities;


import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import com.example.pierre.tp_antoine.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import adapter.EventAdapter;
import model.Adress;
import model.Event;
import model.EventCat;
import model.Place;

public class EventsActivity extends AppCompatActivity {
    ListView mListView;
    EventCat ecJeuxPleinAir = new EventCat("Jeux de plein air");
    EventCat ecSoiree = new EventCat("Soirée");
    Adress aThabor = new Adress("", "Rennes", "", 48.1446522,-1.6902588);
    Adress aMalibu = new Adress("", "Ibiza", "", 34.0293977,-118.8472586);
    Place pThabor = new Place("Thabor", aThabor, 1000);
    Place pMalibu= new Place("Malibu", aMalibu, 200);

    /* ---- Drawer --- */
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    Button btnEvents;
    Button btnProfile;
    Button btnLogout;

    /* ----------------*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        LoadDrawer();

        mListView = (ListView) findViewById(R.id.listView);
        List<Event> events = genererEvents();
        EventAdapter adapter = new EventAdapter(EventsActivity.this, events);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(EventsActivity.this, DetailEventActivity.class));
            }
        });
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(EventsActivity.this, MapsActivity.class));
                return true;
            }
        });
    }


    private List<Event> genererEvents(){
        List<Event> events = new ArrayList<Event>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try{
            events.add(new Event("Chat perche", simpleDateFormat.parse("12/04/2017"), ecJeuxPleinAir, pThabor));
            events.add(new Event("Soirée karaoké", simpleDateFormat.parse("12/04/2017"), ecSoiree, pMalibu));
            events.add(new Event("Chat perche", simpleDateFormat.parse("12/04/2017"), ecJeuxPleinAir, pThabor));
            events.add(new Event("Soirée karaoké", simpleDateFormat.parse("12/04/2017"), ecSoiree, pMalibu));
            events.add(new Event("Chat perche", simpleDateFormat.parse("12/04/2017"), ecJeuxPleinAir, pThabor));
            events.add(new Event("Soirée karaoké", simpleDateFormat.parse("12/04/2017"), ecSoiree, pMalibu));
            events.add(new Event("Chat perche", simpleDateFormat.parse("12/04/2017"), ecJeuxPleinAir, pThabor));
            events.add(new Event("Soirée karaoké", simpleDateFormat.parse("12/04/2017"), ecSoiree, pMalibu));
            events.add(new Event("Chat perche", simpleDateFormat.parse("12/04/2017"), ecJeuxPleinAir, pThabor));
            events.add(new Event("Soirée karaoké", simpleDateFormat.parse("12/04/2017"), ecSoiree, pMalibu));
            events.add(new Event("Chat perche", simpleDateFormat.parse("12/04/2017"), ecJeuxPleinAir, pThabor));
            events.add(new Event("Soirée karaoké", simpleDateFormat.parse("12/04/2017"), ecSoiree, pMalibu));
            events.add(new Event("Chat perche", simpleDateFormat.parse("12/04/2017"), ecJeuxPleinAir, pThabor));
            events.add(new Event("Soirée karaoké", simpleDateFormat.parse("12/04/2017"), ecSoiree, pMalibu));
            events.add(new Event("Chat perche", simpleDateFormat.parse("12/04/2017"), ecJeuxPleinAir, pThabor));
            events.add(new Event("Soirée karaoké", simpleDateFormat.parse("12/04/2017"), ecSoiree, pMalibu));
        }catch(ParseException e){
            e.printStackTrace();
        }
        return events;
    }
    /* ----------- Drawer Menu ------------- */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // synchroniser le drawerToggle après la restauration via onRestoreInstanceState
        drawerToggle.syncState();
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    private void LoadDrawer(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        //definir notre toolbar en tant qu'actionBar
        setSupportActionBar(toolbar);

        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        this.drawerToggle = new ActionBarDrawerToggle(this,this.drawerLayout,0,0);
        this.drawerLayout.addDrawerListener(this.drawerToggle);

        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.login, R.string.password) {

                public void onDrawerClosed(View view) {
                    supportInvalidateOptionsMenu();
                    //drawerOpened = false;
                }

                public void onDrawerOpened(View drawerView) {
                    supportInvalidateOptionsMenu();
                    //drawerOpened = true;
                }
            };
            drawerToggle.setDrawerIndicatorEnabled(true);
            drawerLayout.addDrawerListener(drawerToggle);
            drawerToggle.syncState();
        }

        btnEvents = (Button) findViewById(R.id.btnEvents);
        btnProfile = (Button) findViewById(R.id.btnProfile);
        btnLogout = (Button) findViewById(R.id.btnLogout);


        btnEvents.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    startActivity(new Intent(EventsActivity.this, EventsActivity.class));
                }
        });
        btnProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(EventsActivity.this, ProfileActivity.class));
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(EventsActivity.this, LoginActivity.class));
            }
        });

    }

    /* ----------------------------------------- */

}
