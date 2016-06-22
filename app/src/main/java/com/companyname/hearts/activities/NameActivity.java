package com.companyname.hearts.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.companyname.hearts.R;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class NameActivity extends AppCompatActivity {

    private EditText userNameInput;
    private EditText computer1Input;
    private EditText computer2Input;
    private EditText computer3Input;
    private String[] playerNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        userNameInput = (EditText) findViewById(R.id.user_name_input);
        computer1Input = (EditText) findViewById(R.id.computer1_input);
        computer2Input = (EditText) findViewById(R.id.computer2_input);
        computer3Input = (EditText) findViewById(R.id.computer3_input);
        playerNames = new String[4];
    }

    public void clickedContinueHearts (View view) {
        try {
            FileInputStream fis = getApplicationContext().openFileInput("table.dat");
            ObjectInputStream is = new ObjectInputStream(fis);
            is.close();
            fis.close();
            Intent mainIntent = new Intent(NameActivity.this, MainActivity.class);
            mainIntent.putExtra("continueOldGame", true);
            startActivity(mainIntent);
        } catch (IOException e) {
            Toast.makeText(NameActivity.this, "You don't have any saved games!", Toast.LENGTH_SHORT).show();
        }

    }

    public void clickedStartHearts(View view) {
        String playerDefault = "Player 1";
        String computer1Default = "Computer 1";
        String computer2Default = "Computer 2";
        String computer3Default = "Computer 3";

        if (!userNameInput.getText().toString().equals("")) {
            playerDefault = userNameInput.getText().toString();
        }

        if (!computer1Input.getText().toString().equals("")) {
            computer1Default = computer1Input.getText().toString();
        }

        if (!computer2Input.getText().toString().equals("")) {
            computer2Default = computer2Input.getText().toString();
        }

        if (!computer3Input.getText().toString().equals("")) {
            computer3Default = computer3Input.getText().toString();
        }

        playerNames[0] = playerDefault;
        playerNames[1] = computer1Default;
        playerNames[2] = computer2Default;
        playerNames[3] = computer3Default;

        //String Builder to save shared prefs

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < playerNames.length; i++) {
            sb.append(playerNames[i]).append(",");
        }
        //TODO: Change sharedPrefs name?

        //store value string in shared prefs
        SharedPreferences sharedpreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("playernames", sb.toString());
        editor.commit();

        try {
            Intent shuffleIntent = new Intent(getApplicationContext(), ShuffleAnimationActivity.class);
            startActivity(shuffleIntent);
        } catch(Error e) {
            Toast.makeText(NameActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
        }

    }

}
