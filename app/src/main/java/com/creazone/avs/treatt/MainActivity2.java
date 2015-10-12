package com.creazone.avs.treatt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    String[] treats = new String[] {
            "Burger",
            "Pizza",
            "Sandwich",
            "Grilled Chicken",
            "Hot Dog",
            "Chicken Biriyani",
            "Masala Dosa",
            "Full Meal",
            "Mega Fried Chicken",
            "Chicken Wings"
    };

    int[] price = new int[]{
            75,
            250,
            50,
            400,
            70,
            120,
            60,
            50,
            400,
            300
    };

    int[] flags = new int[]{
            R.drawable.img,
            R.drawable.img,
            R.drawable.img,
            R.drawable.img,
            R.drawable.img,
            R.drawable.img,
            R.drawable.img,
            R.drawable.img,
            R.drawable.img,
            R.drawable.img
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String shop = getIntent().getStringExtra("shops");
        setTitle(shop);
        getSupportActionBar().setIcon(R.drawable.img);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<10;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("trt", treats[i]);
            hm.put("prc" , Integer.toString(price[i]) + " " + "₹");
            hm.put("flag", Integer.toString(flags[i]) );
            aList.add(hm);
        }
        String[] from = { "flag","trt","prc" };

        // Ids of views in listview_layout
        int[] to = { R.id.flag2,R.id.trt,R.id.prc};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_layout2, from, to);

        // Getting a reference to listview of main.xml layout file
        ListView listView = ( ListView ) findViewById(R.id.listview2);

        // Setting the adapter to the listView
        listView.setAdapter(adapter);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View container, int position, long id) {

                Intent intent = new Intent(MainActivity2.this, ContactsActivity.class);
                startActivity(intent);
//                // Getting the Container Layout of the ListView
//                LinearLayout linearLayoutParent = (LinearLayout) container;
//
//                // Getting the inner Linear Layout
//                LinearLayout linearLayoutChild = (LinearLayout ) linearLayoutParent.getChildAt(1);
//
//                // Getting the Country TextView
//                TextView tvCountry = (TextView) linearLayoutChild.getChildAt(0);
//
//                Toast.makeText(getBaseContext(), tvCountry.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        };

        // Setting the item click listener for the listview
        listView.setOnItemClickListener(itemClickListener);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}