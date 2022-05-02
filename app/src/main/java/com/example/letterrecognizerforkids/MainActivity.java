package com.example.letterrecognizerforkids;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    TextView t1,t2;
    Button[] b  = new Button[4];
    char[] letters = {' ','g','s','g','s','g','s','r','s','g','r','s','s','g','g','g','r','r','g',
            'g','s','g','g','g','g','r','g'};
    char[] alpha = {' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s',
            't','u','v','w','x','y','z'};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.letter);
        t2 = findViewById(R.id.ans);
        b[0] = findViewById(R.id.nextletter);
        b[1] = findViewById(R.id.sky);
        b[2] = findViewById(R.id.root);
        b[3] = findViewById(R.id.grass);
        for (int i = 0; i < 4; i++) {
            b[i].setOnClickListener(this);
        }
    }
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.nextletter)
        {
            int random = new Random().nextInt((26 - 1) + 1) + 1;
            char c = alpha[random];
            t1.setText(Character.toString(c));
            t2.setText("ANSWER");
            t2.setTextColor(Color.BLUE);
        }
        else
        {
            char c = t1.getText().charAt(0);
            int let = Character.getNumericValue(c);
            if(R.id.sky == view.getId() && letters[let] == 's' || R.id.grass == view.getId() && letters[let] == 'g' || R.id.root == view.getId() && letters[let] == 'r')
            {
                t2.setText("Correct!");
                t2.setTextColor(Color.GREEN);
            }
            else
            {
                t2.setText("InCorrect!");
                t2.setTextColor(Color.RED);
            }
        }
    }
}