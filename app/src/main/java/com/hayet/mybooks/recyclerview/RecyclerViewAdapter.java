package com.hayet.mybooks.recyclerview;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.hayet.mybooks.R;
import com.hayet.mybooks.model.Book;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Book> mData ;


    public RecyclerViewAdapter(Context mContext, List<Book> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.list_item_book,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.title_book_main.setText(mData.get(position).getTitle());
        holder.img_book_main.setImageResource(mData.get(position).getImgURL());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,BookActivity.class);

                // passing data to the book activity
                intent.putExtra("Title",mData.get(position).getTitle());
                intent.putExtra("Description",mData.get(position).getDescription());
                intent.putExtra("Author",mData.get(position).getAuthor());
                intent.putExtra("Nbrepages",mData.get(position).getNbrpages());
                intent.putExtra("ImageBook",mData.get(position).getImgURL());
                // start the activity
                mContext.startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title_book_main;
        ImageView img_book_main;

        ConstraintLayout constraintLayout;
        public MyViewHolder(View itemView) {
            super(itemView);

            title_book_main = (TextView) itemView.findViewById(R.id.book_title_main) ;
            img_book_main = (ImageView) itemView.findViewById(R.id.book_img_main);
            constraintLayout=(ConstraintLayout) itemView.findViewById(R.id.constraintlayout);



        }
    }


}
