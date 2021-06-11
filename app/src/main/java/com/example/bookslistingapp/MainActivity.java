package com.example.bookslistingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();
    private BookAdapter adapter;
    Button searchBtn;
    EditText searchElem;
    TextView waitingMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView bookListView = (ListView) findViewById(R.id.list);

        adapter = new BookAdapter(this, new ArrayList<Book>());

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        bookListView.setAdapter(adapter);
        searchBtn = findViewById(R.id.search_button);

        searchElem = findViewById(R.id.input_view);

        waitingMessage= findViewById(R.id.waiting_message);


        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String elem = searchElem.getText().toString();
                    StringBuilder str = new StringBuilder();
                    str.append("https://www.googleapis.com/books/v1/volumes?q=").append(elem).append("&filter=ebooks&orderBy=relevance&maxResults=20");
                    String GOOGLEBOOK_REQUEST_URL = str.toString();
                    new BookAsyncTask().execute(GOOGLEBOOK_REQUEST_URL);
            }
        });



        bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                Book currentBook = adapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentBook.getUrl());

                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });
    }
    private class BookAsyncTask extends AsyncTask<String, String, List<Book>> {
        protected void onPreExecute() {
            super.onPreExecute();
            waitingMessage.setText("Wait for result, please...");
        }

        @Override
        protected List<Book> doInBackground(String... urls) {
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            List<Book> result = QueryUtils.fetchBookData(urls[0]);
            return result;
        }
        @Override
        protected void onPostExecute(List<Book> data) {
            adapter.clear();
            if (data != null && !data.isEmpty()) {
                adapter.addAll(data);
            }
            waitingMessage.setVisibility(View.GONE);


        }
    }

}
