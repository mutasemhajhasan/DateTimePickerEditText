package me.mutasem.datetimepickeredittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.InputType;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.widget.AppCompatEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public abstract class PickerEditText extends AppCompatEditText  {
    protected Calendar date = Calendar.getInstance();
    private static final String TAG = "DatePickerEditText";
    protected String dateFormat = "yyyy/MM/dd";
    protected SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.getDefault());
    protected DatePickerEditText.DateListener dateListener;

    public PickerEditText(Context context) {
        super(context);
        init(context, null, 0);
    }

    public PickerEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public PickerEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (event.getRawX() <= getRight() && event.getRawX() >= getLeft() && event.getRawY() <= getBottom() && event.getRawY() >= getTop()) {

                return performClick();
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean performClick() {
        showPickerDialog();
        return super.performClick();
    }

    protected abstract void showPickerDialog();


    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        sdf.applyPattern(dateFormat);
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDateListener(DatePickerEditText.DateListener dateListener) {
        this.dateListener = dateListener;
    }

    public interface DateListener {
        void onDateChange(Calendar date);
    }

    protected void init(Context context, AttributeSet attrs, int defStyleAttr) {
        setInputType(InputType.TYPE_NULL);
        if (attrs != null) {
            TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.PickerEditText,
                    defStyleAttr, 0);
            try {
                String dateFormat = a.getString(R.styleable.PickerEditText_dateFormat);
                if (!TextUtils.isEmpty(dateFormat)) {
                    this.dateFormat = dateFormat;
                    sdf.applyPattern(dateFormat);
                }
            } catch (Exception e) {
                Log.e(TAG, "init: ", e);
            } finally {
                a.recycle();
            }
        }
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        if (focused)
            showPickerDialog();
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }


}
