package com.gohool.meterstoinches.meterstoinches;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
     1m = 39.379in
    */

    private EditText enterMeters;
    private Button convertButton;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterMeters = findViewById(R.id.metersEditText);
        convertButton = findViewById(R.id.convertButtonID);
        resultView = findViewById(R.id.resultID);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //conversion logic
                double multiplier = 39.37;
                double result = 0.0;

                if (enterMeters.getText().toString().equals("")) {
                    resultView.setText(R.string.error_message);
                    resultView.setTextColor(Color.RED);
                }
                else {
                    double meterValue = Double.parseDouble(enterMeters.getText().toString());

                    result = meterValue * multiplier;
                    resultView.setTextColor(Color.BLACK);

                    resultView.setText(String.format("%.2f", result) + " Inches");

                }
            }
        });
    }
}
