package com.bilge.sealfasters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.topList> {

    private ArrayList<String> bestList;
    private ArrayList<String> nickList;

    public adapter(ArrayList<String> bestList, ArrayList<String> nickList) {
        this.bestList = bestList;
        this.nickList = nickList;
    }

    @NonNull
    @Override
    public topList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        View view;
        LayoutInflater lf = LayoutInflater.from(parent.getContext());


        view = lf.inflate(R.layout.r_row,parent,false);

        topList toplist = new topList(view);


        return toplist;
    }

    @Override
    public void onBindViewHolder(@NonNull topList holder, int position) {

        String yazı = (position + 1) + "- " + nickList.get(position) + " : " + bestList.get(position);
        holder.listView.setText(yazı);

    }

    @Override
    public int getItemCount() {

        return bestList.size();
    }

    class topList extends RecyclerView.ViewHolder{


        TextView listView;

        public topList(@NonNull View itemView) {
            super(itemView);

            listView = itemView.findViewById(R.id.sıralamaText);
        }
    }


}
