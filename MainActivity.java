package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText Edit1, Edit2;
    Button button;
    TextView TextResult, TextResult1000, TextResult500, TextResult100;
    String num1, num2;
    Integer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setTitle("자판기");

        Edit1 = (EditText) findViewById(R.id.Edit1);
        Edit2 = (EditText) findViewById(R.id.Edit2);

        button = (Button) findViewById(R.id.button);

        TextResult = (TextView) findViewById(R.id.TextResult);
        TextResult1000 = (TextView) findViewById(R.id.TextResult1000);
        TextResult500 = (TextView) findViewById(R.id.TextResult500);
        TextResult100 = (TextView) findViewById(R.id.TextResult100);

        button.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);

                if(result >= 0){
                    TextResult.setText("잔액 : " + result.toString() + "원");
                    TextResult1000.setText("1000원 : " + result/1000 + "장");
                    TextResult500.setText("500원 : " + result%1000/500 + "개");
                    TextResult100.setText("100원 : " + result%1000%500/100 + "개");
                } else {
                    TextResult.setText("돈이 부족합니다.");
                }

                return false;
            }
        });
    }


}
