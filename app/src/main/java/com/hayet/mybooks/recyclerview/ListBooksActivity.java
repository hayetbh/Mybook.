package com.hayet.mybooks.recyclerview;



import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.hayet.mybooks.R;
import com.hayet.mybooks.model.Book;

import java.util.ArrayList;
import java.util.List;

public class ListBooksActivity extends AppCompatActivity {

    List<Book> lstBook ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_books);

        lstBook = new ArrayList<>();
        lstBook.add(new Book("The Vegitarian","Categorie Book","Description book","123",R.drawable.thevigitarian));
        lstBook.add(new Book("The Wild Robot","Categorie Book","Description book","123",R.drawable.thewildrobot));
        lstBook.add(new Book("Maria Semples","Categorie Book","Description book","123",R.drawable.mariasemples));
        lstBook.add(new Book("The Martian","Categorie Book","Description book","125",R.drawable.themartian));
        lstBook.add(new Book("He Died with...","Categorie Book","Description book","150",R.drawable.hediedwith));
        lstBook.add(new Book("The Vegitarian","Categorie Book","Description book","152",R.drawable.thevigitarian));
        lstBook.add(new Book("The Wild Robot","Categorie Book","Description book","153",R.drawable.thewildrobot));
        lstBook.add(new Book("Maria Semples","Categorie Book","Description book","156",R.drawable.mariasemples));
        lstBook.add(new Book("The Martian","Categorie Book","Description book","250",R.drawable.themartian));
        lstBook.add(new Book("He Died with...","Categorie Book","Description book","200",R.drawable.hediedwith));
        lstBook.add(new Book("The Vegitarian","Categorie Book","Description book","235",R.drawable.thevigitarian));
        lstBook.add(new Book("The Wild Robot","Categorie Book","Description book","452",R.drawable.thewildrobot));
        lstBook.add(new Book("Maria Semples","Categorie Book","Description book","123",R.drawable.mariasemples));
        lstBook.add(new Book("The Martian","Categorie Book","Description book","102",R.drawable.themartian));
        lstBook.add(new Book("He Died with...","Categorie Book","Description book","123",R.drawable.hediedwith));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstBook);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);


    }
}
