package com.example.colcoulater;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClicked(View view) {
        // Get references to the EditText fields
        EditText et1 = findViewById(R.id.Num1);
        EditText et2 = findViewById(R.id.Num2);

        // Get the text from the EditTexts
        String et1Text = et1.getText().toString();
        String et2Text = et2.getText().toString();

        // Check for empty input fields
        if (et1Text.isEmpty() || et2Text.isEmpty()) {
            Toast.makeText(this, "Please enter numbers in both fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Integer result = null;

        try {
            // Try to parse the input text into integers
            Integer num1 = Integer.parseInt(et1Text);
            Integer num2 = Integer.parseInt(et2Text);

            // Perform the operation based on the button clicked
            if (view.getId() == R.id.btnPlus) {
                result = num1 + num2;
            } else if (view.getId() == R.id.btnMinus) {
                result = num1 - num2;
            } else if (view.getId() == R.id.btnMult) {
                result = num1 * num2;
            } else if (view.getId() == R.id.btnDiv) {
                // Handle division by zero
                if (num2 == 0) {
                    Toast.makeText(this, "Can't divide by 0", Toast.LENGTH_LONG).show();
                    return;
                }
                result = num1 / num2;
            }
        } catch (NumberFormatException e) {
            // If input is not a valid number, show a message
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        // Display the result if not null
        if (result != null) {
            TextView tvRes = findViewById(R.id.tvResult);
            tvRes.setText(result.toString());
        }
    }
}