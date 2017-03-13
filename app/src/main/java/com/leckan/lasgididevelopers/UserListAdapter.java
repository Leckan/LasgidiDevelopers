package com.leckan.lasgididevelopers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Simpa on 3/12/2017.
 */

public class UserListAdapter extends BaseAdapter {
    private ArrayList listData;
    private LayoutInflater layoutInflater;

    public UserListAdapter(Context context, ArrayList listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.user_list_view, null);
            holder = new ViewHolder();
            holder.usernameView = (TextView) convertView.findViewById(R.id.txtusername);
            holder.imageView = (ImageView) convertView.findViewById(R.id.userpic);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        LasgidiUser theUser = (LasgidiUser) listData.get(position);

        holder.usernameView.setText(theUser.getDate());
        if (holder.imageView != null) {
            new DownloadImageTask(holder.imageView).execute(theUser.getUrl());
        }
        return convertView;
    }

    static class ViewHolder {
        TextView usernameView;
        ImageView imageView;
    }
}
