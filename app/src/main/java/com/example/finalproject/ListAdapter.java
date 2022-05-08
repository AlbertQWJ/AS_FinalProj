package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter<Book> {
    private int resourceId;

    public ListAdapter(Context context, int textViewResourceId, List<Book> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Book book = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

        ImageView coverIv;
        TextView idTv, writeTv, dateTv, publishTv;

        coverIv = (ImageView) view.findViewById(R.id.item_cover);
        idTv = (TextView) view.findViewById(R.id.item_id);
        writeTv = (TextView) view.findViewById(R.id.item_writer);
        dateTv = (TextView) view.findViewById(R.id.item_date);
        publishTv = (TextView) view.findViewById(R.id.item_publish);

        coverIv.setImageResource(book.getCover());
        idTv.setText(book.getId());
        writeTv.setText(book.getWriter());
        dateTv.setText(book.getDate());
        publishTv.setText(book.getPublish());

        return view;
    }
}
