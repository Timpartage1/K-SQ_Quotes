package com.example.k_sqquotes;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerQuoteAdapter extends RecyclerView.Adapter<RecyclerQuoteAdapter.ViewHolder> {


    private List<QuoteModel> quoteModelList;
    private Context context;

    public RecyclerQuoteAdapter(Context context,List<QuoteModel> list){
        this.quoteModelList=list;
        this.context=context;
    }
    @NonNull
    @Override
    public RecyclerQuoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.quote_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerQuoteAdapter.ViewHolder holder, int position) {
        holder.textViewTitle.setText(quoteModelList.get(position).getTitle());
        holder.textViewCateg.setText(quoteModelList.get(position).getCategory());
        holder.textViewContent.setText(quoteModelList.get(position).getContent());
        holder.textViewDate.setText(quoteModelList.get(position).getCdate());
        Glide.with(holder.imageView).load(quoteModelList.get(position).getUrl()).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ksq).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return quoteModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        TextView textViewContent;
        TextView textViewDate;
        TextView textViewCateg;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle=itemView.findViewById(R.id.row_title);
            textViewContent=itemView.findViewById(R.id.row_content);
            textViewDate=itemView.findViewById(R.id.row_date);
            textViewCateg=itemView.findViewById(R.id.row_categ);
            imageView=itemView.findViewById(R.id.img_row);


        }
    }
}