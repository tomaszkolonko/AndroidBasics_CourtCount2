package com.example.android.courtcount2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayPointsForTeamA(scoreTeamA);
    }

    /**
     * Displays the given score for Team A
     */
    public void displayPointsForTeamA(int score) {
        TextView scoreView = findViewById(R.id.score_game_team_a);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method parses the tag field from the view object and adds it
     * to the value of scoreTeamA
     *
     * @param view
     */
    public void addAndDisplayPointsForA(View view) {
        int points = Integer.parseInt(view.getTag().toString());
        scoreTeamA = scoreTeamA + points;
        displayPointsForTeamA(scoreTeamA);
    }

    /**
     * Displays the given score for Team A
     */
    public void displayPointsForTeamB(int score) {
        TextView scoreView = findViewById(R.id.score_game_team_b);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method parses the tag field from the view object and adds it
     * to the value of scoreTeamB
     *
     * @param view
     */
    public void addAndDisplayPointsForB(View view) {
        int points = Integer.parseInt(view.getTag().toString());
        scoreTeamB = scoreTeamB + points;
        displayPointsForTeamB(scoreTeamB);
    }

    /**
     * This button resets the count of both teams
     *
     * @param view
     */
    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayPointsForTeamA(scoreTeamA);
        displayPointsForTeamB(scoreTeamB);
    }
}
