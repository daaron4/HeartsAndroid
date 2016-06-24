package com.companyname.hearts.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.companyname.hearts.R;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
    This activity is the starting activity that lets the user set their name.
    The user can also decide if they wish to load their previous save or not.
 */

public class NameActivity extends AppCompatActivity {

    private EditText userNameInput;
    private String[] playerNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        userNameInput = (EditText) findViewById(R.id.user_name_input);
        playerNames = new String[4];
    }

    // Skips shuffle, goes right into main activity with an extra boolean, telling that
    // activity to load save game instead of start new one
    public void clickedContinueHearts(View view) {
        try {
            FileInputStream fis = getApplicationContext().openFileInput("table.dat");
            ObjectInputStream is = new ObjectInputStream(fis);
            is.close();
            fis.close();
            Intent mainIntent = new Intent(NameActivity.this, MainActivity.class);
            mainIntent.putExtra("continueOldGame", true);
            startActivity(mainIntent);
        } catch (IOException e) {
            Toast.makeText(NameActivity.this, getString(R.string.no_save_found), Toast.LENGTH_SHORT).show();
        }

    }

    public void clickedStartHearts(View view) {
        // Begin check for saved game
        try {
            FileInputStream fis = getApplicationContext().openFileInput("table.dat");
            ObjectInputStream is = new ObjectInputStream(fis);
            is.close();
            fis.close();
            // Create alert dialog here telling user previous save game will be overwritten:
            AlertDialog.Builder builder = new AlertDialog.Builder(NameActivity.this);
            builder.setTitle(getString(R.string.app_name));
            builder.setMessage(getString(R.string.overwrite_save));
            builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    startTheGameAlready();
                }
            });
            builder.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //does nothing
                }
            });
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setCancelable(false);
            builder.show();
        }
        // No save game exists, start regular game:
        catch (IOException e) {
            startTheGameAlready();
        }

    }

    // Method that starts a new game:
    private void startTheGameAlready() {
        String playerDefault = "Player";
        String computer1Default = "Hal 9000";
        String computer2Default = "Terminator";
        String computer3Default = "ZomboCom";

        if (!userNameInput.getText().toString().equals("")) {
            playerDefault = userNameInput.getText().toString();
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

        //store value string in shared prefs
        SharedPreferences sharedpreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("playernames", sb.toString());
        editor.commit();

        Pair<View, String> morphHal = Pair.create(findViewById(R.id.hal_name_icon), "hal_morph");
        Pair<View, String> morphTerm = Pair.create(findViewById(R.id.terminator_name_icon), "terminator_morph");
        Pair<View, String> morphZombo = Pair.create(findViewById(R.id.zombo_name_icon), "zombo_morph");

        ActivityOptionsCompat morpher = ActivityOptionsCompat.makeSceneTransitionAnimation(this, morphHal, morphTerm, morphZombo);

        Intent shuffleIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(shuffleIntent, morpher.toBundle());
    }
}
