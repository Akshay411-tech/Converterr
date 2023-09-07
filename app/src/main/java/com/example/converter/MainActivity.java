package com.example.converter;

import static java.lang.String.format;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button ansbtn,againbtn;
    TextView Show_ans;
    EditText getval;
    RadioButton c2f,f2c;
    Double x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ansbtn = (Button) findViewById(R.id.ansbtn);
        Show_ans = (TextView) findViewById(R.id.Showans);
        getval= (EditText) findViewById(R.id.getval);
        c2f= (RadioButton) findViewById(R.id.c2f);
        f2c=(RadioButton) findViewById(R.id.f2c);
        againbtn=(Button) findViewById(R.id.againbtn);
        ansbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getval.getText().toString().isEmpty()){
                    Show_ans.setText("Please give Temperature");

                }
                else {
                    x = Double.parseDouble(String.valueOf(getval.getText()));
                    String pattern;
                    if (c2f.isChecked()) {
                        x = (x * 9) / 5 + 32;
                       //x = Double.parseDouble(new DecimalFormat( pattern:"##.###").format(x));
                        Show_ans.setText(String.valueOf(x) + " Degree F");

                    } else if (f2c.isChecked()) {
                        x = (x - 32) * 5 / 9;
                        //x = Double.parseDouble(new DecimalFormat(pattern:"##.###").format(x));
                        Show_ans.setText(String.valueOf(x) + " Degree C");

                    } else {
                        Show_ans.setText("Please select an option !");
                    }
                }
            }
        });
        againbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Show_ans.setText("0.00");
                getval.setText("");
                c2f.setChecked(false);
                f2c.setChecked(false);
            }
        });
    }
}