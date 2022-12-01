package com.unolator.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.unolator.R;
import com.unolator.entity.Player;
import com.unolator.viewmodel.PlayerViewModel;
import com.unolator.viewmodel.ScoreboardListAdapter;

import java.util.List;

import static com.unolator.Constants.*;

public class MainActivity extends AppCompatActivity {

    private PlayerViewModel mScoreViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final ScoreboardListAdapter adapter =
                new ScoreboardListAdapter(new ScoreboardListAdapter.ScoresDiff());
        mScoreViewModel = new ViewModelProvider(this).get(PlayerViewModel.class);
        mScoreViewModel.getAllScores().observe(this, scores -> {
            // Update the cached copy of the scoreboard in the adapter.
            adapter.submitList(scores);
        });
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setAdapter(adapter);

        Button scoresEditButton = (Button)findViewById(R.id.scoreEntry);
        scoresEditButton.setOnClickListener(v ->
        {
            goToScoresPage(adapter.getCurrentList());
        });
    }

    /**
     * INTENT Called when user taps Score Entry button
     * @param currentList
     */
    private void goToScoresPage(List<Player> currentList){
        Intent intent = new Intent(this, ScoresEntryActivity.class);
        Bundle b = new Bundle();
        if(1<=currentList.size()){
            b.putString(PLAYER_A, currentList.get(0).getPlayerName());
        }if(2<=currentList.size()){
            b.putString(PLAYER_B, currentList.get(1).getPlayerName());
        }if(3<=currentList.size()){
            b.putString(PLAYER_C, currentList.get(2).getPlayerName());
        }if(4==currentList.size()){
            b.putString(PLAYER_D, currentList.get(3).getPlayerName());
        }if(5==currentList.size()){
            b.putString(PLAYER_E, currentList.get(4).getPlayerName());
        }
        intent.putExtras(b);
        startActivity(intent);

    /**
     * INTENT Called when user taps player edit button
     */
    public void goToPlayerEditPage(View view){
        Intent intent = new Intent(this, PlayerEditActivity.class);
        startActivity(intent);
    }

    public void resetScores(View view){
        mScoreViewModel.resetScores();
    }

}