# DateTimePickerEditText
Android EditText view for picking date and time

# Usage
## Gradle
```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	dependencies {
	        implementation 'com.github.mutasemhajhasan:DateTimePickerEditText:Tag'
	}
```

## activity.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="10dp"
    tools:context=".MainActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginTop="30dp"
        android:text="Date and Time picker example"
        android:textSize="20sp"
        android:textStyle="bold" />

    <com.google.android.material.textfield.TextInputLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <me.mutasem.datetimepickeredittext.DatePickerEditText
            android:id="@+id/date"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="30dp"
            android:hint="Date"
            app:dateFormat="yyyy-MM-dd" />
    </com.google.android.material.textfield.TextInputLayout>

    <com.google.android.material.textfield.TextInputLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <me.mutasem.datetimepickeredittext.TimePickerEditText
            android:id="@+id/time"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Time"
            app:dateFormat="hh:mm aaa"
            app:is24Hour="true" />
    </com.google.android.material.textfield.TextInputLayout>

    <Button
        android:id="@+id/btn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginTop="20dp"
        android:text="Toast" />
</LinearLayout>
```

## activity.java
```java
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
```
