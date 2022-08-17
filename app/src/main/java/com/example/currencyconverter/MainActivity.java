 package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {
     Button button;
     EditText currencyToBeConverted;
     EditText currencyConverted;
     Spinner convertToDropdown;
     Spinner convertFromDropdown;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         //Initialization
         currencyToBeConverted = (EditText) findViewById(R.id.currency_to_be_converted);

         convertFromDropdown = (Spinner) findViewById(R.id.convert_from);
         convertToDropdown = (Spinner) findViewById(R.id.convert_to);

         button = (Button) findViewById(R.id.button);
         currencyConverted = (EditText) findViewById(R.id.currency_converted);

         //Adding Functionality
         String[] dropDownList = {"TND","EUR","USD"};
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, dropDownList);
         convertToDropdown.setAdapter(adapter);
         convertFromDropdown.setAdapter(adapter);

         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 double currency = Double.valueOf(currencyToBeConverted.getText().toString());
                 double result ;

                 if(convertFromDropdown.getSelectedItem().toString() == "TND" && convertToDropdown.getSelectedItem().toString() == "EUR"){
                     result = currency * 0.31;
                     currencyConverted.setText(String.valueOf(result+" "+convertToDropdown.getSelectedItem().toString()));

                 }else if(convertFromDropdown.getSelectedItem().toString() == "TND" && convertToDropdown.getSelectedItem().toString() == "USD"){
                     result = currency * 0.36;
                     currencyConverted.setText(String.valueOf(result+" "+convertToDropdown.getSelectedItem().toString()));
                 }else if(convertFromDropdown.getSelectedItem().toString() == "EUR" && convertToDropdown.getSelectedItem().toString() == "TND"){
                     result = currency * 3.25;
                     currencyConverted.setText(String.valueOf(result+" "+convertToDropdown.getSelectedItem().toString()));
                 }else if(convertFromDropdown.getSelectedItem().toString() == "EUR" && convertToDropdown.getSelectedItem().toString() == "USD"){
                     result = currency * 1.18;
                     currencyConverted.setText(String.valueOf(result+" "+convertToDropdown.getSelectedItem().toString()));
                 }else if(convertFromDropdown.getSelectedItem().toString() == "USD" && convertToDropdown.getSelectedItem().toString() == "TND"){
                     result = currency * 2.76;
                     currencyConverted.setText(String.valueOf(result+" "+convertToDropdown.getSelectedItem().toString()));
                 }else if(convertFromDropdown.getSelectedItem().toString() == "USD" && convertToDropdown.getSelectedItem().toString() == "EUR"){
                     result = currency * 0.85;
                     currencyConverted.setText(String.valueOf(result+" "+convertToDropdown.getSelectedItem().toString()));
                 }else {
                     result = currency;
                     currencyConverted.setText(String.valueOf(result+" "+convertToDropdown.getSelectedItem().toString()));
                 }

             }
         });



     }
 }