package com.example.calculator;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
        Button clearButton = findViewById(R.id.delete);
        clearButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                display.setText("");
                return true;
            }
        });

        if(savedInstanceState != null) {
            display.setText(savedInstanceState.getString("display"));
        }
    }

    public void updateDisplay(View view){
        display.setText(display.getText().toString() + ((Button)view).getText());
    }

    public void deleteCharacter(View view) {
        StringBuilder sb = new StringBuilder(display.getText());
        sb.deleteCharAt(sb.length() - 1);
        display.setText(sb);
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("display", display.getText().toString());
    }

}
