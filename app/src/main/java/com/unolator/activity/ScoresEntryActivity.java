package com.unolator.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.SimpleGolfScorerGwDowns.R;
import com.example.SimpleGolfScorerGwDowns.activity.holes.Hole10Entry;
import com.example.SimpleGolfScorerGwDowns.activity.holes.Hole11Entry;
import com.example.SimpleGolfScorerGwDowns.activity.holes.Hole12Entry;
import com.example.SimpleGolfScorerGwDowns.activity.holes.Hole13Entry;
import com.example.SimpleGolfScorerGwDowns.activity.holes.Hole14Entry;
import com.example.SimpleGolfScorerGwDowns.activity.holes.Hole15Entry;
import com.example.SimpleGolfScorerGwDowns.activity.holes.Hole16Entry;
import com.example.SimpleGolfScorerGwDowns.activity.holes.Hole17Entry;
import com.example.SimpleGolfScorerGwDowns.activity.holes.Hole18Entry;
import com.example.SimpleGolfScorerGwDowns.activity.holes.Hole1Entry;
import com.example.SimpleGolfScorerGwDowns.activity.holes.Hole2Entry;
import com.example.SimpleGolfScorerGwDowns.activity.holes.Hole3Entry;
import com.example.SimpleGolfScorerGwDowns.activity.holes.Hole4Entry;
import com.example.SimpleGolfScorerGwDowns.activity.holes.Hole5Entry;
import com.example.SimpleGolfScorerGwDowns.activity.holes.Hole6Entry;
import com.example.SimpleGolfScorerGwDowns.activity.holes.Hole7Entry;
import com.example.SimpleGolfScorerGwDowns.activity.holes.Hole8Entry;
import com.example.SimpleGolfScorerGwDowns.activity.holes.Hole9Entry;

import androidx.appcompat.app.AppCompatActivity;

public class ScoresEntryActivity extends AppCompatActivity {

    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scores_entry_activity);
        bundle = getIntent().getExtras();
    }


}
