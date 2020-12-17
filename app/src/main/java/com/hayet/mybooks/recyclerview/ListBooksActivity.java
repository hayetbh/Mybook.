package com.hayet.mybooks.recyclerview;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.hayet.mybooks.Constants;
import com.hayet.mybooks.R;
import com.hayet.mybooks.controller.LoginActivity;
import com.hayet.mybooks.model.Book;

import java.util.ArrayList;
import java.util.List;

public class ListBooksActivity extends AppCompatActivity {

    List<Book> lstBook ;
Button btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_books);

        lstBook = new ArrayList<>();
        lstBook.add(new Book("The First Woman","Jennifer Nansubuga Makumbi", getString(R.string.the_first_woman_desc),"400 pages",R.drawable.the_first_women));
        lstBook.add(new Book("The Wild Robot","Peter Brown",getString(R.string.thewildrobot_desc) ,"288 pages",R.drawable.thewildrobot));
        lstBook.add(new Book("Where'd You Go, Bernadette: A Novel","Maria Semple",getString(R.string.wherewouldyougo_desc),"123",R.drawable.mariasemples));
        lstBook.add(new Book("The Better Angels of Our Nature","Steven Pinker",getString(R.string.thebetterangels_desc) ,"125",R.drawable.the_better_angles_of_our_nature));
        lstBook.add(new Book("The Gift of Forgiveness","Katherine Schwarzenegger",getString(R.string.thegiftof_desc)," 224 pages",R.drawable.the_gift_of_forgiveness));
        lstBook.add(new Book("The Power of Meaning ","Emily Esfahani-Smith",getString(R.string.thepowerofmeaning_desc)," 304 pages",R.drawable.the_poweer_of_meaning));
        lstBook.add(new Book("The Fault","John Green",getString(R.string.thefzult_desc),"318 pages",R.drawable.thefault));
        lstBook.add(new Book("Maybe You Should Talk to Someone","Lori Gottlieb",getString(R.string.maybeyoushould_desc) ," 415 pages",R.drawable.maybe_you_should_talk_to_someone));
        lstBook.add(new Book("Remember Me?","Sophie Kinsella",getString(R.string.remembreme_desc) ,"464 pages",R.drawable.remember_me));
        lstBook.add(new Book("The Happiness Track ","Emma Seppala",getString(R.string.thehappiness_desc) ,"224 pages",R.drawable.the_happiness_track));
        lstBook.add(new Book("The Martian", "Andy Weir", getString(R.string.themartian_desc),"448 pages\n",R.drawable.themartian));
        lstBook.add(new Book("He Died with His Eyes Open","Derek Raymond",getString(R.string.hediedwith_desc) ,"224 pages",R.drawable.hediedwith));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_list);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstBook);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);
        //button log out
        btnLogout =(Button)findViewById(R.id.btn_logout);
         btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences(Constants.MY_PREF, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(getApplicationContext(), "You have logged out!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListBooksActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
