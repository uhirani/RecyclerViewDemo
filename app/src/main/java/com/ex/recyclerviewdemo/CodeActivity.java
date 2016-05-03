package com.ex.recyclerviewdemo;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import Vo.Person;
import adapter.GmailAdapter;


public class CodeActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Person> persons;
    private GmailAdapter gmailAdapter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);

        mContext=this;
        mRecyclerView=(RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        initializeData();
        gmailAdapter=new GmailAdapter(persons, mContext);
        mRecyclerView.setAdapter(gmailAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_code, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id=item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Checkout the project associated with this tutorial on Github if
    // you want to use the same images.
    private void initializeData() {
        persons=new ArrayList<Person>();
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.person));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.person));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.person));
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.person));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.person));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.person));
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.person));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.person));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.person));
    }
}
