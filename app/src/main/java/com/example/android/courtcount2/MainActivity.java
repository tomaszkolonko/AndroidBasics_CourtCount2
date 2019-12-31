package com.example.android.courtcount2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int setScoreTeamA = 0;
    private int setScoreTeamB = 0;
    private int gameScoreTeamA = 0;
    private int gameScoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayPointsForTeamA();
        displayPointsForTeamB();
    }

    /**
     * Displays the given score for Team A
     */
    public void displayPointsForTeamA() {
        TextView gameScoreView = findViewById(R.id.score_game_team_a);
        TextView setScoreView = findViewById(R.id.score_set_team_a);
        gameScoreView.setText(String.valueOf(gameScoreTeamA));
        setScoreView.setText(String.valueOf(setScoreTeamA));
    }

    /**
     * This method parses the tag field from the view object and adds it
     * to the value of gameScoreTeamA
     *
     * @param view
     */
    public void updateAndDisplayPointsForA(View view) {
        int points = Integer.parseInt(view.getTag().toString());
        gameScoreTeamA = gameScoreTeamA + points;
        checkAndUpdateSetIfReached();
        checkIfMatchIsFinished();
        displayPointsForTeamA();
    }

    /**
     * Displays the given score for Team A
     */
    public void displayPointsForTeamB() {
        TextView gameScoreView = findViewById(R.id.score_game_team_b);
        TextView setScoreView = findViewById(R.id.score_set_team_b);
        gameScoreView.setText(String.valueOf(gameScoreTeamB));
        setScoreView.setText(String.valueOf(setScoreTeamB));
    }

    /**
     * This method parses the tag field from the view object and adds it
     * to the value of gameScoreTeamB
     *
     * @param view
     */
    public void updateAndDisplayPointsForB(View view) {
        int points = Integer.parseInt(view.getTag().toString());
        gameScoreTeamB = gameScoreTeamB + points;
        checkAndUpdateSetIfReached();
        checkIfMatchIsFinished();
        displayPointsForTeamB();
    }

    /**
     * This button resets the count of both teams
     *
     * @param view
     */
    public void reset(View view) {
        resetGame();
        resetSet();
        displayPointsForTeamA();
        displayPointsForTeamB();
        updateAllButtons(true);
        updateInfoTextView("This is a game of Basketennis (some weird rule mix of both sports). The team which first achieves 21 points or more in a game will win the set. If two sets are won the game is over.", false);
        changeResetButton("Reset");
    }

    /**
     * This methods checks after each update if either team reached
     * the required 21 points in order to win the game
     */
    private void checkAndUpdateSetIfReached() {
        if(gameScoreTeamA >= 21) {
            setScoreTeamA += 1;
            resetGame();
        } else if(gameScoreTeamB >= 21) {
            setScoreTeamB += 1;
            resetGame();
        }
    }


    /**
     * This method checks if the whole match was won by either team. That happens if either
     * team has gained two sets. If that happens the infoTextView gets updated and all buttons
     * will be disables except the "new Match / Reset" button.
     */
    private void checkIfMatchIsFinished() {
        if(setScoreTeamA >= 2) {
            updateInfoTextView("!!! Team A has won !!!", true);
            setAllButtonsAfterWin();
        } else if(setScoreTeamB >= 2) {
            updateInfoTextView("!!! Team B has won !!!", true);
            setAllButtonsAfterWin();
        }
    }

    /**
     * This method disables all buttons for giving points to either team. It changes
     * the text of the "New Match / Reset" Button.
     */
    private void setAllButtonsAfterWin() {
        updateAllButtons(false);
        changeResetButton("New Match?");
    }

    /**
     * Sets all buttons to given parameter stateOfButton
     *
     * @param stateOfButton
     */
    private void updateAllButtons(Boolean stateOfButton) {
        TextView threePointsButtonA = findViewById(R.id.button_three_points_a);
        threePointsButtonA.setEnabled(stateOfButton);
        TextView twoPointsButtonA = findViewById(R.id.button_two_points_a);
        twoPointsButtonA.setEnabled(stateOfButton);
        TextView onePointButtonA = findViewById(R.id.button_one_point_a);
        onePointButtonA.setEnabled(stateOfButton);

        TextView threePointsButtonB = findViewById(R.id.button_three_points_b);
        threePointsButtonB.setEnabled(stateOfButton);
        TextView twoPointsButtonB = findViewById(R.id.button_two_points_b);
        twoPointsButtonB.setEnabled(stateOfButton);
        TextView onePointButtonB = findViewById(R.id.button_one_point_b);
        onePointButtonB.setEnabled(stateOfButton);
    }

    /**
     * Sets the text of the reset Button to value of textForButton
     * @param textForButton
     */
    private void changeResetButton(String textForButton) {
        TextView resetButton = findViewById(R.id.reset_button);
        resetButton.setText(textForButton);
    }


    /**
     * Sets the text of the infoTextView to the value of text and sets the caps
     * attribute to the value of isAllCaps
     *
     * @param text
     * @param isAllCaps
     */
    private void updateInfoTextView(String text, Boolean isAllCaps) {
        TextView infoTextView = findViewById(R.id.info_view);
        infoTextView.setText(text);
        infoTextView.setAllCaps(isAllCaps);
    }

    /**
     * This method resets the game count for both teams
     */
    private void resetGame() {
        gameScoreTeamA = 0;
        gameScoreTeamB = 0;
        displayPointsForTeamA();
        displayPointsForTeamB();
    }

    /**
     * This method resets the set count for both teams
     */
    private void resetSet() {
        setScoreTeamA = 0;
        setScoreTeamB = 0;
    }


}
