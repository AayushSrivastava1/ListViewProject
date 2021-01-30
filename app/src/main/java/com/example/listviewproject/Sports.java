package com.example.listviewproject;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

public class Sports implements Parcelable
{
     private String titles;
     private String desc;
     private int images;

     public Sports(String titles, String desc, int images)
     {
         this.titles = titles;
         this.desc = desc;
         this.images = images;
     }

    protected Sports(Parcel in)
    {
        titles = in.readString();
        desc = in.readString();
        images = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Sports> CREATOR = new Creator<Sports>() {
        @Override
        public Sports createFromParcel(Parcel in) {
            return new Sports(in);
        }

        @Override
        public Sports[] newArray(int size) {
            return new Sports[size];
        }
    };

    public void writeToParcel(Parcel dest, int flags){
        dest.writeInt(images);
        dest.writeString(titles);
        dest.writeString(desc);
    }

    public String getTitles() {
        return titles;
    }

    public String getDesc() {
        return desc;
    }

    public int getImages()
    {
        return images;
    }
}
