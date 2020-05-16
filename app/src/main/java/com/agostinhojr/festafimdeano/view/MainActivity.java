package com.agostinhojr.festafimdeano.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.agostinhojr.festafimdeano.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewHolder.textToday = findViewById(R.id.text_today);
        mViewHolder.TextDaysLeft = findViewById(R.id.text_days_left);
        mViewHolder.buttonConfirm = findViewById(R.id.buttonConfirm);

        mViewHolder.buttonConfirm.setOnClickListener(this);

        //Datas
        this.mViewHolder.textToday.setText(SIMPLE_DATE_FORMAT.format(Calendar.getInstance().getTime()));
        String daysLeft = String.format("%s %s", String.valueOf(this.getDaysLeft()), getString(R.string.dias));
        this.mViewHolder.TextDaysLeft.setText(daysLeft);

    }

    private int getDaysLeft() {
        //Data de hoje
        Calendar calendarToday = Calendar.getInstance();
        int today = calendarToday.get(Calendar.DAY_OF_YEAR);

        //Dia máximo do ano
        // [1-365]
        Calendar calendarLastDay = Calendar.getInstance();
        int diaMax = calendarLastDay.getActualMaximum(Calendar.DAY_OF_YEAR);

        return diaMax - today;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonConfirm) {
            Intent intent = new Intent(this, DetailsActivity.class);
            startActivity(intent);
        }
    }

    private static class ViewHolder {
        TextView textToday, TextDaysLeft;
        Button buttonConfirm;
    }
}
