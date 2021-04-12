package com.example.recycleview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collection;

public class FootballAdapter extends RecyclerView.Adapter<FootballAdapter.ViewHolder> {
    private Context context;
    private ArrayList<FootballModel> footballModels;

    public FootballAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<FootballModel> getFootballModels() {
        return footballModels;
    }

    public void setFootballModels(ArrayList<FootballModel> footballModels) {
        this.footballModels = footballModels;
    }

    @NonNull
    @Override
    public FootballAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_footbal,viewGroup,false);
        return new ViewHolder(itRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(getFootballModels().get(i).getLambangTeam()).into(viewHolder.ivLambangTeam);
        viewHolder.tvNamateam.setText(getFootballModels().get(i).getNamaTeam());
        viewHolder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, getFootballModels().get(i).getPrivew());
                intent.setType("text/plain");
                context.startActivity(Intent.createChooser(intent, "Send To"));
            }
        });

        viewHolder.visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("logo", getFootballModels().get(i).getLambangTeam());
                intent.putExtra("nama", getFootballModels().get(i).getNamaTeam());
                intent.putExtra("preview", getFootballModels().get(i).getPrivew());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getFootballModels().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivLambangTeam;
        private TextView tvNamateam;
        private Button share;
        private Button visit;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            ivLambangTeam = itemView.findViewById(R.id.IV);
            tvNamateam = itemView.findViewById(R.id.nama_team);
            share = itemView.findViewById(R.id.btn_share);
            visit = itemView.findViewById(R.id.btn_preview);
        }
    }
}
