package com.example.peomapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config {
    private Context context;
    private RecyclerView recyclerView;
    //  private RecyclerView.LayoutManager


    public void setConfig(List<Poem> poems, List<String> keys, Context context, ViewGroup parent) {

        //new RecyclerView(new LayoutInflater().from(context).inflate(R.layout.poem_item_list,parent));
    }

    class PoemViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitle;
        public TextView mContent;
        public String key;

        public PoemViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.titleItemList);
            mContent = (TextView) itemView.findViewById(R.id.contentItemList);

        }

        public void bind(Poem poem, String key) {
            mTitle.setText(poem.getTitle());
            mContent.setText(poem.getContent());
            this.key = key;
        }

    }

    class PoemAdepter extends RecyclerView.Adapter<PoemViewHolder> {
        private List<Poem> poems;
        private List<String> keys;

        @NonNull
        @Override
        public PoemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            return new PoemViewHolder(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull PoemViewHolder holder, int position) {
            holder.bind(poems.get(position), keys.get(position));
        }


        @Override
        public int getItemCount() {
            return poems.size();
        }
    }


}
