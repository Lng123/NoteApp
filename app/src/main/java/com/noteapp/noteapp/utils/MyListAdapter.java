package com.noteapp.noteapp.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.noteapp.noteapp.R;

import java.util.List;

public class MyListAdapter extends ArrayAdapter<ImageFile> {

    private int layout;

    public MyListAdapter(@NonNull Context context, int resource, @NonNull List<ImageFile> objects) {
        super(context, resource, objects);
        this.layout = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mainViewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(layout, parent, false);
            ViewHolder viewHolder = new ViewHolder((ImageView) convertView.findViewById(R.id.list_item_thumbnail), (TextView) convertView.findViewById(R.id.list_item_text));
            // viewHolder.button.setOnClickerListener(new View.OnClickListener() {
            // @Override
            // public void onClick(View v) {
            // ...
            // }
            convertView.setTag(viewHolder);
        }
        mainViewHolder = (ViewHolder) convertView.getTag();
        mainViewHolder.setTitle(getItem(position).getFileName());
        mainViewHolder.setThumbnail(getItem(position).getThumbnail());
        return convertView;
    }
}