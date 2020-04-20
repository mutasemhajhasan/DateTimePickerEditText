package me.mutasem.datetimepickeredittext;

import android.app.DatePickerDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;


public class DatePickerEditText extends PickerEditText  {

    private static final String TAG = "DatePickerEditText";

    public DatePickerEditText(Context context) {
        super(context);
    }

    public DatePickerEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DatePickerEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    protected void showPickerDialog() {
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null)
            imm.hideSoftInputFromWindow(getWindowToken(), 0);

        new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                date.set(Calendar.YEAR, i);
                date.set(Calendar.MONTH, i1);
                date.set(Calendar.DAY_OF_MONTH, i2);
                setText(sdf.format(date.getTime()));
                if (dateListener != null)
                    dateListener.onDateChange(date);
            }
        }
                , date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH)
        )
                .show();
    }


}
