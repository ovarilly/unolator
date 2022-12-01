package com.unolator.viewmodel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.unolator.R;
import com.unolator.entity.Player;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ScoreboardViewHolder extends RecyclerView.ViewHolder {
    private final TextView playerNameView;
    private final TextView scoreView;


    public ScoreboardViewHolder(@NonNull View itemView) {
        super(itemView);
        playerNameView = itemView.findViewById(R.id.playerNameView);
        scoreView = itemView.findViewById(R.id.scoreView);

    }

    public void bindPlayer(Player player){
        playerNameView.setText(player.getPlayerName());
        scoreView.setText(Integer.toString(player.getScore()));
    }

    static ScoreboardViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new ScoreboardViewHolder(view);
    }
}
