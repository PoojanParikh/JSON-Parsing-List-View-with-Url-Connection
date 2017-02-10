package com.poojan.jsonparsinglistviewwithurlconnection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by VNurtureTechnologies on 10/02/17.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<Post> posts;

    CustomAdapter(Context context, ArrayList<Post> posts) {

        this.context = context;
        this.posts = posts;

    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int i) {
        return posts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static class ViewHolder {

        TextView userIdTextView, idTextView, titleTextView, bodyTextView;


    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.single_row_list_view, viewGroup, false);

            holder.userIdTextView = (TextView) convertView.findViewById(R.id.user_id_tv);
            holder.idTextView = (TextView) convertView.findViewById(R.id.id_tv);
            holder.titleTextView = (TextView) convertView.findViewById(R.id.title_tv);
            holder.bodyTextView = (TextView) convertView.findViewById(R.id.body_tv);


            convertView.setTag(holder);
        }

        else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.userIdTextView.setText("userId: "+String.valueOf(posts.get(i).getUserId()));
        holder.idTextView.setText("Id: "+String.valueOf(posts.get(i).getId()));
        holder.titleTextView.setText("Title: "+posts.get(i).getTitle());
        holder.bodyTextView.setText("Body: "+posts.get(i).getBody());

        return convertView;
    }
}
