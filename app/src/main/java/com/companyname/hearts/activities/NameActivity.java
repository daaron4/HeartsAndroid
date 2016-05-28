package com.companyname.hearts.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.companyname.hearts.R;

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

        Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
        mainIntent.putExtra("playerNames", playerNames);
        startActivity(mainIntent);
    }

}
