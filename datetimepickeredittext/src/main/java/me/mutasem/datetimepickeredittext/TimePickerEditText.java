package me.mutasem.datetimepickeredittext;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerEditText extends PickerEditText {
    private static final String TAG = "TimePickerEditText";
    private boolean is24HourView = false;

    public TimePickerEditText(Context context) {
        super(context);

    }

    public TimePickerEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TimePickerEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void showPickerDialog() {
        new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                date.set(Calendar.HOUR_OF_DAY, i);
                date.set(Calendar.MINUTE, i1);

                setText(sdf.format(date.getTime()));
                if (dateListener != null)
                    dateListener.onDateChange(date);
            }
        }
                , date.get(Calendar.HOUR_OF_DAY), date.get(Calendar.MINUTE)
                , is24HourView)
                .show();
    }

    @Override
    protected void init(Context context, AttributeSet attrs, int defStyleAttr) {
        super.init(context, attrs, defStyleAttr);
        if (attrs != null) {
            TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.PickerEditText,
                    defStyleAttr, 0);
            try {
                is24HourView = a.getBoolean(R.styleable.TimePickerEditText_is24Hour, false);
            } catch (Exception e) {
                Log.e(TAG, "init: ", e);
            } finally {
                a.recycle();
            }
        }
    }
}
