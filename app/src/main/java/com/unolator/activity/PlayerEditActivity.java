package com.unolator.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.unolator.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.unolator.entity.Player;
import com.unolator.viewmodel.PlayerViewModel;

import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class PlayerEditActivity extends AppCompatActivity {

    public static final int NEW_PLAYER_ACTIVITY_REQUEST_CODE = 1;
    public static final int REMOVE_PLAYER_ACTIVITY_REQUEST_CODE = 2;
    private PlayerViewModel mScoreViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_edit);
        mScoreViewModel = new ViewModelProvider(this).get(PlayerViewModel.class);


        FloatingActionButton fab = findViewById(R.id.addPlayer);
        fab.setOnClickListener( view -> {
            Intent intent = new Intent(PlayerEditActivity.this, NewPlayerActivity.class);
            startActivityForResult(intent, NEW_PLAYER_ACTIVITY_REQUEST_CODE);
        });

        FloatingActionButton remove = findViewById(R.id.remove);
        remove.setOnClickListener( view -> {
            Intent intent = new Intent(PlayerEditActivity.this, DeletePlayerActivity.class);
            startActivityForResult(intent, REMOVE_PLAYER_ACTIVITY_REQUEST_CODE);
        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_PLAYER_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Player player =
                    new Player(data.getStringExtra(NewPlayerActivity.EXTRA_REPLY).toUpperCase(Locale.ROOT),
                            0);
            mScoreViewModel.insert(player);
        }if (requestCode == REMOVE_PLAYER_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Player player = new Player(data.getStringExtra(DeletePlayerActivity.EXTRA_REPLY), 0);
            mScoreViewModel.deletePlayer(player.getPlayerName().toUpperCase(Locale.ROOT));
        }

    }
}
