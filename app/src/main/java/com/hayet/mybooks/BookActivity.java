package com.hayet.mybooks;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BookActivity extends AppCompatActivity {

    private TextView tvtitle,tvdescription,tvauthor, tvnbrpages;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        tvtitle = (TextView) findViewById(R.id.book_title);
        tvdescription = (TextView) findViewById(R.id.book_Desc);
        tvauthor = (TextView) findViewById(R.id.book_author);
        tvnbrpages = (TextView) findViewById(R.id.book_nbr_pages);
        img = (ImageView) findViewById(R.id.book_img);

        // Recieve data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        String Author = intent.getExtras().getString("Author");
        String Nbrepages = intent.getExtras().getString("Nbrepages");
        int image = intent.getExtras().getInt("ImageBook") ;

        // Setting values

        tvtitle.setText(Title);
        tvdescription.setText(Description);
        tvauthor.setText(Author);
        tvnbrpages.setText(Nbrepages);
        img.setImageResource(image);


    }
}
