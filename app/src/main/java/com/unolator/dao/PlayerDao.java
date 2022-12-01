package com.unolator.dao;

import com.unolator.entity.Player;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface PlayerDao {

    @Insert
    void insert(Player player);

    @Query("DELETE FROM player_table")
    void deleteAll();

    @Query("SELECT * FROM player_table")
    LiveData<List<Player>> getAllScores();

    @Query("SELECT COUNT(playerName) FROM player_table")
    LiveData<Integer> getRowCount();

    @Query("SELECT * FROM player_table WHERE playerName = :playerName")
    Player findPlayerWithPLayerName(String playerName);

    @Query("DELETE FROM player_table WHERE playerName = :playerName")
    void deletePlayerByPlayerName(String playerName);

    @Query("UPDATE player_table " +
            "SET score = score + :addition " +
            "WHERE playerName = :playerName")
    void addToScoreForPlayerName(String playerName, int addition);

    @Query("UPDATE player_table " +
            "SET score = 0")
    void resetScores();
}
