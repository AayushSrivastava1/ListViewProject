package com.example.listviewproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.widget.AdapterView.OnItemClickListener;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    Button button;
    TextView textView;
    TextView textViewV2;
    ListView listView;
    ArrayList<Sports> list = new ArrayList<>();
    int y = -1;
    final static String check = "Here";
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(check, list);
        outState.putInt("Y!", y);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.id_adapter_text);
        textViewV2 = findViewById(R.id.id_adapter_textdesc);
        listView = findViewById(R.id.id_list);
        Sports Basketball = new Sports("Basketball", "A game played between 2 teams of 5 players where each person has to score by throwing the ball through the opponent’s hoop.", R.drawable.basketballandroidstudio);
        list.add(Basketball);
        Sports Soccer = new Sports("Soccer", "A game played between 2 teams of 11 players where each person has to score by kicking the ball through the opponent’s goal", R.drawable.soccerandroidstudio);
        list.add(Soccer);
        Sports Tennis = new Sports("Tennis", "A racket game played between two teams of either 1 person or 2 people where each team’s purpose is to keep hitting the ball to the other side until the ball hits out of bounds", R.drawable.tennisandroidstudio);
        list.add(Tennis);
        Sports Baseball = new Sports("Baseball", "A bat-and-ball game played between two teams who take turns batting and fielding.  The players on the batting hit the ball with the bat and the players on the fielding have to try to catch the ball and tag the player out  ", R.drawable.baseballandroidstudio);
        list.add(Baseball);
        Sports Cricket = new Sports("Cricket", "A bat-and-ball game played between two teams of eleven players on a field at the center in which one team that is batting tries to score runs while the fielding team tries to prevent this by either hitting the wickets or tag the person", R.drawable.cricketandroidstudio);
        list.add(Cricket);
        Sports Football = new Sports("Football", "A game that involves 2 teams of 11 players in which one team has to hold the ball and try to score a touchdown on the opposite side of the field and the other team has to prevent this from occurring", R.drawable.footballandroidstudio);
        list.add(Football);
        if(savedInstanceState!=null) {
            list = savedInstanceState.getParcelableArrayList(check);
        }
        CustomAdapter adapter = new CustomAdapter(this, R.layout.adapter_custom2, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
                {
                    if(!list.isEmpty())
                    {
                        textViewV2.setText(list.get(position).getDesc());
                        textView.setText(list.get(position).getTitles());
                        //imageView.setImageResource(list.get(position).getImages());
                        y = position;
                    }
                }
            }
        });
        if(savedInstanceState!=null)
        {
            if(savedInstanceState.getInt("y")!=-1)
                if(!list.isEmpty()) {
               listView.performItemClick(listView.findViewWithTag(listView.getAdapter().getItem(savedInstanceState.getInt("y"))), savedInstanceState.getInt("y"), listView.getAdapter().getItemId(savedInstanceState.getInt("y")));
                }
        }
    }
}

