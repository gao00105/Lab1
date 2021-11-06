package com.example.lab1;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Jingwei Gao
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {
    /**This holds the text at the centre of the screen*/
    private TextView tv = null;
    /**This holds the password field*/
    private EditText et = null;
    /**This holds the button at the bottom*/
    private Button btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        et = findViewById(R.id.editText);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(clk -> {
            String password = et.getText().toString();

            if (checkPasswordComplexity(password)) tv.setText("Your password meets the requirements");
            else tv.setText("You shall not pass");

        });
    }

    /** This function check if the password is valid
     *
     * @param password The String obj that we are checking
     * @return Return true if the password is valid, otherwise false
     */
    private boolean checkPasswordComplexity(String password) {
        boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial, result;

        foundUpperCase = foundLowerCase = foundNumber = foundSpecial = result = false;

        for (Character c : password.toCharArray()){
            if (isDigit(c)) foundNumber = true;
            if (isUpperCase(c)) foundUpperCase = true;
            if (isLowerCase(c)) foundLowerCase = true;
            if (isSpecialCharacter(c)) foundSpecial = true;
            }

        if(!foundUpperCase)
        {

            Toast.makeText(getApplicationContext(), "Your password is missing upper case letter", Toast.LENGTH_SHORT).show(); ;// Say that they are missing an upper case letter;

            result = false;

        }

        if( ! foundLowerCase)
        {
            Toast.makeText(getApplicationContext(),"Your password is missing lower case letter", Toast.LENGTH_SHORT).show(); // Say that they are missing a lower case letter;

            result = false;

        }

        if( ! foundNumber) {
            Toast.makeText(getApplicationContext(),"Your password is missing number", Toast.LENGTH_SHORT).show(); // Say that they are missing a number;

            result = false;
        }

        if(! foundSpecial) {
            Toast.makeText(getApplicationContext(),"Your password is missing special character", Toast.LENGTH_SHORT).show(); // Say that they are missing a special character;

            result = false;
        }

        if (foundLowerCase && foundUpperCase && foundNumber && foundSpecial) {
            Toast.makeText(getApplicationContext(), "Your password meets the requirements", Toast.LENGTH_SHORT).show(); // Say that password passes
            result = true; //only get here if they're all true
        }
        return result;
    }

    /** this function check if the obj is character
     *
     * @param c The character obj that we are checking
     * @return return true if the obj is character, otherwise false
     */
    private boolean isSpecialCharacter(char c){
        switch (c){
            case '?':
            case '@':
            case '!':
            case '*':
            case '&':
            case '^':
            case '%':
            case '#':
            case '$':
                return true;
            default:
                return false;
        }
    }
}