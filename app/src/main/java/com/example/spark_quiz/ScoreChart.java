package com.example.spark_quiz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ScoreChart extends View {

    private int geography_score = 0;
    private int history_score = 0;
    private int science_score = 0;
    private int popculture_score = 0;

    private Paint paint;

    private TextView ratingTextView;

    public ScoreChart(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        ratingTextView = new TextView(context);
        ratingTextView.setTextSize(16);
        ratingTextView.setTextColor(Color.BLACK);
        ratingTextView.setTextAlignment(TEXT_ALIGNMENT_CENTER);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        int barWidth = width / 16;



        paint.setColor(Color.GREEN);
        canvas.drawRect(barWidth * 2, height - geography_score * (height / 5), barWidth * 3, height, paint);

        paint.setColor(Color.RED);
        canvas.drawRect(barWidth * 6, height - history_score * (height / 5), barWidth * 7, height , paint);

        paint.setColor(Color.YELLOW);
        canvas.drawRect(barWidth * 10, height - science_score * (height / 5), barWidth * 11, height - 10 , paint);

        paint.setColor(Color.parseColor("#FFBAFF"));
        canvas.drawRect(barWidth * 14, height - popculture_score * (height / 5), barWidth * 15, height - 10 , paint);

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10f);
        canvas.drawLine(1, height , 1 , 0 , paint);
        canvas.drawLine(1, height , width , height , paint);

        int overallScore = geography_score + history_score + science_score + popculture_score;
        paint.setTextSize(16);
        paint.setColor(Color.BLACK);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(setRatingText(overallScore), width / 2, height + 50, paint);
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

