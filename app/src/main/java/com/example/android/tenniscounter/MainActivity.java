package com.example.android.tenniscounter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    public int servingPlayer;
    public String player1Name;
    public String player2Name;
    public EditText player1NameEditText, player2NameEditText;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1NameEditText = findViewById(R.id.player_1_name);
        player2NameEditText = findViewById(R.id.player_2_name);
    }

    public void startbtn(View view) {

        RadioGroup serveRadioGroup = (RadioGroup) findViewById(R.id.serve_radiogroup);
        switch (serveRadioGroup.getCheckedRadioButtonId()) {
            case R.id.player_1_serve:
                servingPlayer = 1;
                System.out.println("__________servingPlayer111" + servingPlayer);
                break;
            case R.id.player_2_serve:
                servingPlayer = 2;
                System.out.println("__________servingPlayer222" + servingPlayer);
                break;
            default:
                Toast.makeText(this, getString(R.string.select_serving_player_toast), Toast.LENGTH_SHORT).show();
                return;
        }

        player1Name = player1NameEditText.getText().toString();
        player2Name = player2NameEditText.getText().toString();

        if (player1Name.isEmpty()) {
            Toast.makeText(this, getString(R.string.player1_enter_name_toast), Toast.LENGTH_SHORT).show();
            return;
        } else if (player2Name.isEmpty()) {
            Toast.makeText(this, getString(R.string.player2_enter_name_toast), Toast.LENGTH_SHORT).show();
            return;
        } else if (servingPlayer == 0) {
            Toast.makeText(MainActivity.this, "Select the player to serve first", Toast.LENGTH_SHORT).show();
        } else {

            System.out.println("__________servingPlayer" + servingPlayer);

            Toast.makeText(MainActivity.this, "Cliccccccccccccck  " + player1Name + "  :   " + player2Name, Toast.LENGTH_SHORT).show();
            Bundle args = new Bundle();
            args.putString(ScoreboardActivity.ARG_PLAYER_1_NAME, player1Name);
            args.putString(ScoreboardActivity.ARG_PLAYER_2_NAME, player2Name);
            args.putInt(ScoreboardActivity.ARG_SERVE_START, servingPlayer);
            Intent i = new Intent(MainActivity.this, ScoreboardActivity.class);
            i.putExtras(args);
            startActivity(i);
        }

    }

}