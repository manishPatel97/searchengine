package com.example.dell.searchengine;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toolbar;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MaterialSearchView searchView;
    ListView listview;
    String [] list = {"Manish","jack","chicken" ," chekh"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.widget.Toolbar toolbar =  (findViewById(R.id.toolbar));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Search Category");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
         searchView = findViewById(R.id.searchview);
        listview = findViewById(R.id.listview);
         searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {

             @Override
             public boolean onQueryTextSubmit(String query) {
                 return false;
             }

             @Override
             public boolean onQueryTextChange(String newText) {
                 if(newText!=null && !newText.isEmpty()){
                     System.out.println("mother fucker");
                     List<String> listfound = new ArrayList<String>();
                     for(String item:list){
                         if(item.toLowerCase().contains(newText.toLowerCase())){
                             listfound.add(item);
                         }
                     }
                     ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,listfound);
                     listview.setAdapter(adapter);
                 }else{
                        System.out.println("fuck you");
                 }
                 return false;
             }
         });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        return true;

    }
}
