package com.ex.recyclerviewdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Vo.Person;
import adapter.MyAdapter;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {


    @InjectView(R.id.btn)
    Button mbtn;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Person> persons;
    private MyAdapter myAdapter;
    private Context mContext;
    private Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mContext=this;
        mRecyclerView=(RecyclerView) findViewById(R.id.my_recycler_view);

        mBitmap=BitmapFactory.decodeResource(getResources(), R.drawable.drawable1);

        // Get the color using palette
//        Palette palette = Palette.generate(mBitmap);
//        Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
//        Palette.Swatch vibrantLightSwatch = palette.getLightVibrantSwatch();
//        Palette.Swatch vibrantDarkSwatch = palette.getDarkVibrantSwatch();z
//        Palette.Swatch mutedSwatch = palette.getMutedSwatch();
//        Palette.Swatch mutedLightSwatch = palette.getLightMutedSwatch();
//        Palette.Swatch mutedDarkSwatch = palette.getDarkMutedSwatch();

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        initializeData();
        myAdapter=new MyAdapter(persons, mContext);
        mRecyclerView.setAdapter(myAdapter);


//        mRecyclerView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int itemPosition=mRecyclerView.getChildPosition(v);
//                Person item=persons.get(itemPosition);
//                Toast.makeText(mContext, item.name, Toast.LENGTH_LONG).show();
//            }
//        });

    }

    @OnClick(R.id.btn)public void clickButterKnife()
    {
        Toast.makeText(this, "Butterknife testing", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    // This method creates an ArrayList that has three Person objects
    // Checkout the project associated with this tutorial on Github if
    // you want to use the same images.
    private void initializeData() {
        persons=new ArrayList<Person>();
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.person));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.person));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.person));
    }
}

