/* This app allows the user to enter a lower and upper bound. Once the user selects the bounds and hits
the 'Choose Random Number' button, the app selects a random number  between those
bounds inclusive. The user can then guess the number. When the user guesses a number too low, the app tells the user so and
vice  versa until the user has guessed the number.
 */

package com.example.jaimedeverall.firstassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Random rgen = new Random();
    private int num;
    private int upperBound = 1000;
    private int lowerBound = 1;
    //private static final int upperBound = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chooseRandomNum(View view) {
        EditText upperBoundField = (EditText) findViewById(R.id.upperBoundField);
        EditText lowerBoundField = (EditText) findViewById(R.id.lowerBoundField);
        if(upperBoundField.getText().toString().equals("") || lowerBoundField.getText().toString().equals("")){
            Toast.makeText(this, "Please enter bounds", Toast.LENGTH_SHORT).show();
        } else if( Integer.valueOf( upperBoundField.getText().toString() ) < Integer.valueOf( lowerBoundField.getText().toString() )  ){
            Toast.makeText(this, "Upper bound must be greater than or equal to lower bound", Toast.LENGTH_SHORT).show();
        } else{
            upperBound = Integer.valueOf(upperBoundField.getText().toString() );
            lowerBound = Integer.valueOf( lowerBoundField.getText().toString() );
            num = rgen.nextInt(upperBound - lowerBound + 1) + lowerBound;//creates a random int between lowerBound and upperBound inclusive.
            Toast.makeText(this, "A number between " + lowerBound + " and " + upperBound + " has been chosen", Toast.LENGTH_SHORT).show();
            TextView userGuessLabel = (TextView) findViewById(R.id.userGuessLabel);
            userGuessLabel.setText("The number is between " + lowerBound + " and " + upperBound);
        }

    }

    public void checkGuess(View view) {
        EditText userGuessField = (EditText) findViewById(R.id.userGuessField);
        if(!userGuessField.getText().toString().equals("")) {
            int userGuess = Integer.valueOf(userGuessField.getText().toString());
            if (userGuess > num) {
                Toast.makeText(this, "Your guess was too high", Toast.LENGTH_SHORT).show();
            } else if (userGuess < num) {
                Toast.makeText(this, "Your guess was too low", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "You guessed the number!", Toast.LENGTH_SHORT).show();
            }
        } else{
            Toast.makeText(this, "Please enter a guess", Toast.LENGTH_SHORT).show();
        }
    }
}
