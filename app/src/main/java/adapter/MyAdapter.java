package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ex.recyclerviewdemo.CodeActivity;
import com.ex.recyclerviewdemo.R;

import java.util.List;

import Vo.Person;

/**
 * Created by Urvashi4253 on 7/29/2015.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{
    List<Person> persons;
    private Context mContext;

    public MyAdapter(List<Person> persons, Context pContext)
    {
        this.persons = persons;
        mContext = pContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        CardView cv;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;
        Context cntx;

        ViewHolder(View itemView, final Context pContext) {
            super(itemView);
            cntx = pContext;
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personAge = (TextView)itemView.findViewById(R.id.person_age);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(v == itemView)
            {
                Toast.makeText(cntx, "Visiting Card Clicked is ==>" + persons.get(getPosition()).name, Toast.LENGTH_SHORT).show();
                cntx.startActivity(new Intent(cntx, CodeActivity.class));
            }
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        // create a new view
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.my_text_view, viewGroup, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v, mContext);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i)
    {
        viewHolder.personName.setText(persons.get(i).name);
        viewHolder.personAge.setText(persons.get(i).age);
        viewHolder.personPhoto.setImageResource(persons.get(i).photoId);
    }

    @Override
    public int getItemCount()
    {
        return persons.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
