package com.example.listviewproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Sports>
{
    Context context;
    List<Sports> list;
    int xml;
    ListView listView;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Sports> objects) {
        super(context, resource, objects);
        this.context = context;
        this.list = objects;
        xml = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        String gvTitle = list.get(position).getTitles();
        String gvDesc = list.get(position).getDesc();
        int gvImage = list.get(position).getImages();
        Sports sport = new Sports(gvTitle,gvDesc,gvImage);

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(xml, parent, false);
        View temp = convertView;


        TextView textView = convertView.findViewById(R.id.id_adapter_text);
        TextView textView2 = convertView.findViewById(R.id.id_adapter_textdesc);
        ImageView imageView = convertView.findViewById(R.id.id_adapter_picture);
        Button button = convertView.findViewById(R.id.id_button_button);
        Button button2 = convertView.findViewById(R.id.id_youtubeopener);

        textView.setText(gvTitle);
        button.setText("Remove?");
        imageView.setImageResource(gvImage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                list.remove(position);
                notifyDataSetChanged();
            }
        });
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(gvTitle.equalsIgnoreCase("Basketball"))
                {
                    goToUrlLink("https://www.youtube.com/watch?v=oyjYgmsM00Q");
                }
                if(gvTitle.equalsIgnoreCase("Soccer"))
                {
                    goToUrlLink("https://www.youtube.com/watch?v=cTCgU4Vz0rE");
                }
                if(gvTitle.equalsIgnoreCase("Tennis"))
                {
                    goToUrlLink("https://www.youtube.com/watch?v=1P_Das6OjAk");
                }
                if(gvTitle.equalsIgnoreCase("Baseball"))
                {
                    goToUrlLink("https://www.youtube.com/watch?v=57mc7Df7Arw");
                }
                if(gvTitle.equalsIgnoreCase("Cricket"))
                {
                    goToUrlLink("https://www.youtube.com/watch?v=AqtpNkMvj5Y");
                }
                if(gvTitle.equalsIgnoreCase("Football"))
                {
                    goToUrlLink("https://www.youtube.com/watch?v=Ddwp1HyEFRE");
                }
            }
        });
      temp.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View v)
           {
               textView2.setText(gvDesc);
           }
       });
        return convertView;
    }
    private void goToUrlLink(String s)
        {
            Uri uri = Uri.parse(s);
            Intent open = new Intent(Intent.ACTION_VIEW, uri);
            context.startActivity(open);
        }

}
