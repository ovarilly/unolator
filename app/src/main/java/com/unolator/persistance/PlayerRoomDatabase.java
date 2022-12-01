package com.unolator.persistance;

import android.content.Context;

import com.unolator.dao.PlayerDao;
import com.unolator.entity.Player;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Player.class}, version = 1, exportSchema = false)
public abstract class PlayerRoomDatabase extends RoomDatabase {

   public abstract PlayerDao playerDao();

   private static volatile PlayerRoomDatabase INSTANCE;
   private static final int NUMBER_OF_THREADS = 4;
   static final ExecutorService databaseWriteExecutor =
           Executors.newFixedThreadPool(NUMBER_OF_THREADS);

   static PlayerRoomDatabase getDatabase(final Context context) {
      if (INSTANCE == null) {
         synchronized (PlayerRoomDatabase.class) {
            if (INSTANCE == null) {
               INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                               PlayerRoomDatabase.class, "player_database")
                       .addCallback(sRoomDatabaseCallback)
                       .fallbackToDestructiveMigration()
                       .build();
            }
         }
      }
      return INSTANCE;
   }


   private static final Callback sRoomDatabaseCallback = new Callback() {
      @Override
      public void onCreate(@NonNull SupportSQLiteDatabase db) {
         super.onCreate(db);

         // If you want to keep data through app restarts,
         // comment out the following block
         databaseWriteExecutor.execute(() -> {
            // Populate the database in the background.
            PlayerDao dao = INSTANCE.playerDao();
            dao.deleteAll();

            Player player = new Player("Varilly", 0);
            dao.insert(player);

         });
      }
   };

}
