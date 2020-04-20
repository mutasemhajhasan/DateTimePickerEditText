package me.mutasem.datepickerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import me.mutasem.datetimepickeredittext.DatePickerEditText;
import me.mutasem.datetimepickeredittext.PickerEditText;
import me.mutasem.datetimepickeredittext.TimePickerEditText;

public class MainActivity extends AppCompatActivity {
    DatePickerEditText datePicker;
    TimePickerEditText timePicker;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy", Locale.getDefault());
    SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm", Locale.getDefault());
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker = findViewById(R.id.date);
        timePicker = findViewById(R.id.time);
        btn = findViewById(R.id.btn);
        datePicker.setDateListener(new DatePickerEditText.DateListener() {
            @Override
            public void onDateChange(Calendar date) {
                Toast.makeText(MainActivity.this, sdf.format(date.getTime()), Toast.LENGTH_SHORT).show();
            }
        });
        timePicker.setDateListener(new PickerEditText.DateListener() {
            @Override
            public void onDateChange(Calendar date) {
                Toast.makeText(MainActivity.this, sdf2.format(date.getTime()), Toast.LENGTH_SHORT).show();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, datePicker.getText() + " " + timePicker.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
