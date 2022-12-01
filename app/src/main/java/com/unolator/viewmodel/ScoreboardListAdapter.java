package com.unolator.viewmodel;

import android.view.ViewGroup;

import com.unolator.entity.Player;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class ScoreboardListAdapter extends ListAdapter<Player, com.unolator.viewmodel.ScoreboardViewHolder> {

   public ScoreboardListAdapter(@NonNull DiffUtil.ItemCallback<Player> diffCallback) {
      super(diffCallback);
   }

   @Override
   public com.unolator.viewmodel.ScoreboardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      return com.unolator.viewmodel.ScoreboardViewHolder.create(parent);
   }

   @Override
   public void onBindViewHolder(com.unolator.viewmodel.ScoreboardViewHolder holder, int position) {
      Player current = getItem(position);
      holder.bindPlayer(current);
   }

   public static class ScoresDiff extends DiffUtil.ItemCallback<Player> {

      @Override
      public boolean areItemsTheSame(@NonNull Player oldItem, @NonNull Player newItem) {
         return oldItem == newItem;
      }

      @Override
      public boolean areContentsTheSame(@NonNull Player oldItem, @NonNull Player newItem) {
         return oldItem.getPlayerName().equals(newItem.getPlayerName());
      }
   }
}