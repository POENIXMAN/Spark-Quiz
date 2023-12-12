package com.example.spark_quiz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

public class ScoreChart extends View {

    private int geography_score = 0;
    private int history_score = 0;
    private int science_score = 0;
    private int popculture_score = 0;

    private Context context;



    private Paint paint;

    public ScoreChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        paint = new Paint();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();
        int barHeight = height * 85/100;

        int barWidth = width / 16;

        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(40);

        paint.setColor(Color.GREEN);
        canvas.drawRect((float) (barWidth * 1),  barHeight - geography_score * (barHeight / 5) - 20 , (float) (barWidth * 3), barHeight, paint);
        canvas.drawText("" + geography_score , (float) (barWidth * 2) , barHeight - geography_score * (barHeight / 5) - 40 , paint);

        paint.setColor(Color.RED);
        canvas.drawRect((float) (barWidth * 5),  barHeight - history_score * (barHeight / 5) - 20 , (float) (barWidth * 7), barHeight , paint);
        canvas.drawText("" + history_score , (float) (barWidth * 6) , barHeight - history_score * (barHeight / 5) - 40 , paint);

        paint.setColor(Color.YELLOW);
        canvas.drawRect((float) (barWidth * 9),  barHeight - science_score * (barHeight / 5) - 20 , (float) (barWidth * 11), barHeight , paint);
        canvas.drawText("" + science_score , (float) (barWidth * 10) , barHeight - science_score * (barHeight / 5) - 40 , paint);

        paint.setColor(Color.MAGENTA);
        canvas.drawRect((float) (barWidth * 13), barHeight - popculture_score * (barHeight / 5) - 20 , (float) (barWidth * 15), barHeight , paint);
        canvas.drawText("" + popculture_score , (float) (barWidth * 14) , barHeight - popculture_score * (barHeight / 5) - 40 , paint);

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10f);
        canvas.drawLine(1, barHeight , 1 , 0 , paint);
        canvas.drawLine(1, barHeight , width , barHeight , paint);

        Drawable gi = ContextCompat.getDrawable(context, R.drawable.geography_icon);
        gi.setBounds(barWidth * 1 + 30, barHeight + 10,  barWidth * 1 + 30 + gi.getIntrinsicWidth(), barHeight + 10 + gi.getIntrinsicHeight());
        gi.draw(canvas);

        gi = ContextCompat.getDrawable(context, R.drawable.history_icon);
        gi.setBounds(barWidth * 5 + 30, barHeight + 10,  barWidth * 5 + 30 + gi.getIntrinsicWidth(), barHeight + 10 + gi.getIntrinsicHeight());
        gi.draw(canvas);

        gi = ContextCompat.getDrawable(context, R.drawable.science_icon);
        gi.setBounds(barWidth * 9 + 30 ,  barHeight + 10,  barWidth * 9 + 30 + gi.getIntrinsicWidth(), barHeight + 10 + gi.getIntrinsicHeight());
        gi.draw(canvas);

        gi = ContextCompat.getDrawable(context, R.drawable.popculture_icon);
        gi.setBounds(barWidth * 13 + 30, barHeight + 10,  barWidth * 13 + 30 + gi.getIntrinsicWidth(), barHeight + 10 + gi.getIntrinsicHeight());
        gi.draw(canvas);


//        int overallScore = geography_score + history_score + science_score + popculture_score;
//        paint.setTextSize(40);
//        paint.setColor(Color.BLACK);
//        paint.setTextAlign(Paint.Align.CENTER);
//        canvas.drawText(setRatingText(overallScore), width / 2, barHeight + 80, paint);
    }

    private static String setRatingText(int overallScore) {
        String rating;
        if (overallScore >= 18) {
            rating = "Excellent";
        } else if (overallScore >= 13) {
            rating = "Great";
        } else if (overallScore >= 8) {
            rating = "Good";
        } else {
            rating = "Needs Improvement";
        }

        return rating;
    }

    public void setScore(int[] score) {
        geography_score = score[0];
        history_score = score[1];
        science_score = score[2];
        popculture_score = score[3];
    }
}

