package com.example.bookslistingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {
    public BookAdapter(Context context, List<Book> earthquakes) {
        super(context, 0, earthquakes);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Book currentBook = getItem(position);

        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        titleView.setText(currentBook.getTitle());

        TextView authorView = (TextView) listItemView.findViewById(R.id.author_name);
        authorView.setText(currentBook.getAuthor());

        TextView pagesView = (TextView) listItemView.findViewById(R.id.pages_count);
        pagesView.setText(currentBook.getPagesCount());


        TextView dateView = (TextView) listItemView.findViewById(R.id.publication_date);
        dateView.setText(currentBook.getTime());

        TextView ratingView = (TextView) listItemView.findViewById(R.id.rating);
        ratingView.setText(currentBook.getRating());

        ImageView coverImage = listItemView.findViewById(R.id.book_cover);

        String imageUrl=currentBook.getCoverImage().replace("http","https");
        Glide.with(listItemView).load(imageUrl).into(coverImage);

        return listItemView;
    }

}
