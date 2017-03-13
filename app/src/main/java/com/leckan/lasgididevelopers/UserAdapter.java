package com.leckan.lasgididevelopers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ahmed on 3/10/2017.
 */

public class UserAdapter extends ArrayAdapter {

    int[] imageArray;;
    String[] usernameArray;
    public UserAdapter(Context context, String[] usernames, int[] images)
    {
        super(context, R.layout.user_list_view,R.id.txtusername, usernames);
        this.imageArray = images;
        this.usernameArray = usernames;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.user_list_view,parent,false);
       // ImageView userImage = (ImageView) row.findViewById(R.id.userpic);
        TextView usernameText = (TextView) row.findViewById(R.id.txtusername);

       // userImage.setImageResource(imageArray[position]);
        usernameText.setText(usernameArray[position]);

        new DownloadImageTask((ImageView) row.findViewById(R.id.userpic)).execute("http://feelgrafix.com/data/pictures/pictures-1.jpg");
        return row;
    }
}
