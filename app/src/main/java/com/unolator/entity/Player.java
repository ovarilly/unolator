package com.unolator.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "player_table")
public class Player {

   @PrimaryKey
   @NonNull
   private String playerName;
   private int score;


   public Player(String playerName, int score) {
      this.playerName = playerName;
      this.score = score;
   }


   public String getPlayerName() {
      return playerName;
   }

   public void setPlayerName(String playerName) {
      this.playerName = playerName;
   }

   public int getScore() {
      return score;
   }

   public void setScore(int score) {
      this.score = score;
   }

   @Override
   public String toString() {
      return "Player{" +
              "playerName='" + playerName + '\'' +
              ", score=" + score +
              '}';
   }


}
